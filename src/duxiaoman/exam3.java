package duxiaoman;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class exam3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long res = 1;
        for (int i = 0; i < n; i++) {
            res *= 9;
            res = res % 1000000007;
        }
        for (int i = 2; i < n; i++) {
            res -= cal(i, n) * 8;
        }
        res -= 1;
        System.out.println(res);
    }

    public static long cal(int check, int all) {
        long up = 1, low = 1;

        for (int i = 0; i < check; i++) {
            up *= (all - i);
            up = up % 1000000007;
        }
        for (int i = check; i >= 1; i--) {
            low *= i;
            low = low % 1000000007;
        }
        return (up / low) % 1000000007;
    }
}
