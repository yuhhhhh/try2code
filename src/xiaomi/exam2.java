package xiaomi;

class Node {
    public int data;
    public Node left;
    public Node right;

    public Node(int data) {
        this.data = data;
    }

    public Node() {
    }

    public Node(int data, Node left, Node right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}

public class exam2 {
    Node res, pre;
    public Node Convert(Node pRootOfTree) {
        dfs(pRootOfTree);
        res.left = pre;
        pre.right = res;
        return res;
    }

    public void dfs(Node node) {
        if (node.left != null) dfs(node.left);
        if (pre == null) {
            pre = node;
            res = node;
        } else {
            node.left = pre;
            pre.right = node;
            pre = node;
        }
        if (node.right != null) dfs(node.right);
    }
}
