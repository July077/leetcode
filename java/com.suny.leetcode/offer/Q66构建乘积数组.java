package offer;

import java.util.ArrayList;
import java.util.List;

/**
 * 指 Offer 66. 构建乘积数组
 * 给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，其中B[i] 的值是数组 A 中除了下标 i 以外的元素的积, 即B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。
 * <p>
 *
 * <p>
 * 示例:
 * <p>
 * 输入: [1,2,3,4,5]
 * 输出: [120,60,40,30,24]
 * <p>
 *
 * @author sunjianrong
 * @date 2021/8/5 下午10:02
 */
public class Q66构建乘积数组 {

    public int[] constructArr(int[] a) {
        int length = a.length;
        if (a == null || length <= 0) {
            return new int[0];
        }


        int[] b = new int[length];
        b[0] = 1;

        // 当前元素x左边界也就是之前的元素
        for (int i = 1; i < length; i++) {
            b[i] = b[i - 1] * a[i - 1];
        }

        // 当前元素 X 右边界，也就是后面的元素
        int tmp = 1;
        for (int i = length - 2; i >= 0; i--) {
            tmp = tmp * a[i + 1];
            b[i] = b[i] * tmp;

        }
        return b;
    }

    // 暴力法超时
    public int[] constructArr0(int[] a) {
        List<Integer> resList = new ArrayList<>();

        int length = a.length;

        for (int i = 0; i < length; i++) {
            int res = 1;
            for (int j = 0; j < a.length; j++) {

                if (i == j) {
                    continue;
                }
                res = res * a[j];
            }
            resList.add(res);
        }

        return resList.stream()
                .mapToInt(Integer::intValue).toArray();

    }
}
