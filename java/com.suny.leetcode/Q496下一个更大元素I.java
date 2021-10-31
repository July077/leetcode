import java.util.*;

/**
 * 496. 下一个更大元素 I
 * 给你两个 没有重复元素 的数组nums1 和nums2，其中nums1是nums2的子集。
 * <p>
 * 请你找出 nums1中每个元素在nums2中的下一个比其大的值。
 * <p>
 * nums1中数字x的下一个更大元素是指x在nums2中对应位置的右边的第一个比x大的元素。如果不存在，对应位置输出 -1 。
 * <p>
 *
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums1 = [4,1,2], nums2 = [1,3,4,2].
 * 输出: [-1,3,-1]
 * 解释:
 * 对于 num1 中的数字 4 ，你无法在第二个数组中找到下一个更大的数字，因此输出 -1 。
 * 对于 num1 中的数字 1 ，第二个数组中数字1右边的下一个较大数字是 3 。
 * 对于 num1 中的数字 2 ，第二个数组中没有下一个更大的数字，因此输出 -1 。
 * 示例 2:
 * <p>
 * 输入: nums1 = [2,4], nums2 = [1,2,3,4].
 * 输出: [3,-1]
 * 解释:
 * 对于 num1 中的数字 2 ，第二个数组中的下一个较大数字是 3 。
 * 对于 num1 中的数字 4 ，第二个数组中没有下一个更大的数字，因此输出 -1 。
 * <p>
 *
 * @author sunjianrong
 * @date 2021-10-26 9:11
 */
public class Q496下一个更大元素I {


    public int[] nextGreaterElement1(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums2) {
            while (!stack.isEmpty() && stack.peek() < num) {
                final Integer peek = stack.peek();
                map.put(stack.pop(), num);
                System.out.println("map中放入" + peek + ">>>" + num);
            }
            stack.push(num);
            System.out.println("压栈 " + num);
        }

        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            res[i] = map.getOrDefault(nums1[i], -1);
        }
        return res;
    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums1.length; i++) {
            final int c1 = nums1[i];
            for (int j = 0; j < nums2.length; j++) {
                if (nums2[j] == c1) {
                    for (int k = j; k < nums2.length; k++) {
                        if (nums2[k] > c1) {
                            res.add(nums2[k]);
                            break;
                        }
                    }
                }
            }

            if (res.size() != i + 1) {
                res.add(-1);
            }

        }

        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{4, 1, 2};
        int[] nums2 = new int[]{1, 3, 4, 2};
        System.out.println(Arrays.toString(new Q496下一个更大元素I().nextGreaterElement1(nums1, nums2)));
    }

}
