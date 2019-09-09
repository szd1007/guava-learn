package thecompletereferenc;

import org.junit.Test;

import java.io.*;

/**
 * @author szd1007@github.com
 * @date 2018-12-18 20:52
 */
public class IOTest {

    @Test
    public void testStreamClose() {

        //如果有checkedException，也必须显示catch
        try (InputStream inputStream = new FileInputStream(new File("test"))) {
            //do something

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
