package code.middle;

public class lc36 {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] row = new boolean[9][10];
        boolean[][] col = new boolean[9][10];
        boolean[][] box = new boolean[9][10];
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '.') continue;
                int num = board[i][j] - '0';
                if (row[i][num]) return false;
                if (col[j][num]) return false;
                if (box[(i / 3) * 3 + j / 3][num]) return false;
                row[i][num] = true;
                col[j][num] = true;
                box[(i / 3) * 3 + j / 3][num] = true;
            }
        }
        return true;
    }
}
