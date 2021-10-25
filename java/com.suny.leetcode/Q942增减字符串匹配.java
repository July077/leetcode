/**
 * 942. 增减字符串匹配
 * 给定只含"I"（增大）或 "D"（减小）的字符串S，令N = S.length。
 * <p>
 * 返回[0, 1, ..., N]的任意排列A使得对于所有i = 0,..., N-1，都有：
 * <p>
 * 如果S[i] == "I"，那么A[i] < A[i+1]
 * 如果S[i] == "D"，那么A[i] > A[i+1]
 *
 * <p>
 * 示例 1：
 * <p>
 * 输入："IDID"
 * 输出：[0,4,1,3,2]
 * 示例 2：
 * <p>
 * 输入："III"
 * 输出：[0,1,2,3]
 * 示例 3：
 * <p>
 * 输入："DDI"
 * 输出：[3,2,0,1]
 * <p>
 *
 * @author sunjianrong
 * @date 2021-10-25 12:00
 */
public class Q942增减字符串匹配 {

    public int[] diStringMatch(String s) {
        int length = s.length();
        int low = 0;
        int high = length;

        int[] res = new int[length + 1];

        for (int i = 0; i < length; i++) {
            if (s.charAt(i) == 'I') {
                res[i] = low++;
            } else {
                res[i] = high--;
            }
        }
        res[length] = low;
        return res;
    }

}
