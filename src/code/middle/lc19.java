package code.middle;

import common.ListNode;

public class lc19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode res = new ListNode(0, head);
        ListNode fast = res, low = res;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        while (fast.next != null) {
            low = low.next;
            fast = fast.next;
        }
        low.next = low.next.next;
        return res.next;
    }
}
