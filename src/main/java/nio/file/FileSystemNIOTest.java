package nio.file;

import com.google.common.base.Charsets;
import com.google.common.collect.Lists;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.*;

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


}
