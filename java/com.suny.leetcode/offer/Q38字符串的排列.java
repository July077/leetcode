package offer;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * 剑指 Offer 38. 字符串的排列
 * <p>
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 * <p>
 *
 * <p>
 * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 * <p>
 *
 * <p>
 * 示例:
 * <p>
 * 输入：s = "abc"
 * 输出：["abc","acb","bac","bca","cab","cba"]
 * <p>
 *
 * @author sunjianrong
 * @date 2021/7/29 下午9:31
 */
public class Q38字符串的排列 {

    List<String> res = new LinkedList<>();
    char[] c;

    public String[] permutation(String s) {
        c = s.toCharArray();
        dfs(0);
        return res.toArray(new String[res.size()]);
    }

    private void dfs(int x) {
        if (x == c.length - 1) {
            res.add(String.valueOf(c));
            return;
        }

        // 防止出现重复元素
        HashSet<Character> set = new HashSet<>();

        for (int i = x; i < c.length; i++) {
            // 发现剪枝
            if (set.contains(c[i])) {
                continue;
            }

            set.add(c[i]);

            // 交换元素
            swap(i, x);

            dfs(x + 1);

            swap(i, x);
        }

    }


    private void swap(int i, int x) {
        char temp = c[i];
        c[i] = c[x];
        c[x] = temp;
    }

}
