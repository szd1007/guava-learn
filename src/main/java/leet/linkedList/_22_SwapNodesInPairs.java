package leet.linkedList;
 /**
 *Given 1234, you should return the list as 2143.
 */
public class _22_SwapNodesInPairs {
    public static ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = dummy, q=head;
        while (q != null && q.next != null) {
            ListNode r = q.next;
            ListNode rt = r.next;
            r.next = q;
            q.next = rt;
            p.next = r;
            p=q;
            q=rt;
        }
        return dummy.next;
    }

    public static ListNode reverseNode(ListNode head){
        ListNode dummy = new ListNode(-1);
        ListNode p = head;
        while (p != null) {
            ListNode t = p.next;
            p.next = dummy.next;
            dummy.next = p;
            p = t;
        }
        return dummy.next;
    }

     public static void main(String[] args) {
         ListNode a = new ListNode(0);
         ListNode b = new ListNode(1);
         ListNode c = new ListNode(2);
         ListNode d = new ListNode(3);
         ListNode e = new ListNode(4);

//         a.next=b;
//         b.next=c;
         c.next=d;
//         d.next=e;
         print(a);
         System.out.println("==================");
//         print(reverseNode(a));
         System.out.println("==================");
         print(swapPairs(a));
     }

     private static void print(ListNode reverseNode) {
         while (reverseNode != null) {
             System.out.println(reverseNode.val);
             reverseNode = reverseNode.next;
         }
     }

     static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
