package code.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class lc30 {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) return res;
        Map<String, Integer> dict = new HashMap<>();
        for (String str : words) {
            dict.put(str, dict.getOrDefault(str, 0) + 1);
        }
        int wordLen = words[0].length();
        int len = words.length;
        for (int i = 0; i <wordLen; i++) {
            int l = i, r = i, cnt = 0;
            Map<String, Integer> tmpDict = new HashMap<>();
            while (r + wordLen <= s.length()) {
                String str = s.substring(r, r + wordLen);
                tmpDict.put(str, tmpDict.getOrDefault(str, 0) + 1);
                r += wordLen;
                cnt++;
                while (tmpDict.getOrDefault(str, 0) > dict.getOrDefault(str, 0)) {
                    String tmpStr = s.substring(l, l + wordLen);
                    tmpDict.put(tmpStr, tmpDict.getOrDefault(tmpStr, 0) - 1);
                    l += wordLen;
                    cnt--;
                }
                if (cnt == len) res.add(l);
            }
        }
        return res;
    }
}
