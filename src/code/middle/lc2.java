package code.middle;

import common.ListNode;

public class lc2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode idx1 = l1, idx2 = l2, cur;
        if (l1 != null) cur = l1;
        else cur = l2;
        ListNode res = cur;
        boolean flag = false;
        while(idx1 != null || idx2 != null) {
            int sum;
            if (idx1 == null) {
                sum = idx2.val;
            } else if (idx2 == null) {
                sum = idx1.val;
            } else {
                sum = idx1.val + idx2.val;
            }
            if (flag) sum += 1;
            flag = sum >= 10;
            sum = sum % 10;
            cur.val = sum;
            if (idx1 != null) {
                idx1 = idx1.next;
            }
            if (idx2 != null) {
                idx2 = idx2.next;
            }
            if (idx1 == null && idx2 == null) {
                if (flag) cur.next = new ListNode(1);
            } else if (idx1 != null) {
                cur = idx1;
            } else {
                cur = idx2;
            }
        }

        return res;
    }
}
