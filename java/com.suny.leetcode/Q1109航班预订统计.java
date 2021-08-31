/**
 * 1109. 航班预订统计
 * <p>
 * 这里有n个航班，它们分别从 1 到 n 进行编号。
 * <p>
 * 有一份航班预订表bookings ，表中第i条预订记录bookings[i] = [firsti, lasti, seatsi]意味着在从 firsti到 lasti （包含 firsti 和 lasti ）的 每个航班 上预订了 seatsi个座位。
 * <p>
 * 请你返回一个长度为 n 的数组answer，其中 answer[i] 是航班 i 上预订的座位总数。
 * <p>
 *
 * <p>
 * 示例 1：
 * <p>
 * 输入：bookings = [[1,2,10],[2,3,20],[2,5,25]], n = 5
 * 输出：[10,55,45,25,25]
 * 解释：
 * 航班编号        1   2   3   4   5
 * 预订记录 1 ：   10  10
 * 预订记录 2 ：       20  20
 * 预订记录 3 ：       25  25  25  25
 * 总座位数：      10  55  45  25  25
 * 因此，answer = [10,55,45,25,25]
 * <p>
 *
 * @author sunjianrong
 * @date 2021-08-31 9:11
 */
public class Q1109航班预订统计 {


    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] nums = new int[n];

        for (int[] booking : bookings) {
            nums[booking[0] - 1] += booking[2];
            if (booking[1] < n) {
                nums[booking[1]] -= booking[2];
            }
        }

        for (int i = 1; i < n; i++) {
            nums[i] += nums[i - 1];
        }

        return nums;


    }
}
