package offer2;

import java.util.Arrays;

public class of102 {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = Arrays.stream(nums).sum();
        if (target > sum || target < -sum) return 0;
        int[][] dp = new int[nums.length][sum * 2 + 1];
        dp[0][sum + nums[0]] += 1;
        dp[0][sum - nums[0]] += 1;
        for (int i = 1; i < nums.length; i++) {
            int cur = nums[i];
            for (int j = -sum; j <= sum; j++) {
                if (j - cur < -sum) {
                    dp[i][j + sum] = dp[i - 1][j + cur + sum];
                } else if (j + cur > sum) {
                    dp[i][j + sum] = dp[i - 1][j - cur + sum];
                } else {
                    dp[i][j + sum] = dp[i - 1][j + cur + sum] + dp[i - 1][j - cur + sum];
                }
            }
        }
        return dp[nums.length - 1][target + sum];
    }
}
