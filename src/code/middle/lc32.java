package code.middle;

public class lc32 {

    public static void main(String[] args) {
        int res = longestValidParentheses(")()())");
        System.out.println(res);
        System.out.println(longestValidParentheses("(()"));
    }

    public static int longestValidParentheses(String s) {
        int i = 0, res = 0;
        while(i < s.length()) {
            int lenVal = getLongVal(s, 0, 0, i);
            int len = lenVal - i + 1;
            if (lenVal == -1) i++;
            else i += len;
            res = Math.max(len, res);
        }
        return res;
    }

    public static int getLongVal(String s, int l, int r, int cur) {
        if (cur >= s.length()) {
            if (l == r) return cur - 1;
            else return -1;
        }
        if ((l - r) > s.length() - cur) return -1;
        char c = s.charAt(cur);
        if (c == '(') {
            l += 1;
        } else {
            r += 1;
        }
        if (r > l) {
            return -1;
        }
        int res = getLongVal(s, l, r, cur + 1);
        if (res == -1 && l == r) res = cur;
        return res;
    }

}
