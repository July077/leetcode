import java.util.HashMap;
import java.util.Map;

/**
 * 1791. 找出星型图的中心节点
 * 有一个无向的 星型 图，由 n 个编号从 1 到 n 的节点组成。星型图有一个 中心 节点，并且恰有 n - 1 条边将中心节点与其他每个节点连接起来。
 * 
 * 给你一个二维整数数组 edges ，其中 edges[i] = [ui, vi] 表示在节点 ui 和 vi 之间存在一条边。请你找出并返回 edges
 * 所表示星型图的中心节点。
 * 
 * 
 */
public class Q1791找出星型图的中心节点 {

    public int findCenter(int[][] edges) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int[] edge : edges) {
            map.put(edge[0], map.getOrDefault(edge[0], 0) + 1);
            map.put(edge[1], map.getOrDefault(edge[1], 0) + 1);
        }

        int n = map.size();
        for (int key : map.keySet()) {
            if (map.get(key) == n - 1) {
                return key;
            }
        }

        return -1;
    }

}