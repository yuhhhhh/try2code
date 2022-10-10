package ms;

import java.util.*;

public class exam3 {
    public static void main(String[] args) {
        int[] A = {1, 1, 1, 9, 9, 9, 9, 7, 8};
        int[] B = {2, 0, 3, 1, 6, 5, 4, 0, 0};
        System.out.println(new exam3().solution(A, B));
    }

    Map<Integer, Set<Integer>> map = new HashMap<>();
    boolean[] st;
    int oil = 0;

    public int solution(int[] A, int[] B) {
        // write your code in Java 8 (Java SE 8)

        for (int i = 0; i < A.length; i++) {
            if (map.containsKey(A[i])) {
                map.get(A[i]).add(B[i]);
            } else {
                Set<Integer> set = new HashSet<>();
                set.add(B[i]);
                map.put(A[i], set);
            }
            if (map.containsKey(B[i])) {
                map.get(B[i]).add(A[i]);
            } else {
                Set<Integer> set = new HashSet<>();
                set.add(A[i]);
                map.put(B[i], set);
            }
        }
        st = new boolean[map.size()];
        dfs(0);
        return oil;
    }

    public int dfs(int idx) {
        st[idx] = true;
        Set<Integer> set = map.get(idx);
        Set<Integer> kids = new HashSet<>();
        for (int kid : set) {
            if (!st[kid]) {
                kids.add(kid);
            }
        }
        if (kids.size() == 0) {
            return 1;
        }
        int cnt = 0;
        for (int kid : kids) {
            int kidCnt = dfs(kid);
            if (kidCnt > 5) {
                oil += kidCnt / 5 + 1;
            } else {
                oil += 1;
            }
            cnt += kidCnt;
        }
        return cnt + 1;
    }
}
