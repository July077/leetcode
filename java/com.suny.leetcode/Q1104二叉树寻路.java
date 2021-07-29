import java.util.ArrayList;
import java.util.List;

/**
 * 1104. 二叉树寻路
 * <p>
 * 在一棵无限的二叉树上，每个节点都有两个子节点，树中的节点 逐行 依次按“之” 字形进行标记。
 * <p>
 * 如下图所示，在奇数行（即，第一行、第三行、第五行……）中，按从左到右的顺序进行标记；
 * <p>
 * 而偶数行（即，第二行、第四行、第六行……）中，按从右到左的顺序进行标记。
 * <p>
 * <p>
 * <p>
 * 给你树上某一个节点的标号 label，请你返回从根节点到该标号为 label 节点的路径，该路径是由途经的节点标号所组成的。
 * <p>
 *
 * @author sunjianrong
 * @date 2021-07-29 9:22
 */
public class Q1104二叉树寻路 {
    public List<Integer> pathInZigZagTree(int target) {
        List<Integer> res = new ArrayList<>();
        int depth = (int) (Math.log(target) / Math.log(2)) + 1;

        // 每次向上一层就反转
        while (target > 1) {
            res.add(0, target);
            target = target / 2;
            depth--;

            // 上一层最右边和最左边的值
            int right = (int) (Math.pow(2, depth) - 1);
            int left = (int) (Math.pow(2, depth - 1));

            // 反转
            target = right - (target - left);
        }
        res.add(0, 1);
        return res;
    }
}
