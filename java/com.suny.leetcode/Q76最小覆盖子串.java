/**
 * 76. 最小覆盖子串
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 * <p>
 * 注意：如果 s 中存在这样的子串，我们保证它是唯一的答案。
 *
 * @author sunjianrong
 * @date 2021/6/23 下午10:30
 */
public class Q76最小覆盖子串 {

    public String minWindow(String s, String t) {
        if (s == null || s == "" || t == null || t == "" || s.length() < t.length()) {
            return "";
        }

        // 维护两个数组. 记录已有字符串指定字符的出现次数
        int[] need = new int[128];
        int[] have = new int[128];

        // 将目标字符串指定字符的出现数记录
        for (int i = 0; i < t.length(); i++) {
            need[t.charAt(i)]++;
        }

        // 左右指针、最长长度
        int left = 0;
        int right = 0;
        int min = s.length() + 1;
        int count = 0;
        int start = 0;

        while (right < s.length()) {
            char r = s.charAt(right);
            if (need[r] == 0) {
                right++;
                continue;
            }

            if (have[r] < need[r]) {
                count++;
            }

            have[r]++;
            right++;

            while (count == t.length()) {
                if (right - left < min) {
                    min = right - left;
                    start = left;
                }

                char l = s.charAt(left);
                if (need[l] == 0) {
                    left++;
                    continue;
                }

                if (have[l] == need[l]) {
                    count--;
                }

                have[l]--;
                left++;
            }
        }

        // 如果最小长度为初始值,说明没有符合条件的子串
        if (min == s.length() + 1) {
            return "";
        }

        return s.substring(start, start + min);

    }

}
