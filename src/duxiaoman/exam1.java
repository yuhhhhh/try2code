package duxiaoman;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class exam1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]), k = Integer.parseInt(input[1]);
        int[] nums = new int[n];
        input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(input[i]);
        }
        int min, max, cnt = 0;
        for (int i = 0; i < n; i++) {
            min = nums[i];
            max = nums[i];
            for (int j = i + 1; j < n; j++) {
                min = Math.min(nums[j], min);
                max = Math.max(nums[j], max);
                if (max / k == min && max % k == 0) cnt++;
            }
        }
        System.out.println(cnt);
    }
}
