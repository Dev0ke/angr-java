public class Solution463 {
    public int islandPerimeter(int[][] grid) {
        int M = grid.length;
        int N = grid[0].length;

        int res = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == 0) {
                    continue;
                }

                // 上边界
                if (i == 0 || grid[i - 1][j] == 0) {
                    res++;
                }
                // 下边界
                if (i == M - 1 || grid[i + 1][j] == 0) {
                    res++;
                }
                // 左边界
                if (j == 0 || grid[i][j - 1] == 0) {
                    res++;
                }
                // 右边界
                if (j == N - 1 || grid[i][j + 1] == 0) {
                    res++;
                }
            }
        }
        return res;
    }
}
/*
463. 岛屿的周长
https://leetcode.cn/problems/island-perimeter/

给定一个 row x col 的二维网格地图 grid ，其中：grid[i][j] = 1 表示陆地， grid[i][j] = 0 表示水域。
网格中的格子 水平和垂直 方向相连（对角线方向不相连）。整个网格被水完全包围，但其中恰好有一个岛屿（或者说，一个或多个表示陆地的格子相连组成的岛屿）。
岛屿中没有“湖”（“湖” 指水域在岛屿内部且不和岛屿周围的水相连）。格子是边长为 1 的正方形。网格为长方形，且宽度和高度均不超过 100 。计算这个岛屿的周长。
提示：
row == grid.length
col == grid[i].length
1 <= row, col <= 100
grid[i][j] 为 0 或 1

枚举每块陆地，判断是否为 上下左右 边界
时间复杂度 O(mn)
 */