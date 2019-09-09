package thecompletereferenc;

import java.io.*;
import java.util.Properties;

/**
 * @author szd1007@github.com
 * @date 2018-12-12 11:47
 */
public class PropertiesTest {

    /**
     * 使用load store 实现微型数据库.
     * 不错不错
     *
     * @param args args
     */
    public static void main(String[] args) throws IOException {
        Properties p = new Properties();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name, number;
        FileInputStream fin = null;
        boolean changed = false;

        //Try to open phonebook.dat file
        try {
            fin = new FileInputStream("phonebook.dat");
        } catch (FileNotFoundException e) {
            //ignore missing file
        }
        /* If phonebook file already exists, load existing telephone numbers. */
        try {
            if (fin != null) {
                p.load(fin);
                fin.close();
            }
        } catch (IOException e) {
            System.out.println("Error reading file.");
        }

        //Let user enter new names and numbers
        do {
            System.out.println("Enter new name ('quit' to stop)");
            name = br.readLine();
            if (name.equals("quit")) {
                continue;
            }
            System.out.println("Enter number: ");
            number = br.readLine();
            p.put(name, number);
            changed = true;
        } while (!name.equals("quit"));

        // If phone book data has changed, save it.
        if (changed) {
            FileOutputStream outputStream = new FileOutputStream("phonebook.dat");
            p.store(outputStream, "Telephone Book");
            outputStream.close();
        }

        //Look up numbers given a name.
        do {
            System.out.println("Enter name to find");
            name = br.readLine();
            if (name.equals("quit")) {
                continue;
            }
            number = p.getProperty(name);
            System.out.println("find ->" + number);
        } while (!name.equals("quit"));
    }
}
