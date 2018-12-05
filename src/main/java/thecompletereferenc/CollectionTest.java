package thecompletereferenc;

import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.*;

/**
 * @author shangzhidong@zhuanzhuan.com
 * @date 2018-12-04 09:39
 */
public class CollectionTest {

    private static final List<String> names = Lists.newArrayList("zhangSan", "lisi", "1001");
    @Test
    public void testAddNull() {
        List<Integer> integerList = Lists.newArrayList();
        integerList.add(null);
        System.out.println(integerList);
    }

    @Test
    public void testRemoveIf() {
        names.removeIf(x -> x.length() > 4);
        System.out.println(names);
    }

    @Test
    public void testLinkedList() {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("x");
        linkedList.add("y");
        linkedList.add("1");

        System.out.println(linkedList.peekFirst());
        System.out.println(linkedList.peekLast());
        System.out.println(linkedList.removeFirst());
        System.out.println(linkedList.getFirst());

        linkedList.addLast("ffff");

        System.out.println(linkedList.offerLast("ffffs"));
        System.out.println(linkedList.offer("ssf"));

        linkedList.remove("1");

    }

    @Test
    public void testLinkedHashSet() {
        Set<String> stringSet = new LinkedHashSet<>();

        stringSet.add("2");
        stringSet.add("a");
        stringSet.add("c");

        System.out.println(stringSet);
    }

    @Test
    public void testTreeSet() {
        //默认字典有序
        TreeSet<String> treeSet = new TreeSet<>();
        treeSet.add("C");
        treeSet.add("A");
        treeSet.add("B");
        System.out.println(treeSet);

        //Navigable interface  method
        System.out.println(treeSet.subSet("B", "D"));
    }

    @Test
    public void testArrayDeque() {
        ArrayDeque<String> adq = new ArrayDeque<>();
        adq.add("A");
        adq.add("B");
        adq.add("C");
        adq.push("D");
        adq.push("E");

        while (!Strings.isNullOrEmpty(adq.peek())) {
            System.out.println(adq.pop());
        }
    }

    @Test
    public void testEnumSet() {
        EnumSet<EAlpha> pa = EnumSet.of(EAlpha.A, EAlpha.B);
        System.out.println(pa);
        EnumSet<EAlpha> pc = EnumSet.complementOf(pa);
        System.out.println(pc);
    }

    enum EAlpha{
        A,B,C,D,E;
    }
}
