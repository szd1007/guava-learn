package leet.linkedList;

import leet.ICodePoints;

import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public class _24_CopyListWithRandomPointer {

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    @ICodePoints("双map， 可以简化成一个")
    public Node copyRandomList(Node head) {
        Node dummy = new Node(-1);
        Map<Node, Node> nodeMap = new HashMap<>();
        Map<Node, Node> reverseMap = new HashMap<>();

        Node p = dummy;
        Node t = head;
        while (t != null) {
            Node node = new Node(t.val);
            nodeMap.put(node,t);
            reverseMap.put(t,node);
            p.next =node;
            p = p.next;
            t = t.next;
        }
        p = dummy.next;
        while (p != null) {
            p.random = reverseMap.get(nodeMap.get(p).random);
            p = p.next;
        }
        return dummy.next;
    }

    public Node copyRandomList2(Node head) {
        Node dummy = new Node(-1);
        Map<Node, Node> reverseMap = new HashMap<>();

        Node p = dummy;
        Node t = head;
        while (t != null) {
            Node node = new Node(t.val);
            reverseMap.put(t,node);
            p.next =node;
            p = p.next;
            t = t.next;
        }
        t =head;
        while (t != null) {
             reverseMap.get(t).random = reverseMap.get(t.random);
             t =t.next;
        }
        return dummy.next;
    }

    /**
     * http://www.adamx.org:9999/pics/java/1578045287670.jpg
     * @param head
     * @return
     */
    @ICodePoints("修改原来数据结构，O(1) Space")
    public Node copyRandomList3(Node head) {
        Node dummy = new Node(-1);
        Node p = head;
        while (p != null) {
            Node t = p.next;
            Node node = new Node(p.val);
            node.next = t;
            p.next = node;
            p = t;
        }
        p = head;
        while (p != null) {
            p.next.random= p.random==null?null:p.random.next;
            p = p.next.next;
        }
        p =head;
        Node q= dummy;
        while (p != null) {
            q.next = p.next;
            p.next = p.next.next;
            p = p.next;
            q = q.next;
        }
        return dummy.next;
    }
}
