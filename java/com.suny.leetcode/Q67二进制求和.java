/**
 * 67. 二进制求和
 * <p>
 * 给你两个二进制字符串，返回它们的和（用二进制表示）。
 * <p>
 * 输入为 非空 字符串且只包含数字 1 和 0。
 *
 * @author sunjianrong
 * @date 2021/6/18 下午11:23
 */
public class Q67二进制求和 {

    public String addBinary(String a, String b) {
        StringBuilder ans = new StringBuilder();
        int carry = 0;

        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; i--, j--) {
            int sum = carry;

            // 用ascii 码相减补0
            sum += i >= 0 ? a.charAt(i) - '0' : 0;
            sum += j >= 0 ? b.charAt(j) - '0' : 0;

            // 二者为1  sum%2刚好为0 否则为1
            ans.append(sum % 2);

            // 二者都为1  进位1 要么0
            carry = sum / 2;
        }

        ans.append(carry == 1 ? carry : "");
        return ans.reverse().toString();

    }

    public static void main(String[] args) {
        Q67二进制求和 q67 = new Q67二进制求和();
        String addBinary = q67.addBinary("111", "1");
        System.out.println(addBinary);
    }
}
