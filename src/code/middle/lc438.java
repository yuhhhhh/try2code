package code.middle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class lc438 {
    public static void main(String[] args) {
        List<Integer> list = findAnagrams("cbaebabacd", "abc");
        System.out.println(list);
    }
    public static List<Integer> findAnagrams(String s, String p) {
        int[] st = new int[26];
        List<Integer> res = new ArrayList<>();
        // count表示对应窗口的字符串中有几个字符在p中没有出现过
        int count = 0, len = p.length();
        if (len > s.length()) return res;
        for (int i = 0; i < len; i++) {
            char c = p.charAt(i);
            if (st[c - 'a'] < 0) count--;
            st[c - 'a'] += 1;
            c = s.charAt(i);
            if (st[c - 'a'] <= 0) count++;
            st[c - 'a'] -= 1;
        }
        if (count == 0) res.add(0);
        for (int i = 1; i <= s.length() - len; i++) {
            char oldC = s.charAt(i - 1);
            char newC = s.charAt(i + len - 1);
            if (st[oldC - 'a'] < 0) count--;
            st[oldC - 'a'] += 1;
            if (st[newC - 'a'] <= 0) count++;
            st[newC - 'a'] -= 1;
            if (count == 0) res.add(i);
        }
        return res;
    }
}
