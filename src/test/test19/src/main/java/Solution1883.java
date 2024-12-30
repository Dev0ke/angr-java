import java.util.Arrays;

public class Solution1883 {
    private int[] dist;
    private int speed;
    private int[][] memo;

    public int minSkips(int[] dist, int speed, int hoursBefore) {
        this.dist = dist;
        this.speed = speed;
        long maxDist = (long) speed * hoursBefore;
        if (Arrays.stream(dist).sum() > maxDist) return -1;

        int n = dist.length;
        memo = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(memo[i], -1);
        }

        for (int i = 0; i < n; i++) {
            if (dfs(i, n - 2) + dist[n - 1] <= maxDist) {
                return i;
            }
        }
        return -1;
    }

    // 在最短跳过 i 次的情况下，从 dist[0] 到 dist[j] 需要的最小时间
    // 为避免浮点误差，同等时间用 speed 能走的距离
    private int dfs(int i, int j) {
        if (j < 0) return 0;
        if (memo[i][j] != -1) return memo[i][j];
        int res = (dfs(i, j - 1) + dist[j] + speed - 1) / speed * speed;
        if (i - 1 >= 0) {
            res = Math.min(res, dfs(i - 1, j - 1) + dist[j]);
        }
        return memo[i][j] = res;
    }
}
/*
1883. 准时抵达会议现场的最小跳过休息次数
https://leetcode.cn/problems/minimum-skips-to-arrive-at-meeting-on-time/description/

给你一个整数 hoursBefore ，表示你要前往会议所剩下的可用小时数。要想成功抵达会议现场，你必须途经 n 条道路。道路的长度用一个长度为 n 的整数数组 dist 表示，其中 dist[i] 表示第 i 条道路的长度（单位：千米）。另给你一个整数 speed ，表示你在道路上前进的速度（单位：千米每小时）。
当你通过第 i 条路之后，就必须休息并等待，直到 下一个整数小时 才能开始继续通过下一条道路。注意：你不需要在通过最后一条道路后休息，因为那时你已经抵达会议现场。
- 例如，如果你通过一条道路用去 1.4 小时，那你必须停下来等待，到 2 小时才可以继续通过下一条道路。如果通过一条道路恰好用去 2 小时，就无需等待，可以直接继续。
然而，为了能准时到达，你可以选择 跳过 一些路的休息时间，这意味着你不必等待下一个整数小时。注意，这意味着与不跳过任何休息时间相比，你可能在不同时刻到达接下来的道路。
- 例如，假设通过第 1 条道路用去 1.4 小时，且通过第 2 条道路用去 0.6 小时。跳过第 1 条道路的休息时间意味着你将会在恰好 2 小时完成通过第 2 条道路，且你能够立即开始通过第 3 条道路。
返回准时抵达会议现场所需要的 最小跳过次数 ，如果 无法准时参会 ，返回 -1 。
提示：
n == dist.length
1 <= n <= 1000
1 <= dist[i] <= 10^5
1 <= speed <= 10^6
1 <= hoursBefore <= 10^7

记忆化搜索。注意避免浮点数误差。
时间复杂度 O(n^2)。
 */