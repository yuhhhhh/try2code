public class shence {
    public static void main(String[] args) {
        int[] price = {1, 6, 8, 3, 4, 2, 1};
        int[] maxValueIdx = getMaxValue(price);
        if (maxValueIdx.length != 0) System.out.println(maxValueIdx[0] + "," + maxValueIdx[1]);
    }

    public static int[] getMaxValue(int[] price) {
        if (price.length < 2) {
            return new int[]{};
        }
        int minPriceIdx = 0, curVal = 0, maxPriceIdx = 0, maxVal = Integer.MIN_VALUE;
        for (int i = 1; i < price.length; i++) {
            curVal = price[i] - price[minPriceIdx];
            if (curVal < 0) {
                minPriceIdx = i;
            }
            if (curVal > maxVal) {
                maxVal = curVal;
                maxPriceIdx = i;
            }
        }
        return new int[]{minPriceIdx, maxPriceIdx};
    }

}
