package code;

import java.util.*;
import java.util.stream.Collectors;

public class lc297 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        public class Codec {

            // Encodes a tree to a single string.
            public String serialize(TreeNode root) {
                Deque<TreeNode> queue = new LinkedList<>();
                StringBuilder sb = new StringBuilder();
                sb.append("[");
                if (root != null) {
                    queue.addLast(root);
                }
                while (!queue.isEmpty()) {
                    int size = queue.size();
                    for (int i = 0; i < size; i++) {
                        TreeNode node = queue.removeFirst();
                        if (node == null) sb.append("null,");
                        else {
                            sb.append(node.val + ",");
                            queue.addLast(node.left);
                            queue.addLast(node.right);
                        }
                    }
                }
                if (sb.length() > 1)sb.deleteCharAt(sb.length() - 1);
                sb.append("]");
                return sb.toString();
            }

            // Decodes your encoded data to tree.
            public TreeNode deserialize(String data) {
                String[] strArr = data.substring(1, data.length() - 1).split(",");
                TreeNode root = null;
                Deque<TreeNode> queue = new LinkedList<>();
                if (!strArr[0].equals("") && !strArr[0].equals("null")) {
                    root = new TreeNode(Integer.parseInt(strArr[0]));
                    queue.addLast(root);
                }
                int i = 1;
                while (!queue.isEmpty()) {
                    TreeNode node = queue.removeFirst();
                    if (i < strArr.length && !strArr[i].equals("null")) {
                        node.left = new TreeNode(Integer.parseInt(strArr[i]));
                        queue.addLast(node.left);
                    }
                    i++;
                    if (i < strArr.length && !strArr[i].equals("null")) {
                        node.right = new TreeNode(Integer.parseInt(strArr[i]));
                        queue.addLast(node.right);
                    }
                    i++;
                }
                return root;
            }
        }
    }
}
