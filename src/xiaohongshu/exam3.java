package xiaohongshu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class exam3 {
    static Map<Integer, Set<Integer>> map = new HashMap<>();
    static boolean[] st;
    static int res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        st = new boolean[n];
        for (int i = 0; i < input.length; i++) {
            int m = Integer.parseInt(input[i]);
            Set<Integer> set = map.getOrDefault(i + 2, new HashSet<>());
            set.add(m);
            map.put(i + 2, set);
            set = map.getOrDefault(m, new HashSet<>());
            set.add(i + 2);
            map.put(m, set);
        }
        dfs(1, 0, n);
        System.out.println(res);
    }

    public static void dfs(int idx, int cur, int n) {
        if (idx == n + 1) {
            res = Math.max(cur, res);
            return ;
        }
        if ((n - idx) / 2 + cur < res) return;
        Set<Integer> set = map.get(idx);
        if (st[idx - 1]) {
            dfs(idx + 1, cur, n);
        } else {
            dfs(idx + 1, cur, n);
            st[idx - 1] = true;
            for (int i : set) {
                if (!st[i - 1]) {
                    st[i - 1] = true;
                    dfs(idx + 1, cur + 1, n);
                    st[i - 1] = false;
                }
            }
            st[idx - 1] = false;
        }
    }
}
