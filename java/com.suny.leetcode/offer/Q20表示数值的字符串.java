package offer;

/**
 * 剑指 Offer 20. 表示数值的字符串
 * <p>
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * <p>
 * 数值（按顺序）可以分成以下几个部分：
 * <p>
 * 若干空格
 * 一个小数或者整数
 * （可选）一个'e'或'E'，后面跟着一个整数
 * 若干空格
 * 小数（按顺序）可以分成以下几个部分：
 * <p>
 * （可选）一个符号字符（'+' 或 '-'）
 * 下述格式之一：
 * 至少一位数字，后面跟着一个点 '.'
 * 至少一位数字，后面跟着一个点 '.' ，后面再跟着至少一位数字
 * 一个点 '.' ，后面跟着至少一位数字
 * 整数（按顺序）可以分成以下几个部分：
 * <p>
 * （可选）一个符号字符（'+' 或 '-'）
 * 至少一位数字
 * 部分数值列举如下：
 * <p>
 * ["+100", "5e2", "-123", "3.1416", "-1E-16", "0123"]
 * 部分非数值列举如下：
 * <p>
 * ["12e", "1a3.14", "1.2.3", "+-5", "12e+5.4"]
 *
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "0"
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：s = "e"
 * 输出：false
 * <p>
 *
 * @author sunjianrong
 * @date 2021/7/25 上午10:36
 */
public class Q20表示数值的字符串 {

    public boolean isNumber(String s) {
        char[] chars = s.toCharArray();
        int length = chars.length;

        // 初始化下标
        int index = 0;

        // 4个标记
        boolean hasNum = false;
        boolean hasE = false;
        boolean hasSign = false;
        boolean hasDot = false;

        // 移动到非空字符上
        while (index < length && chars[index] == ' ') {
            index++;
        }

        // 遍历所有字符到结尾
        while (index < length) {
            char c = chars[index];

            if (Character.isDigit(c)) {
                hasNum = true;
            } else if (c == 'e' || c == 'E') {
                // eE 前面必须是数值  必须不是e
                if (hasE || !hasNum) {
                    return false;
                }

                hasE = true;
                hasNum = false;
                hasDot = false;
                hasSign = false;
            } else if (c == '+' || c == '-') {
                // 符号前面必须不是数值 必须没有E   必须没有符号
                if (hasSign || hasDot || hasNum) {
                    return false;
                }
                hasSign = true;
            } else if (c == '.') {
                // 点前面必须是数值  必须没有点 必须没有E
                if (hasDot || hasE) {
                    return false;
                }

                hasDot = true;
            } else if (c == ' ') {
                // 有空格正常就说明已经表达式完毕
                break;
            } else {
                // 非法字符
                return false;
            }

            index++;

        }

        for (; index < length; index++) {
            // 刚刚是空格跳出来的，所以后面必须全是空格，不然就是有问题
            if (chars[index] != ' ') {
                return false;
            }
        }

        return hasNum;


    }

}
