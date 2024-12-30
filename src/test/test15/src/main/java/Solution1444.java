public class Solution1444 {
    private static final int MOD = (int) (1e9 + 7);

    public int ways(String[] pizza, int k) {
        MatrixSum ms = new MatrixSum(pizza);
        int m = pizza.length;
        int n = pizza[0].length();
        var f = new int[k][m][n];
        for (int c = 0; c < k; c++) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (c == 0) {
                        f[c][i][j] = ms.sumRegion(i, j, m - 1, n - 1) > 0 ? 1 : 0;
                        continue;
                    }
                    int res = 0;
                    for (int j2 = j + 1; j2 < n; j2++) { // 垂直切
                        if (ms.sumRegion(i, j, m - 1, j2 - 1) > 0) { // 有苹果
                            res = (res + f[c - 1][i][j2]) % MOD;
                        }
                    }
                    for (int i2 = i + 1; i2 < m; i2++) { // 水平切
                        if (ms.sumRegion(i, j, i2 - 1, n - 1) > 0) {// 有苹果
                            res = (res + f[c - 1][i2][j]) % MOD;
                        }
                    }
                    f[c][i][j] = res;
                }
            }
        }
        return f[k - 1][0][0];
    }

    // 二维前缀和模板（'A' 的 ASCII 码最低位为 1，'.' 的 ASCII 码最低位为 0）
    static class MatrixSum {
        int[][] ps2d;

        public MatrixSum(String[] matrix) {
            int m = matrix.length;
            int n = matrix[0].length();

            ps2d = new int[m + 1][n + 1];
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    ps2d[i][j] = ps2d[i - 1][j] + ps2d[i][j - 1] - ps2d[i - 1][j - 1] + (matrix[i - 1].charAt(j - 1) & 1);
                }
            }
        }

        private int sumRegion(int x1, int y1, int x2, int y2) {
            return ps2d[x2 + 1][y2 + 1] - ps2d[x2 + 1][y1] - ps2d[x1][y2 + 1] + ps2d[x1][y1];
        }
    }
}
/*
1444. 切披萨的方案数
https://leetcode.cn/problems/number-of-ways-of-cutting-a-pizza/description/

给你一个 rows x cols 大小的矩形披萨和一个整数 k ，矩形包含两种字符： 'A' （表示苹果）和 '.' （表示空白格子）。你需要切披萨 k-1 次，得到 k 块披萨并送给别人。
切披萨的每一刀，先要选择是向垂直还是水平方向切，再在矩形的边界上选一个切的位置，将披萨一分为二。如果垂直地切披萨，那么需要把左边的部分送给一个人，如果水平地切，那么需要把上面的部分送给一个人。在切完最后一刀后，需要把剩下来的一块送给最后一个人。
请你返回确保每一块披萨包含 至少 一个苹果的切披萨方案数。由于答案可能是个很大的数字，请你返回它对 10^9 + 7 取余的结果。
提示：
1 <= rows, cols <= 50
rows == pizza.length
cols == pizza[i].length
1 <= k <= 10
pizza 只包含字符 'A' 和 '.' 。

二维前缀和 + 动态规划。
https://leetcode.cn/problems/number-of-ways-of-cutting-a-pizza/solutions/2392051/ji-bai-100cong-di-gui-dao-di-tui-dao-you-dxz5/
时间复杂度 O(kmn(m+n))。
相似题目: 427. 建立四叉树
https://leetcode.cn/problems/construct-quad-tree/description/
 */