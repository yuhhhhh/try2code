package code.middle;

import java.util.PriorityQueue;

public class lc215 {
    public int findKthLargest(int[] nums, int k) {
        if (nums.length == 0 || nums.length > k) return -1;
        PriorityQueue<Integer> heap = new PriorityQueue<>(k);
        for (int num : nums) {
            if (heap.size() < k) {
                heap.add(num);
            } else {
                if (heap.peek() < num) {
                    heap.poll();
                    heap.add(num);
                }
            }
        }
        return heap.peek();
    }
}
