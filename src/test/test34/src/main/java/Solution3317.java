public class Solution3317 {
    private static final int MOD = (int) (1e9 + 7);
    private static final int MX = 1001;
    private static final long[][] STIRLING2 = new long[MX][MX];

    static {
        STIRLING2[0][0] = 1;
        for (int n = 1; n < MX; n++) {
            for (int k = 1; k <= n; k++) {
                STIRLING2[n][k] = (STIRLING2[n - 1][k - 1] + k * STIRLING2[n - 1][k]) % MOD;
            }
        }
    }

    public int numberOfWays(int n, int x, int y) {
        long ans = 0;
        long perm = 1;
        long powY = 1;
        for (int i = 1; i <= Math.min(n, x); i++) {
            perm = perm * (x + 1 - i) % MOD;
            powY = powY * y % MOD;
            ans = (ans + perm * STIRLING2[n][i] % MOD * powY) % MOD;
        }
        return (int) ans;
    }
}
/*
3317. 安排活动的方案数
https://leetcode.cn/problems/find-the-number-of-possible-ways-for-an-event/description/

第 141 场双周赛 T4。

给你三个整数 n ，x 和 y 。
一个活动总共有 n 位表演者。每一位表演者会 被安排 到 x 个节目之一，有可能有节目 没有 任何表演者。
所有节目都安排完毕后，评委会给每一个 有表演者的 节目打分，分数是一个 [1, y] 之间的整数。
请你返回 总 的活动方案数。
答案可能很大，请你将它对 10^9 + 7 取余 后返回。
注意 ，如果两个活动满足以下条件 之一 ，那么它们被视为 不同 的活动：
- 存在 一个表演者在不同的节目中表演。
- 存在 一个节目的分数不同。

组合数学：第二类斯特林数。
https://oi-wiki.org/math/combinatorics/stirling/
i 从 1 枚举到 min(n, x)。结果累加 A(x, i) * S(n, i) * y^i
预处理时间复杂度 O(N^2)。其中 N = 1000
时间复杂度 O(min(n, x))。
rating 2408 (clist.by)
相似题目: 1866. 恰有 K 根木棍可以看到的排列数目
https://leetcode.cn/problems/number-of-ways-to-rearrange-sticks-with-k-sticks-visible/
 */