import java.util.BitSet;

public class Solution2133 {
    public boolean checkValid(int[][] matrix) {
        // n == matrix.length == matrix[i].length
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            BitSet row = new BitSet(n);
            BitSet col = new BitSet(n);
            for (int j = 0; j < n; j++) {
                row.set(matrix[i][j]);
                col.set(matrix[j][i]);
            }
            if (row.cardinality() != n || col.cardinality() != n) {
                return false;
            }
        }
        return true;
    }
}
/*
2133. 检查是否每一行每一列都包含全部整数
https://leetcode.cn/problems/check-if-every-row-and-column-contains-all-numbers/

第 275 场周赛 T1。

对一个大小为 n x n 的矩阵而言，如果其每一行和每一列都包含从 1 到 n 的 全部 整数（含 1 和 n），则认为该矩阵是一个 有效 矩阵。
给你一个大小为 n x n 的整数矩阵 matrix ，请你判断矩阵是否为一个有效矩阵：如果是，返回 true ；否则，返回 false 。
提示：
n == matrix.length == matrix[i].length
1 <= n <= 100
1 <= matrix[i][j] <= n

根据题意模拟。
 */