/**
 * 80. 删除有序数组中的重复项 II
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 最多出现两次 ，返回删除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 * <p>
 *  
 * <p>
 * 说明：
 * <p>
 * 为什么返回数值是整数，但输出的答案是数组呢？
 * <p>
 * 请注意，输入数组是以「引用」方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。
 * <p>
 * 你可以想象内部操作如下:
 * <p>
 * // nums 是以“引用”方式传递的。也就是说，不对实参做任何拷贝
 * int len = removeDuplicates(nums);
 * <p>
 * // 在函数里修改输入数组对于调用者是可见的。
 * // 根据你的函数返回的长度, 它会打印出数组中 该长度范围内 的所有元素。
 * for (int i = 0; i < len; i++) {
 *     print(nums[i]);
 * }
 *
 * @author sunjianrong
 * @date 2021/6/24 下午10:44
 */
public class Q80删除有序数组中的重复项II {

    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n <= 2) {
            return n;
        }

        int slow = 2;
        int fast = 2;

        while (fast < n) {
            System.out.println(String.format("nums[slow-2]= %s  nums[fast]=%s", nums[slow - 2], nums[fast]));
            if (nums[slow - 2] != nums[fast]) {
                System.out.println(String.format("当前 slow=%s fast=%s ", slow, fast));
                nums[slow] = nums[fast];
                ++slow;
            }
            ++fast;
        }

        return slow;

    }


    public static void main(String[] args) {
        Q80删除有序数组中的重复项II q80 = new Q80删除有序数组中的重复项II();
        int removeDuplicates = q80.removeDuplicates(new int[]{1, 1, 1, 2, 2, 3});
        System.out.println(removeDuplicates);
    }
}
