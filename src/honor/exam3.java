package honor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class exam3 {
    static Map<Integer, Set<Integer>> map = new HashMap<>();
    static String res = null;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());
        map.put(1, new HashSet<Integer>() {
            {
                add(1);
                add(2);
                add(4);
            }
        });
        map.put(2, new HashSet<Integer>() {
            {
                add(1);
                add(2);
                add(3);
                add(5);
            }
        });
        map.put(3, new HashSet<Integer>() {
            {
                add(2);
                add(3);
                add(6);
            }
        });
        map.put(4, new HashSet<Integer>() {
            {
                add(1);
                add(4);
                add(5);
                add(7);
            }
        });
        map.put(5, new HashSet<Integer>() {
            {
                add(2);
                add(4);
                add(5);
                add(6);
                add(8);
            }
        });
        map.put(6, new HashSet<Integer>() {
            {
                add(3);
                add(5);
                add(6);
                add(9);
            }
        });
        map.put(7, new HashSet<Integer>() {
            {
                add(4);
                add(7);
                add(8);
            }
        });
        map.put(8, new HashSet<Integer>() {
            {
                add(5);
                add(7);
                add(8);
                add(9);
            }
        });
        map.put(9, new HashSet<Integer>() {
            {
                add(6);
                add(8);
                add(9);
            }
        });
        map.put(0, new HashSet<>() {
            {
                add(1);
                add(2);
                add(3);
                add(4);
                add(5);
                add(6);
                add(7);
                add(8);
                add(9);
            }
        });
        for (int i = 0; i < m; i++) {
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]), b = Integer.parseInt(input[1]);
            Set<Integer> set = map.get(a);
            set.remove(b);
            map.put(a, set);
        }
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        dfs(sb, 0, 0, n);
        System.out.println(res);
    }

    public static void dfs(StringBuilder sb, int num, int i, int n) {
        if (i == n) {
            res = sb.toString();
            return;
        }
        Set<Integer> set = map.get(num);
        if (set.size() == 0) return;
        List<Integer> list = new ArrayList<>(set);
        list.sort((n1, n2) -> n2 - n1);
        for (Integer integer : list) {
            if (res == null) dfs(sb.append(integer), integer, i + 1, n);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
