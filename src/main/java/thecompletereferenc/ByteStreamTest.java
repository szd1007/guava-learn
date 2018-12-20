package thecompletereferenc;


import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author shangzhidong@zhuanzhuan.com
 * @date 2018-12-19 16:18
 */
public class ByteStreamTest {

    public static void main(String[] args) {
        int size;

        //User try-with resources to close the stream.
        try (FileInputStream fin = new FileInputStream("D:\\github\\guava-learn\\src\\main\\java\\thecompletereferenc\\ByteStreamTest.java")) {
            System.out.println("Total Available Bytes: " + (size = fin.available()));

            int n = size/40;
            System.out.println("First " + n + " bytes of the file on read() at a time");
            for (int i = 0; i < n; i++) {
                System.out.print((char) fin.read());
            }

            System.out.println("\nStill Available:" + fin.available());
            System.out.println("Reading the next " + n + " with one read(b[])");
            byte b[] = new byte[n];
            if (fin.read(b) != n) {
                System.err.println("couldn't read " + n + " bytes.");
            }
            System.out.println(new String(b, 0, n));
            System.out.println("\nStill available: " + (size = fin.available()));
            System.out.println("Skipping half of remaining bytes with skip()");

            fin.skip(size / 2);
            System.out.println("Still available: " + fin.available());

            System.out.println("Reading " + n / 2 + " into the end of array");
            if (fin.read(b, n / 2, n / 2) != n / 2) {
                System.err.println("couldn't read " + n / 2 + " bytes");
            }
            System.out.println(new String(b, 0, b.length));
            System.out.println("\nStill Available: " + fin.available());
        } catch (IOException e) {
            System.out.println("I/O error: " + e);
        }
    }

    @Test
    public void testOutputStream() {
        String source = "Now is the time for all good men\n"
                + " to come to the aid of their country\n"
                + "and pay their due taxes.";
        byte buf[] = source.getBytes();
        FileOutputStream f0 = null;
        FileOutputStream f1 = null;
        FileOutputStream f2 = null;

        try {
            f0 = new FileOutputStream("file1.txt");
            f1 = new FileOutputStream("file2.txt");
            f2 = new FileOutputStream("file3.txt");

            //write to first file
            for (int i = 0; i < buf.length; i += 2) {
                f0.write(buf[i]);
            }
            //write to the second file
            f1.write(buf);

            //write to the third file
            f2.write(buf, buf.length - buf.length / 4, buf.length / 4);

        } catch (IOException e) {
            System.out.println("IO Exception: " + e);
        } finally {
            try {
                if (f0 != null) {
                    f0.close();
                }
            } catch (IOException e) {
                System.out.println("Error Closing file1.txt");
            }

            try {
                if (f1 != null) {
                    f1.close();
                }
            } catch (IOException e) {
                System.out.println("Error Closing file2.txt");
            }

            try {
                if (f2 != null) {
                    f2.close();
                }
            } catch (IOException e) {
                System.out.println("Error Closing file3.txt");
            }

        }
    }
}
