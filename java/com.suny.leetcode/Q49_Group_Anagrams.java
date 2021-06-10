import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 49. 字母异位词分组
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 *
 * @author sunjianrong
 * @date 2021/6/10 下午10:24
 */
public class Q49_Group_Anagrams {

    public List<List<String>> groupAnagrams2(String[] strs) {

        return new ArrayList<>(Arrays.stream(strs).collect(Collectors.groupingBy(s -> {
            int[] counter = new int[26];
            for (int i = 0; i < s.length(); i++) {
                counter[s.charAt(i) - 'a']++;
            }
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                if (counter[i] != 0) {
                    builder.append((char) ('a' + i));
                    builder.append(counter[i]);
                }
            }

            return builder.toString();
        })).values());

    }


    public List<List<String>> groupAnagrams(String[] strs) {

        return new ArrayList<>(Arrays.stream(strs).collect(Collectors.groupingBy(s -> {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            return new String(chars);
        })).values());

    }
}
