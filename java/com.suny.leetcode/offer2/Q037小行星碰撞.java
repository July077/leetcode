package offer2;

import java.util.Stack;

/**
 * 剑指 Offer II 037. 小行星碰撞
 * <p>
 * 给定一个整数数组 asteroids，表示在同一行的小行星。
 * <p>
 * 对于数组中的每一个元素，其绝对值表示小行星的大小，正负表示小行星的移动方向（正表示向右移动，负表示向左移动）。每一颗小行星以相同的速度移动。
 * <p>
 * 找出碰撞后剩下的所有小行星。碰撞规则：两个行星相互碰撞，较小的行星会爆炸。如果两颗行星大小相同，则两颗行星都会爆炸。两颗移动方向相同的行星，永远不会发生碰撞。
 * <p>
 *
 * <p>
 * 示例 1：
 * <p>
 * 输入：asteroids = [5,10,-5]
 * 输出：[5,10]
 * 解释：10 和 -5 碰撞后只剩下 10 。 5 和 10 永远不会发生碰撞。
 * <p>
 *
 * @author sunjianrong
 * @date 2021-08-19 12:08
 */
public class Q037小行星碰撞 {

    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int asteroid : asteroids) {
            loop:
            {
                // 行星小于0
                while (!stack.isEmpty() && asteroid < 0 && 0 < stack.peek()) {
                    // 如果右侧的行星大,则栈顶元素毁灭
                    if (stack.peek() < -asteroid) {
                        stack.pop();
                        continue;
                    } else if (stack.peek() == -asteroid) {
                        stack.pop();
                    }

                    // 如果左侧的行星大,则跳出去,自我毁灭
                    break loop;
                }
                stack.push(asteroid);
            }
        }

        return stack.stream().mapToInt(Integer::intValue).toArray();
    }


}
