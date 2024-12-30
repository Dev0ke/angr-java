import java.util.Arrays;

public class Solution2946 {
    public boolean areSimilar(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] newmat = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i % 2 == 0) {
                    newmat[i][j] = mat[i][(j + k) % n];
                } else {
                    newmat[i][j] = mat[i][((j - k) % n + n) % n];
                }
            }
        }
        return Arrays.deepEquals(mat, newmat);
    }
}
/*
2946. 循环移位后的矩阵相似检查
https://leetcode.cn/problems/matrix-similarity-after-cyclic-shifts/description/

第 373 场周赛 T1。

给你一个下标从 0 开始且大小为 m x n 的整数矩阵 mat 和一个整数 k 。请你将矩阵中的 奇数 行循环 右 移 k 次，偶数 行循环 左 移 k 次。
如果初始矩阵和最终矩阵完全相同，则返回 true ，否则返回 false 。
提示：
1 <= mat.length <= 25
1 <= mat[i].length <= 25
1 <= mat[i][j] <= 25
1 <= k <= 50

虽然题目样例看不出来是啥时候左移，但是：
如果左移 k 次可以让数组相等，那么右移 k 次也可以让数组相等
 */