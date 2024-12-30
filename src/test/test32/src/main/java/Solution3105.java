public class Solution3105 {
    public int longestMonotonicSubarray(int[] nums) {
        int n = nums.length;
        int ans = 0;

        int i = 0;
        while (i < n) {
            int st = i;
            // 分组循环
            for (i++; i < n && nums[i - 1] < nums[i]; i++) {
            }
            ans = Math.max(ans, i - st);
        }

        i = 0;
        while (i < n) {
            int st = i;
            // 分组循环
            for (i++; i < n && nums[i - 1] > nums[i]; i++) {
            }
            ans = Math.max(ans, i - st);
        }
        return ans;
    }
}
/*
3105. 最长的严格递增或递减子数组
https://leetcode.cn/problems/longest-strictly-increasing-or-strictly-decreasing-subarray/description/

第 392 场周赛 T1。

给你一个整数数组 nums 。
返回数组 nums 中 严格递增 或 严格递减 的最长非空子数组的长度。
提示：
1 <= nums.length <= 50
1 <= nums[i] <= 50

2024 清明假期回来第一个调休工作日的周赛。
正序 和 倒序 分组循环。
时间复杂度 O(n)。
 */