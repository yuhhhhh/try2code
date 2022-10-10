package code.middle;

public class lc97 {
    public static void main(String[] args) {
        new lc97().isInterleave("aabcc",
                "dbbca",
                "aadbbcbcac");
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        int len1 = s1.length();
        int len2 = s2.length();
        if (s3.length() != len1 + len2) return false;
        boolean[][] dp = new boolean[len1 + 1][len2 + 1];
        dp[0][0] = true;
        for (int i = 0; i <= len1; i++) {
            for (int j = 0; j <= len2; j++) {
                int k = i + j - 1;
                if (i > 0)
                dp[i][j] = (s1.charAt(i) == s3.charAt(k) && dp[i - 1][j]);
                if (j > 0)
                dp[i][j] = dp[i][j] || (s2.charAt(j) == s3.charAt(k) && dp[i][j - 1]);
            }
        }
        return dp[len1][len2];
    }
}
