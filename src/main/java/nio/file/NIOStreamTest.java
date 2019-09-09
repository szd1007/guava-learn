package nio.file;

import org.junit.Test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * 使用path操作文件
 * 以Stream的方式使用nio.2
 *
 * @author szd1007@github.com
 * @date 2018-12-26 10:09
 */
public class NIOStreamTest {

    public static void main(String[] args) {
        if (args.length == 0) {
            args = new String[] { "test.txt" };
        }
        try (BufferedReader br = new BufferedReader(new InputStreamReader(Files.newInputStream(Paths.get(args[0]))))) {
            System.out.println(br.readLine());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testNioStreamWrite() {
        String file = "test_2.txt";
        try (OutputStream out = new BufferedOutputStream(Files.newOutputStream(Paths.get(file)))) {
            for (int i = 0; i < 26; i++) {
                out.write('A' + i);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
