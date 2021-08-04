import java.util.Arrays;

/**
 * 611. 有效三角形的个数
 * <p>
 * 给定一个包含非负整数的数组，你的任务是统计其中可以组成三角形三条边的三元组个数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [2,2,3,4]
 * 输出: 3
 * 解释:
 * 有效的组合是:
 * 2,3,4 (使用第一个 2)
 * 2,3,4 (使用第二个 2)
 * 2,2,3
 * <p>
 *
 * @author sunjianrong
 * @date 2021-08-04 9:13
 */
public class Q611有效三角形的个数 {

    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int res = 0;
        for (int i = n - 1; i >= 2; --i) {
            int l = 0;
            int r = i - 1;
            while (l < r) {
                if (nums[l] + nums[r] > nums[i]) {
                    res += r - l;
                    --r;
                } else {
                    ++l;
                }
            }

        }

        return res;

    }

    // 暴力法
    public int triangleNumber0(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int res = 0;

        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                int s = nums[i] + nums[j];
                int l = j + 1;
                int r = n - 1;
                while (l < r) {
                    int mid = l + (r - l) / 2;
                    if (nums[mid] < s) {
                        l = mid;
                    } else {
                        r = mid - 1;
                    }
                }

                if (nums[r] < s) {
                    res += r - j;
                }

            }
        }
        return res;
    }
}
