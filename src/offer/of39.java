package offer;

import java.util.HashMap;

public class of39 {
    public static int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int max = 0;
        int maxNum = 0;
        int a;
        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i]) == null) {
                map.put(nums[i], 1);
            } else {
                map.put(nums[i], map.get(nums[i]) + 1);
            }
        }
        for(int key: map.keySet()) {
            if(map.get(key) > max) {
                maxNum = key;
                max = map.get(key);
            }
        }
        return maxNum;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,2,2,2,5,4,2};
        int res = majorityElement(nums);
        System.out.println(res);
    }

}
