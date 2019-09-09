package nio.file;

import java.io.IOException;
import java.nio.file.*;

/**
 * @author szd1007@github.com
 * @date 2018-12-26 09:51
 */
public class NIOCopyFile {

    public static void main(String[] args) {
        if (args.length != 2) {
            args = new String[] { "test.txt", "test_copy.txt" };
        }
        try {
            Path source = Paths.get(args[0]);
            //path 地址可以不存在
            Path dest = Paths.get(args[1]);

            //Copy the file.
            Files.copy(source, dest, StandardCopyOption.REPLACE_EXISTING);

        } catch (InvalidPathException e) {
            System.out.println("Path Error " + e);
        } catch (IOException e) {
            System.out.println("I/O Error " + e);
        }
    }

}
