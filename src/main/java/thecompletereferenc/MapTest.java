package thecompletereferenc;

import org.junit.Test;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author shangzhidong@zhuanzhuan.com
 * @date 2018-12-07 10:06
 */
public class MapTest {

    @Test
    public void testTreeMap() {
        TreeMap<String, Double> tm = new TreeMap<>();


        tm.put("ATom Smith", 123.22);
        tm.put("Cohn Doe", 3434.34);
        tm.put("Bod Hall", 99.22);

        for (Map.Entry<String, Double> me : tm.entrySet()) {
            System.out.println(me.getKey());
        }
    }

    @Test
    public void testLinkedHashMap() {
        Map<String, String> lm = new LinkedHashMap<>();
        lm.put("c", "1");
        lm.put("d", "2");

        lm.forEach((x, y) -> System.out.println(x + ":" + y));
    }
}
