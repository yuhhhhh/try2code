package code;

import java.util.*;

public class lc239 {
    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        maxSlidingWindow(nums, 3);
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> queue = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            if (queue.isEmpty()) queue.addLast(nums[i]);
            else {
                while (!queue.isEmpty() && queue.peekLast() < nums[i]) queue.removeLast();
                queue.addLast(nums[i]);
            }
        }
        int[] res = new int[nums.length - k + 1];
        res[0] = queue.peekFirst();
        for (int i = 1; i <= nums.length - k; i++) {
            if (nums[i - 1] == queue.peekFirst()) queue.removeFirst();
            while (!queue.isEmpty() && queue.peekLast() < nums[i + k - 1]) queue.removeLast();
            queue.addLast(nums[i + k - 1]);
            res[i] = queue.peekFirst();
        }
        return res;
    }
}
