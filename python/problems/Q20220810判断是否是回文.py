# 判断字符串是否是回文

class Solution:
    def longestPalindrome(self, s: str) -> bool:
        length = len(s)
        left = 0
        right = length - 1
        while left < right:
            if s[left] == s[right]:
                left = left + 1
                right = right - 1
            else:
                return False

        return True


if __name__ == '__main__':
    solution = Solution()
    print("abba 是否是回文 {}".format(solution.longestPalindrome("abba")))
    print("111abba111 是否是回文 {}".format(solution.longestPalindrome("111abba111")))
    print("adcba 是否是回文 {}".format(solution.longestPalindrome("adcba")))
