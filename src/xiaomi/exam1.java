package xiaomi;


class ListNode<T> {
    public T data;
    public ListNode<T> next;
}

public class exam1 {
    public static void main(String[] args) {
        ListNode<Integer> node1 = new ListNode<>();
        ListNode<Integer> node2 = new ListNode<>();
        ListNode<Integer> node3 = new ListNode<>();
        ListNode<Integer> node4 = new ListNode<>();
        ListNode<Integer> node5 = new ListNode<>();
        node1.data = 1;
        node2.data = 2;
        node3.data = 3;
        node4.data = 4;
        node5.data = 5;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        ListNode<Integer> cur = new exam1().reverseBetween(node1, 2, 3);
        while (cur != null) {
            System.out.println(cur.data);
            cur = cur.next;
        }
    }
    public ListNode<Integer> reverseBetween(ListNode<Integer> head, int left, int right) {
        ListNode<Integer> res = new ListNode<>();
        res.next = head;
        ListNode<Integer> end = res, begin = res;
        for (int i = 0; i < right; i++) {
            end = end.next;
        }
        ListNode<Integer> nodeTail = end.next;
        for (int i = 0; i < left - 1; i++) {
            begin = begin.next;
        }
        ListNode<Integer> nodeHead = begin;
        begin = begin.next;
        end.next = null;
        end = begin;
        ListNode<Integer> pre = begin;
        begin = begin.next;
        pre.next = null;
        while (begin != null) {
            ListNode<Integer> tmp = begin.next;
            begin.next = pre;
            pre = begin;
            begin = tmp;
        }
        nodeHead.next = pre;
        end.next = nodeTail;
        return res.next;
    }

}
