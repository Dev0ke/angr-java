public class SolutionP1933 {
    public boolean isDecomposable(String s) {
        // 等值子字符串长度为2 的个数
        int has2 = 0;
        int pre = ' ';
        int cnt = 0;
        for (char ch : s.toCharArray()) {
            if (ch == pre) {
                cnt++;
            } else {
                if (cnt % 3 == 1) {
                    return false;
                } else if (cnt % 3 == 2) {
                    has2++;
                }
                cnt = 1;
            }
            pre = ch;
        }
        if (cnt % 3 == 1) {
            return false;
        } else if (cnt % 3 == 2) {
            has2++;
        }
        return has2 == 1;
    }
}
/*
$1933. 判断字符串是否可分解为值均等的子串
https://leetcode.cn/problems/check-if-string-is-decomposable-into-value-equal-substrings/

一个字符串的所有字符都是一样的，被称作等值字符串。
- 举例，"1111" 和 "33" 就是等值字符串。
- 相比之下，"123"就不是等值字符串。
规则：给出一个数字字符串s，将字符串分解成一些等值字符串，如果有且仅有一个等值子字符串长度为2，其他的等值子字符串的长度都是3.
如果能够按照上面的规则分解字符串s，就返回真，否则返回假。
子串就是原字符串中连续的字符序列。
提示:
1 <= s.length <= 1000
s 仅包含数字。

取模
 */