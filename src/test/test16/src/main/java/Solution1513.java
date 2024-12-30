public class Solution1513 {
    private static final int MOD = (int) (1e9 + 7);

    public int numSub(String s) {
        int n = s.length();
        long ans = 0;
        int i = 0;
        while (i < n) {
            // 分组循环
            int st = i;
            for (i++; i < n && s.charAt(i) == s.charAt(st); i++) {
            }
            if (s.charAt(st) == '1') {
                long tot = i - st;
                ans += tot * (tot + 1) / 2;
            }
        }
        ans %= MOD;
        return (int) ans;
    }
}
/*
1513. 仅含 1 的子串数
https://leetcode.cn/problems/number-of-substrings-with-only-1s/description/

给你一个二进制字符串 s（仅由 '0' 和 '1' 组成的字符串）。
返回所有字符都为 1 的子字符串的数目。
由于答案可能很大，请你将它对 10^9 + 7 取模后返回。
提示：
s[i] == '0' 或 s[i] == '1'
1 <= s.length <= 10^5

分组循环 只统计 1 的段，等差数列求和公式。
时间复杂度 O(n)。
 */