import java.util.ArrayList;
import java.util.List;

/**
 * 54. 螺旋矩阵
 * <p>
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 *
 * @author sunjianrong
 * @date 2021/6/15 下午9:23
 */
public class Q54螺旋矩阵 {

    public List<Integer> spiralOrder(int[][] matrix) {
        // 定义出4种走法
        // 从左到右,x不变y++   matrix[x][y++]
        // 从右到下,x++ y不变   matrix[x++][y]
        // 从右到左,x不变y--   matrix[x][y--]
        // 从下到上,x--y不变   matrix[x--][y]
        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> res = new ArrayList<>();

        // 边界
        int up = 0;
        int down = m - 1;
        int left = 0;
        int right = n - 1;

        // 当前坐标
        int x = 0;
        int y = 0;

        // while 跑完更新边界 xy , 让下一阶段的起始坐标是对的
        while (up <= down && left <= right) {
            // 从左到右
            while (y <= right && up <= down && left <= right) {
                res.add(matrix[x][y++]);
            }

            x = ++up;
            y = right;

            // 从右到下
            while (x <= down && up <= down && left <= right) {
                res.add(matrix[x++][y]);
            }
            x = down;
            y = --right;


            // 从右到左
            while (y >= left && up <= down && left <= right) {
                res.add(matrix[x][y--]);
            }
            x = --down;
            y = left;


            // 从下到上
            while (x >= up && up <= down && left <= right) {
                res.add(matrix[x--][y]);
            }
            x = up;
            y = ++left;

        }

        return res;

    }
}
