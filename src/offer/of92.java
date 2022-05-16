package offer;

public class of92 {
    public static void main(String[] args) {
        int res = minFlipsMonoIncr("00110");
        System.out.println(res);
    }

    public static int minFlipsMonoIncr(String s) {
        int one = 0, zero = 0;
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '0') {
                one = Math.min(one, zero) + 1;
            } else {
                one = Math.min(one, zero);
                zero++;
            }
        }
        return Math.min(zero, one);
    }
}
