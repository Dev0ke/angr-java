public class Solution2789 {
    public long maxArrayValue(int[] nums) {
        int n = nums.length;
        long sum = 0, ans = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] <= sum) {
                sum += nums[i];
            } else {
                sum = nums[i];
            }
            ans = Math.max(ans, sum);
        }
        return ans;
    }
}
/*
2789. 合并后数组中的最大元素
https://leetcode.cn/problems/largest-element-in-an-array-after-merge-operations/

第 355 场周赛 T2。

给你一个下标从 0 开始、由正整数组成的数组 nums 。
你可以在数组上执行下述操作 任意 次：
- 选中一个同时满足 0 <= i < nums.length - 1 和 nums[i] <= nums[i + 1] 的整数 i 。将元素 nums[i + 1] 替换为 nums[i] + nums[i + 1] ，并从数组中删除元素 nums[i] 。
返回你可以从最终数组中获得的 最大 元素的值。
提示：
1 <= nums.length <= 10^5
1 <= nums[i] <= 10^6

贪心。后往前枚举
时间复杂度 O(n)
 */