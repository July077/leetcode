/**
 * 26. 删除有序数组中的重复项
 *
 * @author sunjianrong
 * @date 2021/5/19 下午9:44
 */
public class Q26RemoveDuplicatesFromSortedArray {

    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // 快慢指针
        int slow = 0;
        int fast = 1;
        while (fast < nums.length) {
            if (nums[slow] != nums[fast]) {
                nums[++slow] = nums[fast];
            }
            fast++;
        }

        return slow + 1;
    }


    public static void main(String[] args) {
        int[] ints = {1, 1, 2};
        Q26RemoveDuplicatesFromSortedArray sortedArray = new Q26RemoveDuplicatesFromSortedArray();
        int duplicates = sortedArray.removeDuplicates(ints);
        System.out.println(duplicates);
    }
}
