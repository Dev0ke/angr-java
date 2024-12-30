public class Solution1844 {
    public String replaceDigits(String S) {
        int n = S.length();
        char[] s = S.toCharArray();
        for (int i = 1; i < n; i += 2) {
            s[i] = (char) (s[i - 1] + (s[i] - '0'));
        }
        return new String(s);
    }
}
/*
1844. 将所有数字用字符替换
https://leetcode.cn/problems/replace-all-digits-with-characters/description/

给你一个下标从 0 开始的字符串 s ，它的 偶数 下标处为小写英文字母，奇数 下标处为数字。
定义一个函数 shift(c, x) ，其中 c 是一个字符且 x 是一个数字，函数返回字母表中 c 后面第 x 个字符。
- 比方说，shift('a', 5) = 'f' 和 shift('x', 0) = 'x' 。
对于每个 奇数 下标 i ，你需要将数字 s[i] 用 shift(s[i-1], s[i]) 替换。
请你替换所有数字以后，将字符串 s 返回。题目 保证 shift(s[i-1], s[i]) 不会超过 'z' 。
提示：
1 <= s.length <= 100
s 只包含小写英文字母和数字。
对所有 奇数 下标处的 i ，满足 shift(s[i-1], s[i]) <= 'z' 。

模拟。
时间复杂度 O(n)。
 */