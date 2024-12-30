public class Solution1493 {
    public int longestSubarray(int[] nums) {
        int n = nums.length, l = 0, r = 0, ans = 0;
        int cnt_0 = 0; // 0 的数量
        while (r < n) {
            if (nums[r] == 0) cnt_0++;
            while (cnt_0 > 1) {
                if (nums[l] == 0) cnt_0--;
                l++;
            }
            ans = Math.max(ans, r - l + 1);
            r++;
        }
        // 需要删掉一个元素
        return ans - 1;
    }
}
/*
1493. 删掉一个元素以后全为 1 的最长子数组
https://leetcode.cn/problems/longest-subarray-of-1s-after-deleting-one-element/description/

给你一个二进制数组 nums ，你需要从中删掉一个元素。
请你在删掉元素的结果数组中，返回最长的且只包含 1 的非空子数组的长度。
如果不存在这样的子数组，请返回 0 。
提示：
1 <= nums.length <= 10^5
nums[i] 要么是 0 要么是 1 。

不定长滑动窗口（求最长/最大）。至多含 1 个 0 的最大长度。
时间复杂度 O(n)
 */