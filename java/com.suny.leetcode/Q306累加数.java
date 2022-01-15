/**
 * 306. 累加数
 * 累加数 是一个字符串，组成它的数字可以形成累加序列。
 * 
 * 一个有效的 累加序列 必须 至少 包含 3 个数。除了最开始的两个数以外，字符串中的其他数都等于它之前两个数相加的和。
 * 
 * 给你一个只包含数字 '0'-'9' 的字符串，编写一个算法来判断给定输入是否是 累加数 。如果是，返回 true ；否则，返回 false 。
 * 
 * 说明：累加序列里的数 不会 以 0 开头，所以不会出现 1, 2, 03 或者 1, 02, 3 的情况。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入："112358"
 * 输出：true
 * 解释：累加序列为: 1, 1, 2, 3, 5, 8 。1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8
 * 示例 2：
 * 
 * 输入："199100199"
 * 输出：true
 * 解释：累加序列为: 1, 99, 100, 199。1 + 99 = 100, 99 + 100 = 199
 */
public class Q306累加数 {

    public boolean isAdditiveNumber(String num) {
        if (num.length() < 3) {
            return false;
        }

        return dfs(num, 0, 0, 0, 0);
    }

    private boolean dfs(String num, int index, int count, long prevprev, long prev) {
        if (index >= num.length()) {
            return count > 2;
        }

        long current = 0;
        for (int i = index; i < num.length(); i++) {
            char c = num.charAt(i);

            if (num.charAt(index) == '0' && i > index) {
                // 如果是前导0就直接过滤
                return false;
            }

            current = current * 10 + c - '0';
            if (count >= 2) {
                long sum = prevprev + prev;
                if (current > sum) {
                    return false;
                }

                if (current < sum) {
                    continue;
                }

            }

            if (dfs(num, i + 1, count + 1, prev, current)) {
                return true;
            }

        }

        return false;
    }

}
