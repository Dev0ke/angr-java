public class Solution2906 {
    public int[][] constructProductMatrix(int[][] grid) {
        int mod = 12345;
        int n = grid.length;
        int m = grid[0].length;

        int[] L = new int[n * m];
        int[] R = new int[n * m];
        L[0] = 1;
        for (int i = 1; i < n * m; i++) {
            int x = (i - 1) / m, y = (i - 1) % m;
            L[i] = grid[x][y] % mod * L[i - 1] % mod;
        }
        R[n * m - 1] = 1;
        for (int i = n * m - 2; i >= 0; i--) {
            int x = (i + 1) / m, y = (i + 1) % m;
            R[i] = grid[x][y] % mod * R[i + 1] % mod;
        }

        int[][] ans = new int[n][m];
        for (int i = 0; i < n * m; i++) {
            int x = i / m, y = i % m;
            ans[x][y] = L[i] * R[i] % mod;
        }
        return ans;
    }
}
/*
2906. 构造乘积矩阵
https://leetcode.cn/problems/construct-product-matrix/

第 367 场周赛 T4。

给你一个下标从 0 开始、大小为 n * m 的二维整数矩阵 grid ，定义一个下标从 0 开始、大小为 n * m 的的二维矩阵 p。如果满足以下条件，则称 p 为 grid 的 乘积矩阵 ：
- 对于每个元素 p[i][j] ，它的值等于除了 grid[i][j] 外所有元素的乘积。乘积对 12345 取余数。
返回 grid 的乘积矩阵。
提示：
1 <= n == grid.length <= 10^5
1 <= m == grid[i].length <= 10^5
2 <= n * m <= 10^5
1 <= grid[i][j] <= 10^9

前后缀分解，注意 逆元 是错误解法。因为 0 不存在逆元。
时间复杂度 O(nm)
相似题目: 238. 除自身以外数组的乘积
https://leetcode.cn/problems/product-of-array-except-self/
 */