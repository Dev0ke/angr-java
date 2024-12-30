public class Solution2017 {
    public long gridGame(int[][] grid) {
        int N = grid[0].length;
        // 前缀和
        long[] preSum1 = new long[N + 1];
        for (int i = 0; i < N; i++) {
            preSum1[i + 1] = preSum1[i] + grid[0][i];
        }
        long[] preSum2 = new long[N + 1];
        for (int i = 0; i < N; i++) {
            preSum2[i + 1] = preSum2[i] + grid[1][i];
        }

        // 枚举转折点 0 ~ N-1
        long min = Long.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            // 第二个 机器人 第一行收集的点数
            long res1 = preSum1[N] - preSum1[i + 1];
            // 第二个 机器人 第二行收集的点数
            long res2 = preSum2[i] - preSum2[0];

            min = Math.min(min, Math.max(res1, res2));
        }
        return min;
    }
}
/*
2017. 网格游戏
https://leetcode.cn/problems/grid-game/

第 260 场周赛 T2。

给你一个下标从 0 开始的二维数组 grid ，数组大小为 2 x n ，其中 grid[r][c] 表示矩阵中 (r, c) 位置上的点数。现在有两个机器人正在矩阵上参与一场游戏。
两个机器人初始位置都是 (0, 0) ，目标位置是 (1, n-1) 。每个机器人只会 向右 ((r, c) 到 (r, c + 1)) 或 向下 ((r, c) 到 (r + 1, c)) 。
游戏开始，第一个 机器人从 (0, 0) 移动到 (1, n-1) ，并收集路径上单元格的全部点数。对于路径上所有单元格 (r, c) ，途经后 grid[r][c] 会重置为 0 。
然后，第二个 机器人从 (0, 0) 移动到 (1, n-1) ，同样收集路径上单元的全部点数。注意，它们的路径可能会存在相交的部分。
第一个 机器人想要打击竞争对手，使 第二个 机器人收集到的点数 最小化 。与此相对，第二个 机器人想要 最大化 自己收集到的点数。
两个机器人都发挥出自己的 最佳水平 的前提下，返回 第二个 机器人收集到的 点数 。

贪心。
由于只要两行，所以 第二个机器人 只存在两种路线。分别求解，取最大值即可。同时由于 第一个机器人 的存在，所以在这些最大值中取最小值。
时间复杂度 O(n)
 */