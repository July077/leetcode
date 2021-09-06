package offer2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 剑指 Offer II 086. 分割回文子字符串
 * 给定一个字符串 s ，请将 s 分割成一些子串，使每个子串都是 回文串 ，返回 s 所有可能的分割方案。
 * <p>
 * 回文串是正着读和反着读都一样的字符串。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "google"
 * 输出：[["g","o","o","g","l","e"],["g","oo","g","l","e"],["goog","l","e"]]
 * 示例 2：
 * <p>
 * 输入：s = "aab"
 * 输出：[["a","a","b"],["aa","b"]]
 *
 * @author sunjianrong
 * @date 2021-09-06 10:11
 */
public class Q086分割回文子字符串 {
    private List<String[]> res = new ArrayList<>();
    private LinkedList<String> path = new LinkedList<>();

    public String[][] partition(String s) {
        dfs(s, 0);
        return res.toArray(new String[res.size()][]);
    }

    private void dfs(String s, int start) {
        if (start == s.length()) {
            res.add(path.toArray(new String[0]));
            return;
        }

        for (int i = start; i < s.length(); i++) {
            if (match(s, start, i)) {
                path.offerLast(s.substring(start, i + 1));
                dfs(s, i + 1);
                path.removeLast();
            }
        }

    }


    private boolean match(String s, int left, int right) {
        if (s.length() == 1) {
            return true;
        }


        final char[] chars = s.toCharArray();
        while (left <= right) {
            final char l = chars[left];
            final char r = chars[right];
            if (l != r) {
                return false;
            }

            left++;
            right--;
        }
        return true;
    }
}
