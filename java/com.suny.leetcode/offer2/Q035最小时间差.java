package offer2;

import java.util.ArrayList;
import java.util.List;

/**
 * 剑指 Offer II 035. 最小时间差
 * 给定一个 24 小时制（小时:分钟 "HH:MM"）的时间列表，找出列表中任意两个时间的最小时间差并以分钟数表示。
 * <p>
 *
 * <p>
 * 示例 1：
 * <p>
 * 输入：timePoints = ["23:59","00:00"]
 * 输出：1
 * <p>
 *
 * @author sunjianrong
 * @date 2021/8/18 下午9:27
 */
public class Q035最小时间差 {

    public int findMinDifference(List<String> timePoints) {
        int n = timePoints.size();
        if (n > 1440) {
            return 0;
        }

        int min = Integer.MAX_VALUE;

        List<Integer> res = new ArrayList<>();
        for (String timePoint : timePoints) {
            String[] split = timePoint.split(":");
            int i = Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
            res.add(i);
        }


        for (int i = 0; i < res.size(); i++) {
            for (int j = i + 1; j < res.size(); j++) {
                int m = Math.min(Math.abs(res.get(i) - res.get(j)), Math.abs(Math.abs(res.get(j) - res.get(i)) - 1440) );
                min = Math.min(min, m);
            }

        }
        return min;
    }

    public static void main(String[] args) {
        Q035最小时间差 q35 = new Q035最小时间差();

        List<String> list = new ArrayList<>();
        list.add("23:59");
        list.add("00:00");
        System.out.println(q35.findMinDifference(list));

    }
}
