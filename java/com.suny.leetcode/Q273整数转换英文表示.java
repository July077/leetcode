/**
 * 273. 整数转换英文表示
 * 将非负整数 num 转换为其对应的英文表示。
 * <p>
 *
 * <p>
 * 示例 1：
 * <p>
 * 输入：num = 123
 * 输出："One Hundred Twenty Three"
 * 示例 2：
 * <p>
 * 输入：num = 12345
 * 输出："Twelve Thousand Three Hundred Forty Five"
 * <p>
 *
 * @author sunjianrong
 * @date 2021-10-11 9:41
 */
public class Q273整数转换英文表示 {

    String[] singles = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    String[] teens = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    String[] tens = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    String[] thousands = {"", "Thousand", "Million", "Billion"};

    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 3, unit = 1000000000; i >= 0; i--, unit /= 1000) {
            int curNum = num / unit;
            if (curNum != 0) {
                num -= curNum * unit;
                sb.append(toEnglish(curNum)).append(thousands[i]).append(" ");
            }

        }

        return sb.toString().trim();
    }

    public String toEnglish(int num) {
        StringBuilder sb = new StringBuilder();
        int hundred = num / 100;
        num %= 100;
        if (hundred != 0) {
            sb.append(singles[hundred]).append(" Hundred ");
        }
        int ten = num / 10;
        if (ten >= 2) {
            sb.append(tens[ten]).append(" ");
            num %= 10;
        }

        if (num > 0 && num < 10) {
            sb.append(singles[num]).append(" ");
        } else if (num >= 10) {
            sb.append(teens[num - 10]).append(" ");
        }
        return sb.toString();
    }
}
