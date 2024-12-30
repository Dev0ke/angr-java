public class Solution1567 {
    public int getMaxLen(int[] nums) {
        int len = nums.length;
        int[] positive = new int[len];
        int[] negative = new int[len];
        if (nums[0] > 0) {
            positive[0] = 1;
        } else if (nums[0] < 0) {
            negative[0] = 1;
        }
        int maxLen = positive[0];
        for (int i = 1; i < len; i++) {
            int prePositive = positive[i - 1] + 1;
            int preNegative = negative[i - 1] > 0 ? negative[i - 1] + 1 : 0;
            if (nums[i] > 0) {
                positive[i] = prePositive;
                negative[i] = preNegative;
            } else if (nums[i] < 0) {
                positive[i] = preNegative;
                negative[i] = prePositive;
            } else {
                positive[i] = 0;
                negative[i] = 0;
            }
            maxLen = Math.max(maxLen, positive[i]);
        }
        return maxLen;
    }
}
/*
1567. 乘积为正数的最长子数组长度
https://leetcode.cn/problems/maximum-length-of-subarray-with-positive-product/

第 204 场周赛 T2。

给你一个整数数组 nums，请你求出乘积为正数的最长子数组的长度。
一个数组的子数组是由原数组中零个或者更多个连续数字组成的数组。
请你返回乘积为正数的最长子数组长度。
提示：
1 <= nums.length <= 10^5
-10^9 <= nums[i] <= 10^9

动态规划。
 */