package zgxitong;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class exam3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String[] str = input.substring(15, input.length() - 2).split(",");
        int m = Integer.parseInt(br.readLine().substring(8, 9));
        int n = Integer.parseInt(br.readLine().substring(8, 9));
        int[] nums = new int[str.length];
        for (int i = 0; i < nums.length; i++) {
            String s = str[i];
            if (s.charAt(0) == ' ') s = s.substring(1);
            nums[i] = Integer.parseInt(s);
        }
        Arrays.sort(nums, m, n + 1);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }
}
