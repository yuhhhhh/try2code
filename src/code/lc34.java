package code;

public class lc34 {

    public static void main(String[] args) {
        int[] nums = new int[]{5, 7, 7, 8, 8, 10};
        int target = 8;
        System.out.println(searchRange(nums, target));
    }

    public static int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) return new int[]{-1, -1};
        int left = lower_bound(nums, target);
        int right = upper_bound(nums, target);
        if (nums[left] != target || left == nums.length) {
            return new int[]{-1, -1};
        }
        return new int[]{left, right};
    }

    public static int lower_bound(int[] nums, int target) {
        int l = 0, r = nums.length, mid;
        while (l < r) {
            mid = (l + r) / 2;
            if (nums[mid] < target) {
                l = mid + 1;
            }
            else {
                r= mid;
            }
        }
        return l;
    }
    public static int upper_bound(int[] nums, int target) {
        int l = 0, r = nums.length, mid;
        while (l < r) {
            mid = (l + r) / 2;
            if (nums[mid] <= target) {
                l = mid + 1;
            }
            else {
                r= mid;
            }
        }
        return l;
    }
}
