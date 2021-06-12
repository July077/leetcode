import java.util.*;

/**
 * @author sunjianrong
 * @date 2021/6/12 下午10:30
 */
public class Q51N皇后 {


    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();

        // 皇后数组,一开始都是-1,下标代表行数，值代表列数, 如 queens[0] 代表 0,0 有皇后
        int[] queens = new int[n];
        Arrays.fill(queens, -1);

        // 列
        Set<Integer> columns = new HashSet<>();

        // 两组斜线,下标代表
        Set<Integer> diagonals1 = new HashSet<>();
        Set<Integer> diagonals2 = new HashSet<>();

        // 递归
        backtrack(res, queens, n, 0, columns, diagonals1, diagonals2);
        return res;

    }


    public void backtrack(List<List<String>> solutions, int[] queens, int n, int row,
                          Set<Integer> columns, Set<Integer> diagonals1, Set<Integer> diagonals2) {
        if (row == n) {
            // 当行数位n的时候,就是添加完
            List<String> board = generateBoard(queens, n);
            solutions.add(board);
        } else {
            // 这一行的每一列都师徒插入
            for (int i = 0; i < n; i++) {
                // 如果列已经有跳过
                if (columns.contains(i)) {
                    continue;
                }


                // 获取斜线  坐标差可以确定一条线,同一斜线的差相等
                int diagonal1 = row - i;
                if (diagonals1.contains(diagonal1)) {
                    continue;
                }

                int diagonal2 = row + i;
                if (diagonals2.contains(diagonal2)) {
                    continue;
                }

                // 添加皇后这个坐标可以存在皇后，记录皇后的位置  row代表行数 i代表列数  tow由递归传递进来

                queens[row] = i;

                // 更新三组变量

                columns.add(i);
                diagonals1.add(diagonal1);
                diagonals2.add(diagonal2);

                // 继续递归 添加下一皇后 行数要+1

                backtrack(solutions, queens, n, row + 1, columns, diagonals1, diagonals2);

                // 回溯
                queens[row] = -1;

                columns.remove(i);

                diagonals1.remove(diagonal1);
                diagonals2.remove(diagonal2);
            }


        }
    }

    public List<String> generateBoard(int[] queens, int n) {
        List<String> board = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char[] row = new char[n];
            Arrays.fill(row, '.');
            row[queens[i]] = 'Q';
            board.add(new String(row));
        }

        return board;
    }

    public void backtrack(List<List<String>> res, int n, char[][] board, int row) {
        if (row == n) {
            res.add(array2list(board));
            return;
        }

        for (int col = 0; col < n; col++) {
            if (!isValid(board, row, col, n)) {
                continue;
            }
            // 做选择
            board[row][col] = 'Q';
            backtrack(res, n, board, row + 1);
            // 撤销选择
            board[row][col] = '.';
        }
    }


    public boolean isValid(char[][] board, int row, int col, int n) {
        // 检查列中是否有皇后冲突
        for (int i = 0; i < row; i++) {
            boolean has = board[i][col] == 'Q';
            System.out.printf("检查%d行%d列中是否有皇后:%s%n", i, col, has);
            if (has) {
                return false;
            }
        }

        // 检查右上方是否有皇后
        for (int i = row - 1; i >= 0; i--) {
            for (int j = col + 1; j < n; j++) {
                if (board[i][j] == 'Q') {
                    return false;
                }
            }
        }


        // 检查左上角是否有皇后冲突
        for (int i = row - 1; i >= 0; i--) {
            for (int j = col - 1; j >= 0; j--) {
                if (i >= 0 && j >= 0) {
                    if (board[i][j] == 'Q') {
                        return false;
                    }
                }
            }
        }

        return true;

    }


    public List<String> array2list(char[][] board) {
        List<String> list = new ArrayList<>();
        for (char[] c : board) {
            list.add(String.copyValueOf(c));
        }

        return list;
    }


    public static void main(String[] args) {
        Q51N皇后 queen = new Q51N皇后();
        queen.solveNQueens(4);
    }

}
