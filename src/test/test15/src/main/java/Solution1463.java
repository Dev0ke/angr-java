import java.util.Arrays;

public class Solution1463 {
    public int cherryPickup(int[][] grid) {
        int M = grid.length;
        int N = grid[0].length;

        // dp[i][j1][j2] 表示机器人 1 从 (0,0) 出发到 (i,j1) && 机器人 2 从 (0,N-1) 出发到 (i,j2) 能收集的最多樱桃数目
        int[][][] dp = new int[M][N][N];
        for (int[][] ints : dp) {
            for (int[] anInt : ints) {
                Arrays.fill(anInt, Integer.MIN_VALUE);
            }
        }
        // 初始状态
        dp[0][0][N - 1] = grid[0][0] + grid[0][N - 1];
        // 状态转移
        for (int i = 1; i <= M - 1; i++) {
            int[][] dp2 = new int[N][N];
            for (int[] ints : dp2) {
                Arrays.fill(ints, Integer.MIN_VALUE);
            }

            for (int j1 = 0; j1 < N; j1++) {
                for (int j2 = 0; j2 < N; j2++) {
                    int res = (j1 == j2) ? grid[i][j1] : grid[i][j1] + grid[i][j2];

                    int preJ1 = Math.max(0, j1 - 1);
                    int endJ1 = Math.min(j1 + 1, N - 1);
                    int preJ2 = Math.max(0, j2 - 1);
                    int endJ2 = Math.min(j2 + 1, N - 1);
                    for (int pj1 = preJ1; pj1 <= endJ1; pj1++) {
                        for (int pj2 = preJ2; pj2 <= endJ2; pj2++) {
                            // 从最多 9 个状态中选取一个进行转移
                            dp2[j1][j2] = Math.max(dp2[j1][j2], dp[i - 1][pj1][pj2] + res);
                        }
                    }
                }
            }
            dp[i] = dp2;
        }

        // 答案即所有 dp[M - 1][j1][j2] 中的最大值
        int max = Integer.MIN_VALUE;
        for (int j1 = 0; j1 < N; j1++) {
            for (int j2 = 0; j2 < N; j2++) {
                max = Math.max(max, dp[M - 1][j1][j2]);
            }
        }
        return max;
    }
}
/*
1463. 摘樱桃 II
https://leetcode.cn/problems/cherry-pickup-ii/

给你一个 rows x cols 的矩阵 grid 来表示一块樱桃地。 grid 中每个格子的数字表示你能获得的樱桃数目。
你有两个机器人帮你收集樱桃，机器人 1 从左上角格子 (0,0) 出发，机器人 2 从右上角格子 (0, cols-1) 出发。
请你按照如下规则，返回两个机器人能收集的最多樱桃数目：
- 从格子 (i,j) 出发，机器人可以移动到格子 (i+1, j-1)，(i+1, j) 或者 (i+1, j+1) 。
- 当一个机器人经过某个格子时，它会把该格子内所有的樱桃都摘走，然后这个位置会变成空格子，即没有樱桃的格子。
- 当两个机器人同时到达同一个格子时，它们中只有一个可以摘到樱桃。
- 两个机器人在任意时刻都不能移动到 grid 外面。
- 两个机器人最后都要到达 grid 最底下一行。
提示：
rows == grid.length
cols == grid[i].length
2 <= rows, cols <= 70
0 <= grid[i][j] <= 100

动态规划。
时间复杂度 O(m*n^2)
空间复杂度 O(m*n^2) 可以压缩到 O(n^2)
相似题目: 741. 摘樱桃
https://leetcode.cn/problems/cherry-pickup/
 */