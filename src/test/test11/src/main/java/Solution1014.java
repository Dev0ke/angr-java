public class Solution1014 {
    public int maxScoreSightseeingPair(int[] values) {
        int n = values.length;
        // f[i] 表示 [0, i) 的 (values[i] + i) 最大值
        int[] f = new int[n + 1];
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, f[i] + values[i] - i);
            f[i + 1] = Math.max(f[i], values[i] + i);
        }
        return max;
    }
}
/*
1014. 最佳观光组合
https://leetcode.cn/problems/best-sightseeing-pair/

第 129 场周赛 T3。

给你一个正整数数组 values，其中 values[i] 表示第 i 个观光景点的评分，并且两个景点 i 和 j 之间的 距离 为 j - i。
一对景点（i < j）组成的观光组合的得分为 values[i] + values[j] + i - j ，也就是景点的评分之和 减去 它们两者之间的距离。
返回一对观光景点能取得的最高分。
提示：
2 <= values.length <= 5 * 10^4
1 <= values[i] <= 1000

双指针 动态规划
由于 用例 数值较大，需要将时间复杂度由 O(n^2) 优化到 O(n)
当 i < j 时：
f(i,j) = values[i] + values[j] + i - j == (values[i] + i) + (values[j] - j)
 */