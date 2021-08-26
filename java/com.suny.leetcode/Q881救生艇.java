import java.util.Arrays;

/**
 * 881. 救生艇
 * <p>
 * 第i个人的体重为people[i]，每艘船可以承载的最大重量为limit。
 * <p>
 * 每艘船最多可同时载两人，但条件是这些人的重量之和最多为limit。
 * <p>
 * 返回载到每一个人所需的最小船数。(保证每个人都能被船载)。
 * <p>
 *
 * <p>
 * 示例 1：
 * <p>
 * 输入：people = [1,2], limit = 3
 * 输出：1
 * 解释：1 艘船载 (1, 2)
 * 示例 2：
 * <p>
 * 输入：people = [3,2,2,1], limit = 3
 * 输出：3
 * 解释：3 艘船分别载 (1, 2), (2) 和 (3)
 * <p>
 *
 * @author sunjianrong
 * @date 2021-08-26 9:34
 */
public class Q881救生艇 {

    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);

        int count = 0;
        int left = 0;
        int right = people.length - 1;

        // 开始匹配答案
        while (left <= right) {
            if (people[left] + people[right] <= limit) {
                left++;
            }

            right--;
            count++;
        }

        return count;
    }
}
