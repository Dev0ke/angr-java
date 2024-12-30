public class Solution2311 {
    public int longestSubsequence(String s, int k) {
        int n = s.length();
        int val = 0; // 二进制的值
        int ans = 0; // 子序列长度
        for (int i = n - 1; i >= 0; i--) {
            int bit = s.charAt(i) - '0';
            if (bit == 0) {
                ans++;
            } else {
                // 2^30 = 1,073,741,824
                if (ans < 31 && val + (1 << ans) <= k) {
                    val += (1 << ans);
                    ans++;
                }
            }
        }
        return ans;
    }
}
/*
2311. 小于等于 K 的最长二进制子序列
https://leetcode.cn/problems/longest-binary-subsequence-less-than-or-equal-to-k/

第 298 场周赛 T3。

给你一个二进制字符串 s 和一个正整数 k 。
请你返回 s 的 最长 子序列，且该子序列对应的 二进制 数字小于等于 k 。
注意：
- 子序列可以有 前导 0 。
- 空字符串视为 0 。
- 子序列 是指从一个字符串中删除零个或者多个字符后，不改变顺序得到的剩余字符序列。
提示：
1 <= s.length <= 1000
s[i] 要么是 '0' ，要么是 '1' 。
1 <= k <= 10^9

贪心。有 0 选 0，然后从低位开始，尽可能选更多的 1。注意判断 1 个数（避免溢出）。
 */