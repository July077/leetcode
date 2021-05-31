/**
 * 37. 解数独
 * 编写一个程序，通过填充空格来解决数独问题。
 * <p>
 * 数独的解法需 遵循如下规则：
 * <p>
 * 数字1-9在每一行只能出现一次。
 * 数字1-9在每一列只能出现一次。
 * 数字1-9在每一个以粗实线分隔的3x3宫内只能出现一次。（请参考示例图）
 * 数独部分空格内已填入了数字，空白格用'.'表示。
 *
 * @author sunjianrong
 * @date 2021/5/31 下午11:13
 */
public class Q37SudokuSolver {
    public void solveSudoku(char[][] board) {
        // 记录某行是否已经摆放
        boolean[][] row = new boolean[9][9];

        // 记录牟烈是否已经被摆放
        boolean[][] col = new boolean[9][9];

        // 记录 3x3 宫格
        boolean[][] block = new boolean[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '1';
                    row[i][num] = true;
                    col[j][num] = true;

                    block[i / 3 * 3 + j / 3][num] = true;
                }
            }
        }

        dfs(board, row, col, block, 0, 0);


    }


    private boolean dfs(char[][] board, boolean[][] row, boolean[][] col, boolean[][] block, int i, int j) {
        // 寻找空位置
        while (board[i][j] != '.') {
            if (++i >= 9) {
                i++;
                j = 0;
            }
            if (i >= 9) {
                return true;
            }
        }

        for (int num = 0; num < 9; num++) {
            int blockIndex = i / 3 * 3 + j / 3;
            if (!row[i][num] && !col[j][num] && !block[blockIndex][num]) {
                // 递归
                board[i][j] = (char) ('1' + num);
                row[i][num] = true;
                col[j][num] = true;
                block[blockIndex][num] = true;
                if (dfs(board, row, col, block, i, j)) {
                    return true;
                } else {
                    // 回溯
                    row[i][num] = false;
                    col[j][num] = false;
                    block[blockIndex][num] = false;
                    board[i][j] = '.';
                }
            }
        }
        return false;
    }


}
