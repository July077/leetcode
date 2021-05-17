import java.util.ArrayList;
import java.util.List;

/**
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 * @author sunjianrong
 * @date 2021/5/16 下午10:15
 */
public class Q22GenerateParentheses {

    List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {


        if (n <= 0) {
            return res;
        }

        getParenthesis("", n, n);
        return res;
    }

    private void getParenthesis(String str, int left, int right) {
        //括号都用完了

        if (left == 0 && right == 0) {
            res.add(str);
            return;
        }

        if (left == right) {
            getParenthesis(str + "(", left - 1, right);
        } else if (left < right) {
            if (left > 0) {
                getParenthesis(str + "(", left - 1, right);
            }

            getParenthesis(str + ")", left, right - 1);
        }
    }

}
