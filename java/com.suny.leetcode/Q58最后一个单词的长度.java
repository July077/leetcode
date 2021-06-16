/**
 * 58. 最后一个单词的长度
 * 给你一个字符串 s，由若干单词组成，单词之间用空格隔开。返回字符串中最后一个单词的长度。如果不存在最后一个单词，请返回 0 。
 * <p>
 * 单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。
 *
 * @author sunjianrong
 * @date 2021/6/16 下午10:38
 */
public class Q58最后一个单词的长度 {

    public int lengthOfLastWord(String s) {
        int len = 0;


        // 倒序遍历
        for (int i = s.length() - 1; i >= 0; i--) {
            // 不为空就增加长度
            if (s.charAt(i) != ' ') {
                len++;

                // 碰到空格了，开始返回
            } else if (len != 0) {
                return len;
            }
        }

        return len;

    }

}
