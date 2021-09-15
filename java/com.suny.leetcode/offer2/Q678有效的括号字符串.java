package offer2;

import java.util.Stack;

/**
 * 678. 有效的括号字符串
 * 给定一个只包含三种字符的字符串：（，）和 *，写一个函数来检验这个字符串是否为有效字符串。有效字符串具有如下规则：
 * <p>
 * 任何左括号 (必须有相应的右括号 )。
 * 任何右括号 )必须有相应的左括号 (。
 * 左括号 ( 必须在对应的右括号之前 )。
 * *可以被视为单个右括号 )，或单个左括号 (，或一个空字符串。
 * 一个空字符串也被视为有效字符串。
 * 示例 1:
 * <p>
 * 输入: "()"
 * 输出: True
 * 示例 2:
 * <p>
 * 输入: "(*)"
 * 输出: True
 * 示例 3:
 * <p>
 * 输入: "(*))"
 * 输出: True
 * <p>
 *
 * @author sunjianrong
 * @date 2021/9/12 下午9:42
 */
public class Q678有效的括号字符串 {

    public boolean checkValidString(String s) {
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> left = new Stack<>();

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c == '(') {
                left.push(i);
            }

            if (c == '*') {
                stack.push(i);
            }

            if (c == ')') {
                if (!left.isEmpty()) {
                    left.pop();
                } else if (!stack.isEmpty()) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }


        while (!left.isEmpty() && !stack.isEmpty()) {
            int leftIndex = left.pop();
            int starIndex = stack.pop();
            if (leftIndex > starIndex) {
                return false;
            }
        }

        return left.isEmpty();
    }

    public static void main(String[] args) {
        Q678有效的括号字符串 q678 = new Q678有效的括号字符串();
        System.out.println(q678.checkValidString("()"));
    }
}
