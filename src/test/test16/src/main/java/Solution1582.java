public class Solution1582 {
    public int numSpecial(int[][] mat) {
        int row = mat.length;
        int col = mat[0].length;

        int[] rowSum = new int[row];
        int[] colSum = new int[col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (mat[i][j] == 1) {
                    rowSum[i]++;
                    colSum[j]++;
                }
            }
        }

        int cnt = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (mat[i][j] == 1 && rowSum[i] == 1 && colSum[j] == 1) {
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
/*
1582. 二进制矩阵中的特殊位置
https://leetcode.cn/problems/special-positions-in-a-binary-matrix/

给你一个大小为 rows x cols 的矩阵 mat，其中 mat[i][j] 是 0 或 1，请返回 矩阵 mat 中特殊位置的数目 。
特殊位置 定义：如果 mat[i][j] == 1 并且第 i 行和第 j 列中的所有其他元素均为 0（行和列的下标均 从 0 开始 ），则位置 (i, j) 被称为特殊位置。
提示：
rows == mat.length
cols == mat[i].length
1 <= rows, cols <= 100
mat[i][j] 是 0 或 1

行列分别求和，判断每个 mat[i][j]==1 的行和列是否为 1 即可。
时间复杂度 O(mn)
空间复杂度 O(m+n)
 */