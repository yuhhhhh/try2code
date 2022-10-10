package baidu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class exam2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int[] arr = new int[n];
        long sum = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }
        long cnt = Long.MAX_VALUE, res = 0;
        int[] dp = new int[n + 1];
        for (int i = 3; i <= n; i++) {
            if (arr[i - 2] > 0 && arr[i - 1] > 1 && arr[i] > 2) {
                int min = Math.min(arr[i - 2], Math.min(arr[i - 1] / 2, arr[i] / 3));
                dp[i] = min + dp[i - 3];
                cnt = Math.max(cnt, dp[i]);
            }
        }
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        res = sum + 5 * cnt;
        System.out.println(res);
    }
}
