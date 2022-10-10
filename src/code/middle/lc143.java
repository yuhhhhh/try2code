package code.middle;

import common.ListNode;

public class lc143 {
    public void reorderList(ListNode head) {
        if (head.next == null) return;
        ListNode low = head, fast = head;
        while (fast != null && fast.next != null) {
            low = low.next;
            fast = fast.next.next;
        }
        fast = low.next;
        low.next = null;
        if (fast != null) {
            low = fast;
            fast = low.next;
            low.next = null;
        } else {
            return ;
        }
        while (fast != null) {
            ListNode tmp = fast.next;
            fast.next = low;
            low = fast;
            fast = tmp;
        }
        fast = head;
        while (fast != null && low != null) {
            ListNode tmp = fast.next;
            fast.next = low;
            fast = tmp;
            tmp = low.next;
            if (fast != null) low.next = fast;
            low = tmp;
        }

    }

}
