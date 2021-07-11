import java.util.*;

/**
 * 126. 单词接龙 II
 * <p>
 * 按字典 wordList 完成从单词 beginWord 到单词 endWord 转化，一个表示此过程的 转换序列 是形式上像 beginWord -> s1 -> s2 -> ... -> sk 这样的单词序列，并满足：
 * <p>
 * 每对相邻的单词之间仅有单个字母不同。
 * 转换过程中的每个单词 si（1 <= i <= k）必须是字典 wordList 中的单词。注意，beginWord 不必是字典 wordList 中的单词。
 * sk == endWord
 * 给你两个单词 beginWord 和 endWord ，以及一个字典 wordList 。请你找出并返回所有从 beginWord 到 endWord 的 最短转换序列 ，如果不存在这样的转换序列，返回一个空列表。每个序列都应该以单词列表 [beginWord, s1, s2, ..., sk] 的形式返回。
 * <p>
 * <p>
 * <p>
 *
 * @author sunjianrong
 * @date 2021/7/11 下午1:57
 */
public class Q126单词接龙II {

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();

        Set<String> dict = new HashSet<>(wordList);
        // 特殊用例
        if (!dict.contains(endWord)) {
            return res;
        }

        // 因为从 beginWord 开始拓展,因此 dict 里一定不可以有 beginWord
        dict.remove(beginWord);


        Map<String, Integer> steps = new HashMap<>();
        steps.put(beginWord, 0);

        Map<String, Set<String>> from = new HashMap<>();
        boolean found = bfs(beginWord, endWord, dict, steps, from);

        if (found) {
            Deque<String> path = new ArrayDeque<>();
            path.add(endWord);
            dfs(from, path, beginWord, endWord, res);
        }

        return res;
    }

    private boolean bfs(String beginWord, String endWord, Set<String> dict, Map<String, Integer> steps, Map<String, Set<String>> from) {
        int wordLen = beginWord.length();
        int step = 0;
        boolean found = false;

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);

        while (!queue.isEmpty()) {
            step++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String currWord = queue.poll();
                char[] charArray = currWord.toCharArray();
                for (int j = 0; j < wordLen; j++) {
                    char origin = charArray[j];
                    for (char c = 'a'; c <= 'z'; c++) {
                        // 将每一位替换成 26个小写英文字母
                        charArray[j] = c;
                        String nextWord = String.valueOf(charArray);

                        // 注意逻辑顺序
                        if (steps.containsKey(nextWord) && steps.get(nextWord) == step) {
                            from.get(nextWord).add(currWord);
                        }

                        if (!dict.contains(nextWord)) {
                            continue;
                        }

                        dict.remove(nextWord);
                        queue.offer(nextWord);

                        // dict跟steps 承担已经访问功能

                        from.putIfAbsent(nextWord, new HashSet<>());
                        from.get(nextWord).add(currWord);
                        steps.put(nextWord, step);

                        if (nextWord.equals(endWord)) {
                            // 多条路径到达 endWord 找到后不能立即退出
                            found = true;
                        }

                    }

                    charArray[j] = origin;
                }
            }

            if (found) {
                break;
            }
        }

        return found;
    }


    private void dfs(Map<String, Set<String>> from, Deque<String> path, String beginWord, String cur, List<List<String>> res) {
        if (cur.equals(beginWord)) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (String precursor : from.get(cur)) {
            path.addFirst(precursor);
            dfs(from, path, beginWord, precursor, res);
            path.removeFirst();
        }
    }

}
