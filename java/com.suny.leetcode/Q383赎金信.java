/**
 * 383. 赎金信
 * 为了不在赎金信中暴露字迹，从杂志上搜索各个需要的字母，组成单词来表达意思。
 * <p>
 * 给你一个赎金信 (ransomNote) 字符串和一个杂志(magazine)字符串，判断 ransomNote 能不能由 magazines 里面的字符构成。
 * <p>
 * 如果可以构成，返回 true ；否则返回 false 。
 * <p>
 * magazine 中的每个字符只能在 ransomNote 中使用一次。
 * <p>
 *
 * <p>
 * 示例 1：
 * <p>
 * 输入：ransomNote = "a", magazine = "b"
 * 输出：false
 * 示例 2：
 * <p>
 * 输入：ransomNote = "aa", magazine = "ab"
 * 输出：false
 * 示例 3：
 * <p>
 * 输入：ransomNote = "aa", magazine = "aab"
 * 输出：true
 * <p>
 *
 * @author sunjianrong
 * @date 2021/12/4 下午11:01
 */
public class Q383赎金信 {

    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) {
            return false;
        }
        int[] cnt = new int[26];
        char[] chars = magazine.toCharArray();
        for (char c : chars) {
            cnt[c - 'a']++;
        }

        char[] charArray = ransomNote.toCharArray();
        for (int i : charArray) {
            cnt[i - 'a']--;
            if (cnt[i - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}
