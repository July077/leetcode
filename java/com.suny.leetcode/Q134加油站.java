/**
 * 134. 加油站
 * 在一条环路上有N个加油站，其中第i个加油站有汽油gas[i]升。
 * <p>
 * 你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1个加油站需要消耗汽油cost[i]升。你从其中的一个加油站出发，开始时油箱为空。
 * <p>
 * 如果你可以绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1。
 * <p>
 * 说明:
 * <p>
 * 如果题目有解，该答案即为唯一答案。
 * 输入数组均为非空数组，且长度相同。
 * 输入数组中的元素均为非负数。
 *
 * @author sunjianrong
 * @date 2021-07-13 9:17
 */
public class Q134加油站 {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;

        // 从每一个点出发
        for (int i = 0; i < n; i++) {
            int j = i;
            int remain = gas[i];

            // 剩余的油是否可以到达下一个点
            while (remain - cost[j] >= 0) {
                // 减去花费的再加上补充的
                remain = remain - cost[j] + gas[(j + 1) % n];
                j = (j + 1) % n;

                // j回到了i
                if (j == i) {
                    return i;
                }
            }
        }

        return -1;

    }
}
