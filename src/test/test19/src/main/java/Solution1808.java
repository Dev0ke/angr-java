public class Solution1808 {
    private static final int MOD = (int) (1e9 + 7);

    public int maxNiceDivisors(int n) {
        if (n <= 3) {
            return n;
        }
        // n = 3 * quotient + remainder
        int quotient = n / 3;
        int remainder = n % 3;
        long ans;
        if (remainder == 0) ans = quickPow(3, quotient);
        else if (remainder == 1) ans = quickPow(3, quotient - 1) * 4;
        else ans = quickPow(3, quotient) * 2;
        return (int) (ans % MOD);
    }

    private long quickPow(long a, long b) {
        long res = 1L;
        while (b > 0) {
            if ((b & 1) != 0) res = res * a % MOD;
            a = a * a % MOD;
            b >>= 1;
        }
        return res;
    }
}
/*
1808. 好因子的最大数目
https://leetcode.cn/problems/maximize-number-of-nice-divisors/description/

给你一个正整数 primeFactors 。你需要构造一个正整数 n ，它满足以下条件：
- n 质因数（质因数需要考虑重复的情况）的数目 不超过 primeFactors 个。
- n 好因子的数目最大化。如果 n 的一个因子可以被 n 的每一个质因数整除，我们称这个因子是 好因子 。比方说，如果 n = 12 ，那么它的质因数为 [2,2,3] ，那么 6 和 12 是好因子，但 3 和 4 不是。
请你返回 n 的好因子的数目。由于答案可能会很大，请返回答案对 10^9 + 7 取余 的结果。
请注意，一个质数的定义是大于 1 ，且不能被分解为两个小于该数的自然数相乘。一个数 n 的质因子是将 n 分解为若干个质因子，且它们的乘积为 n 。
提示：
1 <= primeFactors <= 10^9

翻译完之后就相当于原题：
1、设有质因数 `p1, p2, ..., pk`（不考虑重复，具体是啥值不重要）。设 `c1, c2, ..., ck` 是这些质因数对应的个数。
2、`b1 + b2 + ... + bk <= primeFactors`（条件 1）
好因子的数目：
设有 3 个 p1， 2 个 p2，那么好因子的数目相当于
1）在 3 个 p1 里取出 3 种情况(1 个 p1，2 个 p2，3 个 p3)，
2）在 2 个 p2 里取出 2 种情况(1 个 p2，2 个 p2)，
相乘即可，好因子的数目 = `3 * 2 = 6`（即 `b1 * b2`）
要使好因子的数目最大化（条件 2），原问题就等价于 `b1 + b2 + ... + bk <= primeFactors` 时，求 `b1 * b2 * ... * bk` 最大值。
由于 primeFactors 最大 1e9，需要用到数学 + 快速幂。
时间复杂度 O(logN)。
相似题目: 343. 整数拆分
https://leetcode.cn/problems/integer-break/
 */