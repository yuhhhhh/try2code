package code;

public class lc215 {
    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};
        System.out.println(findKthLargest(nums, 2));
    }

    public static int findKthLargest(int[] nums, int k) {
        return topK(nums, 0, nums.length-1, k);
    }

    public static int topK(int[] nums, int l, int r, int k) {
        int resIdx = quickSort(nums, l, r);
        int rank = nums.length - resIdx;
        if(rank == k) return nums[resIdx];
        return rank < k ? topK(nums, l, resIdx-1, k) : topK(nums, resIdx+1, r, k);
    }

    public static int quickSort(int[] nums, int l, int r) {
        int idx = l, first = l, key = nums[r];
        while (idx < r) {
            if (nums[idx] < key) {
                swap(nums, idx, first++);
            }
            idx++;
        }
        swap(nums, r, first);
        return first;
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
