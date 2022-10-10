package mayi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class exam2 {
    static boolean[] st;
    static long cnt = 0;
    static Map<Integer, Set<Integer>> map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        map = new HashMap<>();
        for (int i = 0; i < n - 1; i++) {
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]), b = Integer.parseInt(input[1]);
            Set<Integer> set = map.getOrDefault(a, new HashSet<>());
            set.add(b);
            map.put(a, set);
            set = map.getOrDefault(b, new HashSet<>());
            set.add(a);
            map.put(b, set);
        }
        st = new boolean[n];
        dfs(1, 0);
        System.out.println(cnt);
    }

    public static void dfs(int i, long cur) {
        if (st[i - 1]) {
            return ;
        }
        st[i - 1] = true;
        long num = Math.max(i - cur - 1, 0);
        cnt += num;
        Set<Integer> set = map.get(i);
        for (int next : set) {
            dfs(next, i - 1);
        }
    }
}
