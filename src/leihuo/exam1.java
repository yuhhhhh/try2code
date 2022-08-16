package leihuo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class exam1 {
    static List<Set<Integer>> box = new ArrayList<>();
    static boolean flag = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String[] inputs = input.substring(0, input.length() - 1).split("]");
        for (int i = 0; i < inputs.length; i++) {
            String str = inputs[i];
            String[] strs = str.substring(2, str.length()).split(",");
            Set<Integer> set = new HashSet<>();
            for (int j = 0; j < strs.length; j++) {
                if (strs[j].equals("")) continue;
                set.add(Integer.parseInt(strs[j]));
            }
            box.add(set);
        }
        boolean[] st = new boolean[box.size()];
        dfs(0, st, 0L);
        System.out.println(flag);
    }

    public static void dfs(int i, boolean[] st, long cnt) {
        if (st[i] || flag) return;
        cnt++;
        if (cnt == box.size()) {
            flag = true;
            return ;
        }
        st[i] = true;
        Set<Integer> set = box.get(i);
        for(int num : set) {
            if (flag) return ;
            dfs(num, st, cnt);
        }
        st[i] = false;
        cnt--;
    }
}
