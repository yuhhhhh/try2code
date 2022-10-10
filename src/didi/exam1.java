package didi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class exam1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]), k = Integer.parseInt(input[1]);
        int[] arr = new int[n];
        input = br.readLine().split(" ");
        double sum = 0 ;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input[i]);
            sum += arr[i];
        }
        Arrays.sort(arr);
        double tmp = sum;
        int up = n, low = 0;
        while (up > 0 && tmp / (up) * k < arr[up - 1]) {
            tmp -= arr[--up];
        }
        tmp = sum;
        while (low < n && tmp / (n - low) * k < arr[n - 1]) {
            tmp -= arr[low++];
        }
        int res = Math.max(up, (n - low));
        // System.out.println(res);
        int r = 0, maxCap = 1;
        double avg = 0;
        sum = 0;
        for (int l = 0; l < n; l++) {
            while (r < n) {
                sum += arr[r];
                avg  = sum / (r - l + 1);
                if (avg * k >= arr[r]) {
                    r++;
                } else {
                    sum -= arr[r];
                    break;
                }
            }
            maxCap = Math.max(maxCap, r - l);
            sum -= arr[l];
        }
        System.out.println(Math.max(maxCap, res));
    }
}
