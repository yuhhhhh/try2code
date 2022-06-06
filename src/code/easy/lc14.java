package code.easy;

public class lc14 {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 1) return strs[0];
        int minLen = Integer.MAX_VALUE;
        String minStr = "";
        for (String str : strs) {
            if (str.length() < minLen) {
                minLen = str.length();
                minStr = str;
            }
        }
        for (int i = 0; i < minLen; i++) {
            char c = ' ';
            for (int j = 0; j < strs.length; j++) {
                if (j == 0) c = strs[j].charAt(i);
                else {
                    if (c != strs[j].charAt(i)) {
                        return strs[0].substring(0, i);
                    }
                }
            }
        }
        return minStr;
    }
}
