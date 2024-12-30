public class Solution479 {
    // {9,987,123,597,677,1218,877,475}
    public int largestPalindrome(int n) {
        // 特判 1
        if (n == 1) return 9;

        // 从大到小枚举
        int high = (int) Math.pow(10, n);
        for (int root = high - 1; ; root--) {
            long p = root;
            for (int x = root; x > 0; x /= 10) {
                p = p * 10 + x % 10;
            }
            for (long x = high - 1; x * x >= p; x--) {
                // x 是 p 的因子
                if (p % x == 0) {
                    return (int) (p % 1337);
                }
            }
        }
    }
}
/*
479. 最大回文数乘积
https://leetcode.cn/problems/largest-palindrome-product/description/

给定一个整数 n ，返回 可表示为两个 n 位整数乘积的 最大回文整数 。因为答案可能非常大，所以返回它对 1337 取余 。
提示:
1 <= n <= 8

枚举 回文根。
打表可以做到 O(1)。
 */