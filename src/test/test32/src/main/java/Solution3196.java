public class Solution3196 {
    public long maximumTotalCost(int[] nums) {
        int n = nums.length;
        // f[i] 取正，g[i] 取反
        long[] f = new long[n];
        long[] g = new long[n];
        f[0] = nums[0];
        g[0] = nums[0];
        for (int i = 1; i < n; i++) {
            f[i] = Math.max(f[i - 1], g[i - 1]) + nums[i];
            g[i] = f[i - 1] + Math.abs(nums[i]);
        }
        return Math.max(f[n - 1], g[n - 1]);
    }
}
/*
3196. 最大化子数组的总成本
https://leetcode.cn/problems/maximize-total-cost-of-alternating-subarrays/description/

第 403 场周赛 T3。

给你一个长度为 n 的整数数组 nums。
子数组 nums[l..r]（其中 0 <= l <= r < n）的 成本 定义为：
cost(l, r) = nums[l] - nums[l + 1] + ... + nums[r] * (−1)r − l
你的任务是将 nums 分割成若干子数组，使得所有子数组的成本之和 最大化，并确保每个元素 正好 属于一个子数组。
具体来说，如果 nums 被分割成 k 个子数组，且分割点为索引 i1, i2, ..., ik − 1（其中 0 <= i1 < i2 < ... < ik - 1 < n - 1），则总成本为：
cost(0, i1) + cost(i1 + 1, i2) + ... + cost(ik − 1 + 1, n − 1)
返回在最优分割方式下的子数组成本之和的最大值。
注意：如果 nums 没有被分割，即 k = 1，则总成本即为 cost(0, n - 1)。
提示：
1 <= nums.length <= 10^5
-10^9 <= nums[i] <= 10^9

动态规划。
时间复杂度 O(n)。
可用滚动数组优化空间复杂度。
 */