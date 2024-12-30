import java.util.Arrays;

public class Solution883 {
    public int projectionArea(int[][] grid) {
        int M = grid.length;
        int N = grid[0].length;
        int[] maxM = new int[M];
        int[] maxN = new int[N];
        for (int i = 0; i < M; i++) {
            maxM[i] = grid[i][0];
            for (int j = 0; j < N; j++) {
                maxM[i] = Math.max(maxM[i], grid[i][j]);
            }
        }
        for (int j = 0; j < N; j++) {
            maxN[j] = grid[0][j];
            for (int i = 0; i < M; i++) {
                maxN[j] = Math.max(maxN[j], grid[i][j]);
            }
        }
        int cnt = Arrays.stream(maxM).sum() + Arrays.stream(maxN).sum();
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                cnt += (grid[i][j] > 0) ? 1 : 0;
            }
        }
        return cnt;
    }
}
/*
883. 三维形体投影面积
https://leetcode.cn/problems/projection-area-of-3d-shapes/

第 96 场周赛 T1。

在 N * N 的网格中，我们放置了一些与 x，y，z 三轴对齐的 1 * 1 * 1 立方体。
每个值 v = grid[i][j] 表示 v 个正方体叠放在单元格 (i, j) 上。
现在，我们查看这些立方体在 xy、yz 和 zx 平面上的投影。
投影就像影子，将三维形体映射到一个二维平面上。
在这里，从顶部、前面和侧面看立方体时，我们会看到“影子”。
返回所有三个投影的总面积。
提示：
n == grid.length == grid[i].length
1 <= n <= 50
0 <= grid[i][j] <= 50

用数组记录 "主视图" 与 "左视图"，累加最大值即可。
 */