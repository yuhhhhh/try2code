package shopee;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class sp2 {
    static long[] tmp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int n = Integer.parseInt(line.split(" ")[0]);
        int m = Integer.parseInt(line.split(" ")[1]);
        line = br.readLine();
        long[] v = new long[n];
        String[] s = line.split(" ");
        long[] preSum = new long[n+1];
        for (int i = 0; i < n; i++) {
            v[i] = Long.parseLong(s[i]) - m;
        }
        for (int i = 1; i <= n; i++) {
            preSum[i] = preSum[i-1] + v[i-1];
        }
        tmp = new long[preSum.length];
        System.out.println(mergeSort(preSum, 0, preSum.length - 1));
    }

    public static long mergeSort(long[] nums, int l, int r) {
        if (l >= r) return 0;
        int m = (l + r) / 2;
        long res = mergeSort(nums, l, m) + mergeSort(nums, m+1, r);
        for (int i = l; i <= r; i++) {
            tmp[i] = nums[i];
        }
        int pre = l, post = m+1;
        for (int i = l; i <= r; i++) {
            if (pre > m) {
                nums[i] = tmp[post++];
            }
            else if (post > r || tmp[pre] <= tmp[post]) {
                nums[i] = tmp[pre++];
                res += r - post + 1;
            } else {
                nums[i] = tmp[post++];
            }
        }
        return res;
    }

}
