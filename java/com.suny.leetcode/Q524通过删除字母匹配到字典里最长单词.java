import java.util.Collections;
import java.util.List;

/**
 * 524. 通过删除字母匹配到字典里最长单词
 * <p>
 * 给你一个字符串 s 和一个字符串数组 dictionary 作为字典，找出并返回字典中最长的字符串，该字符串可以通过删除 s 中的某些字符得到。
 * <p>
 * 如果答案不止一个，返回长度最长且字典序最小的字符串。如果答案不存在，则返回空字符串。
 * <p>
 *
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "abpcplea", dictionary = ["ale","apple","monkey","plea"]
 * 输出："apple"
 * 示例 2：
 * <p>
 * 输入：s = "abpcplea", dictionary = ["a","b","c"]
 * 输出："a"
 * <p>
 *
 * @author sunjianrong
 * @date 2021/9/14 上午11:21
 */
public class Q524通过删除字母匹配到字典里最长单词 {

    public String findLongestWord(String s, List<String> dictionary) {
        dictionary.sort((a, b) -> {
            if (a.length() != b.length()) {
                return b.length() - a.length();
            }
            return a.compareTo(b);
        });
        int length = s.length();
        for (String ss : dictionary) {
            int m = ss.length();
            int i = 0;
            int j = 0;
            while (i < length && j < m) {
                if (s.charAt(i) == ss.charAt(j)) {
                    j++;
                }
                i++;
                if (j == m) {
                    return s;
                }
            }
        }
        return "";
    }
}
