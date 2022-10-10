package h3c;

public class exam3 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param nums1 int整型一维数组
     * @param nums2 int整型一维数组
     * @return double浮点型
     */
    public static void main(String[] args) {
        int[] num1 = {1, 4, 7, 9};
        int[] num2 = {2, 3, 6, 8};
        System.out.println(new exam3().findMedianSortedArrays(num1, num2));
    }
    int len1, len2;

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // write code here
        len1 = nums1.length;
        len2 = nums2.length;
        if ((len1 + len2) % 2 == 1) {
            return findTopKNum(nums1, nums2, (len1 + len2) / 2 + 1);
        } else {
            return (findTopKNum(nums1, nums2, (len1 + len2) / 2)
                    + findTopKNum(nums1, nums2, (len1 + len2) / 2 + 1)) / 2.0;
        }
    }

    public int findTopKNum(int[] num1, int[] num2, int k) {
        int idx1 = 0, idx2 = 0, mid;
        while (k > 1) {
            mid = k / 2 - 1;
            if (idx1 + mid >= len1) {
                return num2[idx2 + k - (len1 - idx1) - 1];
            } else if (idx2 + mid >= len2) {
                return num1[idx1 + k - (len2 - idx2) - 1];
            } else {
                if (num1[idx1 + mid] < num2[idx2 + mid]) {
                    k -= mid + 1;
                    idx1 += mid + 1;
                } else {
                    k -= mid + 1;
                    idx2 += mid + 1;
                }
            }
        }
        if (idx1 < len1 && idx2 < len2) {
            return Math.min(num1[idx1], num2[idx2]);
        } else if (idx1 >= len1) {
            return num2[idx2];
        } else {
            return num1[idx1];
        }
    }
}
