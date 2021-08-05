package offer;

import java.util.HashSet;
import java.util.Set;

/**
 * 剑指 Offer 61. 扑克牌中的顺子
 * 从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
 * <p>
 *
 * <p>
 * 示例1:
 * <p>
 * 输入: [1,2,3,4,5]
 * 输出: True
 * <p>
 *
 * @author sunjianrong
 * @date 2021-08-05 11:58
 */
public class Q61扑克牌中的顺子 {

    public boolean isStraight(int[] nums) {
        Set<Integer> repeat = new HashSet<>();
        int max = 0;
        int min = 14;
        for (int num : nums) {
            if (num == 0) {
                // 跳过大小王
                continue;
            }
            max = Math.max(max, num);
            min = Math.min(min, num);
            if (repeat.contains(num)) {
                return false;
            }
            repeat.add(num);
        }

        return max - min < 5;
    }
}
