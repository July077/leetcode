package offer2;

import common.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 剑指 Offer II 048. 序列化与反序列化二叉树
 * <p>
 * 序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
 * <p>
 * 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
 * <p>
 * <p>
 * <p>
 * 输入：root = [1,2,3,null,null,4,5]
 * 输出：[1,2,3,null,null,4,5]
 *
 * @author sunjianrong
 * @date 2021/8/23 下午9:29
 */
public class Q048序列化与反序列化二叉树 {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return reSerialize(root, "");
    }

    private String reSerialize(TreeNode node, String s) {
        if (node == null) {
            s += "#,";
        } else {
            s += String.valueOf(node.val) + ",";
            s = reSerialize(node.left, s);
            s = reSerialize(node.right, s);
        }
        return s;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] split = data.split(",");
        List<String> list = new LinkedList<>(Arrays.asList(split));
        return reDeserialize(list);
    }

    private TreeNode reDeserialize(List<String> dataList) {
        if (dataList.get(0).equals("#")) {
            dataList.remove(0);
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(dataList.get(0)));
        dataList.remove(0);
        root.left = reDeserialize(dataList);
        root.right = reDeserialize(dataList);

        return root;
    }
}
