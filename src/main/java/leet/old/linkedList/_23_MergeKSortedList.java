package leet.old.linkedList;

import leet.ICodePoints;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;


public class _23_MergeKSortedList {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    @ICodePoints("小根堆 堆排序算法")
    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        PriorityQueue<ListNode> heap = new PriorityQueue<>(lists.length, Comparator.comparingInt(x -> x.val));
        for (ListNode list : lists) {
            if (list != null) {
                heap.add(list);
            }
        }
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        while (!heap.isEmpty()) {
            p.next = heap.poll();
            p = p.next;
            //@ICodePoints("重点在于next是list的下一个节点")
            if (p.next != null) {
                heap.add(p.next);
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(0);
        ListNode b = new ListNode(1);
        ListNode c = new ListNode(2);
        ListNode d = new ListNode(3);
        ListNode e = new ListNode(4);

         a.next=b;
         b.next=d;
        c.next=e;
        print(a);
        System.out.println("==================");
        print(c);
         System.out.println("==================");
        print(mergeKLists2(new ListNode[]{a,c}));
        System.out.println("@@@@@@@@@@@@@@@@@@");
//        print(mergeTwoList(a,c));
    }

    /**
     * O(nk log k) runtime, O(1) space – Divide and conquer using two way merge:
     分治方法
     http://www.adamx.org:9999/pics/java/1577971628744.jpg
     */
    public static ListNode mergeKLists2(ListNode[] lists){
        if (lists.length == 0) {
            return null;
        }
        int end = lists.length-1;
        while (end > 0) {
            int begin =0;
            while (begin<end){
                lists[begin]=mergeTwoList(lists[begin],lists[end]);
                begin++;
                end--;
            }
        }
        return lists[0];
    }
    @ICodePoints("尾插法")
    public static ListNode mergeTwoList(ListNode a, ListNode b){
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        while (a != null && b != null) {
            if (a.val < b.val) {
                p.next = a;
                a = a.next;
            }else {
                p.next = b;
                b = b.next;
            }
            p = p.next;
        }
        if (a != null) {
            p.next = a;

        }
        if (b != null) {
            p.next = b;
        }
        return dummy.next;
    }
    private static void print(ListNode reverseNode) {
        while (reverseNode != null) {
            System.out.println(reverseNode.val);
            reverseNode = reverseNode.next;
        }
    }
}
