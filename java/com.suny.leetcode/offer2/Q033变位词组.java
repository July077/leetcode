package offer2;

import java.util.*;

/**
 * 剑指 Offer II 033. 变位词组
 * <p>
 * 给定一个字符串数组 strs ，将变位词组合在一起。 可以按任意顺序返回结果列表。
 * <p>
 * 注意：若两个字符串中每个字符出现的次数都相同，则称它们互为变位词。
 * <p>
 *
 * <p>
 * 示例 1:
 * <p>
 * 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
 * <p>
 *
 * @author sunjianrong
 * @date 2021-08-18 11:54
 */
public class Q033变位词组 {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            final char[] chars = str.toCharArray();
            Arrays.sort(chars);

            final String sortString = new String(chars);
            final List<String> list = map.getOrDefault(sortString, new ArrayList<>());
            list.add(str);

            map.put(sortString, list);
        }


        return new ArrayList<>(map.values());

    }

}
