public class Solution3000 {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int maxPow = 0;
        int ans = 0;
        for (int[] p : dimensions) {
            int pow = p[0] * p[0] + p[1] * p[1];
            if (maxPow < pow) {
                maxPow = pow;
                ans = p[0] * p[1];
            } else if (maxPow == pow) {
                ans = Math.max(ans, p[0] * p[1]);
            }
        }
        return ans;
    }
}
/*
3000. 对角线最长的矩形的面积
https://leetcode.cn/problems/maximum-area-of-longest-diagonal-rectangle/description/

第 379 场周赛 T1。

给你一个下标从 0 开始的二维整数数组 dimensions。
对于所有下标 i（0 <= i < dimensions.length），dimensions[i][0] 表示矩形 i 的长度，而 dimensions[i][1] 表示矩形 i 的宽度。
返回对角线最 长 的矩形的 面积 。如果存在多个对角线长度相同的矩形，返回面积最 大 的矩形的面积。
提示：
1 <= dimensions.length <= 100
dimensions[i].length == 2
1 <= dimensions[i][0], dimensions[i][1] <= 100

模拟。贪心。
保留 平方数 以免丢失精度。
时间复杂度 O(n)
 */