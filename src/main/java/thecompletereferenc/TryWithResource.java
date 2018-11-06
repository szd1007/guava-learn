package thecompletereferenc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author shangzhidong@zhuanzhuan.com
 * @date 2018-11-06 09:47
 */
public class TryWithResource {

    public static void main(String[] args) {
        int i;

        if (args.length != 1) {
            System.out.println("Usage: ShowFile filename");
            return;
        }

        //The following code use a try-with-resources statement to open
        // a file and then automatically close it when the try block is left.
        //实现autoCloseable接口才可以使用这种语法
        try (FileInputStream fin = new FileInputStream(args[0])) {
            do {
                i = fin.read();
                if (i != -1) {
                    System.out.println((char)i);
                }
            } while (i != -1);
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("An I/O Error Occurred");
        }

    }
}
