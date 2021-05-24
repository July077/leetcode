import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 30. 串联所有单词的子串
 * 给定一个字符串 s 和一些 长度相同 的单词 words 。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。
 * <p>
 * 注意子串要与 words 中的单词完全匹配，中间不能有其他字符 ，但不需要考虑 words 中单词串联的顺序。
 *
 * @author sunjianrong
 * @date 2021/5/24 下午11:25
 */
public class Q30SubstringWithConcatenationOfAllWords {

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();

        Map<String, Integer> wordMap = new HashMap<>();
        if (s.length() == 0 || words.length == 0) {
            return res;
        }

        for (String word : words) {
            if (!s.contains(word)) {
                return res;
            }
            // 保存单词跟出现的次数
            wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
        }

        // 每个单词长度
        int oneLen = words[0].length();
        int wordsLen = oneLen * words.length;
        // 主串小于长度总和
        if (wordsLen > s.length()) {
            return res;
        }

        // 每次匹配的窗口大小位 wordslen,每次后移动一个单词长度
        for (int i = 0; i < oneLen; ++i) {
            int left = i;
            int right = i;
            int count = 0;
            // 统计每个符合要求的word
            Map<String, Integer> subMap = new HashMap<>();
            // 右边窗口不能超过主串的长度
            while (right + oneLen <= s.length()) {
                String word = s.substring(right, right + oneLen);
                // 窗口右移动
                right += oneLen;
                // words 种没有这个单词,肯定匹配失败，直接移动到这个单词后面
                if (!wordMap.containsKey(word)) {
                    left = right;
                    // 单词统计清空,重新统计
                    subMap.clear();
                    // 符合要求的单词清0
                    count = 0;
                } else {
                    // 统计当前子串种单词出现的次数
                    subMap.put(word, subMap.getOrDefault(word, 0) + 1);
                    ++count;

                    //
                    while (subMap.getOrDefault(word, 0) > wordMap.getOrDefault(word, 0)) {
                        // 从当前窗口字符统计 map 种删除从左边窗口到数量超限的所有单词
                        String w = s.substring(left, left + oneLen);
                        subMap.put(w, subMap.getOrDefault(w, 0) - 1);
                        // 符合的单词数减一
                        --count;

                        // 左边窗口右移
                        left += oneLen;
                    }
                    // 当前窗口字符串满足要求
                    if (count == words.length) {
                        res.add(left);
                    }

                }
            }
        }

        return res;
    }
}
