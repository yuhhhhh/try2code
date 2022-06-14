package code.middle;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class lc47 {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        dfs(nums, 0);
        return res;
    }

    public void dfs(int[] nums, int idx) {
        if (idx == nums.length) {
            res.add(new ArrayList<>(list));
            return ;
        }
        Set<Integer> set = new HashSet<>();
        for (int i = idx; i < nums.length; i++) {
            if (set.contains(nums[i])) continue;
            swap(nums, idx, i);
            set.add(nums[idx]);
            list.add(nums[idx]);
            dfs(nums, idx + 1);
            swap(nums, idx, i);
            list.remove(list.size() - 1);
        }

    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
