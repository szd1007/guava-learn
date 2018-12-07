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
//        LinkedHashMap<String, String> lm = new LinkedHashMap<>();
        //根据accessOrder 升序排序，最后访问的放在后面
        LinkedHashMap<String, String> lm = new LinkedHashMap<>(16, 0.75f, true);
        lm.put("c", "1");
        lm.put("d", "2");
        lm.put("f", "3");
        lm.put("e", "4");

        lm.get("d");
        lm.get("e");

        lm.forEach((x, y) -> System.out.println(x + ":" + y));

        System.out.println(">>>>>>>>>>>>>>");
        LinkedHashMap<String, String> rm = new RemoveOldestLinkedHashMap<>(lm);
        rm.forEach((x, y) -> System.out.println(x + ":" + y));
        rm.put("new", "4");
        System.out.println("after put");
        rm.forEach((x, y) -> System.out.println(x + ":" + y));

    }

    /**
     * put putAll之后 删除存储时间最久的元素
     * @param <K>
     * @param <V>
     */
    static class RemoveOldestLinkedHashMap<K, V> extends LinkedHashMap<K, V> {

        public RemoveOldestLinkedHashMap(Map<K, V> lm) {
            super(lm);
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
            return true;
        }
    }
}
