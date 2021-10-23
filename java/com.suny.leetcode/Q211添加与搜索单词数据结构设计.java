import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 211. 添加与搜索单词 - 数据结构设计
 * <p>
 * 请你设计一个数据结构，支持 添加新单词 和 查找字符串是否与任何先前添加的字符串匹配 。
 * <p>
 * 实现词典类 WordDictionary ：
 * <p>
 * WordDictionary() 初始化词典对象
 * void addWord(word) 将 word 添加到数据结构中，之后可以对它进行匹配
 * bool search(word) 如果数据结构中存在字符串与word 匹配，则返回 true ；否则，返回 false 。word 中可能包含一些 '.' ，每个. 都可以表示任何一个字母。
 *
 * <p>
 * 示例：
 * <p>
 * 输入：
 * ["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
 * [[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
 * 输出：
 * [null,null,null,null,false,true,true,true]
 * <p>
 * 解释：
 * WordDictionary wordDictionary = new WordDictionary();
 * wordDictionary.addWord("bad");
 * wordDictionary.addWord("dad");
 * wordDictionary.addWord("mad");
 * wordDictionary.search("pad"); // return False
 * wordDictionary.search("bad"); // return True
 * wordDictionary.search(".ad"); // return True
 * wordDictionary.search("b.."); // return True
 * <p>
 *
 * @author sunjianrong
 * @date 2021-10-19 9:51
 */
public class Q211添加与搜索单词数据结构设计 {

    private Map<Integer, Set<String>> map;

    public Q211添加与搜索单词数据结构设计() {
        map = new HashMap<>();
    }

    public void addWord(String word) {
        final int length = word.length();
        if(map.containsKey(length)){
            map.get(length).add(word);
        }else {
            final HashSet<String> s = new HashSet<>();
            s.add(word);
            map.put(length,s);
        }
    }

    public boolean search(String word) {
        final int length = word.length();
        final Set<String> set = map.get(length);
        if (set == null) {
            return false;
        }

        if (set.contains(word)) {
            return true;
        }

        final char[] chars = word.toCharArray();
        ofor:
        for (String s : set) {
            if (s.length() != length) {
                continue;
            }

            for (int i = 0; i < chars.length; i++) {
                if (chars[i] != '.' && s.charAt(i) != chars[i]) {
                    continue ofor;
                }
            }
            return true;
        }

        return false;

    }
}
