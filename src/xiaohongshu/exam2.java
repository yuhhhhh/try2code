package xiaohongshu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class exam2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        long k = Long.parseLong(input[1]);
        long[] nums = new long[n];
        input = br.readLine().split(" ");
        for (int i = 0; i < input.length; i++) {
            nums[i] = Long.parseLong(input[i]);
        }
        Arrays.sort(nums);
        long cnt = 0;
        int lastIdx = n;
        for (int i = 0; i < nums.length; i++) {
//            if (lastIdx <= i) {
//                cnt += n - lastIdx - 1;
//            } else {
//                cnt += n - lastIdx;
//            }
//            for (int j = lastIdx - 1; j >= 0; j--) {
//                if (nums[i] * nums[j] >= k) {
//                    if (i != j) cnt++;
//                } else {
//                    lastIdx = j + 1;
//                    break;
//                }
//            }
            for (int j = n - 1; j >= 0; j--) {
                if (nums[i] * nums[j] >= k) {
                    if (i != j) cnt++;
                } else {
                    break;
                }
            }
        }
        System.out.println(cnt);
    }
}
