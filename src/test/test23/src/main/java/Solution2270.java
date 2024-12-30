public class Solution2270 {
    public int waysToSplitArray(int[] nums) {
        int n = nums.length;

        // 前缀和
        long[] preSum = new long[n + 1];
        for (int i = 0; i < n; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }

        int cnt = 0;
        for (int i = 0; i < n - 1; i++) {
            long leftSum = preSum[i + 1] - preSum[0];
            long rightSum = preSum[n] - leftSum;
            if (leftSum >= rightSum) {
                cnt++;
            }
        }
        return cnt;
    }
}
/*
2270. 分割数组的方案数
https://leetcode.cn/problems/number-of-ways-to-split-array/

第 78 场双周赛 T2。

给你一个下标从 0 开始长度为 n 的整数数组 nums 。
如果以下描述为真，那么 nums 在下标 i 处有一个 合法的分割 ：
- 前 i + 1 个元素的和 大于等于 剩下的 n - i - 1 个元素的和。
- 下标 i 的右边 至少有一个 元素，也就是说下标 i 满足 0 <= i < n - 1 。
请你返回 nums 中的 合法分割 方案数。
提示：
2 <= nums.length <= 10^5
-10^5 <= nums[i] <= 10^5

前缀和+枚举。
 */