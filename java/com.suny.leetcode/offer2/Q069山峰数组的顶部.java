package offer2;

/**
 * 剑指 Offer II 069. 山峰数组的顶部
 * <p>
 * 符合下列属性的数组 arr 称为 山峰数组（山脉数组） ：
 * <p>
 * arr.length >= 3
 * 存在 i（0 < i< arr.length - 1）使得：
 * arr[0] < arr[1] < ... arr[i-1] < arr[i]
 * arr[i] > arr[i+1] > ... > arr[arr.length - 1]
 * 给定由整数组成的山峰数组 arr ，返回任何满足 arr[0] < arr[1] < ... arr[i - 1] < arr[i] > arr[i + 1] > ... > arr[arr.length - 1] 的下标 i，即山峰顶部。
 * <p>
 *
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [0,1,0]
 * 输出：1
 * <p>
 * <p>
 *
 * @author sunjianrong
 * @date 2021/8/30 下午9:17
 */
public class Q069山峰数组的顶部 {

    public int peakIndexInMountainArray(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (arr[mid] < arr[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
}
