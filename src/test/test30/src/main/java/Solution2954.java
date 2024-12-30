public class Solution2954 {
    static Comb comb = new Comb((int) 1e5);

    public int numberOfSequence(int n, int[] sick) {
        int m = sick.length;
        int tot = n - m;
        long ans = comb.binom(tot, sick[0]) * comb.binom(tot - sick[0], n - sick[m - 1] - 1) % MOD;
        tot -= sick[0] + n - sick[m - 1] - 1;
        for (int i = 1; i < m; i++) {
            int k = sick[i] - sick[i - 1] - 1;
            if (k > 0) {
                ans = ans * comb.quickPow(2, k - 1) % MOD * comb.binom(tot, k) % MOD;
                tot -= k;
            }
        }
        return (int) ans;
    }

    private static final int MOD = (int) (1e9 + 7);

    private static class Comb {
        private final long[] fac, invfac;

        public Comb(int n) {
            fac = new long[n + 1];
            fac[0] = 1;
            for (int i = 1; i <= n; i++) {
                fac[i] = fac[i - 1] * i % MOD;
            }
            invfac = new long[n + 1];
            for (int i = 0; i <= n; i++) {
                invfac[i] = quickPow(fac[i], MOD - 2);
            }
        }

        // C(n, m) = n! / m!(n-m)!
        private long binom(int n, int m) {
            if (n < m || m < 0) return 0;
            return fac[n] * invfac[m] % MOD * invfac[n - m] % MOD;
        }

        // 模下的 a^b
        private long quickPow(long a, long b) {
            long res = 1L;
            while (b > 0) {
                if ((b & 1) == 1) {
                    res = res * a % MOD;
                }
                a = a * a % MOD;
                b >>= 1;
            }
            return res;
        }
    }
}
/*
2954. 统计感冒序列的数目
https://leetcode.cn/problems/count-the-number-of-infection-sequences/description/

第 374 场周赛 T4。

给你一个整数 n 和一个下标从 0 开始的整数数组 sick ，数组按 升序 排序。
有 n 位小朋友站成一排，按顺序编号为 0 到 n - 1 。数组 sick 包含一开始得了感冒的小朋友的位置。如果位置为 i 的小朋友得了感冒，
他会传染给下标为 i - 1 或者 i + 1 的小朋友，前提 是被传染的小朋友存在且还没有得感冒。每一秒中， 至多一位 还没感冒的小朋友会被传染。
经过有限的秒数后，队列中所有小朋友都会感冒。感冒序列 指的是 所有 一开始没有感冒的小朋友最后得感冒的顺序序列。请你返回所有感冒序列的数目。
由于答案可能很大，请你将答案对 10^9 + 7 取余后返回。
注意，感冒序列 不 包含一开始就得了感冒的小朋友的下标。
提示：
2 <= n <= 10^5
1 <= sick.length <= n - 1
0 <= sick[i] <= n - 1
sick 按升序排列。

https://leetcode.cn/problems/count-the-number-of-infection-sequences/solutions/2551734/zu-he-shu-xue-ti-by-endlesscheng-5fjp/
首先考虑两个相邻感冒小朋友之间的序列有多少个。
设这两个相邻感冒小朋友之间有 k 个没有感冒的小朋友。
把感染左边的人记作 L，把感染右边的人记作 R。
按照感染的顺序，我们可以得到一个 LR 序列。问题相当于求 LR 序列有多少个，这相当于从 k 个位置中选一个子集，全部填 L，其余位置填 R。
但是考虑到最后感染的那个小朋友既可以记作 L，又可以记作 R，所以有 2^(k-1) 种方案。
特殊情况：
- 对于最左边感冒小朋友感染他左边的人，序列只有一种。
- 对于最右边感冒小朋友感染他右边的人，序列只有一种。
然后考虑不同的感冒序列之间如何「合并」。
假设有三个感冒序列，长度分别为 k1,k2,k3，长度之和为 s。
- 先从 s 个位置中选 k1 个位置放第一个感冒序列，这有 C(s,k1) 种放法。
- 然后从 s−k1 个位置中选 k2 个位置放第二个感冒序列，这有 C(s−k1,k2) 种放法。
- 然后从 s−k1−k2 个位置中选 k3 个位置放第三个感冒序列，这有 C(s−k1−k2,k3) 种放法。
根据乘法原理，把所有放法相乘，再乘上每种感冒序列的方案，即为答案。
时间复杂度 O(m)
空间复杂度 O(1)
 */