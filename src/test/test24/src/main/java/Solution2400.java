import java.util.Arrays;

public class Solution2400 {
    private static final long MOD = (long) (1e9 + 7);
    private long[][] memo;

    // 记忆化搜索 时间复杂度 O(k^2)
    public int numberOfWays(int startPos, int endPos, int k) {
        int diff = Math.abs(startPos - endPos);
        if (k - diff >= 0 && (k - diff) % 2 == 0) {
            // 重叠部分
            int overlap = (k - diff) / 2;
            // 向一个方向走 diff+overlap 步, 向另一个方向走 overlap 步
            int a = diff + overlap;
            int b = overlap;

            memo = new long[a + 1][b + 1];
            for (int i = 0; i < a + 1; i++) {
                Arrays.fill(memo[i], -1);
            }
            return (int) dfs(a, b);
        }
        return 0;
    }

    private long dfs(int a, int b) {
        if (a + b == 0) {
            return 1;
        }
        if (memo[a][b] != -1) {
            return memo[a][b];
        }

        long res = 0;
        if (a > 0) {
            res += dfs(a - 1, b);
            res %= MOD;
        }
        if (b > 0) {
            res += dfs(a, b - 1);
            res %= MOD;
        }
        memo[a][b] = res;
        return res;
    }

    // 乘法逆元 时间复杂度 O(k)
    public int numberOfWays2(int startPos, int endPos, int k) {
        int diff = Math.abs(startPos - endPos);
        if ((k - diff) % 2 != 0 || diff > k) {
            return 0;
        }
        // 总 k 步
        // 向左 (k-diff)/2 向右 k - (k-diff)/2
        // C(k, (k-diff)/2)
        return (int) combination(k, (k - diff) / 2, (int) MOD);
    }

    // C(n, m) = n! / m!(n-m)! （n 为下标） (% mod)
    private long combination(int n, int m, int mod) {
        // 线性求逆元
        long[] inv = new long[n + 1];
        inv[1] = 1;
        for (int i = 2; i <= n; i++) {
            inv[i] = (mod - mod / i) * inv[mod % i] % mod;
        }
        // 递推求组合数，初值 C(k, 0) = 1
        long res = 1;
        for (int i = 1; i <= m; i++) {
            res = res * (n - i + 1) % mod * inv[i] % mod;
        }
        return res;
    }
}
/*
2400. 恰好移动 k 步到达某一位置的方法数目
https://leetcode.cn/problems/number-of-ways-to-reach-a-position-after-exactly-k-steps/

第 309 场周赛 T2。

给你两个 正 整数 startPos 和 endPos 。最初，你站在 无限 数轴上位置 startPos 处。在一步移动中，你可以向左或者向右移动一个位置。
给你一个正整数 k ，返回从 startPos 出发、恰好 移动 k 步并到达 endPos 的 不同 方法数目。由于答案可能会很大，返回对 10^9 + 7 取余 的结果。
如果所执行移动的顺序不完全相同，则认为两种方法不同。
注意：数轴包含负整数。
提示：
1 <= startPos, endPos, k <= 1000

组合数学
距离绝对值 diff = abs(startPos - endPos)
如果 k - diff 非偶数，无解
否则答案为 C(k, (k+d)/2)
注意除法不能直接取模，涉及到乘法逆元知识点 https://oi-wiki.org/math/number-theory/inverse/
相似题目: 1269. 停在原地的方案数
https://leetcode.cn/problems/number-of-ways-to-stay-in-the-same-place-after-some-steps/
 */