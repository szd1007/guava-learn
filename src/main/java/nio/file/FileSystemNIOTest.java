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


    class MyFileVisitor extends SimpleFileVisitor<Path> {
        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            System.out.println(file);
            return FileVisitResult.CONTINUE;
        }
    }

    @Test
    public void dirTreeList() {
        String dirName = "/Users/zm/gongsiConf/";
        System.out.println("Directory tree starting with " + dirName +":\n");

        try {
            Files.walkFileTree(Paths.get(dirName), new MyFileVisitor());
        } catch (IOException exec) {
            System.out.println("I/O Error");
        }
    }
    @Test
    public void dirListTest() {
        String dirName = "/Users/zm/gongsiConf/";
        //Obtain and manage a directory stream within a try block.

        //过滤文件  通配符
//        try (DirectoryStream<Path> dirstm = Files.newDirectoryStream(Paths.get(dirName), "*.{xml")) {
//            try (DirectoryStream<Path> dirstm = Files.newDirectoryStream(Paths.get(dirName))) {
        //过滤文件  接口方式， demo过滤可写操作文件
        try (DirectoryStream<Path> dirstm = Files.newDirectoryStream(Paths.get(dirName),
                Files::isWritable)) {
            System.out.println("Directory of " + dirName);

            //Because DirectoryStream implements Iterable, we
            //can use a "foreach" loop to display the directory
            for (Path entry : dirstm) {
                BasicFileAttributes attributes = Files.readAttributes(entry, BasicFileAttributes.class);

                if(attributes.isDirectory())
                    System.out.print("<DIR> ");
                else
                    System.out.print("      ");
                System.out.println(entry.getName(3));
            }
        } catch (InvalidPathException e) {
            System.out.println("Path Error " + e);
        }catch (NotDirectoryException e) {
            System.out.println(dirName + " is not a directory");
        }catch (IOException e) {
            System.out.println("I/O Error: " + e);
        }
    }

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


}
