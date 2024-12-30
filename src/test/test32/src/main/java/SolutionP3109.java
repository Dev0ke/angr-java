import java.util.Arrays;

public class SolutionP3109 {
    private static final long MOD = (long) (1e9 + 7);
    private static final int N = 100005;
    private static final long[] fact;

    static {
        fact = new long[N];
        Arrays.fill(fact, 1);
        for (int p = 2; p < N; p++) {
            fact[p] = fact[p - 1] * p % MOD;
        }
    }

    public int getPermutationIndex(int[] perm) {
        long ans = 0;
        int n = perm.length;
        BIT tr = new BIT(n);
        for (int i = 1; i <= n; i++) {
            int x = perm[i - 1];
            tr.add(x, 1);
            ans += (x - tr.query(x)) * fact[n - i] % MOD;
            ans %= MOD;
        }
        return (int) ans;
    }

    static class BIT {
        int n;
        int[] tree;

        public BIT(int n) {
            this.n = n;
            tree = new int[n + 1];
        }

        int lb(int x) {
            return x & -x;
        }

        void add(int pos, int val) {
            for (; pos <= n; pos += lb(pos)) tree[pos] += val;
        }

        int query(int pos) {
            int ret = 0;
            for (; pos > 0; pos -= lb(pos)) ret += tree[pos];
            return ret;
        }
    }
}
/*
$3109. 查找排列的下标
https://leetcode.cn/problems/find-the-index-of-permutation/description/

给定一个长度为 n 的数组 perm，它是 [1, 2, ..., n] 的一个排列，将 [1, 2, ..., n] 所有的排列放在数组中，并以 字典序 排序，返回这个数组中 perm 的下标。
由于答案可能非常大，返回值对 10^9 + 7 取模。
提示：
1 <= n == perm.length <= 10^5
perm 是 [1, 2, ..., n] 的一个排列。

主站 60 题与 315 题的缝合
相似题目: 60. 排列序列
https://leetcode.cn/problems/permutation-sequence/
315. 计算右侧小于当前元素的个数
https://leetcode.cn/problems/count-of-smaller-numbers-after-self/
 */