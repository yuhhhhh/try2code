package h3c;

public class exam2 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 二进制字符串相加
     * @param a string字符串
     * @param b string字符串
     * @return string字符串
     */
    public String addBinary (String a, String b) {
        // write code here
        StringBuffer sb = new StringBuffer();
        int aIdx = a.length() - 1, bIdx = b.length() - 1;
        boolean flag = false;
        while (aIdx >= 0 && bIdx >= 0) {
            char ca = a.charAt(aIdx--), cb = b.charAt(bIdx--);
            if (ca == '1' && cb == '1') {
                if (flag) {
                    sb.append('1');
                } else {
                    sb.append('0');
                    flag = true;
                }
            } else if (ca == '0' && cb == '0') {
                if (flag) {
                    sb.append('1');
                    flag = false;
                } else {
                    sb.append('0');
                }
            } else {
                if (flag) {
                    sb.append('0');
                } else {
                    sb.append('1');
                }
            }
        }
        String s = aIdx >= 0 ? a : b;
        int idx = aIdx >= 0 ? aIdx : bIdx;
        while (idx >= 0) {
            char c = s.charAt(idx--);
            if (c == '1') {
                if (flag) {
                    sb.append('0');
                } else {
                    sb.append('1');
                }
            } else {
                if (flag) {
                    sb.append('1');
                    flag = false;
                } else {
                    sb.append('0');
                }
            }
        }
        if (flag) sb.append('1');
        return sb.reverse().toString();
    }
}
