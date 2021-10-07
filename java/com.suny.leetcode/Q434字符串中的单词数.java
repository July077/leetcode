/**
 * 434. 字符串中的单词数
 * <p>
 * 统计字符串中的单词个数，这里的单词指的是连续的不是空格的字符。
 * <p>
 * 请注意，你可以假定字符串里不包括任何不可打印的字符。
 * <p>
 * 示例:
 * <p>
 * 输入: "Hello, my name is John"
 * 输出: 5
 * 解释: 这里的单词是指连续的不是空格的字符，所以 "Hello," 算作 1 个单词。
 * <p>
 *
 * @author sunjianrong
 * @date 2021/10/7 下午9:13
 */
public class Q434字符串中的单词数 {

    public int countSegments(String s) {
        int res = 0;
        int length = s.length();

        for (int i = 0; i < length; i++) {
            if ((i == 0 || s.charAt(i - 1) == ' ') && s.charAt(i) != ' ') {
                res++;
            }
        }

        return res;
    }
}
