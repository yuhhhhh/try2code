package code.middle;

import common.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class lc199 {
    public List<Integer> rightSideView(TreeNode root) {
        Deque<TreeNode> queue = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        if (root != null) queue.addLast(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            TreeNode node = queue.peekFirst();
            for (int i = 0; i < size; i++) {
                node = queue.removeFirst();
                if (node.left != null) queue.addLast(node.left);
                if (node.right != null) queue.addLast(node.right);
            }
             res.add(node.val);
        }
        return res;
    }
}
