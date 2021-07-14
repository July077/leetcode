import java.util.*;

/**
 * 127. 单词接龙
 * <p>
 * 字典wordList 中从单词 beginWord和 endWord 的 转换序列 是一个按下述规格形成的序列：
 * <p>
 * 序列中第一个单词是 beginWord 。
 * 序列中最后一个单词是 endWord 。
 * 每次转换只能改变一个字母。
 * 转换过程中的中间单词必须是字典wordList 中的单词。
 * 给你两个单词 beginWord和 endWord 和一个字典 wordList ，找到从beginWord 到endWord 的 最短转换序列 中的 单词数目 。如果不存在这样的转换序列，返回 0。
 *
 * @author sunjianrong
 * @date 2021/7/13 下午10:10
 */
public class Q127单词接龙 {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> wordSet = new HashSet<>(wordList);
        if (wordSet.size() == 0 || !wordSet.contains(endWord)) {
            return 0;
        }

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);

        Map<String, Integer> map = new HashMap<>();
        map.put(beginWord, 1);

        while (!queue.isEmpty()) {
            // 取出队头单词
            String word = queue.poll();
            // 获取该单词的路径长度
            int path = map.get(word);
            // 遍历单词的每一个字符
            for (int i = 0; i < word.length(); i++) {
                // 替换
                char[] chars = word.toCharArray();
                // 从 a 到 z 遍历替换
                for (char k = 'a'; k <= 'z'; k++) {
                    chars[i] = k;
                    String newWord = String.valueOf(chars);
                    // 如果新的字符串跟 endWord 保持一直,则返回当前长度+1
                    if (newWord.equals(endWord)) {
                        return path + 1;
                    }


                    if (wordSet.contains(newWord) && !map.containsKey(newWord)) {
                        // 记录单词的路径长度
                        map.put(newWord, path + 1);
                        // 加入队尾
                        queue.offer(newWord);
                    }

                }
            }
        }

        return 0;
    }
}
