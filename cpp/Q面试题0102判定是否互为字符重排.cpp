/**
 *
 * 面试题 01.02. 判定是否互为字符重排
 * 给定两个字符串 s1 和 s2，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。
示例 1：

输入: s1 = "abc", s2 = "bca"
输出: true
示例 2：

输入: s1 = "abc", s2 = "bad"
输出: false

 */
//
// Created by sunjianrong on 2021-12-17.
//

#include <string>
#include <unordered_map>

class Q面试题0102判定是否互为字符重排 {
public:
    bool CheckPermutation(std::string s1, std::string s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        std::unordered_map<char, int> dict;
        for (char c: s1) {
            dict[c] += 1;
        }

        for (char c: s2) {
            dict[c] -= 1;
        }

        for (auto kv : dict) {
            if (kv.second != 0) {
                return false;
            }
        }
        return true;
    }
};

