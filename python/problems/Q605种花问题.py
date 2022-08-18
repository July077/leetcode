# 605.
# 种花问题
# 假设有一个很长的花坛，一部分地块种植了花，另一部分却没有。可是，花不能种植在相邻的地块上，它们会争夺水源，两者都会死去。
#
# 给你一个整数数组
# flowerbed
# 表示花坛，由若干
# 0
# 和
# 1
# 组成，其中
# 0
# 表示没种植花，1
# 表示种植了花。另有一个数
# n ，能否在不打破种植规则的情况下种入
# n
# 朵花？能则返回
# true ，不能则返回
# false。
#
#
#
# 示例
# 1：
#
# 输入：flowerbed = [1, 0, 0, 0, 1], n = 1
# 输出：true
# 示例
# 2：
#
# 输入：flowerbed = [1, 0, 0, 0, 1], n = 2
# 输出：false
from typing import List


class Solution:
    def canPlaceFlowers(self, flowerbed: List[int], n: int) -> bool:
        length = len(flowerbed)
        i = 0

        while i < length and n > 0:
            if flowerbed[i] == 1:
                i += 2
            elif flowerbed[i] == 0:
                if i+1 == length:
                    n = n-1
                    i=i+1
                elif flowerbed[i+1] == 0:
                    n = n-1
                    i = i+2
                else:
                    i=i+3
        return n == 0


if __name__ == '__main__':
    solution = Solution()
    can_place_flowers = solution.canPlaceFlowers([1, 0, 0, 0, 0, 1], 2)
    print(can_place_flowers)
