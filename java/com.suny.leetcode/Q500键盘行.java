import java.util.ArrayList;
import java.util.List;

/**
 * 500. 键盘行
 * 给你一个字符串数组 words ，只返回可以使用在 美式键盘 同一行的字母打印出来的单词。键盘如下图所示。
 * <p>
 * 美式键盘 中：
 * <p>
 * 第一行由字符 "qwertyuiop" 组成。
 * 第二行由字符 "asdfghjkl" 组成。
 * 第三行由字符 "zxcvbnm" 组成。
 * 示例 1：
 * <p>
 * 输入：words = ["Hello","Alaska","Dad","Peace"]
 * 输出：["Alaska","Dad"]
 * 示例 2：
 * <p>
 * 输入：words = ["omk"]
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：words = ["adsdf","sfd"]
 * 输出：["adsdf","sfd"]
 * <p>
 *
 * @author sunjianrong
 * @date 2021/10/31 下午9:15
 */
public class Q500键盘行 {

    public String[] findWords(String[] words) {
        List<String> list = new ArrayList<>();
        String index = "12210111011122000010020202";

        for (String word : words) {
            boolean isValid = true;
            char firstIndex = index.charAt(Character.toLowerCase(word.charAt(0)) - 'a');

            char[] chars = word.toCharArray();
            for (char c : chars) {
                if (index.charAt(Character.toLowerCase(c) - 'a') != firstIndex) {
                    isValid = false;
                    break;
                }
            }
            if (isValid) {
                list.add(word);
            }
        }

        return list.toArray(new String[0]);

    }
}
