/**
 * 476. 数字的补数
 * <p>
 * 给你一个 正 整数 num ，输出它的补数。补数是对该数的二进制表示取反。
 * <p>
 *
 * <p>
 * 示例 1：
 * <p>
 * 输入：num = 5
 * 输出：2
 * 解释：5 的二进制表示为 101（没有前导零位），其补数为 010。所以你需要输出 2 。
 * 示例 2：
 * <p>
 * 输入：num = 1
 * 输出：0
 * 解释：1 的二进制表示为 1（没有前导零位），其补数为 0。所以你需要输出 0 。
 * <p>
 *
 * @author sunjianrong
 * @date 2021-10-18 9:15
 */
public class Q476数字的补数 {

    public int findComplement(int num) {
        final StringBuffer sb = new StringBuffer();

        final String str = Integer.toBinaryString(num);
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '1') {
                sb.append('0');
            } else {
                sb.append('1');
            }
        }

        return Integer.parseInt(sb.toString(), 2);
    }

    public static void main(String[] args) {
        final Q476数字的补数 q476 = new Q476数字的补数();
        q476.findComplement(5);
    }
}
