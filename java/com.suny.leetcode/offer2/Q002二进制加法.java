package offer2;

/**
 * 剑指 Offer II 002. 二进制加法
 * 给定两个 01 字符串a和b，请计算它们的和，并以二进制字符串的形式输出。
 * <p>
 * 输入为 非空 字符串且只包含数字1和0。
 * <p>
 *
 * <p>
 * 示例1:
 * <p>
 * 输入: a = "11", b = "10"
 * 输出: "101"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/JFETK5
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author sunjianrong
 * @date 2021/8/8 下午10:23
 */
public class Q002二进制加法 {

    public String addBinary(String a, String b) {
        if (a == null || a.length() == 0) {
            return b;
        }
        if (b == null || b.length() == 0) {
            return a;
        }

        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;

        int carry = 0;
        while (i >= 0 || j >= 0) {
            if (i >= 0) {
                carry += a.charAt(i--) - '0';
            }
            if (j >= 0) {
                carry += b.charAt(j--) - '0';
            }
            sb.append(carry % 2);
            carry = carry >> 1;
        }

        String s = sb.reverse().toString();
        return carry > 0 ? '1' + s : s;

    }

    // 暴力
    public String addBinary0(String a, String b) {
        int da = Integer.parseInt(a, 2);
        int db = Integer.parseInt(b, 2);
        return Integer.toBinaryString(da + db);
    }

}
