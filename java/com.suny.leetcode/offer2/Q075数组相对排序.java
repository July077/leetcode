package offer2;

/**
 * 剑指 Offer II 075. 数组相对排序
 * <p>
 * 给定两个数组，arr1 和arr2，
 * <p>
 * arr2中的元素各不相同
 * arr2 中的每个元素都出现在arr1中
 * 对 arr1中的元素进行排序，使 arr1 中项的相对顺序和arr2中的相对顺序相同。未在arr2中出现过的元素需要按照升序放在arr1的末尾。
 * <p>
 *
 * <p>
 * 示例：
 * <p>
 * 输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
 * 输出：[2,2,2,1,4,3,3,9,6,7,19]
 * <p>
 *
 * @author sunjianrong
 * @date 2021-09-01 17:57
 */
public class Q075数组相对排序 {

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] result = new int[arr1.length];
        int[] a = new int[1001];

        // 统计 array1 中的个数
        for (int k : arr1) {
            a[k]++;
        }

        // 新数组的下标位置
        int index = 0;
        // 按照 array2 的顺序
        for (int k : arr2) {
            for (int j = 0; j < a[k]; j++) {
                result[index] = k;
                index++;
            }
            a[k] = 0;
        }

        // 剩余的数据，按照数组的顺序填入新的数组
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i]; j++) {
                result[index] = i;
                index++;
            }
        }

        return result;
    }
}
