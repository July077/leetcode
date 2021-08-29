package offer2;

import common.TrieNode;

import java.util.Arrays;

/**
 * 剑指 Offer II 065. 最短的单词编码
 * <p>
 * 单词数组words 的 有效编码 由任意助记字符串 s 和下标数组 indices 组成，且满足：
 * <p>
 * words.length == indices.length
 * 助记字符串 s 以 '#' 字符结尾
 * 对于每个下标 indices[i] ，s 的一个从 indices[i] 开始、到下一个 '#' 字符结束（但不包括 '#'）的 子字符串 恰好与 words[i] 相等
 * 给定一个单词数组words ，返回成功对 words 进行编码的最小助记字符串 s 的长度 。
 * <p>
 *
 * <p>
 * 示例 1：
 * <p>
 * 输入：words = ["time", "me", "bell"]
 * 输出：10
 * 解释：一组有效编码为 s = "time#bell#" 和 indices = [0, 2, 5] 。
 * words[0] = "time" ，s 开始于 indices[0] = 0 到下一个 '#' 结束的子字符串，如加粗部分所示 "time#bell#"
 * words[1] = "me" ，s 开始于 indices[1] = 2 到下一个 '#' 结束的子字符串，如加粗部分所示 "time#bell#"
 * words[2] = "bell" ，s 开始于 indices[2] = 5 到下一个 '#' 结束的子字符串，如加粗部分所示 "time#bell#"
 * <p>
 *
 * @author sunjianrong
 * @date 2021/8/29 下午8:25
 */
public class Q065最短的单词编码 {


    public int minimumLengthEncoding(String[] words) {
        int len = 0;
        Trie trie = new Trie();

        Arrays.sort(words, (s1, s2) -> s2.length() - s1.length());

        for (String word : words) {
            len += trie.insert(word);
        }

        return len;

    }

    class Trie {
        TrieNode trieNode;

        public Trie() {
            trieNode = new TrieNode();
        }

        public int insert(String word) {
            TrieNode curr = trieNode;
            boolean isNew = false;

            // 倒着插入
            for (int i = word.length() - 1; i >= 0; i--) {
                int c = word.charAt(i) - 'a';
                if (curr.children[c] == null) {
                    isNew = true;
                    curr.children[c] = new TrieNode();
                }

                curr = curr.children[c];
            }

            return isNew ? word.length() + 1 : 0;
        }
    }
}
