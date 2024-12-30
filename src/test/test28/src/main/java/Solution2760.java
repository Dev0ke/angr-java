public class Solution2760 {
    public int longestAlternatingSubarray(int[] nums, int threshold) {
        int n = nums.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] % 2 == 1 || nums[i] > threshold) {
                continue;
            }

            int res = 0;
            int j;
            for (j = i + 1; j < n; j++) {
                if (nums[j] % 2 != nums[j - 1] % 2 && nums[j] <= threshold) {
                    res++;
                } else {
                    break;
                }
            }
            j--;
            if (j < n && nums[j] <= threshold) {
                res++;
            }
            ans = Math.max(ans, res);
        }
        return ans;
    }
}
/*
2760. 最长奇偶子数组
https://leetcode.cn/problems/longest-even-odd-subarray-with-threshold/

第 352 场周赛 T1。

给你一个下标从 0 开始的整数数组 nums 和一个整数 threshold 。
请你从 nums 的子数组中找出以下标 l 开头、下标 r 结尾 (0 <= l <= r < nums.length) 且满足以下条件的 最长子数组 ：
- nums[l] % 2 == 0
- 对于范围 [l, r - 1] 内的所有下标 i ，nums[i] % 2 != nums[i + 1] % 2
- 对于范围 [l, r] 内的所有下标 i ，nums[i] <= threshold
以整数形式返回满足题目要求的最长子数组的长度。
注意：子数组 是数组中的一个连续非空元素序列。
提示：
1 <= nums.length <= 100
1 <= nums[i] <= 100
1 <= threshold <= 100

模拟
时间复杂度 O(n^2)
 */