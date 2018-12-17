package thecompletereferenc;

import org.junit.Test;

import java.util.Scanner;

public class ScannerTest {

    public static void main(String args[]) {
        Scanner conin = new Scanner(System.in);

        int count = 0;
        double sum = 0.0;

        //设置分隔符
        conin.useDelimiter("\n");
        System.out.println("Enter numbers to average.");

        //Read and sum numbers.
        while (conin.hasNext()) {
            if (conin.hasNextDouble()) {
                sum += conin.nextDouble();
                count++;
            } else {
                String str = conin.next();
                if (str.equals("done")) {
                    break;
                } else {
                    System.out.println("Data format error");
                    return;
                }
            }
        }
        conin.close();
        System.out.println("Average is " + sum / count);
    }

    @Test
    public void testFindInline() {
        String inStr = "xx:28demoAge:11";

        Scanner scanner = new Scanner(inStr);
//        scanner.useDelimiter("\n");
        while (scanner.hasNext()) {
            System.out.println(">>>>>>>>>>");

            String find = scanner.findInLine("Age");
            System.out.println("find " + find);

            String next = scanner.next();
            System.out.println("next " + next);

        }

    }

}
