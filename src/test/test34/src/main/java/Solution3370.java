public class Solution3370 {
    public int smallestNumber(int n) {
        return (1 << bitsLen(n)) - 1;
    }

    // bits.Len:
    // Len returns the minimum number of bits required to represent x; the result is 0 for x == 0.
    private int bitsLen(long x) {
        if (x == 0) return 0;
//        return Long.toBinaryString(x).length();
        return Long.numberOfTrailingZeros(Long.highestOneBit(x)) + 1;
    }
}
/*
3370. 仅含置位位的最小整数
https://leetcode.cn/problems/smallest-number-with-all-set-bits/description/

第 426 场周赛 T1。

给你一个正整数 n。
返回 大于等于 n 且二进制表示仅包含 置位 位的 最小 整数 x 。
置位 位指的是二进制表示中值为 1 的位。
提示：
1 <= n <= 1000

设 n 的二进制长度为 k，答案为 2^k - 1。
 */