import java.util.ArrayList;
import java.util.List;

public class Solution2438 {
    private static final int MOD = (int) (1e9 + 7);

    public int[] productQueries(int n, int[][] queries) {
        // 预处理 powers
        List<Integer> powers = new ArrayList<>();
        for (int k = 0; k < 30; k++) {
            if (((n >> k) & 1) == 1) {
                powers.add(1 << k);
            }
        }

        int m = queries.length;
        int[] res = new int[m];
        for (int i = 0; i < m; i++) {
            long product = 1;
            for (int j = queries[i][0]; j <= queries[i][1]; j++) {
                product = product * powers.get(j) % MOD;
            }
            res[i] = (int) product;
        }
        return res;
    }

    // 打表优化 O(log^2(n) + m)
    public int[] productQueries2(int n, int[][] queries) {
        // 预处理 powers
        List<Integer> powers = new ArrayList<>();
        for (int k = 0; k < 30; k++) {
            if (((n >> k) & 1) == 1) {
                powers.add(1 << k);
            }
        }

        int sz = powers.size();
        int[][] memo = new int[sz][sz];
        for (int i = 0; i < sz; i++) {
            long product = 1;
            for (int j = i; j < sz; j++) {
                product = product * powers.get(j) % MOD;
                memo[i][j] = (int) product;
            }
        }

        int m = queries.length;
        int[] res = new int[m];
        for (int i = 0; i < m; i++) {
            res[i] = memo[queries[i][0]][queries[i][1]];
        }
        return res;
    }

    // f[k] = 2^k % MOD
    private static int[] f;

    // 幂次的前缀和+打表
    public int[] productQueries3(int n, int[][] queries) {
        if (f == null) {
            // 0+1+2+3+...+28 = 407
            f = new int[407];
            f[0] = 1;
            for (int i = 1; i < 407; i++) {
                f[i] = f[i - 1] * 2 % MOD;
            }
        }

        // 预处理 powers
        List<Integer> powers = new ArrayList<>();
        for (int k = 0; k < 30; k++) {
            if (((n >> k) & 1) == 1) {
                // 2^k
                powers.add(k);
            }
        }

        int sz = powers.size();
        int[] preSum = new int[sz + 1];
        for (int i = 0; i < sz; i++) {
            preSum[i + 1] = preSum[i] + powers.get(i);
        }

        int m = queries.length;
        int[] res = new int[m];
        for (int i = 0; i < m; i++) {
            int k = preSum[queries[i][1] + 1] - preSum[queries[i][0]];
            res[i] = f[k];
        }
        return res;
    }

    // 前缀积 + 乘法逆元
    public int[] productQueries4(int n, int[][] queries) {
        // 预处理 powers
        List<Integer> powers = new ArrayList<>();
        for (int k = 0; k < 30; k++) {
            if (((n >> k) & 1) == 1) {
                powers.add(1 << k);
            }
        }

        // 前缀积
        int sz = powers.size();
        long[] preProduct = new long[sz + 1];
        preProduct[0] = 1;
        for (int i = 0; i < sz; i++) {
            preProduct[i + 1] = preProduct[i] * powers.get(i) % MOD;
        }

        long[] inv = new long[sz + 1];
        for (int i = 0; i < sz + 1; i++) {
            inv[i] = inv(preProduct[i], MOD);
        }

        int m = queries.length;
        int[] res = new int[m];
        for (int i = 0; i < m; i++) {
            // 模运算下 preProduct[queries[i][1] + 1] / preProduct[queries[i][0]]
            int product = (int) (preProduct[queries[i][1] + 1] * inv[queries[i][0]] % MOD);
            res[i] = product;
        }
        return res;
    }

    private long inv(long a, long mod) {
        return quickPow(a, mod - 2, mod);
    }

    private long quickPow(long a, long b, long mod) {
        long res = 1L;
        while (b > 0) {
            if ((b & 1) == 1) {
                res = res * a % mod;
            }
            a = a * a % mod;
            b >>= 1;
        }
        return res;
    }
}
/*
2438. 二的幂数组中查询范围内的乘积
https://leetcode.cn/problems/range-product-queries-of-powers/

第 89 场双周赛 T2。

给你一个正整数 n ，你需要找到一个下标从 0 开始的数组 powers ，它包含 最少 数目的 2 的幂，且它们的和为 n 。powers 数组是 非递减 顺序的。根据前面描述，构造 powers 数组的方法是唯一的。
同时给你一个下标从 0 开始的二维整数数组 queries ，其中 queries[i] = [lefti, righti] ，其中 queries[i] 表示请你求出满足 lefti <= j <= righti 的所有 powers[j] 的乘积。
请你返回一个数组 answers ，长度与 queries 的长度相同，其中 answers[i]是第 i 个查询的答案。由于查询的结果可能非常大，请你将每个 answers[i] 都对 10^9 + 7 取余 。
提示：
1 <= n <= 10^9
1 <= queries.length <= 10^5
0 <= starti <= endi < powers.length

暴力，预处理出 powers 数组，其长度不会超过 logn，即 log(1e9) = 29.897352853986261130832874865405
时间复杂度 O(mlogn) 其中 m = queries.length
 */