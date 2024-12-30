public class Solution2088 {
    public int countPyramids(int[][] grid) {
        int M = grid.length;
        int N = grid[0].length;
        // 金字塔 数组拷贝
        int[][] dpUp = new int[M][N];
        for (int i = 0; i < M; i++) {
            System.arraycopy(grid[i], 0, dpUp[i], 0, N);
        }
        // 倒金字塔 数组拷贝
        int[][] dpDown = new int[M][N];
        for (int i = 0; i < M; i++) {
            System.arraycopy(grid[M - 1 - i], 0, dpDown[i], 0, N);
        }
        int cntUp = countPyramid(dpUp);
        int cntDown = countPyramid(dpDown);
        return cntUp + cntDown;
    }

    private int countPyramid(int[][] dp) {
        int M = dp.length;
        int N = dp[0].length;
        for (int i = 1; i < M; i++) {
            // 第 i 行 进行 i-1 次松弛
            for (int k = 0; k < i; k++) {
                for (int j = 1; j < N - 1; j++) {
                    // 分别判断 本身 上 左 右
                    if (dp[i][j] >= 1 && dp[i - 1][j] >= 1 && dp[i][j - 1] >= 1 && dp[i][j + 1] >= 1) {
                        dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i][j + 1])) + 1;
                    }
                }
            }
        }
        // 统计数目
        int res = 0;
        for (int i = 1; i < M; i++) {
            for (int j = 1; j < N - 1; j++) {
                res += dp[i][j] >= 1 ? dp[i][j] - 1 : 0;
            }
        }
        return res;
    }
}
/*
2088. 统计农场中肥沃金字塔的数目
https://leetcode.cn/problems/count-fertile-pyramids-in-a-land/

第 66 场双周赛 T4。

有一个 矩形网格 状的农场，划分为 m 行 n 列的单元格。每个格子要么是 肥沃的 （用 1 表示），要么是 贫瘠 的（用 0 表示）。网格图以外的所有与格子都视为贫瘠的。
农场中的 金字塔 区域定义如下：
区域内格子数目 大于 1 且所有格子都是 肥沃的 。
金字塔 顶端 是这个金字塔 最上方 的格子。金字塔的高度是它所覆盖的行数。令 (r, c) 为金字塔的顶端且高度为 h ，
那么金字塔区域内包含的任一格子 (i, j) 需满足 r <= i <= r + h - 1 且 c - (i - r) <= j <= c + (i - r) 。
一个 倒金字塔 类似定义如下：
区域内格子数目 大于 1 且所有格子都是 肥沃的 。
倒金字塔的 顶端 是这个倒金字塔 最下方 的格子。倒金字塔的高度是它所覆盖的行数。令 (r, c) 为金字塔的顶端且高度为 h ，
那么金字塔区域内包含的任一格子 (i, j) 需满足 r - h + 1 <= i <= r 且 c - (r - i) <= j <= c + (r - i) 。
下图展示了部分符合定义和不符合定义的金字塔区域。黑色区域表示肥沃的格子。

金字塔 和 倒金字塔 分开统计。
动态规划。
状态定义
dp[i][j] 表示以 [i,j] 为中心的金字塔，dp[i][j] 等于金字塔高度。结果即为 sum(高度-1)
状态转移
当 dp[i][j] = 1 才能转移，dp[i][j] 更新为 min(上，左，右) + 1
初始状态 dp 数组初始化为 原数组
dp[i][j] = grid[i][j]

假设有 grid 如下
1 1 1 1 1
1 1 1 1 1
1 1 1 1 1

step1:
1 1 1 1 1
1 2 2 2 1
1 1 1 1 1

step2:
1 1 1 1 1
1 2 2 2 1
1 2 2 2 1

step3:
1 1 1 1 1
1 2 2 2 1
1 2 3 2 1

res = (2-1) + (2-1) + (2-1) + (2-1) + (3-1) + (2-1)
    = 1 + 1 + 1 + 1 + 2 + 1
    = 7
 */