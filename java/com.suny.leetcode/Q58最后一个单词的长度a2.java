/**
 * 58. 最后一个单词的长度
 * <p>
 * 给你一个字符串 s，由若干单词组成，单词前后用一些空格字符隔开。返回字符串中最后一个单词的长度。
 * <p>
 * 单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "Hello World"
 * 输出：5
 * <p>
 *
 * @author sunjianrong
 * @date 2021-09-21 22:04
 */
public class Q58最后一个单词的长度a2 {
    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int count = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                if (count == 0) {
                    continue;
                }
                break;
            }
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        final Q58最后一个单词的长度a2 q = new Q58最后一个单词的长度a2();
        System.out.println(q.lengthOfLastWord("day"));

    }
}
