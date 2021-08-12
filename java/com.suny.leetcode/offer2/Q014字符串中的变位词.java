package offer2;

/**
 * 剑指 Offer II 014. 字符串中的变位词
 * 给定两个字符串s1和s2，写一个函数来判断 s2 是否包含 s1的某个变位词。
 * <p>
 * 换句话说，第一个字符串的排列之一是第二个字符串的 子串 。
 * <p>
 *
 * <p>
 * 示例 1：
 * <p>
 * 输入: s1 = "ab" s2 = "eidbaooo"
 * 输出: True
 * 解释: s2 包含 s1 的排列之一 ("ba").
 * <p>
 *
 * @author sunjianrong
 * @date 2021-08-12 11:54
 */
public class Q014字符串中的变位词 {

    public boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length()) {
            return false;
        }

        // 由于只有小写字母,故26个元素就够
        int[] visitedTime = new int[26];

        char[] c1 = s1.toCharArray();

        // 统计为位串1在哈希表中出现的位置以及个数
        for (int i = 0; i < c1.length; i++) {
            visitedTime[c1[i] - 'a']++;
        }

        char[] c2 = s2.toCharArray();

        int count = 0;

        for (int i = 0; i < c1.length; i++) {
            // 若原先个数只有一个，操作后刚好等于0。  若原先的格式大于一个，操作后则大于1
            if (--visitedTime[c2[i] - 'a'] >= 0) {
                count++;
            }
        }


        // 如果窗口中的个数刚好是字符串1的个数，符合条件就直接返回 true
        if (count == c1.length) {
            return true;
        }

        // 进行滑动窗口 平移 不进行扩张以及缩放
        for (int i = c1.length; i < c2.length; i++) {
            // 若移出窗口的字母是被统计股的符合条件的字母，统计的时候需要减掉
            if (++visitedTime[c2[i - c1.length] - 'a'] > 0) {
                count--;
            }

            // 若进入窗口的字符符合统计的条件，则统计计数需要加1
            if (--visitedTime[c2[i] - 'a'] >= 0) {
                count++;
            }

            // 当统计计数到达串1的个数时，即窗口中的字母刚好符合条件，直接返回  true
            if (count == c1.length) {
                return true;
            }

        }

        return false;


    }

}
