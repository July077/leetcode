import java.util.HashSet;
import java.util.Set;

/**
 * 869. 重新排序得到 2 的幂
 * 给定正整数 N，我们按任何顺序（包括原始顺序）将数字重新排序，注意其前导数字不能为零。
 * <p>
 * 如果我们可以通过上述方式得到2 的幂，返回 true；否则，返回 false。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：1
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：10
 * 输出：false
 * 示例 3：
 * <p>
 * 输入：16
 * 输出：true
 * 示例 4：
 * <p>
 * 输入：24
 * 输出：false
 *
 * @author sunjianrong
 * @date 2021-10-28 9:32
 */
public class Q869重新排序得到2的幂 {

    private static Set<String> set = new HashSet<>();

    static {
        for (int i = 1; i <= 1e9; i <<= 1) {
            set.add(reverseDigits(i));
        }
    }

    public boolean reorderedPowerOf2(int n) {
        return set.contains(reverseDigits(n));
    }

    private static String reverseDigits(int n) {
        char[] cnt = new char[10];
        while (n > 0) {
            ++cnt[n % 10];
            n /= 10;
        }
        return new String(cnt);
    }

}
