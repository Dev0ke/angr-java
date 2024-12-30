public class Solution1749 {
    public int maxAbsoluteSum(int[] nums) {
        int ans = 0, fMax = 0, fMin = 0;
        for (int v : nums) {
            fMax = Math.max(fMax, 0) + v;
            fMin = Math.min(fMin, 0) + v;
            ans = Math.max(ans, Math.max(fMax, -fMin));
        }
        return ans;
    }
}
/*
1749. 任意子数组和的绝对值的最大值
https://leetcode.cn/problems/maximum-absolute-sum-of-any-subarray/description/

给你一个整数数组 nums 。一个子数组 [numsl, numsl+1, ..., numsr-1, numsr] 的 和的绝对值 为 abs(numsl + numsl+1 + ... + numsr-1 + numsr) 。
请你找出 nums 中 和的绝对值 最大的任意子数组（可能为空），并返回该 最大值 。
abs(x) 定义如下：
- 如果 x 是负整数，那么 abs(x) = -x 。
- 如果 x 是非负整数，那么 abs(x) = x 。
提示：
1 <= nums.length <= 10^5
-10^4 <= nums[i] <= 10^4

动态规划。
时间复杂度 O(n)。
相似题目: 53. 最大子数组和
https://leetcode.cn/problems/maximum-subarray/
 */