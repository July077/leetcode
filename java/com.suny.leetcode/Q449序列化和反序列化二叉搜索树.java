import common.TreeNode;

import java.util.LinkedList;

/**
 * 449. 序列化和反序列化二叉搜索树
 * 序列化是将数据结构或对象转换为一系列位的过程，以便它可以存储在文件或内存缓冲区中，或通过网络连接链路传输，以便稍后在同一个或另一个计算机环境中重建。
 * <p>
 * 设计一个算法来序列化和反序列化 二叉搜索树 。 对序列化/反序列化算法的工作方式没有限制。 您只需确保二叉搜索树可以序列化为字符串，并且可以将该字符串反序列化为最初的二叉搜索树。
 * <p>
 * 编码的字符串应尽可能紧凑。
 * <p>
 *
 * <p>
 * 示例 1：
 * <p>
 * 输入：root = [2,1,3]
 * 输出：[2,1,3]
 * 示例 2：
 * <p>
 * 输入：root = []
 * 输出：[]
 * <p>
 *
 * @author sunjianrong
 * @date 2021-11-10 12:04
 */
public class Q449序列化和反序列化二叉搜索树 {

    private String sep = ",";
    private String nullCharacter = "#";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        dfs(sb, root);
        return sb.toString();
    }

    private void dfs(StringBuilder sb, TreeNode treeNode) {
        if (treeNode == null) {
            sb.append(nullCharacter).append(sep);
            return;
        }

        sb.append(treeNode.val).append(sep);
        dfs(sb, treeNode.left);
        dfs(sb, treeNode.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        LinkedList<String> list = new LinkedList<>();
        final String[] split = data.split(sep);

        for (String s : split) {
            list.add(s);
        }
        return deserialize(list);
    }

    private TreeNode deserialize(LinkedList<String> nodes) {
        if (nodes.isEmpty()) {
            return null;
        }

        final String first = nodes.removeFirst();
        if (first.equals(nullCharacter)) {
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(first));

        root.left = deserialize(nodes);
        root.right = deserialize(nodes);
        return root;
    }


}
