public class Solution2875 {
    public int minSizeSubarray(int[] nums, int target) {
        long tot = 0;
        for (int x : nums) {
            tot += x;
        }
        int n = nums.length;
        // round * n 长度
        int len = (int) (target / tot * n);
        target %= tot;
        int ans = n;
        int l = 0, r = 0;
        int sum = 0;
        while (r < n * 2) {
            sum += nums[r % n];
            while (sum > target) {
                sum -= nums[l % n];
                l++;
            }
            if (sum == target) {
                ans = Math.min(ans, r - l + 1);
            }
            r++;
        }
        return ans == n ? -1 : ans + len;
    }
}
/*
2875. 无限数组的最短子数组
https://leetcode.cn/problems/minimum-size-subarray-in-infinite-array/description/

第 365 场周赛 T3。

给你一个下标从 0 开始的数组 nums 和一个整数 target 。
下标从 0 开始的数组 infinite_nums 是通过无限地将 nums 的元素追加到自己之后生成的。
请你从 infinite_nums 中找出满足 元素和 等于 target 的 最短 子数组，并返回该子数组的长度。如果不存在满足条件的子数组，返回 -1 。
提示：
1 <= nums.length <= 10^5
1 <= nums[i] <= 10^5
1 <= target <= 10^9

取模，滑动窗口
时间复杂度 O(n)
 */