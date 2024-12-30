public class Solution1039 {
    public int minScoreTriangulation(int[] values) {
        int n = values.length;

        // 区间 DP
        int[][] f = new int[n][n];
        // f[i] 从 f[k] 转移过来，所以 i 要倒序枚举
        for (int i = n - 3; i >= 0; i--) {
            // f[i][j] 从 f[i][k] 转移过来，所以 j 要正序枚举
            for (int j = i + 2; j < n; j++) {
                int min = Integer.MAX_VALUE;
                for (int k = i + 1; k < j; k++) {
                    min = Math.min(min, f[i][k] + f[k][j] + values[i] * values[j] * values[k]);
                }
                f[i][j] = min;
            }
        }
        return f[0][n - 1];
    }
}
/*
1039. 多边形三角剖分的最低得分
https://leetcode.cn/problems/minimum-score-triangulation-of-polygon/

你有一个凸的 n 边形，其每个顶点都有一个整数值。给定一个整数数组 values ，其中 values[i] 是第 i 个顶点的值（即 顺时针顺序 ）。
假设将多边形 剖分 为 n - 2 个三角形。对于每个三角形，该三角形的值是顶点标记的乘积，三角剖分的分数是进行三角剖分后所有 n - 2 个三角形的值之和。
返回 多边形进行三角剖分后可以得到的最低分 。
提示：
n == values.length
3 <= n <= 50
1 <= values[i] <= 100

区间 DP
时间复杂度 O(n^3)
空间复杂度 O(n^2)
 */