public class Solution2482 {
    public int[][] onesMinusZeros(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[] onesRow = new int[m];
        int[] onesCol = new int[n];
        int[] zerosRow = new int[m];
        int[] zerosCol = new int[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    zerosRow[i]++;
                    zerosCol[j]++;
                } else {
                    onesRow[i]++;
                    onesCol[j]++;
                }
            }
        }

        int[][] diff = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                diff[i][j] = onesRow[i] + onesCol[j] - zerosRow[i] - zerosCol[j];
            }
        }
        return diff;
    }
}
/*
2482. 行和列中一和零的差值
https://leetcode.cn/problems/difference-between-ones-and-zeros-in-row-and-column/

第 92 场双周赛 T2。

给你一个下标从 0 开始的 m x n 二进制矩阵 grid 。
我们按照如下过程，定义一个下标从 0 开始的 m x n 差值矩阵 diff ：
- 令第 i 行一的数目为 onesRowi 。
- 令第 j 列一的数目为 onesColj 。
- 令第 i 行零的数目为 zerosRowi 。
- 令第 j 列零的数目为 zerosColj 。
- diff[i][j] = onesRowi + onesColj - zerosRowi - zerosColj
请你返回差值矩阵 diff 。
提示：
m == grid.length
n == grid[i].length
1 <= m, n <= 10^5
1 <= m * n <= 10^5
grid[i][j] 要么是 0 ，要么是 1 。

模拟。
 */