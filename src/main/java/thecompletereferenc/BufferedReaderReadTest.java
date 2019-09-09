package thecompletereferenc;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author szd1007@github.com
 * @date 2018-11-05 13:24
 */
public class BufferedReaderReadTest {

    public static void main(String[] args) throws IOException {
        char c;
        BufferedReader bufferedReader;
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter characters, 'q' to quit.");

        //read characters
        do {
            c = (char) bufferedReader.read();
            System.out.println(c);
        } while (c != 'q');
    }
}
