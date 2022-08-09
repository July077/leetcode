# 11.
# 盛最多水的容器
# 给定一个长度为n的整数数组height 。有n条垂线，第i条线的两个端点是(i, 0)和(i, height[i]) 。
# 找出其中的两条线，使得它们与x轴共同构成的容器可以容纳最多的水。
# 返回容器可以储存的最大水量。
# 说明：你不能倾斜容器。
from typing import List


class Solution:
    def maxArea(self, height: List[int]) -> int:
        res = 0
        left = 0
        right = len(height) - 1
        while left < right:
            res = max(res, (right - left) * min(height[left], height[right]))
            if height[left] > height[right]:
                right = right - 1
            else:
                left = left + 1
        return res


if __name__ == '__main__':
    solution = Solution()
    max_area = solution.maxArea([1, 8, 6, 2, 5, 4, 8, 3, 7])
    print(max_area)
