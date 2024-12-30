public class Solution2765 {
    public int alternatingSubarray(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int delta = 1;
            int j = i + 1;
            for (; j < n; j++) {
                if (nums[j] - nums[j - 1] != delta) break;
                delta *= -1;
            }
            ans = Math.max(ans, j - i);
        }
        // m 大于 1
        return ans == 1 ? -1 : ans;
    }
}
/*
2765. 最长交替子序列
https://leetcode.cn/problems/longest-alternating-subarray/

第 108 场双周赛 T1。

给你一个下标从 0 开始的整数数组 nums 。如果 nums 中长度为 m 的子数组 s 满足以下条件，我们称它是一个交替子序列：
- m 大于 1 。
- s1 = s0 + 1 。
- 下标从 0 开始的子数组 s 与数组 [s0, s1, s0, s1,...,s(m-1) % 2] 一样。也就是说，s1 - s0 = 1 ，s2 - s1 = -1 ，s3 - s2 = 1 ，s4 - s3 = -1 ，以此类推，直到 s[m - 1] - s[m - 2] = (-1)m 。
请你返回 nums 中所有 交替 子数组中，最长的长度，如果不存在交替子数组，请你返回 -1 。
子数组是一个数组中一段连续 非空 的元素序列。
提示：
2 <= nums.length <= 100
1 <= nums[i] <= 10^4

时间复杂度 O(n^2)
另有 O(n) 的解法
 */