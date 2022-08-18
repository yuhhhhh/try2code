package code.middle;

import common.ListNode;

public class lc92 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        new lc92().reverseBetween(node1, 2, 4);
    }
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode res = new ListNode();
        res.next = head;
        ListNode pre = res;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }
        ListNode cur = res.next, next;
        for (int i = 0; i < right - left; i++) {
            next = cur.next;
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }
        return res.next;
    }
}
