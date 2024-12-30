import java.util.Arrays;

public class Solution2787 {
    private static final int MOD = (int) (1e9 + 7);
    private int n, x;
    private int maxI;
    private long[][] memo;

    public int numberOfWays(int n, int x) {
        this.n = n;
        this.x = x;
        for (int i = 1; i <= n; i++) {
            if (Math.pow(i, x) <= n) {
                maxI = i;
            }
        }

        memo = new long[maxI + 1][n + 1];
        for (int i = 0; i < maxI + 1; i++) {
            Arrays.fill(memo[i], -1);
        }
        return (int) dfs(1, 0);
    }

    private long dfs(int d, int sum) {
        if (d > maxI) {
            return sum == n ? 1 : 0;
        }
        if (sum > n) return 0;

        if (memo[d][sum] != -1) {
            return memo[d][sum];
        }
        // 不选
        long res = dfs(d + 1, sum);
        // 选
        res += dfs(d + 1, sum + (int) Math.pow(d, x));
        res %= MOD;
        return memo[d][sum] = res;
    }
}
/*
2787. 将一个数字表示成幂的和的方案数
https://leetcode.cn/problems/ways-to-express-an-integer-as-sum-of-powers/

第 109 场双周赛 T4。

给你两个 正 整数 n 和 x 。
请你返回将 n 表示成一些 互不相同 正整数的 x 次幂之和的方案数。换句话说，你需要返回互不相同整数 [n1, n2, ..., nk] 的集合数目，满足 n = n1^x + n2^x + ... + nk^x 。
由于答案可能非常大，请你将它对 10^9 + 7 取余后返回。
比方说，n = 160 且 x = 3 ，一个表示 n 的方法是 n = 2^3 + 3^3 + 5^3 。
提示：
1 <= n <= 300
1 <= x <= 5

记忆化搜索。选哪个。预处理一下每个 maxI
时间复杂度 O(n)
 */
