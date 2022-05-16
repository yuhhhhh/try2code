package shopee;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class sp1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            String nm = br.readLine();
            int n = Integer.parseInt(nm.split(" ")[0]);
            int m = Integer.parseInt(nm.split(" ")[1]);
            int[][] fruit = new int[n][m];
            for (int j = 0; j < n; j++) {
                String val = br.readLine();
                String[] cellArr = val.split(" ");
                for (int k = 0; k < m; k++) {
                    fruit[j][k] = Integer.parseInt(cellArr[k]);
                }
            }
            int[][] dp = new int[n + 1][2];
            for (int j = 1; j <= n; j++) {
                if (j == 1) {
                    dp[j][0] = Math.max(dp[j - 1][0], walkRight(fruit[j - 1]) + dp[j - 1][0]);
                    dp[j][1] = getSum(fruit[j - 1]) + dp[j - 1][0];
                } else {
                    dp[j][0] = Math.max(Math.max(dp[j - 1][0], getSum(fruit[j - 1]) + dp[j - 1][1]), walkRight(fruit[j - 1]) + dp[j - 1][0]);
                    dp[j][1] = Math.max(Math.max(dp[j - 1][1], getSum(fruit[j - 1]) + dp[j - 1][0]), walkLeft(fruit[j - 1]) + dp[j - 1][1]);
                }
            }
            System.out.println(Math.max(dp[n][0], dp[n][1]));
        }
        return;
    }

    public static int getSum(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum;
    }

    public static int walkLeft(int[] nums) {
        int res = 0, sum = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            sum += nums[i];
            res = Math.max(res, sum);
        }
        return res;
    }

    public static int walkRight(int[] nums) {
        int res = 0, sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            res = Math.max(res, sum);
        }
        return res;
    }
    public String largestNumber(int[] nums) {
        String[] strArray = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strArray[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strArray, (str1, str2)->{
            long num1 = Long.parseLong(str1 + str2);
            long num2 = Long.parseLong(str2 + str1);
            return (int) (num2 - num1);
        });
        StringBuilder sb = new StringBuilder();
        for (String str : strArray) {
            sb.append(str);
        }
        return sb.toString();
    }
}

