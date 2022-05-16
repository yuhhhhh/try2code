package code;

import org.junit.Test;

import java.util.*;

public class lc18 {
    List<List<Integer>> res = new ArrayList<>();
    Set<Integer> set = new HashSet<>();
    int[] nums;

    @Test
    public void test1() {
        int target = 0;
        int[] nums = new int[] {1,0,-1,0,-2,2};
        this.nums = nums;
        Arrays.sort(nums);
        dfs(target);
        System.out.println(res);
    }



    public void dfs(int target) {
        if (set.size() == 4) {
            if (target == 0) {
                List<Integer> list = new ArrayList<Integer>();
                for (int i: set) {
                    list.add(nums[i]);
                }
                res.add(list);
            }
            return ;
        }

        for (int i = 0; i < nums.length; i++) {
            if (i != 0 && nums[i] == nums[i-1]) continue;
            if (!set.contains(i)) {
                set.add(i);
                dfs (target - nums[i]);
                set.remove(i);
            }
        }

        return ;
    }
}
