package zoom;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class exam1 {
    static long cnt = 0;
    static Map<Integer, List<Integer>> dict = new HashMap<>();
    static String colors;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        colors = br.readLine();

        for (int i = 0; i < n - 1; i++) {
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]), b = Integer.parseInt(input[1]);
            if (dict.containsKey(a)) {
                dict.get(a).add(b);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(b);
                dict.put(a, list);
            }
            if (dict.containsKey(b)) {
                dict.get(b).add(a);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(a);
                dict.put(b, list);
            }
        }
        dfs(1, 0, 0, -1);
        System.out.println(cnt);
    }

    public static void dfs(int cur, int r, int b, int pre) {
        if (!dict.containsKey(cur)) {
            return ;
        }
        List<Integer> list = dict.get(cur);
        if (colors.charAt(cur - 1) == 'R') {
            r += 1;
        } else {
            b += 1;
        }
        cnt += Math.abs(r - b);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == pre) continue;
            dfs(list.get(i), r, b, cur);
        }
    }
}
