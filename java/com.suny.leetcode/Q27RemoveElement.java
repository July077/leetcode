/**
 * @author sunjianrong
 * @date 2021/5/20 下午9:44
 */
public class Q27RemoveElement {

    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int slow = 0;
        int fast = 0;
        while (fast < nums.length) {
            if (val != nums[fast]) {
                nums[slow++] = nums[fast];
            }
            fast++;
        }

        return slow;

    }
}
