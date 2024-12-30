public class Solution209 {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length, l = 0, r = 0, minLen = n + 1;
        int sum = 0;
        while (r < n) {
            sum += nums[r];
            while (sum >= target) {
                minLen = Math.min(minLen, r - l + 1);
                sum -= nums[l];
                l++;
            }
            r++;
        }
        return (minLen == n + 1) ? 0 : minLen;
    }
}
/*
209. 长度最小的子数组
https://leetcode.cn/problems/minimum-size-subarray-sum/

给定一个含有 n 个正整数的数组和一个正整数 target 。
找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 并返回其长度。如果不存在符合条件的子数组，返回 0。
提示：
1 <= target <= 10^9
1 <= nums.length <= 10^5
1 <= nums[i] <= 10^5
进阶：
如果你已经实现 O(n) 时间复杂度的解法, 请尝试设计一个 O(n log(n)) 时间复杂度的解法。

不定长滑动窗口（求最短/最小）
时间复杂度 O(n)
 */