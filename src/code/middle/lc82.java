package code.middle;

import common.ListNode;

public class lc82 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode res = new ListNode(0, head);
        ListNode pre = res, cur = head;
        while (cur != null) {
            if (cur.next != null && cur.next.val != cur.val) {
                pre = cur;
            }
            while (cur.next != null && cur.next.val == cur.val) {
                cur = cur.next;
            }
            pre.next = cur.next;
            cur = cur.next;
        }
        return res.next;
    }
}
