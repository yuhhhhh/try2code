package duxiaoman;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class exam2 {
    static boolean flag = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            flag = false;
            String[] input = br.readLine().split(" ");
            int n = Integer.parseInt(input[0]), m = Integer.parseInt(input[1]), k = Integer.parseInt(input[2]),
                    x = Integer.parseInt(input[3]);
            int[][] map = new int[n][m];
            for (int j = 0; j < n; j++) {
                input = br.readLine().split(" ");
                for (int l = 0; l < m; l++) {
                    map[j][l] = Integer.parseInt(input[l]);
                }
            }
            dfs(0, 0, map, 0, x);
            if (flag) System.out.println("yes");
            else System.out.println("no");
        }


    }

    public static void dfs(int x, int y, int[][] map, int cur, int target) {
        if (flag) return;
        cur += map[x][y];
        if (x == map.length - 1 && y == map[0].length - 1) {
            if (cur == target) {
                flag = true;
            }
        } else if (x == map.length - 1) {
            dfs(x, y + 1, map, cur, target);
        } else if (y == map[0].length - 1) {
            dfs(x + 1, y, map, cur, target);
        } else {
            dfs(x, y + 1, map, cur, target);
            dfs(x + 1, y, map, cur, target);
        }
    }
}
