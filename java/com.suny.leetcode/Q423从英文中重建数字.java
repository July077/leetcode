import java.util.HashMap;
import java.util.Map;

/**
 * Q423从英文中重建数字
 * 给你一个字符串 s ，其中包含字母顺序打乱的用英文单词表示的若干数字（0-9）。按 升序 返回原始的数字。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "owoztneoer"
 * 输出："012"
 * 示例 2：
 * <p>
 * 输入：s = "fviefuro"
 * 输出："45"
 *
 * @author sunjianrong
 * @date 2021-11-24 9:29
 */
public class Q423从英文中重建数字 {

    public String originalDigits(String s) {
        Map<Character, Integer> map = new HashMap<>();
        final int length = s.length();
        for (int i = 0; i < length; i++) {
            final char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int[] cnt = new int[10];
        cnt[0] = map.getOrDefault('z', 0);
        cnt[2] = map.getOrDefault('w', 0);
        cnt[4] = map.getOrDefault('u', 0);
        cnt[6] = map.getOrDefault('x', 0);
        cnt[8] = map.getOrDefault('g', 0);


        cnt[3] = map.getOrDefault('h', 0) - cnt[8];
        cnt[5] = map.getOrDefault('f', 0) - cnt[4];
        cnt[7] = map.getOrDefault('s', 0) - cnt[6];


        cnt[1] = map.getOrDefault('o', 0) - cnt[0] - cnt[2] - cnt[4];

        cnt[9] = map.getOrDefault('i', 0) - cnt[5] - cnt[6] - cnt[8];


        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < cnt[i]; j++) {
                stringBuffer.append((char) (i + '0'));
            }
        }

        return stringBuffer.toString();
    }
}
