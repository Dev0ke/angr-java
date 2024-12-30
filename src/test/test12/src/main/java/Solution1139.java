public class Solution1139 {
    public int largest1BorderedSquare(int[][] grid) {
        int M = grid.length;
        int N = grid[0].length;
        int[][] up = new int[M + 1][N + 1];
        int[][] left = new int[M + 1][N + 1];
        int maxL = 0;
        for (int i = 1; i <= M; i++) {
            for (int j = 1; j <= N; j++) {
                if (grid[i - 1][j - 1] == 1) {
                    up[i][j] = up[i - 1][j] + 1;
                    left[i][j] = left[i][j - 1] + 1;
                    int len = Math.min(up[i][j], left[i][j]);
                    while (up[i][j - len + 1] < len || left[i - len + 1][j] < len) {
                        len--;
                    }
                    maxL = Math.max(maxL, len);
                }
            }
        }
        return maxL * maxL;
    }
}
/*
1139. 最大的以 1 为边界的正方形
https://leetcode.cn/problems/largest-1-bordered-square/

给你一个由若干 0 和 1 组成的二维网格 grid，请你找出边界全部由 1 组成的最大 正方形 子网格，并返回该子网格中的元素数量。如果不存在，则返回 0。
提示：
1 <= grid.length <= 100
1 <= grid[0].length <= 100
grid[i][j] 为 0 或 1

动态规划
left[x][y] 表示以 (x,y) 为起点左侧连续 1 的最大数目
up[x][y] 表示以 (x,y) 为起点上侧连续 1 的最大数目
时间复杂度 O(mn * min(m,n))
时间复杂度 O(mn)
 */