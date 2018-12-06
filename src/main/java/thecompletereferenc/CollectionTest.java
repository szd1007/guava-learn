package thecompletereferenc;

import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.*;
import java.util.function.Consumer;

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
        EnumSet<EAlpha> pd = EnumSet.allOf(EAlpha.class);
        System.out.println(pd);

    }

    @Test
    public void testEachRemaining() {
        names.iterator().forEachRemaining(System.out::println);
        System.out.println("-----");
        //and then 用法
        names.forEach(((Consumer<String>) s -> System.out.println(s + ":"))
                              .andThen(System.out::println));
    }

    enum EAlpha{
        A,B,C,D,E;
    }

    /**
     * 提供给你遍历过程中修改数据的功能
     */
    @Test
    public void testIterator() {

        Iterator<String> itr = names.iterator();

        while (itr.hasNext()) {
            String element = itr.next();
            System.out.println("element" + element);
        }
        System.out.println(">>>>>>");

        //modify obj being iterated
        ListIterator<String> litr = names.listIterator();
        System.out.println("print previous start");
        while (litr.hasPrevious()) {
            System.out.println(litr.previous());
        }
        System.out.println("print previous end");

        while (litr.hasNext()) {
            String element = litr.next();
            litr.set(element + "+");
            if (element.startsWith("1001")) {
                litr.remove();
            }
        }
        System.out.println("modified contents " + names);

        //Now, display the list backwards.
        System.out.println("Modified list backwards");
        while (litr.hasPrevious()) {
            String element = litr.previous();
            System.out.println(element);
        }
    }

    @Test
    public void testSpliterators() {
        Spliterator<String> spr = names.spliterator();
        while (spr.tryAdvance(System.out::println)) {
            System.out.println("consume one");
        }
        //create new list that contains square roots.
        spr = names.spliterator();
        spr.forEachRemaining(x -> System.out.println("(" + x + ")"));
    }
}
