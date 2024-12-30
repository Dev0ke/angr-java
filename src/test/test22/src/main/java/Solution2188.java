import java.util.Arrays;

public class Solution2188 {
    public int minimumFinishTime(int[][] tires, int changeTime, int numLaps) {
        // best[i] 表示不换胎跑 i 圈需要耗费的 最少 时间
        // i 极限值不会太大，[1,2]
        int[] best = new int[18];
        Arrays.fill(best, Integer.MAX_VALUE);

        int maxLap = 0;
        for (int[] tire : tires) {
            int lap = tire[0];
            int preSum = tire[0];
            for (int x = 1; lap < changeTime + tire[0]; x++) {
                best[x] = Math.min(best[x], preSum);
                lap *= tire[1];
                preSum += lap;
                maxLap = Math.max(maxLap, x);
            }
        }

        // dp[i] 表示跑 i 圈需要耗费的 最少 时间
        int[] dp = new int[numLaps + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= numLaps; i++) {
            // 注意溢出
//            for (int j = 0; j < i && i - j <= maxLap; j++) {
            for (int j = i - 1; j >= 0 && i - j <= maxLap; j--) {
                dp[i] = Math.min(dp[i], dp[j] + best[i - j] + changeTime);
            }
        }
        return dp[numLaps] - changeTime;
    }
}
/*
2188. 完成比赛的最少时间
https://leetcode.cn/problems/minimum-time-to-finish-the-race/

第 282 场周赛 T4。

给你一个下标从 0 开始的二维整数数组 tires ，其中 tires[i] = [fi, ri] 表示第 i 种轮胎如果连续使用，第 x 圈需要耗时 fi * ri(x-1) 秒。
- 比方说，如果 fi = 3 且 ri = 2 ，且一直使用这种类型的同一条轮胎，那么该轮胎完成第 1 圈赛道耗时 3 秒，完成第 2 圈耗时 3 * 2 = 6 秒，完成第 3 圈耗时 3 * 22 = 12 秒，依次类推。
同时给你一个整数 changeTime 和一个整数 numLaps 。
比赛总共包含 numLaps 圈，你可以选择 任意 一种轮胎开始比赛。每一种轮胎都有 无数条 。每一圈后，你可以选择耗费 changeTime 秒 换成 任意一种轮胎（也可以换成当前种类的新轮胎）。
请你返回完成比赛需要耗费的 最少 时间。
提示：
1 <= tires.length <= 10^5
tires[i].length == 2
1 <= fi, changeTime <= 10^5
2 <= ri <= 10^5
1 <= numLaps <= 1000

由于耗时指数级增长，所以同一条轮胎不会连续跑太多圈数。如（[ ] 外为无效值，换胎重跑更划算）：
tires = [[2,3],[3,4]], changeTime = 5, numLaps = 4
[2,3] => [2,  6], 18, 54
[3,4] => [3], 12, 48, 192
best[] = {2, 8}
tires = [[1,10],[2,2],[3,4]], changeTime = 6, numLaps = 5
[1,10] => [1], 10, 100, 1000
[2,2]  => [2,  4],   8, 16
[3,4]  => [3], 12,  48, 192
best[] = {1, 6}

时间复杂度：O((n+numLaps)logTmax)
 */