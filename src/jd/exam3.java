package jd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class exam3 {
    static long t;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int diff = n - 6;
        long cnt = (long) (Math.pow(26, diff) % (Math.pow(10, 9) + 7));
        dfs(0, diff, 0);
        cnt = cnt * t;
        cnt = (long) (cnt % (Math.pow(10, 9) + 7));
        if (n % 3 == 0) {
            int tmp = n / 3;
            cnt -= ((long) tmp * (tmp - 1)) / 2;
            cnt += 1;
        }
        System.out.println(cnt);
    }

    public static long getN(int n) {
        int diff = n - 6;
        long cnt = (long) (Math.pow(26, diff) % (Math.pow(10, 9) + 7));
        dfs(0, diff, 0);
        cnt = cnt * t;
        cnt = (long) (cnt % (Math.pow(10, 9) + 7));
        if (n % 3 == 0) {
            int tmp = n / 3;
            cnt -= ((long) tmp * (tmp - 1)) / 2;
            cnt += 1;
        }
        return cnt;
    }

    public static void dfs(int cur, int target, int idx) {
        if (idx == 2) {
            if (cur <= target) t++;
            return ;
        }
        for (int i = 0; i <= target; i++) {
            dfs(cur + i, target, idx + 1);
        }
    }
}
