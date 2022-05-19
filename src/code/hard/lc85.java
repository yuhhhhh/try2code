package code.hard;

import java.util.Deque;
import java.util.LinkedList;

public class lc85 {

    public  int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        if (m == 0) return 0;
        int n = matrix[0].length;
        int[][] left = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0) {
                    left[i][j] = matrix[i][j] == '0' ? 0 : 1;
                } else {
                    left[i][j] = matrix[i][j] == '0' ? 0 : left[i][j - 1] + 1;
                }
            }
        }
        int res = 0;
        for (int j = 0; j < n; j++) {
            int[] up = new int[m];
            int[] down = new int[m];
            Deque<Integer> stack = new LinkedList<>();
            for (int i = 0; i < m; i++) {
                while (!stack.isEmpty() && left[stack.peekLast()][j] >= left[i][j]) {
                    stack.removeLast();
                }
                up[i] = stack.isEmpty() ? -1 : stack.peekLast();
                stack.addLast(i);
            }
            stack.clear();
            for (int i = m - 1; i >= 0; i--) {
                while (!stack.isEmpty() && left[stack.peekLast()][j] >= left[i][j]) {
                    stack.removeLast();
                }
                down[i] = stack.isEmpty() ? m : stack.peekLast();
                stack.addLast(i);
            }
            for (int i = 0; i < m; i++) {
                int area = left[i][j] * (down[i] - up[i] - 1);
                res = Math.max(area, res);
            }
        }
        return res;
    }

}
