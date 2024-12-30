import java.util.Arrays;

public class Solution2962 {
    public long countSubarrays(int[] nums, int k) {
        int n = nums.length, l = 0, r = 0;
        int mx = Arrays.stream(nums).max().orElseThrow();
        long ans = 0;
        // 频次大于等于 k 的数目
        int cnt_freqGtK = 0;
        while (r < n) {
            if (nums[r] == mx) cnt_freqGtK++;
            while (cnt_freqGtK >= k) {
                ans += n - r;
                if (nums[l] == mx) cnt_freqGtK--;
                l++;
            }
            r++;
        }
        return ans;
    }
}
/*
2962. 统计最大元素出现至少 K 次的子数组
https://leetcode.cn/problems/count-subarrays-where-max-element-appears-at-least-k-times/description/

第 375 场周赛 T3。

给你一个整数数组 nums 和一个 正整数 k 。
请你统计有多少满足 「 nums 中的 最大 元素」至少出现 k 次的子数组，并返回满足这一条件的子数组的数目。
子数组是数组中的一个连续元素序列。
提示：
1 <= nums.length <= 10^5
1 <= nums[i] <= 10^6
1 <= k <= 10^5

双指针。
时间复杂度 O(n)
 */