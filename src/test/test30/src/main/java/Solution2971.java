import java.util.Arrays;

public class Solution2971 {
    public long largestPerimeter(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        long[] ps = new long[n + 1];
        for (int i = 0; i < n; i++) {
            ps[i + 1] = ps[i] + nums[i];
        }
        for (int k = n - 1; k >= 0; k--) {
            if (nums[k] >= ps[k]) {
                continue;
            }
            return ps[k + 1];
        }
        return -1;
    }
}
/*
2971. 找到最大周长的多边形
https://leetcode.cn/problems/find-polygon-with-the-largest-perimeter/description/

第 120 场双周赛 T2。

给你一个长度为 n 的 正 整数数组 nums 。
多边形 指的是一个至少有 3 条边的封闭二维图形。多边形的 最长边 一定 小于 所有其他边长度之和。
如果你有 k （k >= 3）个 正 数 a1，a2，a3, ...，ak 满足 a1 <= a2 <= a3 <= ... <= ak 且 a1 + a2 + a3 + ... + ak-1 > ak ，那么 一定 存在一个 k 条边的多边形，每条边的长度分别为 a1 ，a2 ，a3 ， ...，ak 。
一个多边形的 周长 指的是它所有边之和。
请你返回从 nums 中可以构造的 多边形 的 最大周长 。如果不能构造出任何多边形，请你返回 -1 。
提示：
3 <= n <= 10^5
1 <= nums[i] <= 10^9

排序 + 前缀和 + 枚举
时间复杂度 O(nlogn)
 */