import common.GraphNode;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 133. 克隆图
 * <p>
 * 给你无向连通图中一个节点的引用，请你返回该图的深拷贝（克隆）。
 * <p>
 * 图中的每个节点都包含它的值 val（int） 和其邻居的列表（list[Node]）。
 * <p>
 * class Node {
 * public int val;
 * public List<Node> neighbors;
 * }
 *
 * <p>
 * 测试用例格式：
 * <p>
 * 简单起见，每个节点的值都和它的索引相同。例如，第一个节点值为 1（val = 1），第二个节点值为 2（val = 2），以此类推。该图在测试用例中使用邻接列表表示。
 * <p>
 * 邻接列表 是用于表示有限图的无序列表的集合。每个列表都描述了图中节点的邻居集。
 * <p>
 * 给定节点将始终是图中的第一个节点（值为 1）。你必须将给定节点的拷贝作为对克隆图的引用返回。
 *
 * @author sunjianrong
 * @date 2021/7/12 下午10:21
 */
public class Q133克隆图 {

    private HashMap<GraphNode, GraphNode> visited = new HashMap<>();

    public GraphNode cloneGraph(GraphNode node) {
        if (node == null) {
            return node;
        }

        // 如果已经访问过了就直接从哈希表中取出克隆节点返回
        if (visited.containsKey(node)) {
            return visited.get(node);
        }

        // 克隆节点,注意不克隆邻居列表
        GraphNode cloneNode = new GraphNode(node.val, new ArrayList<>());
        // 哈希表存储
        visited.put(node, cloneNode);

        // 遍历该节点的邻居并更新克隆节点的邻居列表
        for (GraphNode neighbor : node.neighbors) {
            cloneNode.neighbors.add(cloneGraph(neighbor));
        }

        return cloneNode;

    }
}
