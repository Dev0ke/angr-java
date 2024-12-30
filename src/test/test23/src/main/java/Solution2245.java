public class Solution2245 {
    public int maxTrailingZeros(int[][] grid) {
        int M = grid.length;
        int N = grid[0].length;

        int[][][] origin = new int[M][N][2];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                origin[i][j][0] = getPrimeFactorK(grid[i][j], 2);
                origin[i][j][1] = getPrimeFactorK(grid[i][j], 5);
            }
        }

        // 上下左右
        int[][][] left = new int[M][N][2];
        int[][][] right = new int[M][N][2];
        int[][][] top = new int[M][N][2];
        int[][][] bottom = new int[M][N][2];
        for (int j = 1; j <= N - 1; j++) {
            for (int i = 0; i < M; i++) {
                left[i][j][0] = left[i][j - 1][0] + origin[i][j - 1][0];
                left[i][j][1] = left[i][j - 1][1] + origin[i][j - 1][1];
            }
        }
        for (int j = N - 2; j >= 0; j--) {
            for (int i = 0; i < M; i++) {
                right[i][j][0] = right[i][j + 1][0] + origin[i][j + 1][0];
                right[i][j][1] = right[i][j + 1][1] + origin[i][j + 1][1];
            }
        }
        for (int i = 1; i <= M - 1; i++) {
            for (int j = 0; j < N; j++) {
                top[i][j][0] = top[i - 1][j][0] + origin[i - 1][j][0];
                top[i][j][1] = top[i - 1][j][1] + origin[i - 1][j][1];
            }
        }
        for (int i = M - 2; i >= 0; i--) {
            for (int j = 0; j < N; j++) {
                bottom[i][j][0] = bottom[i + 1][j][0] + origin[i + 1][j][0];
                bottom[i][j][1] = bottom[i + 1][j][1] + origin[i + 1][j][1];
            }
        }

        // 枚举每个单元格 4 个象限
        int max = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                int rightTop0 = origin[i][j][0] + right[i][j][0] + top[i][j][0];
                int rightTop1 = origin[i][j][1] + right[i][j][1] + top[i][j][1];

                int topLeft0 = origin[i][j][0] + left[i][j][0] + top[i][j][0];
                int topLeft1 = origin[i][j][1] + left[i][j][1] + top[i][j][1];

                int leftBottom0 = origin[i][j][0] + left[i][j][0] + bottom[i][j][0];
                int leftBottom1 = origin[i][j][1] + left[i][j][1] + bottom[i][j][1];

                int bottomRight0 = origin[i][j][0] + right[i][j][0] + bottom[i][j][0];
                int bottomRight1 = origin[i][j][1] + right[i][j][1] + bottom[i][j][1];

                max = Math.max(max, Math.min(rightTop0, rightTop1));
                max = Math.max(max, Math.min(topLeft0, topLeft1));
                max = Math.max(max, Math.min(leftBottom0, leftBottom1));
                max = Math.max(max, Math.min(bottomRight0, bottomRight1));
            }
        }
        return max;
    }

    // 求数 n 质因子 k 的个数
    public int getPrimeFactorK(int n, int k) {
        int cnt = 0;
        for (int x = n; x % k == 0; x /= k) {
            cnt++;
        }
        return cnt;
    }
}
/*
2245. 转角路径的乘积中最多能有几个尾随零
https://leetcode.cn/problems/maximum-trailing-zeros-in-a-cornered-path/

第 289 场周赛 T3。

给你一个二维整数数组 grid ，大小为 m x n，其中每个单元格都含一个正整数。
转角路径 定义为：包含至多一个弯的一组相邻单元。具体而言，路径应该完全 向水平方向 或者 向竖直方向 移动过弯（如果存在弯），
而不能访问之前访问过的单元格。在过弯之后，路径应当完全朝 另一个 方向行进：如果之前是向水平方向，那么就应该变为向竖直方向；反之亦然。
当然，同样不能访问之前已经访问过的单元格。
一条路径的 乘积 定义为：路径上所有值的乘积。
请你从 grid 中找出一条乘积中尾随零数目最多的转角路径，并返回该路径中尾随零的数目。
注意：
- 水平 移动是指向左或右移动。
- 竖直 移动是指向上或下移动。
提示：
m == grid.length
n == grid[i].length
1 <= m, n <= 10^5
1 <= m * n <= 10^5
1 <= grid[i][j] <= 1000

主要思路，枚举每个单元格上下左右四个方向贡献的零。
比赛时一开始看错了数据范围，发现会狠狠的爆 long，换 BigInteger 会 TLE。
乘积末尾零问题可以转化为 求 质因子 2 的个数和质因子 5 的个数的较小值 问题
相似题目: 172. 阶乘后的零
https://leetcode.cn/problems/factorial-trailing-zeroes/
 */