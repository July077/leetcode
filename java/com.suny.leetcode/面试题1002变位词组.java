import java.util.*;

/**
 * 面试题 10.02. 变位词组
 * <p>
 * 编写一种方法，对字符串数组进行排序，将所有变位词组合在一起。变位词是指字母相同，但排列不同的字符串。
 * <p>
 * 注意：本题相对原题稍作修改
 * <p>
 * 示例:
 * <p>
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * 输出:
 * [
 * ["ate","eat","tea"],
 * ["nat","tan"],
 * ["bat"]
 * ]
 * 说明：
 * <p>
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 *
 * @author sunjianrong
 * @date 2021/7/18 上午8:55
 */
public class 面试题1002变位词组 {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String sortStr = new String(chars);

            List<String> mapOrDefault = map.getOrDefault(sortStr, new ArrayList<>());
            mapOrDefault.add(s);
            map.put(sortStr, mapOrDefault);
        }

        return new ArrayList<>(map.values());

    }

}
