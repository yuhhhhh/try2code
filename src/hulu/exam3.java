package hulu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class exam3 {
    /**
     * 3	3	6
     * 1	1	2
     * 1	1	3
     * 1	1	4
     * 10	10	20
     * 10	10	30
     * 10	10	60
     */
    static int[][] s, p;
    static int res = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split("\t");
        int n = Integer.parseInt(input[0]), k = Integer.parseInt(input[1]), t = Integer.parseInt(input[2]);
        s = new int[n][k];
        for (int i = 0; i < n; i++) {
            input = br.readLine().split("\t");
            for (int j = 0; j < k; j++) {
                s[i][j] = Integer.parseInt(input[j]);
            }
        }
        p = new int[n][k];
        for (int i = 0; i < n; i++) {
            input = br.readLine().split("\t");
            for (int j = 0; j < k; j++) {
                p[i][j] = Integer.parseInt(input[j]);
            }
        }
        dfs(0, 0, k, n, t, 0);
        System.out.println(res);
    }

    public static void dfs(int iN, int iK, int k, int n, int t, int cur) {
        if (iN == n) return;
        dfs(iN + 1, 0, k, n, t, cur);
        if (t >= s[iN][iK]) {
            t -= s[iN][iK];
            cur += p[iN][iK];
            res = Math.max(res, cur);
            if (iK < k - 1) dfs(iN, iK + 1, k, n, t, cur);
            else dfs(iN, 0, k, n, t, cur);
        } else {
            dfs(iN + 1, 0, k, n, t, cur);
        }

    }
}
