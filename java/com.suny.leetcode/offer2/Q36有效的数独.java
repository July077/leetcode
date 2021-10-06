package offer2;

/**
 * 36. 有效的数独
 * <p>
 * 请你判断一个9x9 的数独是否有效。只需要 根据以下规则 ，验证已经填入的数字是否有效即可。
 * <p>
 * 数字1-9在每一行只能出现一次。
 * 数字1-9在每一列只能出现一次。
 * 数字1-9在每一个以粗实线分隔的3x3宫内只能出现一次。（请参考示例图）
 * 数独部分空格内已填入了数字，空白格用'.'表示。
 * <p>
 * 注意：
 * <p>
 * 一个有效的数独（部分已被填充）不一定是可解的。
 * 只需要根据以上规则，验证已经填入的数字是否有效即可。
 * <p>
 *
 * @author sunjianrong
 * @date 2021-09-17 8:52
 */
public class Q36有效的数独 {

    public boolean isValidSudoku(char[][] board) {
        int[][] row = new int[9][9];
        int[][] col = new int[9][9];
        int[][] block = new int[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if ('1' <= board[i][j] && board[i][j] <= '9') {
                    if (++row[i][board[i][j] - '1'] > 1) {
                        return false;
                    }
                    if (++col[i][board[i][j] - '1'] > 1) {
                        return false;
                    }

                    int n = i / 3;
                    int m = j / 3;
                    int num = n * 3 + m;

                    if (++block[num][board[i][j] - '1'] > 1) {
                        return false;
                    }
                }
            }
        }
        return true;

    }
}
