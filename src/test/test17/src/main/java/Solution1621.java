public class Solution1621 {
    public int numberOfSets(int n, int k) {
        Comb comb = new Comb(n + k);
        return (int) comb.binom(n + k - 1, k * 2);
    }

    private static final int MOD = (int) (1e9 + 7);

    static class Comb {
        long[] fac, inv_fac;

        public Comb(int n) {
            fac = new long[n + 1];
            fac[0] = 1;
            for (int i = 1; i <= n; i++) fac[i] = fac[i - 1] * i % MOD;
            inv_fac = new long[n + 1];
            for (int i = 0; i <= n; i++) inv_fac[i] = quickPow(fac[i], MOD - 2);
        }

        // C(n, m) = n! / m!(n-m)!
        long binom(int n, int m) {
            if (n < m || m < 0) return 0;
            return fac[n] * inv_fac[m] % MOD * inv_fac[n - m] % MOD;
        }

        // 模下的 a^b
        long quickPow(long a, long b) {
            long res = 1L;
            while (b > 0) {
                if ((b & 1) != 0) res = res * a % MOD;
                a = a * a % MOD;
                b >>= 1;
            }
            return res;
        }
    }
}
/*
1621. 大小为 K 的不重叠线段的数目
https://leetcode.cn/problems/number-of-sets-of-k-non-overlapping-line-segments/description/

给你一维空间的 n 个点，其中第 i 个点（编号从 0 到 n-1）位于 x = i 处，请你找到 恰好 k 个不重叠 线段且每个线段至少覆盖两个点的方案数。线段的两个端点必须都是 整数坐标 。这 k 个线段不需要全部覆盖全部 n 个点，且它们的端点 可以 重合。
请你返回 k 个不重叠线段的方案数。由于答案可能很大，请将结果对 10^9 + 7 取余 后返回。
提示：
2 <= n <= 1000
1 <= k <= n-1

组合数学。
如果线段之间首尾不重合，k 个线段需要选择 C(n, 2k) 个点
由于最多有 k-1 个线段首尾相连，所以不妨增加 k-1 个虚构点，k 个线段需要选择 C(n+k-1, 2k) 个点
math.comb(n + k - 1, k * 2) % (10**9 + 7)
时间复杂度 O(n+k)。
 */