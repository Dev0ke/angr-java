public class SolutionP2361 {
    public long[] minimumCosts(int[] regular, int[] express, int expressCost) {
        int n = regular.length;
        long[][] dp = new long[n + 1][2];
        long[] ans = new long[n];
        dp[0][0] = 0;
        dp[0][1] = expressCost;
        for (int i = 0; i < n; i++) {
            dp[i + 1][0] = Math.min(dp[i][0], dp[i][1]) + regular[i];
            dp[i + 1][1] = Math.min(dp[i][1], dp[i][0] + expressCost) + express[i];
            ans[i] = Math.min(dp[i + 1][0], dp[i + 1][1]);
        }
        return ans;
    }
}
/*
$2361. 乘坐火车路线的最少费用
https://leetcode.cn/problems/minimum-costs-using-the-train-line/description/

城市中的火车有两条路线，分别是常规路线和特快路线。两条路线经过 相同 的 n + 1 个车站，车站编号从 0 到 n。初始时，你位于车站 0 的常规路线。
给你两个 下标从 1 开始 、长度均为 n 的两个整数数组 regular 和 express ，其中 regular[i] 表示乘坐常规路线从车站 i - 1 到车站 i 的费用，express[i] 表示乘坐特快路线从车站 i - 1 到车站 i 的费用。
另外给你一个整数 expressCost，表示从常规路线转换到特快路线的费用。
注意：
- 从特快路线转换回常规路线没有费用。
- 每次 从常规路线转换到特快路线，你都需要支付 expressCost 的费用。
- 留在特快路线上没有额外费用。
返回 下标从 1 开始 、长度为 n 的数组 costs，其中 costs[i] 是从车站 0 到车站 i 的最少费用。
注意：每个车站都可以从任意一条路线 到达 。
提示：
n == regular.length == express.length
1 <= n <= 10^5
1 <= regular[i], express[i], expressCost <= 10^5

动态规划。
dp[i][1] 表示从车站 0 的常规路线到车站 i 的特快路线的最少费用。
时间复杂度 O(n)。
 */