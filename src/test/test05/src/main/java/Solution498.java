public class Solution498 {
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        int[] ans = new int[m * n];
        int j = 0;
        for (int i = 0; i < m + n - 1; i++) {
            if (i % 2 == 1) {
                // 左上到右下
                int x = i < n ? 0 : i - n + 1;
                int y = i < n ? i : n - 1;
                while (x < m && y >= 0) {
                    ans[j++] = mat[x++][y--];
                }
            } else {
                int x = i < m ? i : m - 1;
                int y = i < m ? 0 : i - m + 1;
                while (x >= 0 && y < n) {
                    ans[j++] = mat[x--][y++];
                }
            }
        }
        return ans;
    }
}
/*
498. 对角线遍历
https://leetcode.cn/problems/diagonal-traverse/description/

给你一个大小为 m x n 的矩阵 mat ，请以对角线遍历的顺序，用一个数组返回这个矩阵中的所有元素。
提示：
m == mat.length
n == mat[i].length
1 <= m, n <= 10^4
1 <= m * n <= 10^4
-10^5 <= mat[i][j] <= 10^5

模拟。
时间复杂度 O(mn)。
 */