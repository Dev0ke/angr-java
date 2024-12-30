public class Solution2320 {
    private static final int MOD = (int) (1e9 + 7);

    public int countHousePlacements(int n) {
        if (n == 1) {
            return 4;
        }
        long[] f = new long[n + 1];
        f[0] = 1;
        f[1] = 2;
        for (int i = 2; i <= n; i++) {
            f[i] = (f[i - 1] + f[i - 2]) % MOD;
        }
        return (int) (f[n] * f[n] % MOD);
    }
}
/*
2320. 统计放置房子的方式数
https://leetcode.cn/problems/count-number-of-ways-to-place-houses/

第 299 场周赛 T2。

一条街道上共有 n * 2 个 地块 ，街道的两侧各有 n 个地块。每一边的地块都按从 1 到 n 编号。每个地块上都可以放置一所房子。
现要求街道同一侧不能存在两所房子相邻的情况，请你计算并返回放置房屋的方式数目。由于答案可能很大，需要对 10^9 + 7 取余后再返回。
注意，如果一所房子放置在这条街某一侧上的第 i 个地块，不影响在另一侧的第 i 个地块放置房子。
提示：
1 <= n <= 10^4

动态规划。
状态定义：f[i] 表示前 i 各地块的放置方案数
状态转移：f[i] = f[i-1] + f[i-2]
初始状态：f[0] = 1, f[1] = 2
与双周赛 T4 类似。
相似题目: 2318. 不同骰子序列的数目
https://leetcode.cn/problems/number-of-distinct-roll-sequences/
 */