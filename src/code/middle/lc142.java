package code.middle;

import common.ListNode;

public class lc142 {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode fast = head.next.next, low = head.next;
        while (fast != null && fast.next != null && fast != low) {
            fast = fast.next.next;
            low = low.next;
        }
        if (fast == null || fast.next == null) return null;
        low = head;
        while (fast != low) {
            fast = fast.next;
            low = low.next;
        }
        return fast;
    }
}
