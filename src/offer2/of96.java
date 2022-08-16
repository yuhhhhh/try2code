package offer2;

public class of96 {
    public static void main(String[] args) {
        System.out.println(isInterleave("aabcc", "dbbca", "aadbbcbcac"));
    }

    public static boolean isInterleave(String s1, String s2, String s3) {
        int len1 = s1.length(), len2 = s2.length();
        if (len1 + len2 != s3.length()) return false;
        boolean[][] dp = new boolean[len1 + 1][len2 + 1];
        dp[0][0] = true;
        dp[1][0] = s1.charAt(0) == s3.charAt(0);
        dp[0][1] = s2.charAt(0) == s3.charAt(0);
        for (int i = 0; i <= len1; i++) {
            for (int j = 0; j <= len2; j++) {
                if (i == 0 && j == 0) continue;
                char c = s3.charAt(i + j - 1);
                if (i > 0 && s1.charAt(i - 1) == c) {
                    dp[i][j] = dp[i][j] || dp[i - 1][j];
                }
                if (j > 0 && s2.charAt(j - 1) == c) {
                    dp[i][j] = dp[i][j] || dp[i][j - 1];
                }
            }
        }
        return dp[len1][len2];
    }
}
