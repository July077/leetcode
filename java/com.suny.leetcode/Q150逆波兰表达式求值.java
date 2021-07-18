import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Set;

/**
 * 150. 逆波兰表达式求值
 * <p>
 * 根据 逆波兰表示法，求表达式的值。
 * <p>
 * 有效的算符包括 +、-、*、/ 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
 * <p>
 *  
 * <p>
 * 说明：
 * <p>
 * 整数除法只保留整数部分。
 * 给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。
 * <p>
 *
 * @author sunjianrong
 * @date 2021/7/17 下午11:03
 */
public class Q150逆波兰表达式求值 {

    private static final Set<String> TOKENS = Set.of("+", "-", "*", "/");

    public int evalRPN(String[] tokens) {
        Deque<Integer> deque = new ArrayDeque<>();
        for (String token : tokens) {
            if (isNumber(token)) {
                deque.addLast(Integer.valueOf(token));
            } else {
                Integer num1 = deque.pollLast();
                Integer num2 = deque.pollLast();
                switch (token) {
                    case "+":
                        deque.addLast(num1 + num2);
                        break;
                    case "-":
                        deque.addLast(num1 - num2);
                        break;
                    case "*":
                        deque.addLast(num1 * num2);
                        break;
                    case "/":
                        deque.addLast(num1 / num2);
                        break;
                    default:
                        deque.addLast(Integer.valueOf(token));
                        break;
                }
            }
        }

        return deque.pollLast();

    }

    public boolean isNumber(String token) {
        return !TOKENS.contains(token);
    }

}
