package shence;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class exam1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] inputs = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(inputs[j]);
            }
        }
        int st = 0;
        int x = 0, y = 0;
        List<Integer> res = new ArrayList<>();
        while (x != n - 1 || y != n - 1) {
            res.add(arr[x][y]);
            if (st % 4 == 0) {
                st++;
                if (y == n - 1) {
                    x += 1;
                } else {
                    y += 1;
                }
            } else if (st % 4 == 1) {
                x += 1;
                y -= 1;
                if (y == 0 || x == n - 1) {
                    st++;
                }
            } else if (st % 4 == 2) {
                st++;
                if (x == n - 1) {
                    y += 1;
                } else {
                    x += 1;
                }
            } else {
                x -= 1;
                y += 1;
                if (x == 0 || y == n - 1) {
                    st++;
                }
            }

        }
        res.add(arr[n - 1][n - 1]);
        for (int i = 0; i < res.size(); i++) {
            System.out.print(res.get(i));
            if (i != res.size() - 1) {
                System.out.print(" ");
            }
        }
    }
}
