package tianyiyun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class exam1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            arr[i][0] = Integer.parseInt(input[0]);
            arr[i][1] = Integer.parseInt(input[1]);
        }
        Arrays.sort(arr, (a1, a2) -> a1[0] - a2[0]);
        int begin = arr[0][0], end = arr[0][1], len = end - begin, cBegin = -1, cEnd = -1;
        long res = 0;
        for (int i = 1; i < n; i++) {
            if (arr[i][0] < end) {
                if(arr[i][0] > begin) res += arr[i][0] - begin;
                begin = Math.min(arr[i][1], end);
                end = Math.max(arr[i][1], end);
            } else {
                res += end - begin;
                begin = arr[i][0];
                end = arr[i][1];
            }
        }
        res += end - begin;
        System.out.println(res);
    }
}
