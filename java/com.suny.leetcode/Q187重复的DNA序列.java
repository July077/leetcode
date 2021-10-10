import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 187. 重复的DNA序列
 * <p>
 * 所有 DNA 都由一系列缩写为 'A'，'C'，'G' 和 'T' 的核苷酸组成，例如："ACGAATTCCG"。在研究 DNA 时，识别 DNA 中的重复序列有时会对研究非常有帮助。
 * <p>
 * 编写一个函数来找出所有目标子串，目标子串的长度为 10，且在 DNA 字符串 s 中出现次数超过一次。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
 * 输出：["AAAAACCCCC","CCCCCAAAAA"]
 * 示例 2：
 * <p>
 * 输入：s = "AAAAAAAAAAAAA"
 * 输出：["AAAAAAAAAA"]
 *
 * @author sunjianrong
 * @date 2021-10-08 9:37
 */
public class Q187重复的DNA序列 {

    public List<String> findRepeatedDnaSequences(String s) {
        int subLength = 10;
        final int length = s.length();

        List<String> res = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i <= length - subLength; i++) {
            final String substring = s.substring(i, i + 10);
            map.put(substring, map.getOrDefault(substring, 0) + 1);
            if (map.get(substring) == 2) {
                res.add(substring);
            }
        }

        return res;
    }

}
