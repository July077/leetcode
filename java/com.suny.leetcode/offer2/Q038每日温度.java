package offer2;

import java.util.Stack;

/**
 * 剑指 Offer II 038. 每日温度
 * 请根据每日 气温 列表 temperatures，重新生成一个列表，要求其对应位置的输出为：要想观测到更高的气温，至少需要等待的天数。如果气温在这之后都不会升高，请在该位置用0 来代替。
 * <p>
 *
 * <p>
 * 示例 1:
 * <p>
 * 输入: temperatures = [73,74,75,71,69,72,76,73]
 * 输出:[1,1,4,2,1,1,0,0]
 * <p>
 *
 * @author sunjianrong
 * @date 2021/8/19 下午9:50
 */
public class Q038每日温度 {

    public int[] dailyTemperatures1(int[] temperatures) {
        int length = temperatures.length;
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[length];

        for (int i = 0; i < length; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                // 如果不是大于，就直接计算下标差
                Integer pop = stack.pop();
                res[pop] = i - pop;
            }
            stack.add(i);
        }
        return res;
    }

    // 暴力法
    public int[] dailyTemperatures(int[] temperatures) {
        int length = temperatures.length;
        int[] res = new int[length];
        for (int i = 0; i < length; i++) {
            for (int j = i; j < length; j++) {
                if (temperatures[j] - temperatures[i] > 0) {
                    res[i] = j - i;
                    break;
                }
            }
        }

        return res;
    }
}
