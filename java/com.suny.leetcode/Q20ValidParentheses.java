import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 有效的括号
 *
 * @author sunjianrong
 * @date 2021/5/13 下午10:03
 */
public class Q20ValidParentheses {


    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        if (s.length() % 2 == 1) {
            return false;
        }

        final Map<Character, Character> map = new HashMap<Character, Character>() {
            {
                put(')','(');
                put('}','{');
                put(']','[');
            }
        };

        char[] chars = s.toCharArray();


        Stack<Character> stack = new Stack<>();
        for (Character c : chars) {
            if (map.containsKey(c)) {
                if (stack.isEmpty() || !stack.peek().equals(map.get(c))) {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
