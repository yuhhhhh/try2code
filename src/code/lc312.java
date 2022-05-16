package code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class lc312 {
    class Solution {
        int[] val;
        int[][] rect;

        public int maxCoins(int[] nums) {
            val = new int[nums.length + 2];
            rect = new int[nums.length + 2][nums.length + 2];
            for (int i = 0; i < nums.length; i++) {
                val[i + 1] = nums[i];
            }
            val[0] = val[val.length - 1] = 1;
            for (int i = 0; i < rect.length; i++) {
                Arrays.fill(rect[i], -1);
            }
            return getConin(0, val.length - 1);
        }

        public int getConin(int l, int r) {
            if (l >= r - 1) return 0;
            if (rect[l][r] != -1) return rect[l][r];
            for (int i = l + 1; i < r; i++) {
                int num = val[l] * val[r] * val[i];
                num += getConin(l, i) + getConin(i, r);
                rect[l][r] = Math.max(rect[l][r], num);
            }
            return rect[l][r];
        }
    }
}
