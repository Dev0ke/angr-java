import java.util.TreeSet;

public class Solution363 {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int M = matrix.length;
        int N = matrix[0].length;

        int max = Integer.MIN_VALUE;
        // i1 上边界 i2 下边界
        for (int i1 = 0; i1 < M; i1++) {
            int[] sum = new int[N];
            for (int i2 = i1; i2 < M; i2++) {
                // 每列的元素和
                for (int j = 0; j < N; j++) {
                    sum[j] += matrix[i2][j];
                }

                TreeSet<Integer> sumTreeSet = new TreeSet<>();
                sumTreeSet.add(0);
                int preSum = 0;
                for (int s : sum) {
                    preSum += s;
                    // 求小于等于 k 的最大区间和
                    // k + (preSum - k) = preSum
                    // max + ceil(preSum - k) = preSum
                    Integer ceiling = sumTreeSet.ceiling(preSum - k);
                    if (ceiling != null) {
                        max = Math.max(max, preSum - ceiling);
                    }
                    sumTreeSet.add(preSum);
                }
            }
        }
        return max;
    }
}
/*
363. 矩形区域不超过 K 的最大数值和
https://leetcode.cn/problems/max-sum-of-rectangle-no-larger-than-k/

给你一个 m x n 的矩阵 matrix 和一个整数 k ，找出并返回矩阵内部矩形区域的不超过 k 的最大数值和。
题目数据保证总会存在一个数值和不超过 k 的矩形区域。
提示：
m == matrix.length
n == matrix[i].length
1 <= m, n <= 100
-100 <= matrix[i][j] <= 100
-10^5 <= k <= 10^5
进阶：如果行数远大于列数，该如何设计解决方案？

枚举矩形的上下边界，对行的和进行二分。
时间复杂度 O(n^2 mlogm)
如果行数远大于列数，应该枚举矩形的左右边界。
 */