import java.util.Arrays;
import java.util.HashSet;

/**
 * 488. 祖玛游戏
 * 你正在参与祖玛游戏的一个变种。
 * <p>
 * 在这个祖玛游戏变体中，桌面上有 一排 彩球，每个球的颜色可能是：红色 'R'、黄色 'Y'、蓝色 'B'、绿色 'G' 或白色 'W' 。你的手中也有一些彩球。
 * <p>
 * 你的目标是 清空 桌面上所有的球。每一回合：
 * <p>
 * 从你手上的彩球中选出 任意一颗 ，然后将其插入桌面上那一排球中：两球之间或这一排球的任一端。
 * 接着，如果有出现 三个或者三个以上 且 颜色相同 的球相连的话，就把它们移除掉。
 * 如果这种移除操作同样导致出现三个或者三个以上且颜色相同的球相连，则可以继续移除这些球，直到不再满足移除条件。
 * 如果桌面上所有球都被移除，则认为你赢得本场游戏。
 * 重复这个过程，直到你赢了游戏或者手中没有更多的球。
 * 给你一个字符串 board ，表示桌面上最开始的那排球。另给你一个字符串 hand ，表示手里的彩球。请你按上述操作步骤移除掉桌上所有球，计算并返回所需的 最少 球数。如果不能移除桌上所有的球，返回 -1 。
 * <p>
 *
 * <p>
 * 示例 1：
 * <p>
 * 输入：board = "WRRBBW", hand = "RB"
 * 输出：-1
 * 解释：无法移除桌面上的所有球。可以得到的最好局面是：
 * - 插入一个 'R' ，使桌面变为 WRRRBBW 。WRRRBBW -> WBBW
 * - 插入一个 'B' ，使桌面变为 WBBBW 。WBBBW -> WW
 * 桌面上还剩着球，没有其他球可以插入。
 * 示例 2：
 * <p>
 * 输入：board = "WWRRBBWW", hand = "WRBRW"
 * 输出：2
 * 解释：要想清空桌面上的球，可以按下述步骤：
 * - 插入一个 'R' ，使桌面变为 WWRRRBBWW 。WWRRRBBWW -> WWBBWW
 * - 插入一个 'B' ，使桌面变为 WWBBBWW 。WWBBBWW -> WWWW -> empty
 * 只需从手中出 2 个球就可以清空桌面。
 * 示例 3：
 * <p>
 * 输入：board = "G", hand = "GGGGG"
 * 输出：2
 * 解释：要想清空桌面上的球，可以按下述步骤：
 * - 插入一个 'G' ，使桌面变为 GG 。
 * - 插入一个 'G' ，使桌面变为 GGG 。GGG -> empty
 * 只需从手中出 2 个球就可以清空桌面。
 * <p>
 *
 * @author sunjianrong
 * @date 2021-11-09 9:28
 */
public class Q488祖玛游戏 {
    private int ans = Integer.MAX_VALUE;
    private HashSet<String> cache;
    private int count;


    public int findMinStep(String board, String hand) {
        count = hand.length();
        int[] hands = new int[5];
        cache = new HashSet<>();
        // 统计每个球的个数
        for (int i = 0; i < hand.length(); i++) {
            hands[getId(hand.charAt(i))]++;
        }
        dfs(board,hands,0);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    private void dfs(String board, int[] hands, int step) {
        board = eliminate(board);
        if (board.length() == 0) {
            ans = Math.min(ans, step);
            return;
        }

        if (step == count) {
            return;
        }

        if (step >= ans) {
            return;
        }

        String node = board + Arrays.toString(hands);
        if (cache.contains(node)) {
            return;
        }

        for (int i = 0; i < hands.length; i++) {
            if (hands[i] == 0) {
                continue;
            }
            hands[i]--;
            for (int j = 0; j < board.length(); j++) {
                // 枚举当前球应该放的位置
                dfs(board.substring(0, j) + getChar(i) + board.substring(j), hands, step + 1);
            }
            hands[i]++;
        }
        cache.add(node);
    }

    private String eliminate(String board) {
        int s = 0;
        final int length = board.length();
        for (int i = 1; i <= length; i++) {
            if (i == length || board.charAt(i) != board.charAt(i - 1)) {
                if (i - s >= 3) {
                    return eliminate(board.substring(0, s) + board.substring(i));
                } else {
                    // 更新s下标
                    s = i;
                }
            }
        }
        return board;
    }

    private int getId(char c) {
        switch (c) {
            case 'W':
                return 0;
            case 'B':
                return 1;
            case 'Y':
                return 2;
            case 'G':
                return 3;
            default:
                return 4;
        }
    }

    private char getChar(int id) {
        switch (id) {
            case 0:
                return 'W';
            case 1:
                return 'B';
            case 2:
                return 'Y';
            case 3:
                return 'G';
            default:
                return 'R';
        }
    }
}
