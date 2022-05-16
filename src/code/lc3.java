package code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class lc3 {
    public static void main(String[] args) {
        String s = "abba";
        Map<Character, Integer> map = new HashMap<>();
        int l = 0, maxLen = 0;
        for (int r = 0; r < s.length(); r++) {
            char a = s.charAt(r);
            if (map.containsKey(a) && map.get(a) >= l) l = map.get(a) + 1;
            map.put(a, r);
            maxLen = Math.max(r-l+1, maxLen);
        }
        System.out.println(maxLen);
    }
}
