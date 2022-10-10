package code.middle;

public class lc300 {
    public static void main(String[] args) {
        int[] nums = {2, 3, 7, 11};
        int l = 0, r = nums.length - 1, target = 5;
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] < target) l = mid + 1;
            else r = mid;
        }
        System.out.println(l);
        System.out.println(r);
    }
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int res = 0;
        for (int num : nums) {
            int l = 0, r = res;
            while (l < r) {
                int mid = (l + r) / 2;
                if (dp[mid] < num) l = mid + 1;
                else r = mid;
            }
            dp[l] = num;
            if (r == res) res++;
        }
        return res;
    }
}
