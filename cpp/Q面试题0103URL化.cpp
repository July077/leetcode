//
// Created by sunjianrong on 2021-12-20.
//
/**
 *  面试题 01.03. URL化
URL化。编写一种方法，将字符串中的空格全部替换为%20。假定该字符串尾部有足够的空间存放新增字符，并且知道字符串的“真实”长度。（注：用Java实现的话，请使用字符数组实现，以便直接在数组上操作。）



示例 1：

输入："Mr John Smith    ", 13
输出："Mr%20John%20Smith"
示例 2：

输入："               ", 5
输出："%20%20%20%20%20"
 */
#include <string>

using namespace std;

class Q面试题0103URL化 {
public:
    string replaceSpaces(string S, int length) {
        int fillIndex = S.size() - 1;
        int i = 0;

        for (i = length - 1; i >= 0; i--) {
            if (S[i] == ' ') {
                S[fillIndex] = '0';
                S[fillIndex - 1] = '2';
                S[fillIndex - 2] = '%';
                fillIndex -= 3;
            } else {
                S[fillIndex] = S[i];
                fillIndex--;
            }
        }

        S = S.substr(fillIndex + 1);
        return S;
    }

};