package offer;

/**
 * 剑指 Offer 12. 矩阵中的路径
 * 给定一个m x n 二维字符网格board 和一个字符串单词word 。如果word 存在于网格中，返回 true ；否则，返回 false 。
 * <p>
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * <p>
 *
 * <p>
 * 例如，在下面的 3×4 的矩阵中包含单词 "ABCCED"（单词中的字母已标出）。
 * <p>
 *
 * @author sunjianrong
 * @date 2021-07-20 12:06
 */
public class Q12矩阵中的路径 {
    public boolean exist(char[][] board, String word) {
        final char[] charArray = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, charArray, i, j, 0)) {
                    return true;
                }

            }
        }
        return false;
    }

    private boolean dfs(char[][] board, char[] word, int i, int j, int k) {
        if (i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != word[k]) {
            return false;
        }

        if (k == word.length - 1) {
            return true;
        }

        board[i][j] = '\0';
        final int next = k + 1;
        boolean res = dfs(board, word, i + 1, j, next) // 往右边搜
                || dfs(board, word, i - 1, j, next) // 往左边搜
                || dfs(board, word, i, j + 1, next) // 往上面搜
                || dfs(board, word, i, j - 1, next); // 往下面搜

        board[i][j] = word[k];
        return res;
    }


}
