public class Solution1572 {
    public int diagonalSum(int[][] mat) {
        // 正方形矩阵 mat n*n
        int n = mat.length;
        int cnt = 0;
        // 主对角线 + 副对角线
        for (int i = 0; i < n; i++) {
            cnt += mat[i][i];
            cnt += mat[i][n - 1 - i];
        }
        // 奇数长度减去重复部分
        if (n % 2 == 1) {
            cnt -= mat[n / 2][n / 2];
        }
        return cnt;
    }
}
/*
1572. 矩阵对角线元素的和
https://leetcode.cn/problems/matrix-diagonal-sum/

第 34 场双周赛 T1。

给你一个正方形矩阵 mat，请你返回矩阵对角线元素的和。
请你返回在矩阵主对角线上的元素和副对角线上且不在主对角线上元素的和。
提示：
n == mat.length == mat[i].length
1 <= n <= 100
1 <= mat[i][j] <= 100

模拟。
 */