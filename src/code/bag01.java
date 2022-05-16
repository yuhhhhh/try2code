package code;

import java.util.Deque;
import java.util.LinkedList;

public class bag01 {
    public static void main(String[] args) {
        int[][] f = new int[10][10];
        int[] v = new int[]{0, 3, 2, 4, 1};
        int[] w = new int[]{0, 4, 4, 5, 1};
        int n = 4, m = 5;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m ; j++) {
                f[i][j] = f[i-1][j];
                if(j >= v[i]) f[i][j] = Math.max(f[i][j], f[i-1][j-v[i]] + w[i]);
            }
        }
        int res = f[n][m];
        System.out.println(res);
    }
}
