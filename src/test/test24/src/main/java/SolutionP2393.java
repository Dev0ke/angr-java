public class SolutionP2393 {
    public long countSubarrays(int[] nums) {
        int n = nums.length;
        int i = 0;
        long ans = 0;
        while (i < n) {
            // 分组循环
            int st = i;
            for (i++; i < n && nums[i] > nums[i - 1]; i++) {
            }
            long span = i - st;
            ans += (span + 1) * (span) / 2;
        }
        return ans;
    }
}
/*
$2393. 严格递增的子数组个数
https://leetcode.cn/problems/count-strictly-increasing-subarrays/description/

给定一个由 正整数 组成的数组 nums 。
返回 严格递增 顺序的 nums 子数组 的数目。
子数组 是数组的一部分，且是 连续 的。
提示:
1 <= nums.length <= 10^5
1 <= nums[i] <= 10^6

分组循环 + 等差数列求和公式。
时间复杂度 O(n)。
 */