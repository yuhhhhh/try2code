package oppo;

public class exam3 {
    public static void main(String[] args) {
        System.out.println(new exam3().tourismRoutePlanning(4));
    }
    public long tourismRoutePlanning(int scenicspot) {
        // write code here
        int[] dp = new int[scenicspot + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= scenicspot; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[scenicspot];
    }
}
