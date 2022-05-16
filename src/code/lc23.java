package code;


import common.ListNode;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class lc23 {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> heap = new PriorityQueue<ListNode>((n1, n2) -> n1.val - n2.val);
        ListNode res = new ListNode();
        ListNode cur = res;
        for (ListNode node : lists) {
            if (node != null) heap.add(node);
        }
        while (!heap.isEmpty()) {
            ListNode node = heap.remove();
            cur.next = node;
            cur = node;
            if (node.next != null) heap.add(node.next);
        }
        return res.next;
    }

}
