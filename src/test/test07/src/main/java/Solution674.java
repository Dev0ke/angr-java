public class Solution674 {
    public int findLengthOfLCIS(int[] nums) {
        int max = 1;
        int start = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] >= nums[i]) {
                start = i;
            }
            max = Math.max(max, i - start + 1);
        }
        return max;
    }
}
/*
674. 最长连续递增序列
https://leetcode.cn/problems/longest-continuous-increasing-subsequence/

给定一个未经排序的整数数组，找到最长且 连续递增的子序列，并返回该序列的长度。
连续递增的子序列 可以由两个下标 l 和 r（l < r）确定，如果对于每个 l <= i < r，都有 nums[i] < nums[i + 1] ，那么子序列 [nums[l], nums[l + 1], ..., nums[r - 1], nums[r]] 就是连续递增子序列。
提示：
1 <= nums.length <= 10^4
-109 <= nums[i] <= 10^9

不是子序列，而是子数组。贪心即可。
时间复杂度 O(n)
 */