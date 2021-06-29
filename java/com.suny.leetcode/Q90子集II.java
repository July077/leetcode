import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 90. 子集 II
 * 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
 * <p>
 * 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
 * <p>
 *
 * @author sunjianrong
 * @date 2021-06-29 12:07
 */
public class Q90子集II {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        getAnswer(nums, 0, new ArrayList<>(), res);
        // 回溯查找
        return res;
    }

    private void getAnswer(int[] nums, int start, ArrayList<Integer> temp, List<List<Integer>> ans) {
        ans.add(new ArrayList<>(temp));

        for (int i = start; i < nums.length; i++) {
            // 跟上个数字相等就跳过
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }

            temp.add(nums[i]);
            getAnswer(nums, i + 1, temp, ans);
            temp.remove(temp.size() - 1);

        }
    }

}
