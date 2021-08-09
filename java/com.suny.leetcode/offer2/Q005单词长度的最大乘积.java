package offer2;

/**
 * 剑指 Offer II 005. 单词长度的最大乘积
 * 给定一个字符串数组words，请计算当两个字符串 words[i] 和 words[j] 不包含相同字符时，它们长度的乘积的最大值。假设字符串中只包含英语的小写字母。如果没有不包含相同字符的一对字符串，返回 0。
 * <p>
 *
 * <p>
 * 示例1:
 * <p>
 * 输入: words = ["abcw","baz","foo","bar","fxyz","abcdef"]
 * 输出: 16
 * 解释: 这两个单词为 "abcw", "fxyz"。它们不包含相同字符，且长度的乘积最大。
 * <p>
 *
 * @author sunjianrong
 * @date 2021/8/9 下午8:54
 */
public class Q005单词长度的最大乘积 {

    public int bitNumber(char c) {
        return (int) c - 'a';
    }

    public boolean noCommonLetters(String s1, String s2) {
        int bitmask = 0;
        int bitmask2 = 0;

        // 26个字母不会超过 int 最大值   1<< 左移动扩大。  | 则可以合并两数值
        for (char c : s1.toCharArray()) {
            bitmask = bitmask | 1 << bitNumber(c);
        }

        for (char c : s2.toCharArray()) {
            bitmask2 = bitmask2 | 1 << bitNumber(c);
        }

        // & 为相等则为0，不相等则为1
        return (bitmask & bitmask2) == 0;
    }


    // 暴力法超时
    public int maxProduct0(String[] words) {
        int n = words.length;

        int maxProd = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (!hasCommonLetter(words[i], words[j])) {
                    maxProd = Math.max(maxProd, words[i].length() * words[j].length());
                }
            }
        }

        return maxProd;
    }

    private boolean hasCommonLetter(String a, String b) {
        for (char c : a.toCharArray()) {
            if (b.indexOf(c) != -1) {
                return true;
            }
        }
        return false;
        /*for (int i = 0; i < a.length(); i++) {
            for (int j = 0; j < b.length(); j++) {
                if (a.charAt(i) == b.charAt(j)) {
                    return true;
                }
            }
        }

        return false;*/
    }

    public static void main(String[] args) {
        String[] strings = {"abcw", "baz", "foo", "bar", "xtfn", "abcdef"};
        Q005单词长度的最大乘积 q005 = new Q005单词长度的最大乘积();
        System.out.println(q005.maxProduct0(strings));
    }

}
