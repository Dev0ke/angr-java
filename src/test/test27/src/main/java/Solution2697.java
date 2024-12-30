public class Solution2697 {
    public String makeSmallestPalindrome(String s) {
        int n = s.length();
        char[] cs = s.toCharArray();
        int l = 0, r = n - 1;
        while (l < r) {
            if (cs[l] != cs[r]) {
                char c = cs[l] < cs[r] ? cs[l] : cs[r];
                cs[l] = c;
                cs[r] = c;
            }
            l++;
            r--;
        }
        return new String(cs);
    }
}
/*
2697. 字典序最小回文串
https://leetcode.cn/problems/lexicographically-smallest-palindrome/

第 346 场周赛 T2。

给你一个由 小写英文字母 组成的字符串 s ，你可以对其执行一些操作。在一步操作中，你可以用其他小写英文字母 替换  s 中的一个字符。
请你执行 尽可能少的操作 ，使 s 变成一个 回文串 。如果执行 最少 操作次数的方案不止一种，则只需选取 字典序最小 的方案。
对于两个长度相同的字符串 a 和 b ，在 a 和 b 出现不同的第一个位置，如果该位置上 a 中对应字母比 b 中对应字母在字母表中出现顺序更早，则认为 a 的字典序比 b 的字典序要小。
返回最终的回文字符串。
提示：
1 <= s.length <= 1000
s 仅由小写英文字母组成

贪心。
时间复杂度 O(n)
 */