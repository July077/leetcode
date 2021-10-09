import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

/**
 * 352. 将数据流变为多个不相交区间
 * 给你一个由非负整数a1, a2, ..., an 组成的数据流输入，请你将到目前为止看到的数字总结为不相交的区间列表。
 * <p>
 * 实现 SummaryRanges 类：
 * <p>
 * SummaryRanges() 使用一个空数据流初始化对象。
 * void addNum(int val) 向数据流中加入整数 val 。
 * int[][] getIntervals() 以不相交区间[starti, endi] 的列表形式返回对数据流中整数的总结。
 *
 * <p>
 * 示例：
 * <p>
 * 输入：
 * ["SummaryRanges", "addNum", "getIntervals", "addNum", "getIntervals", "addNum", "getIntervals", "addNum", "getIntervals", "addNum", "getIntervals"]
 * [[], [1], [], [3], [], [7], [], [2], [], [6], []]
 * 输出：
 * [null, null, [[1, 1]], null, [[1, 1], [3, 3]], null, [[1, 1], [3, 3], [7, 7]], null, [[1, 3], [7, 7]], null, [[1, 3], [6, 7]]]
 * <p>
 * 解释：
 * SummaryRanges summaryRanges = new SummaryRanges();
 * summaryRanges.addNum(1);      // arr = [1]
 * summaryRanges.getIntervals(); // 返回 [[1, 1]]
 * summaryRanges.addNum(3);      // arr = [1, 3]
 * summaryRanges.getIntervals(); // 返回 [[1, 1], [3, 3]]
 * summaryRanges.addNum(7);      // arr = [1, 3, 7]
 * summaryRanges.getIntervals(); // 返回 [[1, 1], [3, 3], [7, 7]]
 * summaryRanges.addNum(2);      // arr = [1, 2, 3, 7]
 * summaryRanges.getIntervals(); // 返回 [[1, 3], [7, 7]]
 * summaryRanges.addNum(6);      // arr = [1, 2, 3, 6, 7]
 * summaryRanges.getIntervals(); // 返回 [[1, 3], [6, 7]]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/data-stream-as-disjoint-intervals
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author sunjianrong
 * @date 2021-10-09 11:57
 */
public class Q352将数据流变为多个不相交区间 {

    private TreeSet<Integer> treeSet;


    public Q352将数据流变为多个不相交区间() {
        treeSet = new TreeSet<>();
    }

    public void addNum(int val) {
        treeSet.add(val);
    }

    public int[][] getIntervals() {
        List<int[]> res = new ArrayList<>();
        final Iterator<Integer> iterator = treeSet.iterator();
        int left = -1;
        int right = -1;
        while (iterator.hasNext()) {
            int item = iterator.next();
            if (left == -1) {
                left = right = item;
            } else {
                // 合并
                if (right + 1 == item) {
                    right = item;
                } else {
                    res.add(new int[]{left, right});
                    left = right = item;
                }
            }
        }

        res.add(new int[]{left, right});

        int[][] r = new int[res.size()][2];
        final int size = res.size();
        for (int i = 0; i < size; i++) {
            r[i] = res.get(i);
        }
        return r;
    }
}
