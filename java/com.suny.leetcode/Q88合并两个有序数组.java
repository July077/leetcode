import java.util.Arrays;

/**
 * 88. 合并两个有序数组
 * <p>
 * 给你两个有序整数数组nums1 和 nums2，请你将 nums2 合并到nums1中，使 nums1 成为一个有序数组。
 * <p>
 * 初始化nums1 和 nums2 的元素数量分别为m 和 n 。你可以假设nums1 的空间大小等于m + n，这样它就有足够的空间保存来自 nums2 的元素。
 * <p>
 *
 * @author sunjianrong
 * @date 2021/6/28 下午10:20
 */
public class Q88合并两个有序数组 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = 0;
        int p2 = 0;
        int[] sorted = new int[m + n];
        int curr;

        while (p1 < m || p2 < n) {
            if (p1 == m) {
                curr = nums2[p2++];
            } else if (p2 == n) {
                curr = nums1[p1++];
            } else if (nums1[p1] < nums2[p2]) {
                curr = nums1[p1++];
            } else {
                curr = nums2[p2++];
            }

            sorted[p1 + p2 - 1] = curr;
        }

        for (int i = 0; i != m + n; ++i) {
            nums1[i] = sorted[i];
        }
    }


    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        int tail = m + n - 1;
        int current;

        while (p1 >= 0 || p2 >= 0) {
            if (p1 == -1) {
                current = nums1[p2--];
            } else if (p2 == -1) {
                current = nums1[p1--];
            } else if (nums1[p1] > nums2[p2]) {
                current = nums1[p1--];
            } else {
                current = nums2[p2--];
            }
            nums1[tail--] = current;
        }
    }


    // 小天才做法
    public void merge0(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 1; i <= n; i++) {
            nums1[m + i] = nums2[i - 1];
        }

        Arrays.sort(nums1);

    }
}
