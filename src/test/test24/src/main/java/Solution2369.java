public class Solution2369 {
    public boolean validPartition(int[] nums) {
        int len = nums.length;
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;
        for (int i = 0; i < len; i++) {
            if (dp[i]) {
                if (i + 1 < len && nums[i + 1] == nums[i]) {
                    dp[i + 2] = true;
                }
                if (i + 2 < len && nums[i + 2] == nums[i + 1] && nums[i + 1] == nums[i]) {
                    dp[i + 3] = true;
                }
                if (i + 2 < len && nums[i + 2] == nums[i + 1] + 1 && nums[i + 1] == nums[i] + 1) {
                    dp[i + 3] = true;
                }
            }
        }
        return dp[len];
    }
}
/*
2369. 检查数组是否存在有效划分
https://leetcode.cn/problems/check-if-there-is-a-valid-partition-for-the-array/

第 305 场周赛 T3。

给你一个下标从 0 开始的整数数组 nums ，你必须将数组划分为一个或多个 连续 子数组。
如果获得的这些子数组中每个都能满足下述条件 之一 ，则可以称其为数组的一种 有效 划分：
1.子数组 恰 由 2 个相等元素组成，例如，子数组 [2,2] 。
2.子数组 恰 由 3 个相等元素组成，例如，子数组 [4,4,4] 。
3.子数组 恰 由 3 个连续递增元素组成，并且相邻元素之间的差值为 1 。例如，子数组 [3,4,5] ，但是子数组 [1,3,5] 不符合要求。
如果数组 至少 存在一种有效划分，返回 true ，否则，返回 false 。

动态规划。
时间复杂度：O(n)
 */