/**
 * 43. 字符串相乘
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 * <p>
 * 示例 1:
 * <p>
 * 输入: num1 = "2", num2 = "3"
 * 输出: "6"
 * 示例 2:
 * <p>
 * 输入: num1 = "123", num2 = "456"
 * 输出: "56088"
 * 说明：
 * <p>
 * num1 和 num2 的长度小于110。
 * num1 和 num2 只包含数字 0-9。
 * num1 和 num2 均不以零开头，除非是数字 0 本身。
 * 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
 *
 * @author sunjianrong
 * @date 2021/6/6 下午9:29
 */
public class Q43_Multiply_Strings {

    public static void main(String[] args) {
        Q43_Multiply_Strings multiplyStrings = new Q43_Multiply_Strings();
        String multiply = multiplyStrings.multiply("123", "45");
        System.out.println(multiply);
    }

    public String multiply(String num1, String num2) {
        final String zero = "0";
        if (zero.equals(num1) || zero.equals(num2)) {
            return zero;
        }

        int len1 = num1.length();
        int len2 = num2.length();
        int[] ans = new int[len1 + len2];
        for (int i = len1 - 1; i >= 0; i--) {
            int value1 = num1.charAt(i) - '0';
            for (int j = len2 - 1; j >= 0; j--) {
                int value2 = num2.charAt(j) - '0';
                int sum = ans[i + j + 1] + value1 * value2;
                ans[i + j + 1] = sum % 10;
                ans[i + j] += sum / 10;

                System.out.printf("i=%d , j=%d ,v1=%d , v2=%d , 总和=%d, ans[i+j+1]=ans[%d]=%d , ans[i+j]=ans[%d]=%d %n", i, j, value1, value2, sum, i + j + 1, ans[i + j + 1], i + j, ans[i + j]);
            }

        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < ans.length; i++) {
            if (i == 0 && ans[i] == 0) {
                continue;
            }
            stringBuilder.append(ans[i]);
        }

        return stringBuilder.toString();

    }
}
