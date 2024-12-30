public class Solution2401 {
    public int longestNiceSubarray(int[] nums) {
        int n = nums.length, l = 0, r = 0, ans = 0;
        int bitOr = 0; // 按位或
        while (r < n) {
            // 如果 bitOr 与新加入的 nums[r] 有交集，则不断从 bitOr 去掉 nums[l]，至多交集为空
            while ((bitOr & nums[r]) != 0) {
                bitOr ^= nums[l];
                l++;
            }
            bitOr |= nums[r];
            ans = Math.max(ans, r - l + 1);
            r++;
        }
        return ans;
    }
}
/*
2401. 最长优雅子数组
https://leetcode.cn/problems/longest-nice-subarray/

第 309 场周赛 T3。

给你一个由 正 整数组成的数组 nums 。
如果 nums 的子数组中位于 不同 位置的每对元素按位 与（AND）运算的结果等于 0 ，则称该子数组为 优雅 子数组。
返回 最长 的优雅子数组的长度。
子数组 是数组中的一个 连续 部分。
注意：长度为 1 的子数组始终视作优雅子数组。
提示：
1 <= nums.length <= 10^5
1 <= nums[i] <= 10^9

不定长滑动窗口（求最长/最大）
或运算 | 可以将一个状态加入到集合中
异或运算 ^ 可以将一个状态从集合中剔除
时间复杂度 O(n)
 */