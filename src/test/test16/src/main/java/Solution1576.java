public class Solution1576 {
    public String modifyString(String s) {
        char[] chars = s.toCharArray();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            if (chars[i] == '?') {
                char left = (i - 1 >= 0) ? chars[i - 1] : '.';
                char right = (i + 1 < len && chars[i + 1] != '?') ? chars[i + 1] : '.';
                for (char ch = 'a'; ; ch++) {
                    if (ch != left && ch != right) {
                        chars[i] = ch;
                        break;
                    }
                }
            }
        }
        return new String(chars);
    }
}
/*
1576. 替换所有的问号
https://leetcode.cn/problems/replace-all-s-to-avoid-consecutive-repeating-characters/

第 205 场周赛 T1。

给你一个仅包含小写英文字母和 '?' 字符的字符串 s，请你将所有的 '?' 转换为若干小写字母，使最终的字符串不包含任何 连续重复 的字符。
注意：你 不能 修改非 '?' 字符。
题目测试用例保证 除 '?' 字符 之外，不存在连续重复的字符。
在完成所有转换（可能无需转换）后返回最终的字符串。如果有多个解决方案，请返回其中任何一个。可以证明，在给定的约束条件下，答案总是存在的。
提示：
1 <= s.length <= 100
s 仅包含小写英文字母和 '?' 字符

贪心，线性遍历，观察左右相邻字母的可能性，从 'a' 开始尝试。最多只需枚举到 'c'
时间复杂度 O(n)
 */