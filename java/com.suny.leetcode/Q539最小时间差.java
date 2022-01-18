import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * 539. 最小时间差
 * 给定一个 24 小时制（小时:分钟 "HH:MM"）的时间列表，找出列表中任意两个时间的最小时间差并以分钟数表示。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入：timePoints = ["23:59","00:00"]
 * 输出：1
 * 示例 2：
 * 
 * 输入：timePoints = ["00:00","23:59","00:00"]
 * 输出：0
 */
public class Q539最小时间差 {

    public int findMinDifference(List<String> timePoints) {
        Collections.sort(timePoints);
        int ans = Integer.MAX_VALUE;
        int t0Minutes = getMinutes(timePoints.get(0));
        int preMinutes = t0Minutes;
        for (int i = 1; i < timePoints.size(); i++) {
            int minutes = getMinutes(timePoints.get(i));
            ans = Math.min(ans, minutes - preMinutes);
            preMinutes = minutes;
        }
        ans = Math.min(ans, t0Minutes + 1440 - preMinutes);
        return ans;

    }

    public int getMinutes(String t) {
        return ((t.charAt(0) - '0') * 10 + (t.charAt(1) - '0')) * 60 + (t.charAt(3) - '0') * 10 + (t.charAt(4) - '0');
    }
}
