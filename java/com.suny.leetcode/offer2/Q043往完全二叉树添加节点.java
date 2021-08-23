package offer2;

import common.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 剑指 Offer II 043. 往完全二叉树添加节点
 * <p>
 * 完全二叉树是每一层（除最后一层外）都是完全填充（即，节点数达到最大，第 n 层有 2n-1个节点）的，并且所有的节点都尽可能地集中在左侧。
 * <p>
 * 设计一个用完全二叉树初始化的数据结构CBTInserter，它支持以下几种操作：
 * <p>
 * CBTInserter(TreeNode root)使用根节点为root的给定树初始化该数据结构；
 * CBTInserter.insert(int v) 向树中插入一个新节点，节点类型为 TreeNode，值为 v 。使树保持完全二叉树的状态，并返回插入的新节点的父节点的值；
 * CBTInserter.get_root() 将返回树的根节点。
 *
 * <p>
 * 示例 1：
 * <p>
 * 输入：inputs = ["CBTInserter","insert","get_root"], inputs = [[[1]],[2],[]]
 * 输出：[null,1,[1,2]]
 * <p>
 *
 * @author sunjianrong
 * @date 2021/8/21 下午11:00
 */
public class Q043往完全二叉树添加节点 {

    List<TreeNode> list = new ArrayList<>();

    public Q043往完全二叉树添加节点(TreeNode root) {
        if (root == null) {
            return;
        }

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            list.add(poll);
            if (poll.left != null) {
                queue.offer(poll.left);
            }
            if (poll.right != null) {
                queue.offer(poll.right);
            }
        }

    }

    public int insert(int v) {
        TreeNode treeNode = new TreeNode(v);
        list.add(treeNode);

        int parent = list.size() / 2 - 1;
        if (list.size() % 2 == 0) {
            list.get(parent).left = treeNode;
        } else {
            list.get(parent).right = treeNode;
        }
        return list.get(parent).val;

    }

    public TreeNode get_root() {
        return list.isEmpty() ? null : list.get(0);
    }
}
