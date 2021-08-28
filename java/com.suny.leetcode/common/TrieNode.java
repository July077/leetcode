package common;

/**
 * 前缀树节点
 *
 * @author sunjianrong
 * @date 2021/8/28 下午11:17
 */
public class TrieNode {

    /**
     * 子节点
     */
    public TrieNode[] children;

    public String word;

    public TrieNode() {
        children = new TrieNode[26];
    }
}
