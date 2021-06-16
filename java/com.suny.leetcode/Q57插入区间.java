import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个 无重叠的 ，按照区间起始端点排序的区间列表。
 * <p>
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 * <p>
 *  
 * <p>
 *
 * @author sunjianrong
 * @date 2021/6/16 下午10:09
 */
public class Q57插入区间 {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        int idx = 0;
        List<int[]> res = new ArrayList<>();

        while (idx < intervals.length && intervals[idx][1] < newInterval[0]) {
            // 寻找需要合并的区间
            res.add(intervals[idx]);
            idx++;
        }

        // 待合并区间头小于当前区间尾
        while (idx < intervals.length && intervals[idx][0] <= newInterval[1]) {
            // 更新待合并区间头
            newInterval[0] = Math.min(newInterval[0], intervals[idx][0]);
            // 更新待合并区间尾
            newInterval[1] = Math.max(newInterval[1], intervals[idx][1]);
            idx++;
        }

        // 加入合并区间
        res.add(newInterval);

        // 加入剩余区间
        while (idx < intervals.length) {
            res.add(intervals[idx++]);
        }

        return res.toArray(new int[res.size()][]);

    }
}
