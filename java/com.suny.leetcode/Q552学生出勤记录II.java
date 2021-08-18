/**
 * 552. 学生出勤记录 II
 * 可以用字符串表示一个学生的出勤记录，其中的每个字符用来标记当天的出勤情况（缺勤、迟到、到场）。记录中只含下面三种字符：
 * 'A'：Absent，缺勤
 * 'L'：Late，迟到
 * 'P'：Present，到场
 * 如果学生能够 同时 满足下面两个条件，则可以获得出勤奖励：
 * <p>
 * 按 总出勤 计，学生缺勤（'A'）严格 少于两天。
 * 学生 不会 存在 连续 3 天或 连续 3 天以上的迟到（'L'）记录。
 * 给你一个整数 n ，表示出勤记录的长度（次数）。请你返回记录长度为 n 时，可能获得出勤奖励的记录情况 数量 。答案可能很大，所以返回对 109 + 7 取余 的结果。
 * <p>
 *
 * <p>
 *
 * @author sunjianrong
 * @date 2021-08-18 9:24
 */
public class Q552学生出勤记录II {
    private int MOD = 1000000007;


    public int checkRecord1(int n) {
        long[][][] dp = new long[n][2][3];
        // 初始值
        dp[0][0][0] = 1;
        dp[0][1][0] = 1;
        dp[0][0][1] = 1;

        for (int i = 1; i < n; i++) {
            // 本次填入 p , 分成前一天累计了0个A跟1个A的情况
            dp[i][0][0] = (dp[i - 1][0][0] + dp[i - 1][0][1] + dp[i - 1][0][2]) % MOD;
            dp[i][1][0] = (dp[i - 1][1][0] + dp[i - 1][1][1] + dp[i - 1][1][2]) % MOD;

            // 本次填入A,前一天没有累计A都可以转移过来
            dp[i][1][0] = (dp[i][1][0] + dp[i - 1][0][0] + dp[i - 1][0][1] + dp[i - 1][0][2]) % MOD;
            // 本次填入 L

            dp[i][0][1] = dp[i - 1][0][0];
            dp[i][0][2] = dp[i - 1][0][1];
            dp[i][1][1] = dp[i - 1][1][0];
            dp[i][1][2] = dp[i - 1][1][1];
        }

        //计算结果
        long ans = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                ans = (ans + dp[n - 1][i][j]) % MOD;
            }
        }

        return (int) ans;

    }

    public int checkRecord(int n) {
        int[][][] memo = new int[n][2][3];
        return dfs(0, n, 0, 0, memo);
    }


    private int dfs(int day, int n, int absent, int late, int[][][] memo) {
        if (day >= n) {
            return 1;
        }

        // 计算过了直接返回
        if (memo[day][absent][late] != 0) {
            return memo[day][absent][late];
        }

        // 回溯开始
        int ans = 0;
        // present 随便放
        ans = (ans + dfs(day + 1, n, absent, 0, memo)) % MOD;
        // absent 最多放一个
        if (absent < 1) {
            ans = (ans + dfs(day + 1, n, 1, 0, memo)) % MOD;
        }

        // late 最多放2个
        if (late < 2) {
            ans = (ans + dfs(day + 1, n, absent, late + 1, memo)) % MOD;
        }

        return ans;
    }


}
