/**
 * 65. 有效数字
 * 有效数字（按顺序）可以分成以下几个部分：
 * <p>
 * 一个 小数 或者 整数
 * （可选）一个 'e' 或 'E' ，后面跟着一个 整数
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
 * 部分有效数字列举如下：
 * <p>
 * ["2", "0089", "-0.1", "+3.14", "4.", "-.9", "2e10", "-90E3", "3e+7", "+6e-1", "53.5e93", "-123.456e789"]
 * 部分无效数字列举如下：
 * <p>
 * ["abc", "1a", "1e", "e3", "99e2.5", "--6", "-+3", "95a54e53"]
 * 给你一个字符串 s ，如果 s 是一个 有效数字 ，请返回 true 。
 *
 * @author sunjianrong
 * @date 2021/6/17 下午9:57
 */
public class Q65有效数字 {
    public boolean isNumber(String s) {
        // 为空则直接返回 false
        if (s == null || s.length() == 0) {
            return false;
        }

        // 遇到整数,小数点,e或者E的情况
        boolean isNum = false;
        boolean isDot = false;
        boolean iseOrE = false;

        char[] chars = s.trim().toCharArray();

        for (int i = 0; i < chars.length; i++) {
            // 0-9 就返回整数
            if (chars[i] >= '0' && chars[i] <= '9') {
                isNum = true;
            } else if (chars[i] == '.') {
                // 如果当前位置是小数点,那么小数点后必须药有数字
                if (isDot || iseOrE) {
                    return false;
                }
                isDot = true;
            } else if (chars[i] == 'e' || chars[i] == 'E') {
                // 表示遇到 e 或者 E
                if (!isNum || iseOrE) {
                    // e、E前面必须是数字,并且 e跟 E前面一定不能出现 e、E
                    return false;
                }
                iseOrE = true;
                // 重置 isNum ，因为 e或者E后面一定是整数
                isNum = false;
            } else if (chars[i] == '+' || chars[i] == '-') {
                // 当前位置出现字符
                // 遇到符号:1 在第一位，2.前一位必须是e或者E。 如果两个条件都不满足，则一定不是数值
                if (i != 0 && chars[i - 1] != 'e' && chars[i - 1] != 'E') {
                    return false;
                }
            } else {
                // 其它情况一定不是数值
                return false;
            }
        }

        return isNum;

    }

}
