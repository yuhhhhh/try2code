package xiecheng;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class exam3 {
    static Map<Character, Integer> lMap = new HashMap<>();
    static Map<Character, Integer> rMap = new HashMap<>();
    static boolean[] st;
    static Map<Integer, Set<Integer>> map = new HashMap<>();
    static int res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[] colors = new char[n];
        String input = br.readLine();
        for (int i = 0; i < n; i++) {
            colors[i] = input.charAt(i);
            rMap.put(colors[i], rMap.getOrDefault(colors[i], 0) + 1);
        }
        for (int i = 0; i < n - 1; i++) {
            String[] inputs = br.readLine().split(" ");
            int a = Integer.parseInt(inputs[0]) - 1, b = Integer.parseInt(inputs[1]) - 1;
            Set<Integer> set = map.getOrDefault(a, new HashSet<>());
            set.add(b);
            map.put(a, set);
            set = map.getOrDefault(b, new HashSet<>());
            set.add(a);
            map.put(b, set);
        }
        st = new boolean[n];
        int begin = 0;
        for (int idx : map.keySet()) {
            if (map.get(idx).size() == 1) {
                begin = idx;
                break;
            }
        }
        dfs(begin, colors);
        System.out.println(res);
    }

    public static void dfs(int idx, char[] colors) {
        if (st[idx]) {
            return ;
        }
        st[idx] = true;
        lMap.put(colors[idx], rMap.getOrDefault(colors[idx], 0) + 1);
        rMap.put(colors[idx], rMap.getOrDefault(colors[idx], 0) - 1);
        if (rMap.get(colors[idx]) <= 0) {
            rMap.remove(colors[idx]);
            return ;
        }
        if (rMap.size() == 3 && lMap.size() == 3) {
            res++;
        }
        Set<Integer> set = map.get(idx);
        for (int n : set) {
            dfs(n, colors);
        }
    }
}
