package offer;

/**
 * 剑指 Offer 05. 替换空格
 * <p>
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 * <p>
 *
 * @author sunjianrong
 * @date 2021-07-21 9:06
 */
public class Q05替换空格 {

    public String replaceSpace(String s) {
        StringBuilder sb = new StringBuilder();

        final char[] charArray = s.toCharArray();
        for (char c : charArray) {
            if (c == ' ') {
                sb.append("%20");
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
