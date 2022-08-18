package code.middle;

public class lc5 {
    public String longestPalindrome(String s) {
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        int begin = 0, maxLen = 1;
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        for (int l = 2; l <= len; l++) {
            for (int i = 0; i <= len - l; i++) {
                int j = i + l - 1;
                if (s.charAt(i) == s.charAt(j)) {
                    if (l <= 3) dp[i][j] = true;
                    else dp[i][j] = dp[i + 1][j - 1];
                    if (dp[i][j] && l > maxLen) {
                        begin = i;
                        maxLen = l;
                    }
                } else {
                    dp[i][j] = false;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }
}
