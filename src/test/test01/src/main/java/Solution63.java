public class Solution63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        if (obstacleGrid[0][0] == 1) {
            return 0;
        }

        // f[i][j] 表示到达坐标 (i,j) 的路径总数
        int[][] f = new int[m][n];
        // 初始状态
        f[0][0] = 1;
        for (int i = 1; i < m; i++) {
            if (obstacleGrid[i][0] == 0) {
                f[i][0] = 1;
            } else {
                break;
            }
        }
        for (int j = 1; j < n; j++) {
            if (obstacleGrid[0][j] == 0) {
                f[0][j] = 1;
            } else {
                break;
            }
        }
        // 状态转移
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 0) {
                    f[i][j] = f[i][j - 1] + f[i - 1][j];
                } else {
                    // 不可达
                    f[i][j] = 0;
                }
            }
        }
        return f[m - 1][n - 1];
    }
}
/*
63. 不同路径 II
https://leetcode.cn/problems/unique-paths-ii/

一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
网格中的障碍物和空位置分别用 1 和 0 来表示。
提示：
m == obstacleGrid.length
n == obstacleGrid[i].length
1 <= m, n <= 100
obstacleGrid[i][j] 为 0 或 1

动态规划。
时间复杂度 O(mn)
空间复杂度 O(mn)
相似题目: 62. 不同路径
https://leetcode.cn/problems/unique-paths/
 */