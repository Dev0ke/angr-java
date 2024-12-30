public class SolutionP3125 {
    public long maxNumber(long n) {
        long highestOneBit = 1;
        while (highestOneBit << 1 <= n) {
            highestOneBit <<= 1;
        }
        return highestOneBit - 1;
    }
}
/*
$3125. 使得按位与结果为 0 的最大数字
https://leetcode.cn/problems/maximum-number-that-makes-result-of-bitwise-and-zero/description/

给定一个整数 n，返回 最大的 整数 x 使得 x <= n，并且所有在范围 [x, n] 内的数字的按位 AND 为 0。
提示：
1 <= n <= 10^15

可以找到不超过 n 的最大的 2 的整数次幂 highestBit，则答案是 highestBit−1。
时间复杂度 O(logn)。
 */