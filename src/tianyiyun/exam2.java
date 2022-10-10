package tianyiyun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class exam2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        String[] input = br.readLine().split(",");
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input[i]);
            if (arr[i] % 2 == 0) {
                cnt++;
            }
        }
        int[] newArr = new int[n];
        int l = 0, r = cnt;
        for (int i = 0; i < n; i++) {
            if (arr[i] % 2 == 0) {
                newArr[l++] = arr[i];
            } else {
                newArr[r++] = arr[i];
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.print(newArr[i]);
            if (i != (n - 1)) {
                System.out.print(",");
            }
        }
    }
}
