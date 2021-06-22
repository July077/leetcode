/**
 * 74. 搜索二维矩阵
 * <p>
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 * <p>
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 *
 * @author sunjianrong
 * @date 2021/6/22 下午10:51
 */
public class Q74搜索二维矩阵 {


    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length - 1;
        int columns = 0;

        while (rows >= 0 && columns < matrix[0].length) {
            int num = matrix[rows][columns];
            if (num == target) {
                // 匹配
                return true;
            } else if (num > target) {
                // 目标数小于当前数,说明得往上面移
                rows--;
            } else {
                // 目标数大于当前数,就得往右移,右边的数更大
                columns++;
            }
        }
        return false;

    }

    // 暴力匹配
    public boolean searchMatrix0(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == target) {
                    return true;
                }
            }
        }

        return false;

    }
}
