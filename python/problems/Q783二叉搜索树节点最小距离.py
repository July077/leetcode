# 783.
# 二叉搜索树节点最小距离
# 给你一个二叉搜索树的根节点
# root ，返回
# 树中任意两不同节点值之间的最小差值 。
#
# 差值是一个正数，其数值等于两值之差的绝对值。
#
#
#
# 示例
# 1：
#
#
# 输入：root = [4, 2, 6, 1, 3]
# 输出：1
from typing import Optional, List

from common import TreeNode


class Solution:
    def minDiffInBST(self, root: Optional[TreeNode]) -> int:
        nodes = []
        res = float("inf")
        self.dfs(nodes, root)

        for i in range(len(nodes) - 1):
            res = min(abs(nodes[i] - nodes[i+1]),res)

        return res


    def dfs(self, nodes: List, treeNode: TreeNode) -> List:
        if treeNode is None:
            return
        if treeNode.left is not None:
            self.dfs(nodes, treeNode.left)
        nodes.append(treeNode.val)

        if treeNode.right is not None:
            self.dfs(nodes, treeNode.right)


if __name__ == '__main__':
    solution = Solution()
