package weeklycontest;

/**
 * 5843. 作为子字符串出现在单词中的字符串数目
 * 给你一个字符串数组 patterns 和一个字符串 word ，统计 patterns 中有多少个字符串是 word 的子字符串。返回字符串数目。
 * <p>
 * 子字符串 是字符串中的一个连续字符序列。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：patterns = ["a","abc","bc","d"], word = "abc"
 * 输出：3
 * 解释：
 * - "a" 是 "abc" 的子字符串。
 * - "abc" 是 "abc" 的子字符串。
 * - "bc" 是 "abc" 的子字符串。
 * - "d" 不是 "abc" 的子字符串。
 * patterns 中有 3 个字符串作为子字符串出现在 word 中。
 *
 * @author sunjianrong
 * @date 2021/8/15 上午10:31
 */
public class Q5843作为子字符串出现在单词中的字符串数目 {

    public int numOfStrings(String[] patterns, String word) {
        char[] chars = word.toCharArray();

        int res = 0;

        for (String pattern : patterns) {
            if(word.contains(pattern)){
                ++res;
            }
        }
        return res;

       /* for (String pattern : patterns) {
            char[] charArray = pattern.toCharArray();

            for (int i = 0; i < charArray.length; i++) {
                char t = charArray[i];


                // 比较当前字母是否在目标word中,需循环从 每一个字母进行比较
                for (int j = 0; j < chars.length; j++) {
                    if (t == chars[j]) {
                        continue;
                    }
                    break;
                }
            }
        }

        return res;*/

    }
}
