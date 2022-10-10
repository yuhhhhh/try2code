package tianyiyun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class exam3 {
    static int res = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int hp = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int[] v = new int[n];
        int[] f = new int[n];
        for (int i = 0; i < n; i++) {
            v[i] = Integer.parseInt(input[i+1]);
        }
        input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            f[i] = Integer.parseInt(input[i+1]);
        }
        dfs(f, v, 0, 0, hp, 0);
        System.out.println(res);
    }

    public static void dfs(int[] f, int[] v, int i, int cur, int hp, int curVal) {
        if (i == f.length) {
            res = Math.max(res, curVal);
            return ;
        }
        dfs(f, v, i+1, cur, hp, curVal);
        if (cur + f[i] <= hp) {
            dfs(f, v, i+1, cur + f[i], hp, curVal + v[i]);
        }
    }
}
