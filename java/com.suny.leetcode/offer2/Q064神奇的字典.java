package offer2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 剑指 Offer II 064. 神奇的字典
 * <p>
 * 设计一个使用单词列表进行初始化的数据结构，单词列表中的单词 互不相同 。 如果给出一个单词，请判定能否只将这个单词中一个字母换成另一个字母，使得所形成的新单词存在于已构建的神奇字典中。
 * <p>
 * 实现 MagicDictionary 类：
 * <p>
 * MagicDictionary() 初始化对象
 * void buildDict(String[]dictionary) 使用字符串数组dictionary 设定该数据结构，dictionary 中的字符串互不相同
 * bool search(String searchWord) 给定一个字符串 searchWord ，判定能否只将字符串中 一个 字母换成另一个字母，使得所形成的新字符串能够与字典中的任一字符串匹配。如果可以，返回 true ；否则，返回 false 。
 *
 * <p>
 * 示例：
 * <p>
 * 输入
 * inputs = ["MagicDictionary", "buildDict", "search", "search", "search", "search"]
 * inputs = [[], [["hello", "leetcode"]], ["hello"], ["hhllo"], ["hell"], ["leetcoded"]]
 * 输出
 * [null, null, false, true, false, false]
 * <p>
 * 解释
 * MagicDictionary magicDictionary = new MagicDictionary();
 * magicDictionary.buildDict(["hello", "leetcode"]);
 * magicDictionary.search("hello"); // 返回 False
 * magicDictionary.search("hhllo"); // 将第二个 'h' 替换为 'e' 可以匹配 "hello" ，所以返回 True
 * magicDictionary.search("hell"); // 返回 False
 * magicDictionary.search("leetcoded"); // 返回 False
 * <p>
 *
 * @author sunjianrong
 * @date 2021/8/28 下午11:27
 */
public class Q064神奇的字典 {
    Map<Integer, ArrayList<String>> buckets;

    /**
     * Initialize your data structure here.
     */
    public Q064神奇的字典() {
        buckets = new HashMap<>();
    }

    public void buildDict(String[] dictionary) {
        for (String d : dictionary) {
            buckets.computeIfAbsent(d.length(), x -> new ArrayList<>()).add(d);
        }

    }

    public boolean search(String searchWord) {
        if (!buckets.containsKey(searchWord.length())) {
            return false;
        }

        ArrayList<String> list = buckets.get(searchWord.length());
        for (String s : list) {
            int mismatch = 0;
            int length = searchWord.length();
            for (int i = 0; i < length; i++) {
                if (searchWord.charAt(i) != s.charAt(i)) {
                    if (++mismatch > 1) {
                        break;
                    }
                }
            }

            if (mismatch == 1) {
                return true;
            }
        }

        return false;
    }
}
