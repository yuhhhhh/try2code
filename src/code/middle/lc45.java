package code.middle;

import java.util.Arrays;

public class lc45 {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        System.out.println(jump(nums));
    }

    public static int jump(int[] nums) {
        int res = 0, start = 0, end = 1;
        while (end < nums.length) {
            int maxStep = 0;
            for (int i = start; i < end; i++) {
                maxStep = Math.max(maxStep, i + nums[i]);
            }
            start = end;
            end = maxStep + 1;
            res++;
        }
        return res;
    }
}
