public class Solution1680 {
    private static final int MOD = (int) (1e9 + 7);

    public int concatenatedBinary(int n) {
        long ans = 0;
        for (int i = 1; i <= n; i++) {
            ans = (ans << bitsLen(i) | i) % MOD;
        }
        return (int) ans;
    }

    // bits.Len:
    // Len returns the minimum number of bits required to represent x; the result is 0 for x == 0.
    private int bitsLen(long x) {
        if (x == 0) return 0;
        return Long.toBinaryString(x).length();
    }
}
/*
1680. 连接连续二进制数字
https://leetcode.cn/problems/concatenation-of-consecutive-binary-numbers/description/

给你一个整数 n ，请你将 1 到 n 的二进制表示连接起来，并返回连接结果对应的 十进制 数字对 10^9 + 7 取余的结果。
提示：
1 <= n <= 10^5

用位运算模拟这个过程：每拼接一个数 i，就把之前拼接过的数左移 i 的二进制长度，然后加上 i。
由于左移后空出的位置全为 0，加法运算也可以写成或运算。
时间复杂度 O(nlogU)。
 */