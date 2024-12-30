public class SolutionP2036 {
    public long maximumAlternatingSubarraySum(int[] nums) {
        int n = nums.length;
        // f[i][0] 表示以 i 结尾的子数组最后操作为 - 的结果
        // f[i][1] 表示以 i 结尾的子数组最后操作为 + 的结果
        long[][] f = new long[n][2];
        f[0][1] = nums[0];
        f[0][0] = 0;
        long ans = nums[0];
        for (int i = 1; i < n; i++) {
            f[i][0] = f[i - 1][1] - nums[i];
            f[i][1] = Math.max(f[i - 1][0] + nums[i], nums[i]);
            ans = Math.max(ans, Math.max(f[i][0], f[i][1]));
        }
        return ans;
    }
}
/*
$2036. 最大交替子数组和
https://leetcode.cn/problems/maximum-alternating-subarray-sum/description/

子数组是以0下标开始的数组的连续非空子序列，从 i 到 j（0 <= i <= j < nums.length）的 子数组交替和 被定义为 nums[i] - nums[i+1] + nums[i+2] - ... +/- nums[j] 。
给定一个以0下标开始的整数数组nums，返回它所有可能的交替子数组和的最大值。
提示：
1 <= nums.length <= 10^5
-10^5 <= nums[i] <= 10^5

动态规划。
时间复杂度 O(n)。
 */