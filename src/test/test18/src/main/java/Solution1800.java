public class Solution1800 {
    public int maxAscendingSum(int[] nums) {
        int sum = nums[0];
        int max = sum;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                sum += nums[i];
            } else {
                sum = nums[i];
            }
            max = Math.max(max, sum);
        }
        return max;
    }
}
/*
1800. 最大升序子数组和
https://leetcode.cn/problems/maximum-ascending-subarray-sum/

给你一个正整数组成的数组 nums ，返回 nums 中一个 升序 子数组的最大可能元素和。
子数组是数组中的一个连续数字序列。
已知子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，若对所有 i（l <= i < r），numsi < numsi+1 都成立，则称这一子数组为 升序 子数组。注意，大小为 1 的子数组也视作 升序 子数组。
提示：
1 <= nums.length <= 100
1 <= nums[i] <= 100

贪心
 */