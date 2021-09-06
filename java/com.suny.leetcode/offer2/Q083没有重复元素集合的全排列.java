package offer2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 剑指 Offer II 083. 没有重复元素集合的全排列
 * <p>
 * 给定一个不含重复数字的整数数组 nums ，返回其 所有可能的全排列 。可以 按任意顺序 返回答案。
 * <p>
 * 
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * <p>
 *
 * @author sunjianrong
 * @date 2021/9/4 下午10:00
 */
public class Q083没有重复元素集合的全排列 {

    private List<List<Integer>> res = new ArrayList<>();
    private LinkedList<Integer> path = new LinkedList<>();
    private boolean[] used;


    public List<List<Integer>> permute(int[] nums) {

        if (nums == null) {
            return res;
        }
        used = new boolean[nums.length];

        if (nums.length == 1) {
            res.add(Collections.singletonList(nums[0]));
            return res;
        }

        dfs(nums, 0);
        return res;
    }


    private void dfs(int[] nums, int depth) {
        if (depth == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }


            path.addLast(nums[i]);
            used[i] = true;

            dfs(nums, depth + 1);

            used[i] = false;
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] ints = {1, 2, 3};
        Q083没有重复元素集合的全排列 q083 = new Q083没有重复元素集合的全排列();
        System.out.println(q083.permute(ints));
    }
}
