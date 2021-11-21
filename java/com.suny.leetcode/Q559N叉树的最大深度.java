import common.Node;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 559. N 叉树的最大深度
 * 给定一个 N 叉树，找到其最大深度。
 * <p>
 * 最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。
 * <p>
 * N 叉树输入按层序遍历序列化表示，每组子节点由空值分隔（请参见示例）。
 * <p>
 *
 * @author sunjianrong
 * @date 2021/11/21 下午9:22
 */
public class Q559N叉树的最大深度 {

    int res = 0;

    public int maxDepth(Node root) {
        if (root == null) {
            return res;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                if (node == null) {
                    continue;
                }
                for (Node child : node.children) {
                    queue.add(child);
                }

            }
            res++;
        }
        return res;

    }
}
