import java.util.Arrays;

/**
 * 52. N皇后 II
 * <p>
 * n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * <p>
 * 给你一个整数 n ，返回 n 皇后问题 不同的解决方案的数量。
 * <p>
 *
 * @author sunjianrong
 * @date 2021/6/14 下午9:50
 */
public class Q52N皇后II {
    int res;

    public int totalNQueens(int n) {
        char[][] board = new char[n][n];
        for (char[] c : board) {
            Arrays.fill(c, '.');
        }
        backtrack(n, board, 0);

        return res;
    }

    public boolean check(char[][] board, int row, int col, int n) {
        // 检查列中是否有皇后冲突
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        // 检查左上方是否有皇后     横坐标(row)-1    纵坐标(col)-1

        // i初始值为行数-1    j初始值为列数- 1
        for (int i = row -1, j = col -1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        // 检查右上方是否有皇后     横坐标(row)+1   纵坐标(col)-1
        for (int i = row -1, j = col +1 ; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }


    public void backtrack(int n, char[][] board, int row) {
        if (row == n) {
            res++;
            return;
        }

        for (int col = 0; col < n; col++) {
            if (!check(board, row, col, n)) {
                continue;
            }

            // 选择
            board[row][col] = 'Q';

            // 回溯
            backtrack(n, board, row + 1);

            // 撤销选择
            board[row][col] = '.';
        }
    }

}
