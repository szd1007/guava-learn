package leet.old.linkedList;

import com.google.common.collect.Lists;

import java.util.LinkedList;

/**
 * 两个有序数组合并，  类似分桶排序
 */
public class _20_MergeTwoSortedLists {
    public static LinkedList<Integer> mergeTwoSortedList(LinkedList<Integer> list1, LinkedList<Integer> list2) {
        LinkedList<Integer>res = new LinkedList<>();
        while (list1.size() > 0 && list2.size() > 0) {
            if (list1.getFirst() <= list2.getFirst()) {
                res.addLast(list1.removeFirst());
            }else {
                res.addLast(list2.removeFirst());
            }
        }
        while (!list1.isEmpty()) {
            res.addLast(list1.removeFirst());
        }
        while (!list2.isEmpty()) {
            res.addLast(list2.removeFirst());
        }
        return res;
    }

    public static void main(String[] args) {
        LinkedList<Integer> list1 = Lists.newLinkedList(Lists.newArrayList(1,3,10,13));
        LinkedList<Integer> list2 = Lists.newLinkedList(Lists.newArrayList(2,3,4,5,16));
        System.out.println(mergeTwoSortedList(list1,list2));
    }
}
