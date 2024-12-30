public class Solution812 {
    public double largestTriangleArea(int[][] points) {
        int n = points.length;
        double max = 0.0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    max = Math.max(max, getTriangleArea(points[i], points[j], points[k]));
                }
            }
        }
        return max;
    }

    private double getTriangleArea(int[] p1, int[] p2, int[] p3) {
        return 0.5 * Math.abs(p1[0] * p2[1] + p2[0] * p3[1] + p3[0] * p1[1] - p1[0] * p3[1] - p2[0] * p1[1] - p3[0] * p2[1]);
    }
}
/*
812. 最大三角形面积
https://leetcode.cn/problems/largest-triangle-area/

给定包含多个点的集合，从其中取三个点组成三角形，返回能组成的最大三角形的面积。
注意:
3 <= points.length <= 50.
不存在重复的点。
 -50 <= points[i][j] <= 50.
结果误差值在 10^-6 以内都认为是正确答案。

三角形面积公式：s = 1/2 * | x1y2 + x2y3 + x3y1 - x1y3 - x2y1 - x3y2 |
时间复杂度 O(n^3)
 */