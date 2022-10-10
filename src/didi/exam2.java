package didi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class exam2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int[] lArr = new int[t], rArr = new int[t], tArr = new int[t];
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < t; i++) {
            lArr[i] = Integer.parseInt(input[i]);
        }
        input = br.readLine().split(" ");
        for (int i = 0; i < t; i++) {
            rArr[i] = Integer.parseInt(input[i]);
        }
        input = br.readLine().split(" ");
        for (int i = 0; i < t; i++) {
            tArr[i] = Integer.parseInt(input[i]);
        }
        for (int i = 0; i < t; i++) {
            System.out.print(getBeautyNum(lArr[i], rArr[i], tArr[i]));
            if (i != t - 1) {
                System.out.print(" ");
            }
        }
    }

    public static int getBeautyNum(int l, int r, int t) {
        int val = 0, cnt = 0;
        for (int i = l; i <= r; i++) {
            val = 0;
            int num = i;
            while (num > 0) {
                val ^= num % 10;
                num /= 10;
            }
            if (val == t) {
                i = (i / 10 + 1) * 10 - 1;
                cnt++;
            }
        }
        return cnt;
    }
}
