public class Solution1706 {
    public int[] findBall(int[][] grid) {
        int M = grid.length;
        int N = grid[0].length;

        int[] res = new int[N];
        for (int i = 0; i < N; i++) {
            res[i] = i;
        }

        for (int i = 0; i < N; i++) {
            for (int row = 0; row < M; row++) {
                // 球当前列
                int col = res[i];
                if (col != -1) {
                    if (grid[row][col] == 1) {
                        if (col + 1 < N && grid[row][col + 1] == 1) {
                            res[i]++;
                        } else {
                            res[i] = -1;
                        }
                    } else {
                        if (col - 1 >= 0 && grid[row][col - 1] == -1) {
                            res[i]--;
                        } else {
                            res[i] = -1;
                        }
                    }
                }
            }
        }
        return res;
    }
}
/*
1706. 球会落何处
https://leetcode.cn/problems/where-will-the-ball-fall/

用一个大小为 m x n 的二维网格 grid 表示一个箱子。你有 n 颗球。箱子的顶部和底部都是开着的。
箱子中的每个单元格都有一个对角线挡板，跨过单元格的两个角，可以将球导向左侧或者右侧。
- 将球导向右侧的挡板跨过左上角和右下角，在网格中用 1 表示。
- 将球导向左侧的挡板跨过右上角和左下角，在网格中用 -1 表示。
在箱子每一列的顶端各放一颗球。每颗球都可能卡在箱子里或从底部掉出来。如果球恰好卡在两块挡板之间的 "V" 形图案，或者被一块挡导向到箱子的任意一侧边上，就会卡住。
返回一个大小为 n 的数组 answer ，其中 answer[i] 是球放在顶部的第 i 列后从底部掉出来的那一列对应的下标，如果球卡在盒子里，则返回 -1 。
提示：
m == grid.length
n == grid[i].length
1 <= m, n <= 100
grid[i][j] 为 1 或 -1

模拟。
时间复杂度 O(mn)
空间复杂度 O(1) 返回值不计入空间
 */