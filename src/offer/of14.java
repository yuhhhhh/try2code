package offer;

public class of14 {
    public void main(String[] args) {
        int x = cuttingRope(2);
        System.out.println(x);
    }

    public int cuttingRope(int n) {
        if (n == 1) return 1;
        int max = 0;
        int dp = 0;
        for (int i = 0; i < n; i++) {
            dp = cuttingRope(i+1)* (n-i-1);
            max = Math.max(dp, max);
        }

        return max;
    }
}
