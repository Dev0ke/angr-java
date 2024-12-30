public class Solution3179 {
    // 杨辉三角第 n+k 排的第 n 个数，即 C(n+k-1, n-1) = C(n+k-1, k)
    public int valueAfterKSeconds(int n, int k) {
        Comb comb = new Comb(n + k - 1);
        return (int) comb.binom(n + k - 1, k);
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
3179. K 秒后第 N 个元素的值
https://leetcode.cn/problems/find-the-n-th-value-after-k-seconds/description/

第 401 场周赛 T2。

给你两个整数 n 和 k。
最初，你有一个长度为 n 的整数数组 a，对所有 0 <= i <= n - 1，都有 a[i] = 1 。每过一秒，你会同时更新每个元素为其前面所有元素的和加上该元素本身。例如，一秒后，a[0] 保持不变，a[1] 变为 a[0] + a[1]，a[2] 变为 a[0] + a[1] + a[2]，以此类推。
返回 k 秒后 a[n - 1] 的值。
由于答案可能非常大，返回其对 10^9 + 7 取余 后的结果。
提示：
1 <= n, k <= 1000

组合数学。
时间复杂度 O(1)。
 */