package offer;

import java.util.ArrayList;
import java.util.List;

public class of34 {
    List<Integer> list = new ArrayList<>();
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> pathSum(of32.TreeNode root, int target) {
        dfs(root, target);
        return res;
    }
    public void dfs(of32.TreeNode node, int target) {
        if (node == null) {
            return;
        }
        target -= node.val;
        list.add(node.val);
        if (target == 0) {
            res.add(list);
        }
        dfs(node.left, target);
        dfs(node.right, target);
        target += node.val;
        list.remove(list.size()-1);
    }
}
