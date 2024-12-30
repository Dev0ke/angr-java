import java.util.Arrays;

public class Solution741 {
    public int cherryPickup(int[][] grid) {
        int N = grid.length;

        // 问题可以看成两个人同时从 (0,0) 出发走到 (n-1,n-1) 能摘到最多樱桃的数量
        // 假设当前走了 step 步
        // dp[i1][i2] 从 (0,0) 走到 (i1,step-i1) && 从 (0,0) 走到 (i2,step-i2) 能摘到最多樱桃的数量
        int[][] dp = new int[N][N];
        for (int[] ints : dp) {
            Arrays.fill(ints, Integer.MIN_VALUE);
        }

        dp[0][0] = grid[0][0];

        for (int step = 1; step <= 2 * N - 2; step++) {
            int[][] dp2 = new int[N][N];
            for (int[] ints : dp2) {
                Arrays.fill(ints, Integer.MIN_VALUE);
            }

            int begin = Math.max(0, step - (N - 1));
            int end = Math.min(N - 1, step);
            for (int i1 = begin; i1 <= end; i1++) {
                for (int i2 = begin; i2 <= end; i2++) {
                    if (grid[i1][step - i1] == -1 || grid[i2][step - i2] == -1) {
                        continue;
                    }

                    int res = (i1 == i2) ? grid[i1][step - i1] : grid[i1][step - i1] + grid[i2][step - i2];

                    int preI1 = Math.max(0, i1 - 1);
                    int preI2 = Math.max(0, i2 - 1);
                    for (int pi = preI1; pi <= i1; pi++) {
                        for (int pj = preI2; pj <= i2; pj++) {
                            // 从最多 4 个状态中选取一个进行转移
                            dp2[i1][i2] = Math.max(dp2[i1][i2], dp[pi][pj] + res);
                        }
                    }
                }
            }
            dp = dp2;
        }
        return Math.max(0, dp[N - 1][N - 1]);
    }
}
/*
741. 摘樱桃
https://leetcode.cn/problems/cherry-pickup/

一个N x N的网格(grid) 代表了一块樱桃地，每个格子由以下三种数字的一种来表示：
- 0 表示这个格子是空的，所以你可以穿过它。
- 1 表示这个格子里装着一个樱桃，你可以摘到樱桃然后穿过它。
- -1 表示这个格子里有荆棘，挡着你的路。
你的任务是在遵守下列规则的情况下，尽可能的摘到最多樱桃：
- 从位置 (0, 0) 出发，最后到达 (N-1, N-1) ，只能向下或向右走，并且只能穿越有效的格子（即只可以穿过值为0或者1的格子）；
- 当到达 (N-1, N-1) 后，你要继续走，直到返回到 (0, 0) ，只能向上或向左走，并且只能穿越有效的格子；
- 当你经过一个格子且这个格子包含一个樱桃时，你将摘到樱桃并且这个格子会变成空的（值变为0）；
- 如果在 (0, 0) 和 (N-1, N-1) 之间不存在一条可经过的路径，则没有任何一个樱桃能被摘到。
说明:
grid 是一个 N * N 的二维数组，N的取值范围是1 <= N <= 50。
每一个 grid[i][j] 都是集合 {-1, 0, 1}其中的一个数。
可以保证起点 grid[0][0] 和终点 grid[N-1][N-1] 的值都不会是 -1。

动态规划。
时间复杂度 O(n^3)
空间复杂度 O(n^2)
相似题目: 1463. 摘樱桃 II
https://leetcode.cn/problems/cherry-pickup-ii/
 */