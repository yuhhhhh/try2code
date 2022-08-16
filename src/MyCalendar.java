import java.util.HashSet;
import java.util.Set;

class MyCalendar {
    Set<Integer> lazy;
    Set<Integer> tree;
    public MyCalendar() {
        lazy = new HashSet<>();
        tree = new HashSet<>();
    }

    public boolean book(int start, int end) {
        if (query(start, end - 1, 0, 1000000000, 1)) {
            return false;
        }
        update(start, end - 1, 0, 1000000000, 1);
        return true;
    }

    public boolean query(int start, int end, int l, int r, int idx) {
        if (start > r || end < l) {
            return false;
        }
        if (lazy.contains(idx)) {
            return true;
        }
        if (start <= l && end >= r) {
            return tree.contains(idx);
        }
        else {
            int mid = (l + r) >> 1;
            if (end < mid) {
                return query(start, end, l, mid, idx * 2);
            } else if (start > mid) {
                return query(start, end, mid+1, r, idx * 2 + 1);
            } else {
                return query(start, end, l, mid, idx * 2) | query(start, end, mid+1, r, idx * 2 + 1);
            }
        }
    }


    public void update (int start, int end, int l, int r, int idx) {
        if (start > r || end < l) return ;
        if (start <= l && end >= r) {
            tree.add(idx);
            lazy.add(idx);
        } else {
            int mid = (l + r) >> 1;
            update(start, end, l, mid, idx*2);
            update(start, end, mid+1, r, idx*2+1);
            tree.add(idx);
        }
    }
}