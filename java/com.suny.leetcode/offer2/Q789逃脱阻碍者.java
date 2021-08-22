package offer2;

/**
 * 789. 逃脱阻碍者
 * 你在进行一个简化版的吃豆人游戏。你从 [0, 0] 点开始出发，你的目的地是target = [xtarget, ytarget] 。地图上有一些阻碍者，以数组 ghosts 给出，第 i 个阻碍者从ghosts[i] = [xi, yi]出发。所有输入均为 整数坐标 。
 * <p>
 * 每一回合，你和阻碍者们可以同时向东，西，南，北四个方向移动，每次可以移动到距离原位置 1 个单位 的新位置。当然，也可以选择 不动 。所有动作 同时 发生。
 * <p>
 * 如果你可以在任何阻碍者抓住你 之前 到达目的地（阻碍者可以采取任意行动方式），则被视为逃脱成功。如果你和阻碍者同时到达了一个位置（包括目的地）都不算是逃脱成功。
 * <p>
 * 只有在你有可能成功逃脱时，输出 true ；否则，输出 false 。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：ghosts = [[1,0],[0,3]], target = [0,1]
 * 输出：true
 * 解释：你可以直接一步到达目的地 (0,1) ，在 (1, 0) 或者 (0, 3) 位置的阻碍者都不可能抓住你。
 * <p>
 *
 * @author sunjianrong
 * @date 2021/8/22 下午7:56
 */
public class Q789逃脱阻碍者 {

    public boolean escapeGhosts(int[][] ghosts, int[] target) {
        // 计算水先达到中点
        int[] source = new int[]{0, 0};
        int playerDistance = distance(source, target);

        for (int[] ghost : ghosts) {
            if (distance(ghost, target) <= playerDistance) {
                return false;
            }
        }

        return true;
    }

    private int distance(int[] p1, int[] p2) {
        return Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);
    }
}
