package common;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sunjianrong
 * @date 2021/7/12 下午10:22
 */
public class GraphNode {
    public int val;
    public List<GraphNode> neighbors;

    public GraphNode() {
        val = 0;
        neighbors = new ArrayList<GraphNode>();
    }

    public GraphNode(int val) {
        this.val = val;
        neighbors = new ArrayList<GraphNode>();
    }

    public GraphNode(int val, ArrayList<GraphNode> neighbors) {
        this.val = val;
        this.neighbors = neighbors;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
