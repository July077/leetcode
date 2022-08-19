# 面试题 08.12. 八皇后
# 设计一种算法，打印 N 皇后在 N × N 棋盘上的各种摆法，其中每个皇后都不同行、不同列，也不在对角线上。这里的“对角线”指的是所有的对角线，不只是平分整个棋盘的那两条对角线。
#
# 注意：本题相对原题做了扩展
#
# 示例:
#
#  输入：4
#  输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
#  解释: 4 皇后问题存在如下两个不同的解法。
# [
#  [".Q..",  // 解法 1
#   "...Q",
#   "Q...",
#   "..Q."],
#
#  ["..Q.",  // 解法 2
#   "Q...",
#   "...Q",
#   ".Q.."]
# ]
from typing import List


class Solution:

    def solveNQueens(self, n: int) -> List[List[str]]:
        if not n:
            return []

        board = [['.'] * n for _ in range(n)]
        res = []

        def isValid(board, row, col):
            # 列冲突
            for i in range(len(board)):
                if board[i][col] == 'Q':
                    return False

            # 左上角冲突
            i = row - 1
            j = col - 1
            while i >= 0 and j >= 0:
                if board[i][j] == 'Q':
                    return False
                i = i - 1
                j = j - 1
            # 右上角是否冲突

            i = row - 1
            j = col + 1
            while i >= 0 and j < len(board):
                if board[i][j] == 'Q':
                    return False

                i = i - 1
                j = j + 1
            return True

        def backtracking(board, row, n):
            if row == n:
                tmp_res = []
                for tmp in board:
                    tmp_str = "".join(tmp)
                    tmp_res.append(tmp_str)
                res.append(tmp_res)

            for col in range(n):
                if not isValid(board, row, col):
                    continue
                board[row][col] = 'Q'
                backtracking(board, row + 1, n)
                board[row][col] = '.'

        backtracking(board, 0, n)
        return res
