package code;

import java.util.ArrayList;
import java.util.List;

public class lc139 {
    public static void main(String[] args) {
        String s = "leetcode";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("leet");
        wordDict.add("code");
        int idx = 0;
        boolean st = true;
        while (idx < s.length() && st) {
            st = false;
            char a = s.charAt(idx);
            for (String str : wordDict) {
                System.out.println(s.substring(idx, idx+str.length()));
                if (str.charAt(0) == a
                        && s.substring(idx, idx+str.length()).equals(str)) {
                    idx += str.length();
                    st = true;
                    break;
                }
            }

        }
        System.out.println(st);
    }
}
