package sf;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

public class exam1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 1];
        dp[1] = 1;
        long cnt = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = 1 + dp[i / 2];
            cnt += dp[i];
        }
        System.out.println(cnt);
    }
}
