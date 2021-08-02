package offer;

/**
 * 剑指 Offer 58 - I. 翻转单词顺序
 * 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，标点符号和普通字母一样处理。例如输入字符串"I am a student. "，则输出"student. a am I"。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入: "the sky is blue"
 * 输出:"blue is sky the"
 * 示例 2：
 * <p>
 * 输入: " hello world! "
 * 输出:"world! hello"
 * 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 *
 * @author sunjianrong
 * @date 2021-08-02 12:07
 */
public class Q58I翻转单词顺序 {

    public String reverseWords(String s) {
        final String trim = s.trim();
        int r = trim.length() - 1;
        int l = r;
        StringBuilder sb = new StringBuilder();
        while (l >= 0) {
            // 找到第一个空格
            while (l >= 0 && trim.charAt(l) != ' ') {
                l--;
            }
            // 添加单词
            sb.append(trim, l + 1, r + 1).append(" ");

            // 跳过单词间空格
            while (l >= 0 && trim.charAt(l) == ' ') {
                l--;
            }

            // 两指针切到下个单词
            r = l;
        }
        return sb.toString().trim();
    }

}
