package nio.file;

import com.google.common.base.Charsets;
import com.google.common.collect.Lists;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * @author shangzhidong@zhuanzhuan.com
 * @date 2018-12-26 10:23
 */
public class FileSystemNIOTest {

    @Test
    public void testPath() throws IOException {
        String filePath = "D:\\";
        Path path = Paths.get(filePath);
        path.iterator().forEachRemaining(System.out::println);
        System.out.println(">>>>>>>>>>>>>");
        Files.list(path).forEach(System.out::println);
    }

    @Test
    public void testReadLine() throws IOException {
        Path path = Paths.get("test.txt");
        //强强强
        Files.lines(path, Charsets.UTF_8).forEach(x -> System.out.println("line::>>" + x));
        Files.write(path, Lists.newArrayList("追加写入测试"), Charsets.UTF_8, StandardOpenOption.APPEND);
    }

    @Test
    public void testPathDemo() {
        Path path = Paths.get("examples\\test.txt");

        System.out.println("File name: " + path.getName(1));
        System.out.println("Path: " + path);
        System.out.println("Absolute Path: " + path.toAbsolutePath());
        System.out.println("Parent: " + path.getParent());

        if (Files.exists(path)) {
            System.out.println("File exists");
        } else {
            System.out.println("File does not exist");
        }

        try {
            if (Files.isHidden(path)) {
                System.out.println("File is hidden");
            } else {
                System.out.println("File is not hidden");
            }
        } catch (IOException e) {
            System.out.println("I/O Error: " + e);
        }

        boolean flag ;
        flag = Files.isWritable(path);
        System.out.println("File is writeable " + flag);

        flag = Files.isReadable(path);
        System.out.println("File is readable " + flag);

        flag = Files.isDirectory(path);
        System.out.println("File is directory " +flag);

        try{
            BasicFileAttributes attributes = Files.readAttributes(path, BasicFileAttributes.class);

            if (attributes.isDirectory()) {
                System.out.println("file is directory");
            } else {
                System.out.println("file is not directory");
            }

            if (attributes.isRegularFile()) {
                System.out.println("The file is a normal file");
            } else {
                System.out.println("The file is not a normal file");
            }

            if (attributes.isSymbolicLink()) {
                System.out.println("The file is a symbolic link");
            } else {
                System.out.println("The file is not a symbolic link");
            }

            System.out.println("File last modified: " + attributes.lastModifiedTime());
            System.out.println("File size: " + attributes.size() + " Bytes");
        } catch (IOException e) {
            System.out.println("Error reading attributes: " + e);
        }
    }

    @Test
    public void testDirList() {

    }


}
