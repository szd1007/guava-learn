package thecompletereferenc;

import org.junit.Test;

import java.util.ArrayList;
import java.util.PrimitiveIterator;

public class ArrayListTest {

    @Test
    public void testInitialCapacity() {
        ArrayList<String> list = new ArrayList<>();
        list.add("x");
        list.add("y");
        //设置内部对象引用数组的大小，没必要追求小。但是尽量保证少reallocation】
        list.ensureCapacity(4);

        //设置cap大小与数组size值一致 exactly
        list.trimToSize();

        list.toArray();

        String[] sA = new String[list.size()];
        list.toArray(sA);
//        String [] nA = list.toArray(null);

//
        System.out.println(sA.length);
//        System.out.println(nA.length);
    }
}
