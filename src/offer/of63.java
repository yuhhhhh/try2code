package offer;

public class of63 {
    public static void main(String[] args) {
        int[] prices = new int[]{2,1,2,1,0,1,2};
        int[] maxP = new int[prices.length];
        int buyDay = 0;
        int sellDay = 0;
        int sellP = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] <= prices[buyDay]) {
                buyDay = i;
                continue;
            }
            if (prices[i] >= prices[sellDay] || sellDay == 0) {
                sellP = prices[i] - prices[buyDay];
                sellDay = i;
            }
        }
        System.out.println(sellP);
        
    }
}
