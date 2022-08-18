package code.middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class lc15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            int target = -nums[i], l = i + 1, r = nums.length - 1, sum = 0;
            while (l < r) {
                sum = nums[l] + nums[r];
                if (sum == target) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[l]);
                    list.add(nums[r]);
                    res.add(list);
                    l++;
                    while (l < nums.length && nums[l] == nums[l - 1]) {
                        l++;
                    }
                } else if (sum < target) {
                    l++;
                } else {
                    r--;
                }
            }
        }
        return res;
    }
}
