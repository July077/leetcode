import java.util.*;
import java.util.stream.Collectors;

/**
 * 414. 第三大的数
 * 给你一个非空数组，返回此数组中 第三大的数 。如果不存在，则返回数组中最大的数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：[3, 2, 1]
 * 输出：1
 * 解释：第三大的数是 1 。
 * 示例 2：
 * <p>
 * 输入：[1, 2]
 * 输出：2
 * 解释：第三大的数不存在, 所以返回最大的数 2 。
 * 示例 3：
 * <p>
 * 输入：[2, 2, 3, 1]
 * 输出：1
 * 解释：注意，要求返回第三大的数，是指在所有不同数字中排第三大的数。
 * 此例中存在两个值为 2 的数，它们都排第二。在所有不同数字中排第三大的数为 1 。
 *
 * @author sunjianrong
 * @date 2021/10/6 下午11:16
 */
public class Q414第三大的数 {

    public int thirdMax(int[] nums) {
        ArrayList<Integer> list = Arrays.stream(nums).boxed().distinct().sorted().collect(Collectors.toCollection(ArrayList::new));
        return list.size() < 3 ? list.get(list.size() - 1) : list.get(list.size() - 3);
    }
}
