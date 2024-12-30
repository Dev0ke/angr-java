import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution1975 {
    public long maxMatrixSum(int[][] matrix) {
        int matrixM = matrix.length;
        int matrixN = matrix[0].length;

        // 负数或零
        List<Integer> negativeOrZeroList = new ArrayList<>();
        // 最小的正数
        int minPositive = Integer.MAX_VALUE;
        long cnt = 0;
        for (int i = 0; i < matrixM; i++) {
            for (int j = 0; j < matrixN; j++) {
                if (matrix[i][j] > 0) {
                    cnt += matrix[i][j];
                    minPositive = Math.min(minPositive, matrix[i][j]);
                } else {
                    negativeOrZeroList.add(matrix[i][j]);
                }
            }
        }

        // 升序排序
        Collections.sort(negativeOrZeroList);
        int sz = negativeOrZeroList.size();
        if (sz % 2 == 0) {
            for (int i = 0; i < sz; i++) {
                // 将偶数对 负数或零 取反
                cnt += -negativeOrZeroList.get(i);
            }
        } else {
            for (int i = 0; i < sz - 1; i++) {
                // 将偶数对 负数或零 取反
                cnt += -negativeOrZeroList.get(i);
            }
            int lastNum = negativeOrZeroList.get(sz - 1);
            // 若 |-4| > |1| 那么选择 +4-1
            if (-lastNum > minPositive) {
                // 互换
                cnt = cnt + (-lastNum) - minPositive - minPositive;
            } else {
                // 不能互换
                cnt += lastNum;
            }
        }
        return cnt;
    }
}
/*
1975. 最大方阵和
https://leetcode.cn/problems/maximum-matrix-sum/

第 59 场双周赛 T2。

给你一个 n x n 的整数方阵 matrix 。你可以执行以下操作 任意次 ：
- 选择 matrix 中 相邻 两个元素，并将它们都 乘以 -1 。
如果两个元素有 公共边 ，那么它们就是 相邻 的。
你的目的是 最大化 方阵元素的和。请你在执行以上操作之后，返回方阵的 最大 和。
提示：
n == matrix.length == matrix[i].length
2 <= n <= 250
-10^5 <= matrix[i][j] <= 10^5

这意味着我们可以改变偶数对负数的取值，同时存在两种边界场景：
case1: 符号对 0 没有影响，-0 == 0，因此可以将 0 与负数归为一类。
case2: 当负数的绝对值大于最小正数绝对值时，我们可以将其符号进行互换，达到最优解。若 |-4| > |1| 那么选择 +4-1
 */