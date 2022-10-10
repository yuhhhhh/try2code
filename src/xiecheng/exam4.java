package xiecheng;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class exam4 {
    static class Node {
        int val;
        int idx;

        public Node(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(input[i]);
        }
        Node node1 = getMax(nums);
        int res = node1.val;
        int a = node1.idx;
        int tmp;
        tmp = nums[a - 1];
        if (a == 1) {
            nums[a - 1] = nums[a];
        } else {
            nums[a - 1] = (nums[a - 2] + nums[a]) / 2;
        }
        Node node2 = getMax(nums);
        res = Math.min(res, node2.val);
        nums[a - 1] = tmp;
        nums[a] = (nums[a - 1] + nums[a + 1]) / 2;
        node2 = getMax(nums);
        res = Math.min(res, node2.val);
        System.out.println(res);
    }

    public static Node getMax(int[] nums) {
        PriorityQueue<Node> queue = new PriorityQueue<>((n1, n2) -> n2.val - n1.val);
        for (int i = 1; i < nums.length; i++) {
            queue.add(new Node(Math.abs(nums[i] - nums[i - 1]), i));
        }
        return queue.remove();
    }
}
