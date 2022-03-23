package offer2;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * 剑指 Offer II 036. 后缀表达式
 * 根据 逆波兰表示法，求该后缀表达式的计算结果。
 * <p>
 * 有效的算符包括+、-、*、/。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
 * <p>
 *
 * <p>
 * 说明：
 * <p>
 * 整数除法只保留整数部分。
 * 给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。
 *
 * <p>
 * 示例1：
 * <p>
 * 输入：tokens = ["2","1","+","3","*"]
 * 输出：9
 * 解释：该算式转化为常见的中缀算术表达式为：((2 + 1) * 3) = 9
 * <p>
 *
 * @author sunjianrong
 * @date 2021-08-19 11:53
 */
public class Q036后缀表达式 {

    public int evalRPN(String[] tokens) {
        final Set<String> sets =  new HashSet<>();
        sets.add("+");
        sets.add("-");
        sets.add("*");
        sets.add("/");
        Stack<String> stack = new Stack<>();
        for (String token : tokens) {
            if (sets.contains(token)) {
                final int num1 = Integer.parseInt(stack.pop());
                final int num2 = Integer.parseInt(stack.pop());

                int res = 0;
                switch (token) {
                    case "+":
                        res = num2 + num1;
                        break;
                    case "-":
                        res = num2 - num1;
                        break;
                    case "*":
                        res = num2 * num1;
                        break;
                    case "/":
                        res = num2 / num1;
                        break;
                    default:
                        break;
                }
                stack.push(String.valueOf(res));
            } else {
                stack.push(token);
            }
        }

        return Integer.parseInt(stack.pop());

    }
}
