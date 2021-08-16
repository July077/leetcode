package weeklycontest;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * 5832. 构造元素不等于两相邻元素平均值的数组
 * 给你一个 下标从 0 开始 的数组 nums ，数组由若干 互不相同的 整数组成。你打算重新排列数组中的元素以满足：重排后，数组中的每个元素都 不等于 其两侧相邻元素的 平均值 。
 * <p>
 * 更公式化的说法是，重新排列的数组应当满足这一属性：对于范围 1 <= i < nums.length - 1 中的每个 i ，(nums[i-1] + nums[i+1]) / 2 不等于 nums[i] 均成立 。
 * <p>
 * 返回满足题意的任一重排结果。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3,4,5]
 * 输出：[1,2,4,5,3]
 * 解释：
 * i=1, nums[i] = 2, 两相邻元素平均值为 (1+4) / 2 = 2.5
 * i=2, nums[i] = 4, 两相邻元素平均值为 (2+5) / 2 = 3.5
 * i=3, nums[i] = 5, 两相邻元素平均值为 (4+3) / 2 = 3.5
 *
 * @author sunjianrong
 * @date 2021/8/15 上午10:40
 */
public class Q5832构造元素不等于两相邻元素平均值的数组 {

    HashSet<Integer> visited = new HashSet<>();

    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);

        for (int i = 1; i < n - 1; i += 2) {
            int temp = nums[i];
            nums[i] = nums[i + 1];
            nums[i + 1] = temp;
        }

        return nums;
    }


    private void dfs(LinkedList<Integer> res, int[] nums, int curr) {
        if (curr == nums.length) {
            return;
        }
        if (res.size() == nums.length) {
            return;
        }

        if (curr == 0) {
            res.add(nums[curr]);
            visited.add(nums[curr]);
            ++curr;
        }

        if (curr == nums.length - 1) {
            res.add(nums[nums.length - 1]);
            visited.add(nums[nums.length - 1]);
            return;
        }


        for (int i = curr; i < nums.length; i++) {
            int num = nums[i];
            if (visited.contains(num)) {
                continue;
            }


            if (isIllegal(nums[i - 1], nums[i], nums[i + 1])) {
                res.add(num);
                visited.add(num);
                ++curr;
            } else {
                dfs(res, nums, curr);
            }

        }
    }

    private boolean isIllegal(int left, int right, int mid) {
        return ((left + right) / 2) != mid;
    }

    public static void main(String[] args) {
        int[] ints = {1, 2, 3, 4, 5};
        Q5832构造元素不等于两相邻元素平均值的数组 q5832 = new Q5832构造元素不等于两相邻元素平均值的数组();
        System.out.println(Arrays.toString(q5832.rearrangeArray(ints)));
    }
}
