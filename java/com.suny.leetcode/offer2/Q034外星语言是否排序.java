package offer2;

import java.util.HashMap;
import java.util.Map;

/**
 * 剑指 Offer II 034. 外星语言是否排序
 * <p>
 * 某种外星语也使用英文小写字母，但可能顺序 order 不同。字母表的顺序（order）是一些小写字母的排列。
 * <p>
 * 给定一组用外星语书写的单词 words，以及其字母表的顺序 order，只有当给定的单词在这种外星语中按字典序排列时，返回 true；否则，返回 false。
 * <p>
 *
 * <p>
 * 示例 1：
 * <p>
 * 输入：words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
 * 输出：true
 * 解释：在该语言的字母表中，'h' 位于 'l' 之前，所以单词序列是按字典序排列的。
 * <p>
 *
 * @author sunjianrong
 * @date 2021-08-18 12:11
 */
public class Q034外星语言是否排序 {

    Map<Character, Integer> map = new HashMap<>();

    public boolean isAlienSorted(String[] words, String order) {
        final char[] orderChars = order.toCharArray();
        for (int i = 0; i < orderChars.length; i++) {
            map.put(orderChars[i], i);
        }

        for (int i = 0; i < words.length; i++) {
            if(!isOrder(words[i],words[i+1])){
                return false;
            }
        }

        return true;
    }

    public boolean isOrder(String word1, String word2) {
        int n = Math.min(word1.length(), word2.length());
        for (int i = 0; i < n; i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                int a = map.get(word1.charAt(i));
                int b = map.get(word2.charAt(i));
                if (a > b) {
                    return false;
                } else if (a < b) {
                    return true;
                }
            }

            if (i == n - 1 && word1.length() > word2.length()) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        final Q034外星语言是否排序 q034 = new Q034外星语言是否排序();
        final String[] strings = {"hello", "leetcode"};
        String order = "hlabcdefgijkmnopqrstuvwxyz";
        System.out.println(q034.isAlienSorted(strings, order));
    }
}
