package offer2;

import java.util.ArrayList;
import java.util.List;

/**
 * 剑指 Offer II 085. 生成匹配的括号
 * 正整数n代表生成括号的对数，请设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * <p>
 *
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 * 示例 2：
 * <p>
 * 输入：n = 1
 * 输出：["()"]
 * <p>
 *
 * @author sunjianrong
 * @date 2021-09-06 9:55
 */
public class Q085生成匹配的括号 {

    private List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        dfs("", n, 0, 0);
        return res;
    }

    private void dfs(String s, int n, int left, int right) {
        if (left > n || right > n) {
            return;
        }

        if (left == n && right == n) {
            res.add(s);
            return;
        }

        if (left < n) {
            dfs(s + "(", n, left + 1, right);
        }
        if (left > right) {
            dfs(s + ")", n, left, right + 1);
        }

    }


    public static void main(String[] args) {
        final Q085生成匹配的括号 q085 = new Q085生成匹配的括号();
        System.out.println(q085.generateParenthesis(3));
    }

}
