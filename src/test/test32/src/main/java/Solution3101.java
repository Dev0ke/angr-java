public class Solution3101 {
    public long countAlternatingSubarrays(int[] nums) {
        int n = nums.length;
        long ans = 0;
        int i = 0;
        while (i < n) {
            // 分组循环
            int st = i;
            for (i++; i < n && nums[i] != nums[i - 1]; i++) {
            }
            ans += (i - st + 1L) * (i - st) / 2;
        }
        return ans;
    }
}
/*
3101. 交替子数组计数
https://leetcode.cn/problems/count-alternating-subarrays/description/

第 391 场周赛 T3。

给你一个 二进制数组 nums 。
如果一个 子数组 中 不存在 两个 相邻 元素的值 相同 的情况，我们称这样的子数组为 交替子数组 。
返回数组 nums 中交替子数组的数量。
提示：
1 <= nums.length <= 10^5
nums[i] 不是 0 就是 1 。

分组循环
时间复杂度 O(n)
 */