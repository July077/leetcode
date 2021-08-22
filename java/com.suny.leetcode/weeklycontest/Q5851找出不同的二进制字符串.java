package weeklycontest;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 5851. 找出不同的二进制字符串
 * 给你一个字符串数组 nums ，该数组由 n 个 互不相同 的二进制字符串组成，且每个字符串长度都是 n 。请你找出并返回一个长度为 n 且 没有出现 在 nums 中的二进制字符串。如果存在多种答案，只需返回 任意一个 即可。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = ["01","10"]
 * 输出："11"
 * 解释："11" 没有出现在 nums 中。"00" 也是正确答案。
 * 示例 2：
 * <p>
 * 输入：nums = ["00","01"]
 * 输出："11"
 * 解释："11" 没有出现在 nums 中。"10" 也是正确答案。
 * 示例 3：
 * <p>
 * 输入：nums = ["111","011","001"]
 * 输出："101"
 * 解释："101" 没有出现在 nums 中。"000"、"010"、"100"、"110" 也是正确答案。
 *
 * @author sunjianrong
 * @date 2021/8/22 上午10:55
 */
public class Q5851找出不同的二进制字符串 {

    public String findDifferentBinaryString(String[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        Set<String> set = new HashSet<>(Arrays.asList(nums));

        for (String num : nums) {
            char[] chars = num.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                char c = chars[i];
                if (c == '1') {
                    // 换成0试试
                    if (match(set, chars, i, c, '0')) {
                        return new String(chars);
                    }
                } else {
                    // 换成1试试
                    if (match(set, chars, i, c, '1')) {
                        return new String(chars);
                    }
                }
            }
        }

        return null;
    }

    /**
     * 匹配
     *
     * @param set         所有参数
     * @param chars       当前数组元素转成的字符数组
     * @param i           当前匹配第几个下标
     * @param currentChar 当前字符数组字符，用于存档复原
     * @param replaceChar 需要尝试替换的字符
     * @return 是否匹配
     */
    private boolean match(Set<String> set, char[] chars, int i, char currentChar, char replaceChar) {
        chars[i] = replaceChar;
        if (set.contains(new String(chars))) {
            // 复原
            chars[i] = currentChar;
        } else {
            return true;
        }
        return false;
    }


    public static void main(String[] args) {
        String[] param = new String[]{"1"};
        Q5851找出不同的二进制字符串 q5851 = new Q5851找出不同的二进制字符串();
        System.out.println(q5851.findDifferentBinaryString(param));
    }
}
