public class Solution643 {
    public double findMaxAverage(int[] nums, int k) {
        int n = nums.length;
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        int maxSum = sum;
        for (int i = k; i < n; i++) {
            sum -= nums[i - k];
            sum += nums[i];
            maxSum = Math.max(maxSum, sum);
        }
        return (double) maxSum / k;
    }
}
/*
643. 子数组最大平均数 I
https://leetcode.cn/problems/maximum-average-subarray-i/

给你一个由 n 个元素组成的整数数组 nums 和一个整数 k 。
请你找出平均数最大且 长度为 k 的连续子数组，并输出该最大平均数。
任何误差小于 10^-5 的答案都将被视为正确答案。
提示：
n == nums.length
1 <= k <= n <= 10^5
-10^4 <= nums[i] <= 10^4

定长滑动窗口。
时间复杂度 O(n)
 */
