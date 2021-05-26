import java.util.Deque;
import java.util.LinkedList;

/**
 * @author sunjianrong
 * @date 2021/5/26 下午11:16
 */
public class Q32LongestValidParentheses {
    public int longestValidParentheses(String s) {
        if (s == null || s.length() <= 1) {
            return 0;
        }

        int max = 0;

        Deque<Integer> stack = new LinkedList<>();
        stack.push(-1);

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    max = Math.max(max, i - stack.peek());
                }
            }
        }

        return max;
    }

}
