package code.middle;

import java.util.ArrayList;
import java.util.List;

public class lc46 {
    public static void main(String[] args) {
        new lc46().permute(new int[]{1, 2, 3});
    }
    List<List<Integer>> res;
    List<Integer> cur;
    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        cur = new ArrayList<>();
        dfs(nums, 0);
        return res;
    }

    public void dfs(int[] nums, int idx) {
        if (nums.length == idx) {
            res.add(new ArrayList<>(cur));
            return ;
        }
        for (int i = idx; i < nums.length; i++) {
            swap(nums, i, idx);
            cur.add(nums[idx]);
            dfs(nums, idx + 1);
            cur.remove(cur.size() - 1);
        }
    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
