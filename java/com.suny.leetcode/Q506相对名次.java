import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * 506. 相对名次
 * 给你一个长度为 n 的整数数组 score ，其中 score[i] 是第 i 位运动员在比赛中的得分。所有得分都 互不相同 。
 * <p>
 * 运动员将根据得分 决定名次 ，其中名次第 1 的运动员得分最高，名次第 2 的运动员得分第 2 高，依此类推。运动员的名次决定了他们的获奖情况：
 * <p>
 * 名次第 1 的运动员获金牌 "Gold Medal" 。
 * 名次第 2 的运动员获银牌 "Silver Medal" 。
 * 名次第 3 的运动员获铜牌 "Bronze Medal" 。
 * 从名次第 4 到第 n 的运动员，只能获得他们的名次编号（即，名次第 x 的运动员获得编号 "x"）。
 * 使用长度为 n 的数组 answer 返回获奖，其中 answer[i] 是第 i 位运动员的获奖情况。
 * <p>
 *
 * <p>
 * 示例 1：
 * <p>
 * 输入：score = [5,4,3,2,1]
 * 输出：["Gold Medal","Silver Medal","Bronze Medal","4","5"]
 * 解释：名次为 [1st, 2nd, 3rd, 4th, 5th] 。
 * 示例 2：
 * <p>
 * 输入：score = [10,3,8,9,4]
 * 输出：["Gold Medal","5","Bronze Medal","Silver Medal","4"]
 * 解释：名次为 [1st, 5th, 3rd, 2nd, 4th] 。
 * <p>
 *
 * @author sunjianrong
 * @date 2021-12-02 9:13
 */
public class Q506相对名次 {


    public String[] findRelativeRanks(int[] score) {
        if (score == null) {
            return new String[0];
        }
        if (score.length == 1) {
            return new String[]{"Gold Medal"};
        }
        final int length = score.length;
        Map<Integer, Integer> map = new HashMap<>();

        Integer[] newScores = new Integer[length];
        for (int i = 0; i < score.length; i++) {
            newScores[i] = score[i];
        }

        Arrays.sort(newScores, Collections.reverseOrder());
        String[] res = new String[length];

        for (int i = 0; i < length; i++) {
            map.put(newScores[i], i);
        }


        for (int i = 0; i < length; i++) {
            final Integer integer = map.get(score[i]);


            if (integer == 0) {
                res[i] = "Gold Medal";
                continue;
            }
            if (integer == 1) {
                res[i] = "Silver Medal";
                continue;
            }
            if (integer == 2) {
                res[i] = "Bronze Medal";
                continue;
            }
            res[i] = String.valueOf(integer + 1);
        }

        return res;
    }

    public static void main(String[] args) {
        // final int[] ints = {10, 3, 8, 9, 4};
        final int[] ints = {1,2};
        System.out.println(Arrays.toString(new Q506相对名次().findRelativeRanks(ints)));
    }
}
