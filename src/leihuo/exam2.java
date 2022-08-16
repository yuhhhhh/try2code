package leihuo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class exam2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int bit = 0, tmpN = n;
        while (tmpN > 0) {
            bit++;
            tmpN /= 10;
        }
        int res = 1;
        int start = 1;
        for (int i = 3; i <= bit; i++) {
            //if (25 * Math.pow(10, i - 2) < n) res++;
            for (int j = 0; j < i - 1; j++) {
                int tmp = (int) Math.pow(10, i - 2 - j);
                int min = (int)Math.pow(10, j-1);
                for (int k = 0; k < Math.pow(10, i - 2); k++) {
                    int low = k % tmp, up = k / tmp;

                    if (j != 0 && up < min) continue;
                    int num = tmp * 25 + low + up * tmp * 100;
                    if (num <= n) {
                        res++;
                    } else {
                        break;
                    }
                }
            }
            start *= 10;
        }
        System.out.println(res);
    }
}
