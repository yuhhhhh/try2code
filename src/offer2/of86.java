package offer2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class of86 {
    int n;
    boolean[][] st;
    List<List<String>> res = new ArrayList<>();
    List<String> cur = new ArrayList<>();

    public String[][] partition(String s) {
        n = s.length();
        st = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(st[i], true);
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                st[i][j] = (s.charAt(i) == s.charAt(j)) && st[i + 1][j - 1];
            }
        }
        dfs(s, 0);
        int rows = res.size();
        String[][] ans = new String[rows][];
        for (int i = 0; i < rows; i++) {
            ans[i] = new String[res.get(i).size()];
            for (int j = 0; j < ans[i].length; j++) {
                ans[i][j] = res.get(i).get(j);
            }
        }
        return ans;
    }

    public void dfs(String s, int idx) {
        if (idx == n) {
            res.add(new ArrayList<>(cur));
            return;
        }
        for (int i = idx; i < n; i++) {
            if (st[idx][i]) {
                cur.add(s.substring(idx, i + 1));
                dfs(s, i + 1);
                cur.remove(cur.size() - 1);
            }
        }
    }
}
