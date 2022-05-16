package code;

public class lc704 {
    public static void main(String[] args) {
        int[] nums = new int[]{-1,0,3,5,9,12};
        int target = 2;
        int l = 0, r = nums.length-1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] < target) l = mid + 1;
            else if (nums[mid] > target) r = mid - 1;
            else System.out.println(mid);
        }
        System.out.println(-1);
    }
}
