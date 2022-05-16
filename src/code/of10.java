package code;

public class of10 {
    public int numWays(int n) {
        // a为f(0)，b为f(1)开始
        int a = 1, b = 1, sum = 0;
        for(int i = 0; i < n; i++) {
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return a;
    }

}
