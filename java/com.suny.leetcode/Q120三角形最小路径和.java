import java.util.ArrayList;
import java.util.List;

/**
 * 120. 三角形最小路径和
 * <p>
 * 给定一个三角形 triangle ，找出自顶向下的最小路径和。
 * <p>
 * 每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。
 *
 * @author sunjianrong
 * @date 2021-07-09 12:10
 */
public class Q120三角形最小路径和 {

    Integer[][] memo;

    public int minimumTotal(List<List<Integer>> triangle) {
        memo = new Integer[triangle.size()][triangle.size()];

        return dfs(triangle, 0, 0);
    }

    private int dfs(List<List<Integer>> triangle, int i, int j) {
        if (i == triangle.size()) {
            return 0;
        }

        if (memo[i][j] != null) {
            return memo[i][j];
        }

        return memo[i][j] = Math.min(dfs(triangle, i + 1, j), dfs(triangle, i + 1, j + 1)) + triangle.get(i).get(j);
    }


    public int minimumTotal0(List<List<Integer>> triangle) {
        // 暴力遍历
        int total = 0;

        int currLevel = 0;
        int lastLevelPoint = 0;
        for (int i = 0; i < triangle.size(); i++) {
            currLevel = i;

            final List<Integer> list = triangle.get(i);
            if (currLevel == 0) {
                total = total + list.get(0);
                continue;
            }


            int leftVal = 0;
            int rightVal = 0;
            for (int j = 0; j < list.size(); j++) {
                if (j == lastLevelPoint) {
                    leftVal = list.get(j);
                }
                if (j == lastLevelPoint + 1) {
                    rightVal = list.get(j);
                }
            }

            int targetVal;
            // 负数的时候取最大值
            if (leftVal < 0 && rightVal < 0) {
                targetVal = Math.max(leftVal, rightVal);
            } else {
                targetVal = Math.min(leftVal, rightVal);
            }

            // 正数的时候取最小值
            if (targetVal == leftVal) {
                total += leftVal;
            } else {
                lastLevelPoint = lastLevelPoint + 1;
                total += rightVal;
            }

        }

        return total;

    }

    public static void main(String[] args) {
        // List<List<Integer>> param = new ArrayList<>();
        // param.add(List.of(-1));
        // param.add(List.of(-2, -3));


        List<List<Integer>> param = new ArrayList<>();
        //param.add(List.of(-1));
        //param.add(List.of(2, 3));
        //param.add(List.of(1, -1, -3));

        final Q120三角形最小路径和 q120 = new Q120三角形最小路径和();
        final int minimumTotal = q120.minimumTotal(param);
        System.out.println(minimumTotal);
    }
}
