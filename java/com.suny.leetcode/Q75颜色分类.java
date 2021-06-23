/**
 * 75. 颜色分类
 * 给定一个包含红色、白色和蓝色，一共n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * <p>
 * 此题中，我们使用整数 0、1 和 2 分别表示红色、白色和蓝色。
 *
 * @author sunjianrong
 * @date 2021-06-23 12:09
 */
public class Q75颜色分类 {

    public void sortColors(int[] nums) {
        // zero 代表0的右侧边界   one、two 分别代表 1跟2的边界
        int zero = 0;
        int one = 0;
        int two = 0;

        int length = nums.length;

        for (int i = 0; i < length; i++) {
            // 记录需要特别处理的值
            int temp = nums[i];

            // 先填充2
            nums[two] = 2;
            two++;

            // 当前数 <= 1 右侧 one 需要往右挪动
            if (temp <= 1) {
                nums[one] = 1;
                one++;
            }

            // 为0的话右侧边界 zero 需要往右挪动
            if (temp == 0) {
                nums[zero] = 0;
                zero++;
            }
        }


    }

}
