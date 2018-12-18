package thecompletereferenc;

import org.junit.Test;

import java.io.File;

/**
 * @author shangzhidong@zhuanzhuan.com
 * @date 2018-12-18 09:55
 */
public class FileTest {

    @Test
    public void testFileUtil() {
        File file = new File("D:/");
        if (file.isDirectory()) {
            System.out.println("is directory");
            System.out.println("total bytes:" + file.getTotalSpace());
            System.out.println("free bytes:" + file.getFreeSpace());
            System.out.println("usable byte:" + file.getUsableSpace());
        }

//        File[] listFiles = file.listFiles();
        String[] s = file.list();
        for (int i = 0; i < s.length; i++) {
            String path = "D:/" + s[i];
            System.out.println("file path "+path);
            File f = new File(path);
            if (f.isDirectory()) {
                System.out.println(s[i] + " is a directory");
            } else {
                System.out.println(s[i] + " is a file");
            }
        }

    }

    @Test
    public void testFileFilter() {
        File file = new File("D:/");

        //只过滤txt文件
        File[] files = file.listFiles((dir, name) -> name.endsWith(".txt"));
        System.out.println("txt file list:");
        for (File file1 : files) {
            System.out.println(file1.getName());
        }
    }

}
