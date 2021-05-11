import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author sunjianrong
 * @date 2021/5/11 下午9:28
 */
public class Q18四数之和 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 4) {
            return result;
        }

        Arrays.sort(nums);

        int length = nums.length;
        for (int k = 0; k < length - 3; k++) {
            // 如果k值与前面的值相等时则直接忽略
            if (k > 0 && nums[k] == nums[k - 1]) {
                continue;
            }

            // 获取当前最小值，如果最小值逗比目标大，说明后面的更大的值不符合条件
            int min1 =nums[k] + nums[k + 1] + nums[k + 2] + nums[k + 3];
            if (min1 > target) {
                break;
            }

            // 获取当前最大值,如果最大值比目标小,则说明后面越来越小的值更不符合条件
            int max1 = nums[k] + nums[length - 1] + nums[length - 2] + nums[length - 3];
            if (max1 < target) {
                continue;
            }


            // 第二层循环
            for (int i = k + 1; i < length - 2; i++) {
                // 当i的值与前面的值相等时则直接忽略
                if (i > k + 1 && nums[i] == nums[i - 1]) {
                    continue;
                }

                // 定义指针j指向 i+1
                int j = i + 1;
                // 定义指针h指向数组末尾
                int h = length - 1;
                // 获取当前最小值,如果最小值比目标小，则说明后面越来越小的不符合条件
                int min = nums[k] + nums[i] + nums[j] + nums[j + 1];
                if (min > target) {
                    break;
                }

                // 获取当前最大值,如果最大值比目标值小,则后面不符合条件
                int max = nums[k] + nums[i] + nums[h] + nums[h - 1];
                if (max < target) {
                    continue;
                }


                while (j < h) {
                    int curr = nums[k] + nums[i] + nums[j] + nums[h];
                    if (curr == target) {
                        result.add(Arrays.asList(nums[k], nums[i], nums[j], nums[h]));
                        j++;
                        while (j < h && nums[j] == nums[j - 1]) {
                            j++;
                        }
                        h--;
                        while (j < h && nums[h] == nums[h + 1]) {
                            h--;
                        }
                    } else if (curr > target) {
                        h--;
                    } else {
                        j++;
                    }
                }

            }

        }

        return result;
    }
}
