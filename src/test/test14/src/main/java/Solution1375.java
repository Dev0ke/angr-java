public class Solution1375 {
    public int numTimesAllBlue(int[] flips) {
        int n = flips.length;
        int max = 0, ans = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, flips[i]);
            if (max == i + 1) {
                ans++;
            }
        }
        return ans;
    }
}
/*
1375. 二进制字符串前缀一致的次数
https://leetcode.cn/problems/number-of-times-binary-string-is-prefix-aligned/

给你一个长度为 n 、下标从 1 开始的二进制字符串，所有位最开始都是 0 。我们会按步翻转该二进制字符串的所有位（即，将 0 变为 1）。
给你一个下标从 1 开始的整数数组 flips ，其中 flips[i] 表示对应下标 i 的位将会在第 i 步翻转。
二进制字符串 前缀一致 需满足：在第 i 步之后，在 闭 区间 [1, i] 内的所有位都是 1 ，而其他位都是 0 。
返回二进制字符串在翻转过程中 前缀一致 的次数。
提示：
n == flips.length
1 <= n <= 5 * 10^4
flips 是范围 [1, n] 中所有整数构成的一个排列

如果前 i 个数的最大值等于 i，则说明找到了 [1,i] 内的所有整数。
时间复杂度 O(n)
 */