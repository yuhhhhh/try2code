package code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class lc15 {
    public static void main(String[] args) {
        // if (nums.length < 3) return new ArrayList<Integer>();
        //int[] nums = new int[] {-1,0,1,2,-1,-4};
        List<Integer> list = new ArrayList<>();
        int[] nums = new int[] {0, 0, 0, 0};
//        int[] nums = new int[] {-2, 0, 1, 1, 2};
        Arrays.sort(nums);
        int l = 0, r = nums.length - 1, m = 1;
        List<List<Integer>> res = new ArrayList<>();

        while(l < r) {
            while (m < r) {
                if (nums[l] + nums[r] + nums[m] > 0) r--;
                else if (nums[l] + nums[r] + nums[m] < 0) m++;
                else {
//                    List<Integer> list = new ArrayList<>();
//                    list.add(nums[l]);
//                    list.add(nums[m]);
//                    list.add(nums[r]);
//                    res.add(list);
//                    int flag = nums[r];
//                    r--;
//                    while (r>=1 && nums[r] == flag) r--;
//                    m = l + 1;
                }
            }
            l++;
            m = l + 1;
        }
        System.out.println(res);
    }
}
