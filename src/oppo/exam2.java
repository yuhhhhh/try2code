package oppo;

import common.ListNode;

import java.util.List;
import java.util.PriorityQueue;

public class exam2 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        node3.next = node4;
        node4.next = node1;
        node5.next = node6;
        node6.next = node2;
        ListNode res = new exam2().combineTwoDisorderNodeToOrder(node3, node5);
        while(res!= null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
    public ListNode combineTwoDisorderNodeToOrder (ListNode node1, ListNode node2) {
        // write code here
        PriorityQueue<ListNode> queue = new PriorityQueue<>((n1, n2) -> n1.val - n2.val);
        ListNode cur = node1;
        while (cur != null) {
            queue.add(cur);
            cur = cur.next;
        }
        cur = node2;
        while (cur != null) {
            queue.add(cur);
            cur = cur.next;
        }
        ListNode res = queue.remove();
        cur = res;
        while (!queue.isEmpty()) {
            cur.next = queue.remove();
            cur = cur.next;
        }
        cur.next = null;
        return res;
    }
}
