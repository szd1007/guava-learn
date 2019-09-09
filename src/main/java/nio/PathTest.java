package nio;

import org.junit.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author szd1007@github.com
 * @date 2018-12-25 10:51
 */
public class PathTest {

    @Test
    public void testGetPath() {
        Path path = Paths.get("D:\\batch");
        System.out.println(path.getFileSystem());
        System.out.println(path.getNameCount());
        System.out.println(path.getName(0));
        path.iterator().forEachRemaining(x -> System.out.println("name:" + x));
    }
}
