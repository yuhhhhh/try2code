package code;

public class lc76 {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        String result = minWindow(s,t);
        System.out.println(result);
    }

    public static String minWindow(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();
        boolean[] flag = new boolean[52];
        int[] charNum = new int[52];
        for (int i = 0; i < tLen; i++) {
            flag[t.charAt(i) - 'A'] = true;
            ++charNum[t.charAt(i) - 'A'];
        }
        int cnt = 0, l = 0, r = 0, min_len = sLen+1, min_l = 0;
        for (r = 0; r < sLen; r++) {
            if (flag[s.charAt(r) - 'A']) {
                if (--charNum[s.charAt(r) - 'A'] >= 0) {
                    cnt++;
                }
                while (cnt == tLen) {
                    if (r-l+1 < min_len) {
                        min_len = r-l+1;
                        min_l = l;
                    }
                    if (flag[s.charAt(l)-'A'] && ++charNum[s.charAt(l)-'A']>0) {
                        cnt--;
                    }
                    l++;
                }
            }
        }
        return min_len > sLen ? "":s.substring(min_l,min_l+min_len);
    }
}
