package code.middle;

public class lc7 {
    public static void main(String[] args) {
        reverse(-10);
    }
    public static int reverse(int x) {
        boolean flag = true;
        if (x < 0) flag = false;
        x = Math.abs(x);
        int res = 0;
        while (x > 0) {
            if (flag) {
                if ((Integer.MAX_VALUE - x % 10) / 10.0 < res) return 0;
            } else {
                if ((Integer.MAX_VALUE- x % 10) / 10.0 + 0.1 < res) return 0;
            }
            res = x % 10 + res * 10;
            x = x / 10;
        }
        if (!flag) res = -res;
        return res;
    }
}
