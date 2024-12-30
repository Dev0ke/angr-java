public class SolutionP2128 {
    public boolean removeOnes(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 1; i < m; i++) {
            int diff = 0;
            for (int j = 0; j < n; j++) {
                diff += grid[i][j] ^ grid[0][j];
            }
            if (diff != 0 && diff != n) {
                return false;
            }
        }
        return true;
    }
}
/*
$2128. 通过翻转行或列来去除所有的 1
https://leetcode.cn/problems/remove-all-ones-with-row-and-column-flips/description/

给你一个大小为 m x n 的二进制矩阵 grid。
每次操作，你可以选择 任意 一行 或者 一列，然后将其中的所有值翻转（0 变成 1， 1变成 0）。
如果经过 任意次 操作，你能将矩阵中所有的 1 去除，那么返回 true；否则返回 false。
提示:
m == grid.length
n == grid[i].length
1 <= m, n <= 300
grid[i][j] 是 0 或者 1.

只需要判断下面每一行是否跟第一行相等或者异或相等。
相似题目: $2174. 通过翻转行或列来去除所有的 1 II
https://leetcode.cn/problems/remove-all-ones-with-row-and-column-flips-ii/description/
 */