package code.middle;

public class lc8 {
    public static void main(String[] args) {
        myAtoi("words and 987");
    }
    public static int myAtoi(String s) {
        s = s.trim();
        int flag = 0;
        if (s.charAt(0) == '-') {
             flag = 1;
             s = s.substring(1);
        }
        int num = 0;
        char[] charArr = s.toCharArray();
        for (int i = 0; i < charArr.length; i++) {
            if (!isNum(charArr[i])) continue;
            if (Integer.MAX_VALUE / 10.0 + flag / 10.0 - (charArr[i] - '0') / 10.0 < num) {
                if (flag == 1) num = Integer.MIN_VALUE;
                else num = Integer.MAX_VALUE;
                break;
            }
            num = num * 10 + charArr[i] - '0';
        }
        if (flag == 1 && num != Integer.MIN_VALUE) num = -num;
        return num;
    }

    public static boolean isNum(char c) {
        return c >= '0' && c <= '9';
    }
}
