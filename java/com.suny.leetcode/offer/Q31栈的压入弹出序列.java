package offer;

import java.util.Stack;

/**
 * 剑指 Offer 31. 栈的压入、弹出序列
 * <p>
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等。例如，序列 {1,2,3,4,5} 是某栈的压栈序列，序列 {4,5,3,2,1} 是该压栈序列对应的一个弹出序列，但 {4,3,5,1,2} 就不可能是该压栈序列的弹出序列。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
 * 输出：true
 * 解释：我们可以按以下顺序执行：
 * push(1), push(2), push(3), push(4), pop() -> 4,
 * push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
 * 示例 2：
 * <p>
 * 输入：pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
 * 输出：false
 * 解释：1 不能在 2 之前弹出。
 * <p>
 *
 * @author sunjianrong
 * @date 2021/7/29 下午9:06
 */
public class Q31栈的压入弹出序列 {

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        for (int num : pushed) {
            stack.push(num);
            System.out.println("入栈" + num);
            // 如果栈非空并且跟指定下标相等的话就弹出，否则就不相等
            while (!stack.isEmpty() && stack.peek() == popped[i]) {
                Integer pop = stack.pop();
                System.out.println("出栈" + pop);
                i++;
            }
        }
        return stack.isEmpty();
    }


    public static void main(String[] args) {
        Q31栈的压入弹出序列 q31 = new Q31栈的压入弹出序列();
        int[] push = new int[]{1, 2, 3, 4, 5};
        int[] pop = new int[]{4, 5, 3, 2, 1};
        boolean b = q31.validateStackSequences(pop, pop);
        System.out.println(b);
    }

}
