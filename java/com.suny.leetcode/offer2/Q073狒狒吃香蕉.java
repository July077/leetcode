package offer2;

/**
 * 剑指 Offer II 073. 狒狒吃香蕉
 * <p>
 * 狒狒喜欢吃香蕉。这里有N堆香蕉，第 i 堆中有piles[i]根香蕉。警卫已经离开了，将在H小时后回来。
 * <p>
 * 狒狒可以决定她吃香蕉的速度K（单位：根/小时）。每个小时，她将会选择一堆香蕉，从中吃掉 K 根。如果这堆香蕉少于 K 根，她将吃掉这堆的所有香蕉，然后这一小时内不会再吃更多的香蕉，下一个小时才会开始吃另一堆的香蕉。
 * <p>
 * 狒狒喜欢慢慢吃，但仍然想在警卫回来前吃掉所有的香蕉。
 * <p>
 * 返回她可以在 H 小时内吃掉所有香蕉的最小速度 K（K 为整数）。
 * <p>
 *
 * <p>
 * 示例 1：
 * <p>
 * 输入: piles = [3,6,7,11], H = 8
 * 输出: 4
 * <p>
 *
 * @author sunjianrong
 * @date 2021/8/31 下午9:21
 */
public class Q073狒狒吃香蕉 {

    public int minEatingSpeed(int[] piles, int h) {
        int maxVal = 1;
        for (int pile : piles) {
            maxVal = Math.max(maxVal, pile);
        }

        // 最慢速度跟最快速度
        int left = 1;
        int right = maxVal;
        while (left < right) {
            int mid = left + (right - left) / 2;

            if (calculateSum(piles, mid) > h) {
                // 耗时太多说明太慢了
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;

    }

    private int calculateSum(int[] piles, int speed) {
        int sum = 0;
        for (int pile : piles) {
            sum += (pile + speed - 1) / speed;
        }
        return sum;
    }
}
