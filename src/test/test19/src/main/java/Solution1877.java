import java.util.Arrays;

public class Solution1877 {
    public int minPairSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int max = 0;
        for (int i = 0; i < n / 2; i++) {
            max = Math.max(max, nums[i] + nums[n - 1 - i]);
        }
        return max;
    }
}
/*
1877. 数组中最大数对和的最小值
https://leetcode.cn/problems/minimize-maximum-pair-sum-in-array/

第 53 双周赛 T2。

一个数对 (a,b) 的 数对和 等于 a + b 。最大数对和 是一个数对数组中最大的 数对和 。
- 比方说，如果我们有数对 (1,5) ，(2,3) 和 (4,4)，最大数对和 为 max(1+5, 2+3, 4+4) = max(6, 5, 8) = 8 。
给你一个长度为 偶数 n 的数组 nums ，请你将 nums 中的元素分成 n / 2 个数对，使得：
- nums 中每个元素 恰好 在 一个 数对中，且
- 最大数对和 的值 最小 。
请你在最优数对划分的方案下，返回最小的 最大数对和 。
提示：
n == nums.length
2 <= n <= 10^5
n 是 偶数 。
1 <= nums[i] <= 10^5

题目要求最小的最大数对和 即 从有序数组的首尾两端求和中取最值
 */