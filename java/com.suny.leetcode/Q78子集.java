import java.util.ArrayList;
import java.util.List;

/**
 * 78. 子集
 * <p>
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * <p>
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * 示例 2：
 * <p>
 * 输入：nums = [0]
 * 输出：[[],[0]]
 *
 * @author sunjianrong
 * @date 2021-06-24 12:10
 */
public class Q78子集 {

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    int length;


    public List<List<Integer>> subsets(int[] nums) {
        // 使用回溯的思路，进行遍历整个数组
        length = nums.length;
        dfs(nums, 0);
        return res;
    }

    private void dfs(int[] nums, int start) {
        res.add(new ArrayList<>(path));


        for (int i = start; i < length; i++) {
            path.add(nums[i]);
            dfs(nums, i + 1);
            path.remove(path.size() - 1);
        }
    }


    public static void main(String[] args) {
        final Q78子集 q78 = new Q78子集();
        final List<List<Integer>> list = q78.subsets(new int[]{1, 2, 3});
        for (List<Integer> l : list) {
            System.out.println(l.toString());
        }
    }

}
