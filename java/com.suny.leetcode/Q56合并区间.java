import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 56. 合并区间
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
 *
 * @author sunjianrong
 * @date 2021-06-16 11:55
 */
public class Q56合并区间 {

    public int[][] merge(int[][] intervals) {
        final int length = intervals.length;
        if (length < 2) {
            return intervals;
        }

        // 排序
        Arrays.sort(intervals, Comparator.comparing(o -> o[0]));

        // 区间划分
        List<int[]> res = new ArrayList<>();
        res.add(intervals[0]);

        for (int i = 1; i < length; i++) {
            int[] currentInterval = intervals[i];

            // 每次遍历到的跟当前结果集中的最好一个区间的末尾节点进行比较
            int[] peek = res.get(res.size() - 1);

            if (currentInterval[0] > peek[1]) {
                res.add(currentInterval);
            } else {
                // 取最大
                peek[1] = Math.max(currentInterval[1], peek[1]);
            }
        }

        return res.toArray(new int[res.size()][]);

    }


    public static void main(String[] args) {
        final Q56合并区间 mergeRange = new Q56合并区间();
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] res = mergeRange.merge(intervals);
        Arrays.stream(res).map(Arrays::toString).forEach(System.out::println);

    }


}
