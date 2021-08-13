package offer2;

/**
 * 剑指 Offer II 017. 含有所有字符的最短字符串
 * 给定两个字符串 s 和t 。返回 s 中包含t的所有字符的最短子字符串。如果 s 中不存在符合条件的子字符串，则返回空字符串 "" 。
 * <p>
 * 如果 s 中存在多个符合条件的子字符串，返回任意一个。
 * <p>
 *
 * <p>
 * 注意： 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
 * <p>
 *
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "ADOBECODEBANC", t = "ABC"
 * 输出："BANC"
 * 解释：最短子字符串 "BANC" 包含了字符串 t 的所有字符 'A'、'B'、'C'
 * <p>
 *
 * @author sunjianrong
 * @date 2021-08-13 11:58
 */
public class Q017含有所有字符的最短字符串 {

    public String minWindow(String s, String t) {
        // 保存字符串 t 中各元素需要的个数
        int[] need = new int[128];
        for (int i = 0; i < t.length(); i++) {
            need[t.charAt(i)]++;
        }

        // 开始进行滑动窗口
        int left = 0;
        int right = 0;
        int windowsSize = Integer.MAX_VALUE;
        int needCount = t.length();
        int start = 0;

        while (right < s.length()) {
            char c = s.charAt(right);
            if (need[c] > 0) {
                needCount--;
            }
            // 无论字符是否在 t 中, need数组中对应字符的计数都需要减少,利用正负区分是否需要该字符
            need[c]--;

            // 如果为0的时候说明窗口已经满足字符的条件
            if (needCount == 0) {
                // 乳沟左边界的字符在 need 数组中小于0,则说明他是一个多余的字符
                while (left < right && need[s.charAt(left)] < 0) {
                    // need 数组中维护更新这个值,增加1
                    need[s.charAt(left)]++;
                    // 左边界向右边移动,过滤掉这个元素
                    left++;
                }

                // 如果当前的窗口大小比之前维护的窗口值更小,就需要做更新
                if (right - left + 1 < windowsSize) {
                    // 更新窗口的值
                    windowsSize = right - left + 1;
                    // 更新窗口的起始位置,方便找到对应位置的返回结果
                    start = left;
                }
                // 先将1位置的字符计数重新增加1
                need[s.charAt(left)]++;
                left++;
                needCount++;
            }
            // 右边界移动,开始下一次的循环
            right++;

        }

        return windowsSize == Integer.MAX_VALUE ? "" : s.substring(start, start + windowsSize);

    }
}
