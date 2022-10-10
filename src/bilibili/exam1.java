package bilibili;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class exam1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        System.out.println(getMaxSum(n));
    }

    public static long getMaxSum(long n) {
        if (n <= 2) return n;
        long max = (long) Math.sqrt(n);
        long res = n;
        boolean flag = false;
        long tmp = 0;
        for (long i = 2; i <= max; i++) {
            if (n % i == 0) {
                flag = true;
                if ((i + n / i) <= res) {
                    res = i + n / i;
                    tmp = i;
                }
            }
        }
        if (!flag) {
            return res;
        } else {
           return getMaxSum(tmp) + getMaxSum(n / tmp);
        }
    }
}
