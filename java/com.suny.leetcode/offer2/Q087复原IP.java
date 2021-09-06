package offer2;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 剑指 Offer II 087. 复原 IP
 * 给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能从s 获得的 有效 IP 地址 。你可以按任何顺序返回答案。
 * <p>
 * 有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
 * <p>
 * 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效 IP 地址。
 * <p>
 *
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "25525511135"
 * 输出：["255.255.11.135","255.255.111.35"]
 * <p>
 *
 * @author sunjianrong
 * @date 2021-09-06 11:08
 */
public class Q087复原IP {
    private List<String> res = new ArrayList<>();
    private Deque<String> path = new ArrayDeque<>();

    public List<String> restoreIpAddresses(String s) {
        final int length = s.length();
        if (length > 12 || length < 4) {
            return res;
        }
        dfs(s, 0, 4);
        return res;
    }

    private void dfs(String s, int begin, int residue) {
        if (begin == s.length()) {
            if (residue == 0) {
                res.add(String.join(".", path));
            }
            return;
        }

        for (int i = begin; i < begin + 3; i++) {
            if (i >= s.length()) {
                break;
            }

            if (residue * 4 < s.length() - i) {
                continue;
            }

            if (judegIpSegment(s, begin, i)) {
                final String substring = s.substring(begin, i + 1);
                path.addLast(substring);

                dfs(s, i + 1, residue - 1);
                path.removeLast();
            }


        }
    }

    private boolean judegIpSegment(String s, int left, int right) {
        int lenght = right - left + 1;
        if (lenght > 1 && s.charAt(left) == '0') {
            return false;
        }

        int res = 0;
        while (left <= right) {
            res = res * 10 + s.charAt(left) - '0';
            left++;
        }

        return res >= 0 && res <= 255;
    }
}
