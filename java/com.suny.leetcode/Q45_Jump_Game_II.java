/**
 * 45. 跳跃游戏 II
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * <p>
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * <p>
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 * <p>
 * 假设你总是可以到达数组的最后一个位置。
 * <p>
 *
 * @author sunjianrong
 * @date 2021/6/7 下午11:06
 */
public class Q45_Jump_Game_II {
    public int jump(int[] nums) {
        int steps = 0;
        int end = 0;
        int maxPos = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            // 找到可以跳到最远的
            maxPos = Math.max(nums[i] + i, maxPos);

            // 遇到边界,就更新边界,并加步骤数
            if (i == end) {
                end = maxPos;
                steps++;
            }

        }

        return steps;

    }


}
