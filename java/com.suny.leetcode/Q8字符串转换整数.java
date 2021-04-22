/**
 * @author sunjianrong
 * @date 2021/4/22 下午8:59
 */
public class Q8字符串转换整数 {

    public static int myAtoi(String s) {
        char[] chars = s.toCharArray();

        int n = chars.length;
        int idx = 0;

        while ((idx < n && chars[idx] == ' ')) {
            idx++;
        }

        if (idx == n) {
            return 0;
        }

        boolean negative = false;
        if (chars[idx] == '-') {
            negative = true;
            idx++;
        } else if (chars[idx] == '+') {
            idx++;
        } else if (!Character.isDigit(chars[idx])) {
            return 0;
        }

        int answer = 0;
        while (idx < n && Character.isDigit(chars[idx])) {
            int digit = chars[idx] - '0';
            if (answer > (Integer.MAX_VALUE - digit) / 10) {
                return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }

            answer = answer * 10 + digit;
            idx++;
        }

        return negative ? -answer : answer;
    }

    public static void main(String[] args) {
        int i = myAtoi(" -42");
        System.out.println(i);
    }
}
