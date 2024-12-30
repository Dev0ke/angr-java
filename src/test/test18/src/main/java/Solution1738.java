import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Solution1738 {
    public int kthLargestValue(int[][] matrix, int k) {
        int M = matrix.length;
        int N = matrix[0].length;

        List<Integer> resList = new ArrayList<>();
        // "二维前缀和"
        int[][] preSum2d = new int[M + 1][N + 1];
        for (int i = 1; i <= M; i++) {
            for (int j = 1; j <= N; j++) {
                //
                preSum2d[i][j] = preSum2d[i - 1][j] ^ preSum2d[i][j - 1] ^ preSum2d[i - 1][j - 1] ^ matrix[i - 1][j - 1];
                resList.add(preSum2d[i][j]);
            }
        }
        resList.sort(Comparator.reverseOrder());
        return resList.get(k - 1);
    }
}
/*
1738. 找出第 K 大的异或坐标值
https://leetcode.cn/problems/find-kth-largest-xor-coordinate-value/

给你一个二维矩阵 matrix 和一个整数 k ，矩阵大小为 m x n 由非负整数组成。
矩阵中坐标 (a, b) 的 值 可由对所有满足 0 <= i <= a < m 且 0 <= j <= b < n 的元素 matrix[i][j]（下标从 0 开始计数）执行异或运算得到。
请你找出 matrix 的所有坐标中第 k 大的值（k 的值从 1 开始计数）。
提示：
m == matrix.length
n == matrix[i].length
1 <= m, n <= 1000
0 <= matrix[i][j] <= 10^6
1 <= k <= m * n

二维前缀和 + 排序
时间复杂度 O(mnlog(mn))。
 */