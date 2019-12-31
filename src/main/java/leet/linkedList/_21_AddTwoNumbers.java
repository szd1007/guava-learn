package leet.linkedList;


/**
 * Question:
 * You are given two linked lists representing two non-negative numbers.
 * The digits are stored in reverse order and each of their nodes contains a single digit.
 * Add the two numbers and return it as a linked list.
 * Input: (243) + (564) Output: 708
 * <p>
 * <p>
 * Take extra caution of the following cases:
 * - When one list is longer than the other.
 * - The sum could have an extra carry of one at the end, which is easy to forget
 * . (e.g., (99) + (1) = (001))
 */
public class _21_AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode cur = head;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int a = l1 == null ? 0 : l1.val;
            int b = l2 == null ? 0 : l2.val;
            ListNode data = new ListNode((a + b + carry) % 10);
            carry = (a+b +carry)/10;
            cur.next = data;
            cur = cur.next;
            if(l1!=null) l1 = l1.next;
            if(l2!=null) l2 = l2.next;

        }
        if (carry == 1) {
            cur.next = new ListNode(1);
        }
        return head.next;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
