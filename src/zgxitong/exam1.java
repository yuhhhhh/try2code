package zgxitong;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class exam1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String[] arr = input.substring(1, input.length() - 1).split(",");
        int[] nums = new int[arr.length];
        for (int i = 0; i < nums.length; i++) {
            String s = arr[i];
            if (s.charAt(0) == ' ') s = s.substring(1);
            nums[i] = Integer.parseInt(s);
        }
        Arrays.sort(nums);
        System.out.print("[");
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]);
            if (i != nums.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.print("]");
    }
}
