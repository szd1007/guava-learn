package thecompletereferenc;

import org.junit.Test;

import java.io.*;

public class ByteArrayInputStreamTest {
    public static void main(String[] args) {
        String tmp = "absdfsfsfsfwewef";
        byte b [] = tmp.getBytes();

        ByteArrayInputStream input1 = new ByteArrayInputStream(b);
        ByteArrayInputStream input2 = new ByteArrayInputStream(b, 0, 3);


    }

    @Test
    public void testOut() {
        String t ="sdfssdf";
        byte[] b = t.getBytes();
        ByteArrayOutputStream bou1 = new ByteArrayOutputStream();
        bou1.write(b);

        try (FileOutputStream fOut2 =new FileOutputStream("out.txt")) {


        }  catch (IOException e) {
            e.printStackTrace();
        }

    }
}
