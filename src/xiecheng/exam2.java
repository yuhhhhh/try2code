package xiecheng;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class exam2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int q = Integer.parseInt(br.readLine());
        for (int i = 0; i < q; i++) {
            String[] input = br.readLine().split(" ");
            int[] nums = new int[3];
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < 3; j++) {
                nums[j] = Integer.parseInt(input[j]);
                min = Math.min(nums[j], min);
            }
            int res = min * 2;
            if (nums[1] > min) {
                res += nums[1] - min - 1;
            }
            System.out.println(res);
        }
    }
}
