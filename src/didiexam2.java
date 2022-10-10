public class didiexam2 {
    public static void main(String[] args) {
        int[] nums = {5, 4, 3, 1, 4, 1, 2, 4};
        System.out.println(getWater(nums));
    }

    public static int getWater(int[] nums) {
        int l = 0, r = 1, sum = 0;
        while (l < nums.length - 1) {
            int cur = 0;
            while (r < nums.length && nums[r] < nums[l]) {
                cur += nums[l] - nums[r++];
            }
            if(r < nums.length) sum += cur;
            l = r++;
        }
        l = nums.length - 2;
        r = nums.length - 1;
        while (r > 0) {
            int cur = 0;
            while (l >= 0 && nums[l] <= nums[r]) {
                cur += nums[r] - nums[l--];
            }
            if (l >= 0) sum += cur;
            r = l--;
        }
        return sum;
    }
}
