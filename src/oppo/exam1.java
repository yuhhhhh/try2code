package oppo;

import java.util.Arrays;

public class exam1 {
    public int maxDigit (int[] digits) {
        // write code here
        Arrays.sort(digits);
        int res = 0;
        for (int i = digits.length - 1; i >= 0; i--) {
            res = res * 10 + digits[i];
        }
        return res;
    }
}
