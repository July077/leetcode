package offer;

import java.util.Arrays;

/**
 * 剑指 Offer 11. 旋转数组的最小数字
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。  
 * <p>
 * 示例 1：
 * <p>
 * 输入：[3,4,5,1,2]
 * 输出：1
 * 示例 2：
 * <p>
 * 输入：[2,2,2,0,1]
 * 输出：0
 * <p>
 *
 * @author sunjianrong
 * @date 2021/7/19 下午10:11
 */
public class Q11旋转数组的最小数字 {

    public int minArray(int[] numbers) {
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (numbers[mid] > numbers[right]) {
                left = mid + 1;
            } else if (numbers[mid] < numbers[right]) {
                right = mid;
            } else {
                int x = left;
                for (int i = left + 1; i < right; i++) {
                    if (numbers[i] < numbers[x]) {
                        x = i;
                    }
                    return numbers[x];
                }
            }
        }

        return numbers[left];

    }


    public int minArray0(int[] numbers) {
        Arrays.sort(numbers);
        return numbers[0];
    }
}
