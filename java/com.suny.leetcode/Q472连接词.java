import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 472. 连接词
 * 给你一个 不含重复 单词的字符串数组 words ，请你找出并返回 words 中的所有 连接词 。
 * 
 * 连接词 定义为：一个完全由给定数组中的至少两个较短单词组成的字符串。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入：words =
 * ["cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"]
 * 输出：["catsdogcats","dogcatsdog","ratcatdogcat"]
 * 解释："catsdogcats" 由 "cats", "dog" 和 "cats" 组成;
 * "dogcatsdog" 由 "dog", "cats" 和 "dog" 组成;
 * "ratcatdogcat" 由 "rat", "cat", "dog" 和 "cat" 组成。
 * 示例 2：
 * 
 * 输入：words = ["cat","dog","catdog"]
 * 输出：["catdog"]
 * 
 * 
 * 提示：
 * 
 * 1 <= words.length <= 104
 * 0 <= words[i].length <= 1000
 * words[i] 仅由小写字母组成
 * 0 <= sum(words[i].length) <= 105
 */
public class Q472连接词 {

    private Trie trie = new Trie();

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> ans = new ArrayList<>();
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (word.length() == 0) {
                continue;
            }
            if (dfs(word, 0)) {
                ans.add(word);
            } else {
                insert(word);
            }

        }
        return ans;
    }

    private boolean dfs(String word, int start) {
        if (word.length() == start) {
            return true;
        }

        Trie node = trie;
        for (int i = start; i < word.length(); i++) {
            char ch = word.charAt(i);
            int index = ch - 'a';
            node = node.children[index];
            if (node == null) {
                return false;
            }

            if (node.isEnd) {
                if (dfs(word, i + 1)) {
                    return true;
                }
            }

        }
        return false;
    }

    private void insert(String word) {
        Trie node = trie;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int index = ch - 'a';

            if (node.children[index] == null) {
                node.children[index] = new Trie();
            }
            node = node.children[index];
        }
        node.isEnd = true;
    }

}

class Trie {
    Trie[] children;
    boolean isEnd;

    public Trie() {
        children = new Trie[26];
        isEnd = false;
    }
}