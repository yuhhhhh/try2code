package code.middle;

import common.ListNode;

public class lc24 {
    public ListNode swapPairs(ListNode head) {
        ListNode res = new ListNode();
        res.next = head;
        ListNode cur = res;
        while (cur != null && cur.next != null && cur.next.next != null) {
            ListNode tmp = cur.next.next;
            swap(cur.next, cur.next.next);
            cur.next = tmp;
            cur = tmp.next;
        }
        return res.next;
    }

    public void swap(ListNode node1, ListNode node2) {
        ListNode tmp = node2.next;
        node2.next = node1;
        node1.next = tmp;
    }
}
