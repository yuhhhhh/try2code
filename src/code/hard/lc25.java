package code.hard;

import common.ListNode;

public class lc25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode res = new ListNode();
        res.next = head;
        ListNode cur = res;
        ListNode node = head;
        while (node != null) {
            ListNode end = node;
            for (int i = 0; i < k - 1 && end != null; i++) {
                end = end.next;
            }
            if (end != null) {
                ListNode tmp = end.next;
                reverseK(node, k);
                cur.next = end;
                cur = node;
                node = tmp;
            } else {
                cur.next = node;
                break;
            }
        }
        return res.next;
    }

    public void reverseK(ListNode node, int k) {
        ListNode cur = null, post = node;
        for (int i = 0; i < k; i++) {
            ListNode tmp = post.next;
            post.next = cur;
            cur = post;
            post = tmp;
        }
    }
}
