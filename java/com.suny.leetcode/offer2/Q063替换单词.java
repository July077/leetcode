package offer2;

import common.TrieNode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 剑指 Offer II 063. 替换单词
 * <p>
 * 在英语中，有一个叫做词根(root) 的概念，它可以跟着其他一些词组成另一个较长的单词——我们称这个词为继承词(successor)。例如，词根an，跟随着单词other(其他)，可以形成新的单词another(另一个)。
 * <p>
 * 现在，给定一个由许多词根组成的词典和一个句子，需要将句子中的所有继承词用词根替换掉。如果继承词有许多可以形成它的词根，则用最短的词根替换它。
 * <p>
 * 需要输出替换之后的句子。
 * <p>
 *
 * <p>
 * 示例 1：
 * <p>
 * 输入：dictionary = ["cat","bat","rat"], sentence = "the cattle was rattled by the battery"
 * 输出："the cat was rat by the bat"
 * <p>
 *
 * @author sunjianrong
 * @date 2021/8/28 下午11:02
 */
public class Q063替换单词 {

    public String replaceWords(List<String> dictionary, String sentence) {
        // 初始化前缀树
        TrieNode trieNode = new TrieNode();
        for (String d : dictionary) {
            TrieNode curr = trieNode;
            char[] chars = d.toCharArray();
            for (char c : chars) {
                if (curr.children[c - 'a'] == null) {
                    curr.children[c - 'a'] = new TrieNode();
                }
                curr = curr.children[c - 'a'];
            }
            curr.word = d;
        }

        // 开始查找
        StringBuilder sb = new StringBuilder();

        String[] split = sentence.split(" ");
        for (String s : split) {
            if (sb.length() > 0) {
                sb.append(" ");
            }

            TrieNode curr = trieNode;
            char[] chars = s.toCharArray();
            for (char c : chars) {
                if (curr.children[c - 'a'] == null || curr.word != null) {
                    break;
                }
                curr = curr.children[c - 'a'];
            }
            sb.append(curr.word != null ? curr.word : s);
        }
        return sb.toString();

    }

    public String replaceWords1(List<String> dictionary, String sentence) {

        Set<String> set = new HashSet<>(dictionary);

        StringBuilder sb = new StringBuilder();
        String[] split = sentence.split(" ");


        for (String s : split) {
            String prefix = "";

            int length = s.length();
            for (int i = 1; i <= length; i++) {
                prefix = s.substring(0, i);
                if (set.contains(prefix)) {
                    break;
                }
            }

            if (sb.length() > 0) {
                sb.append(" ");
            }
            sb.append(prefix);
        }

        return sb.toString();
    }
}
