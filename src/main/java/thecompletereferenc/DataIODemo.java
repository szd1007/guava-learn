package thecompletereferenc;

import java.io.*;

/**
 * 节约存储， 减少IO
 * @author szd1007@github.com
 * @date 2018-12-21 20:27
 */
public class DataIODemo {

    public static void main(String[] args) {
        //First, write the data.
        try (DataOutputStream dout = new DataOutputStream(new FileOutputStream("Test.dat"))) {
            dout.writeDouble(98.6);
            dout.writeInt(1000);
            dout.writeBoolean(true);
        } catch (FileNotFoundException e) {
            System.out.println("Cannot Open Output file");
            return;
        } catch (IOException e) {
            System.out.println("I/O Error: " + e);
        }


        //Now, read the data back.
        try (DataInputStream din = new DataInputStream(new FileInputStream("Test.dat"))) {
            double d = din.readDouble();
            int i = din.readInt();
            boolean b = din.readBoolean();

            System.out.println("Here are the Values: " + d + " " + i + " " + b);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
