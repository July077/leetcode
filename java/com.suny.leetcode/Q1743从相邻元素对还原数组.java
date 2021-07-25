import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 1743. 从相邻元素对还原数组
 * <p>
 * 存在一个由 n 个不同元素组成的整数数组 nums ，但你已经记不清具体内容。好在你还记得 nums 中的每一对相邻元素。
 * <p>
 * 给你一个二维整数数组 adjacentPairs ，大小为 n - 1 ，其中每个 adjacentPairs[i] = [ui, vi] 表示元素 ui 和 vi 在 nums 中相邻。
 * <p>
 * 题目数据保证所有由元素 nums[i] 和 nums[i+1] 组成的相邻元素对都存在于 adjacentPairs 中，存在形式可能是 [nums[i], nums[i+1]] ，也可能是 [nums[i+1], nums[i]] 。这些相邻元素对可以 按任意顺序 出现。
 * <p>
 * 返回 原始数组 nums 。如果存在多种解答，返回 其中任意一个 即可。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：adjacentPairs = [[2,1],[3,4],[3,2]]
 * 输出：[1,2,3,4]
 * 解释：数组的所有相邻元素对都在 adjacentPairs 中。
 * 特别要注意的是，adjacentPairs[i] 只表示两个元素相邻，并不保证其 左-右 顺序。
 * 示例 2：
 * <p>
 * 输入：adjacentPairs = [[4,-2],[1,4],[-3,1]]
 * 输出：[-2,4,1,-3]
 * 解释：数组中可能存在负数。
 * 另一种解答是 [-3,1,4,-2] ，也会被视作正确答案。
 * 示例 3：
 * <p>
 * 输入：adjacentPairs = [[100000,-100000]]
 * 输出：[100000,-100000]
 *
 * @author sunjianrong
 * @date 2021/7/25 上午9:57
 */
public class Q1743从相邻元素对还原数组 {


    public int[] restoreArray(int[][] adjacentPairs) {
        int m = adjacentPairs.length;
        int n = m + 1;
        Map<Integer, Integer> cnts = new HashMap<>();
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int[] ints : adjacentPairs) {
            int a = ints[0];
            int b = ints[1];
            cnts.put(a, cnts.getOrDefault(a, 0) + 1);
            cnts.put(b, cnts.getOrDefault(b, 0) + 1);

            List<Integer> aList = map.getOrDefault(a, new ArrayList<>());
            aList.add(b);
            map.put(a, aList);

            List<Integer> bList = map.getOrDefault(b, new ArrayList<>());
            bList.add(a);
            map.put(b, bList);
        }

        int start = -1;
        for (Integer i : cnts.keySet()) {
            if (cnts.get(i) == 1) {
                start = i;
                break;
            }
        }

        int[] ans = new int[n];
        ans[0] = start;
        ans[1] = map.get(start).get(0);

        for (int i = 2; i < n; i++) {
            int x = ans[i - 1];
            List<Integer> list = map.get(x);
            for (Integer j : list) {
                if (j != ans[i - 2]) {
                    ans[i] = j;
                }
            }
        }

        return ans;

    }

}
