public class Solution2874 {
    public long maximumTripletValue(int[] nums) {
        long maxI = 0;
        long maxIsubj = 0;
        long ans = 0;
        for (int x : nums) {
            ans = Math.max(ans, maxIsubj * x);
            maxIsubj = Math.max(maxIsubj, maxI - x);
            maxI = Math.max(maxI, x);
        }
        return ans;
    }
}
/*
2874. 有序三元组中的最大值 II
https://leetcode.cn/problems/maximum-value-of-an-ordered-triplet-ii/description/

第 365 场周赛 T2。

给你一个下标从 0 开始的整数数组 nums 。
请你从所有满足 i < j < k 的下标三元组 (i, j, k) 中，找出并返回下标三元组的最大值。如果所有满足条件的三元组的值都是负数，则返回 0 。
下标三元组 (i, j, k) 的值等于 (nums[i] - nums[j]) * nums[k] 。
提示：
3 <= nums.length <= 10^5
1 <= nums[i] <= 10^6

枚举 k
时间复杂度 O(n)
 */