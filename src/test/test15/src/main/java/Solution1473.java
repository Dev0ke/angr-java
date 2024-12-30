import java.util.Arrays;

public class Solution1473 {
    private static final int INF = 100 * 20 * 10000;

    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        // f[i][j][k] 表示粉刷 [0, i] 行的房子且第 i 行房子颜色为 j 且属于第 k 个街区时的最小花费
        int[][][] f = new int[m][n][target];

        // 处理成 0 开始
        for (int i = 0; i < m; i++) {
            houses[i]--;
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(f[i][j], INF);
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (houses[i] != -1 && houses[i] != j) {
                    continue;
                }

                for (int k = 0; k < target; k++) {
                    for (int j0 = 0; j0 < n; j0++) {
                        if (j == j0) {
                            if (i == 0) {
                                if (k == 0) {
                                    f[i][j][k] = 0;
                                }
                            } else {
                                f[i][j][k] = Math.min(f[i][j][k], f[i - 1][j][k]);
                            }
                        } else if (i > 0 && k > 0) {
                            f[i][j][k] = Math.min(f[i][j][k], f[i - 1][j0][k - 1]);
                        }
                    }

                    if (f[i][j][k] != INF && houses[i] == -1) {
                        f[i][j][k] += cost[i][j];
                    }
                }
            }
        }

        int min = INF;
        for (int j = 0; j < n; j++) {
            min = Math.min(min, f[m - 1][j][target - 1]);
        }
        return min == INF ? -1 : min;
    }
}
/*
1473. 粉刷房子 III
https://leetcode.cn/problems/paint-house-iii/

在一个小城市里，有 m 个房子排成一排，你需要给每个房子涂上 n 种颜色之一（颜色编号为 1 到 n ）。有的房子去年夏天已经涂过颜色了，所以这些房子不可以被重新涂色。
我们将连续相同颜色尽可能多的房子称为一个街区。（比方说 houses = [1,2,2,3,3,2,1,1] ，它包含 5 个街区  [{1}, {2,2}, {3,3}, {2}, {1,1}] 。）
给你一个数组 houses ，一个 m * n 的矩阵 cost 和一个整数 target ，其中：
- houses[i]：是第 i 个房子的颜色，0 表示这个房子还没有被涂色。
- cost[i][j]：是将第 i 个房子涂成颜色 j+1 的花费。
请你返回房子涂色方案的最小总花费，使得每个房子都被涂色后，恰好组成 target 个街区。如果没有可用的涂色方案，请返回 -1 。
提示：
m == houses.length == cost.length
n == cost[i].length
1 <= m <= 100
1 <= n <= 20
1 <= target <= m
0 <= houses[i] <= n
1 <= cost[i][j] <= 10^4

动态规划
时间复杂度 O(m n^2 target)
相似题目: $256. 粉刷房子
https://leetcode.cn/problems/paint-house/
$265. 粉刷房子 II
https://leetcode.cn/problems/paint-house-ii/
 */