package code.middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class lc40 {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(candidates, target, 0, 0);
        return res;
    }

    public void dfs(int[] candidates, int target, int cur, int idx) {
        if (cur == target) {
            res.add(new ArrayList<>(list));
            return ;
        } else if (cur > target) {
            return ;
        }
        for (int i = idx; i < candidates.length; i++) {
            if (i != idx && candidates[i] == candidates[i - 1]) continue;
            list.add(candidates[i]);
            dfs(candidates, target, cur + candidates[i], i + 1);
            list.remove(list.size() - 1);
        }
        return ;
    }
}
