/**
 * 130. 被围绕的区域
 * <p>
 * 给你一个 m x n 的矩阵 board ，由若干字符 'X' 和 'O' ，找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
 *
 * @author sunjianrong
 * @date 2021-07-12 12:18
 */
public class Q130被围绕的区域 {


    public void solve(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }

        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 从边缘o 开始搜索
                boolean isEdge = i == 0 || j == 0 || i == m - 1 || j == n - 1;
                if (isEdge && board[i][j] == 'O') {
                    dfs(board, i, j);
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }

                if (board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }

    }


    private void dfs(char[][] board, int i, int j) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] == 'X' || board[i][j] == '#') {
            // 如果为 # 则说明已经搜索过了
            return;
        }

        board[i][j] = '#';
        // 上
        dfs(board, i - 1, j);

        // 下
        dfs(board, i + 1, j);

        // 左边
        dfs(board, i, j - 1);

        // 右边
        dfs(board, i, j + 1);
    }

}
