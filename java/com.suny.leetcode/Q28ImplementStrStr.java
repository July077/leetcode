/**
 * 实现 strStr()
 * <p>
 * 实现 strStr() 函数。
 * <p>
 * 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。如果不存在，则返回  -1 。
 * <p>
 *
 * @author sunjianrong
 * @date 2021/5/21 下午10:12
 */
public class Q28ImplementStrStr {
    public int strStr(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();

        char[] totalArray = haystack.toCharArray();
        char[] subArray = needle.toCharArray();

        // 出发点
        for (int i = 0; i <= n - m; i++) {

            int a = i;
            int b = 0;

            // 两个指针开始匹配
            while (b < m && totalArray[a] == subArray[b]) {
                a++;
                b++;
            }

            if (b == m) {
                return i;
            }

        }
        return -1;


    }
}
