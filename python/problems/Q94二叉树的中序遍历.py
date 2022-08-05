# 94. 二叉树的中序遍历
# 给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。

# 示例 1：
# 输入：root = [1,null,2,3]
# 输出：[1,3,2]
from typing import List, Optional

from python.problems.common.TreeNode import TreeNode


class Solution:
    def inorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        res = []
        self.inOrders(res, root)
        return res

    def inOrders(self, res: List, treeNode: Optional[TreeNode]):
        if treeNode is None:
            return
        self.inOrders(res, treeNode.left)
        res.append(treeNode.val)
        self.inOrders(res, treeNode.right)
