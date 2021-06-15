/**
 * 55. 跳跃游戏
 * 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
 * <p>
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * <p>
 * 判断你是否能够到达最后一个下标。
 *
 * @author sunjianrong
 * @date 2021/6/15 下午10:45
 */
public class Q55跳跃游戏 {


    public boolean canJump(int[] nums) {
        if (nums == null) {
            return false;
        }

        // 前n-1 个元素可以跳的最远距离
        int k = 0;

        for (int i = 0; i <= k; i++) {
            // 第 i个元素可以跳到的最远距离
            int temp = i + nums[i];
            // 更新远的距离
            k = Math.max(k, temp);
            // 如果最远距离已经大于或者等于最后一个元素的下标,就说明可以跳过去
            if (k >= nums.length - 1) {
                return true;
            }

        }

        // 最远距离 k不再改变,并且没有到达元素末尾
        return false;
    }

    public boolean canJump1(int[] nums) {
        if (nums == null) {
            return false;
        }

        // 前n-1 元素可以跳的最远距离
        int curr = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > curr) {
                return false;
            }

            curr = Math.max(curr, i + nums[i]);
        }
        return true;
    }

    public boolean canJumpError(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return false;
        }
        if (length == 1) {
            return true;
        }

        int current = 0;
        int step = 0;
        for (int i = 0; i < length; i++) {
            int num = nums[i];
            if (step == 0) {
                // 获取当前数开始下一跳
                if (num == 0) {
                    return false;
                }
                step = num;
            }

            current++;
            step--;

            if (current == length - 1) {
                return true;
            }

        }

        return false;

    }

    public static void main(String[] args) {
        int[] ints = {2, 0, 0};
        Q55跳跃游戏 jump = new Q55跳跃游戏();
        boolean b = jump.canJump(ints);
        System.out.println(b);
    }

}
