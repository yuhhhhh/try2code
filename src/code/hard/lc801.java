package code.hard;

public class lc801 {
    public int minSwap(int[] nums1, int[] nums2) {
        int[][] dp = new int[2][2];
        dp[0][1] = 1;
        for (int i = 1; i < nums1.length; i++) {
            if (nums1[i] > nums1[i - 1] && nums2[i] > nums2[i - 1] && nums1[i] > nums2[i - 1] && nums2[i] > nums1[i - 1]) {
                dp[i % 2][0] = Math.min(dp[(i-1) % 2][0], dp[(i-1) % 2][1]);
                dp[i % 2][1] = dp[i % 2][0] + 1;
            } else if (nums1[i] > nums1[i - 1] && nums2[i] > nums2[i - 1]) {
                dp[i % 2][0] = dp[(i-1) % 2][0];
                dp[i % 2][1] = dp[(i-1) % 2][1] + 1;
            } else if (nums1[i] > nums2[i - 1] && nums2[i] > nums1[i - 1]) {
                dp[i % 2][0] = dp[(i-1) % 2][1];
                dp[i % 2][1] = dp[(i-1) % 2][0] + 1;
            }
        }
        return Math.min(dp[(nums1.length - 1) % 2][0], dp[(nums1.length - 1) % 2][1]);
    }
}
