public class Solution1605 {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int m = rowSum.length;
        int n = colSum.length;
        int[][] ans = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int mn = Math.min(rowSum[i], colSum[j]);
                ans[i][j] = mn;
                rowSum[i] -= mn;
                colSum[j] -= mn;
            }
        }
        return ans;
    }
}
/*
1605. 给定行和列的和求可行矩阵
https://leetcode.cn/problems/find-valid-matrix-given-row-and-column-sums/

第 36 场双周赛 T3。

给你两个非负整数数组 rowSum 和 colSum ，其中 rowSum[i] 是二维矩阵中第 i 行元素的和， colSum[j] 是第 j 列元素的和。
换言之你不知道矩阵里的每个元素，但是你知道每一行和每一列的和。
请找到大小为 rowSum.length x colSum.length 的任意 非负整数 矩阵，且该矩阵满足 rowSum 和 colSum 的要求。
请你返回任意一个满足题目要求的二维矩阵，题目保证存在 至少一个 可行矩阵。
提示：
1 <= rowSum.length, colSum.length <= 500
0 <= rowSum[i], colSum[i] <= 10^8
sum(rows) == sum(columns)

贪心。
时间复杂度 O(mn)。
相似题目: 1253. 重构 2 行二进制矩阵
https://leetcode.cn/problems/reconstruct-a-2-row-binary-matrix/description/
 */