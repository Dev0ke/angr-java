public class Solution2680 {
    public long maximumOr(int[] nums, int k) {
        int n = nums.length;

        // 前后缀分解
        int[] pre = new int[n + 1];
        int[] suf = new int[n + 1];
        for (int i = 0; i < n; i++) {
            pre[i + 1] = pre[i] | nums[i];
            suf[i + 1] = suf[i] | nums[n - 1 - i];
        }

        long ans = 0;
        for (int i = 0; i < n; i++) {
            long xorsum = ((long) nums[i] << k) | pre[i] | suf[n - 1 - i];
            ans = Math.max(ans, xorsum);
        }
        return ans;
    }
}
/*
2680. 最大或值
https://leetcode.cn/problems/maximum-or/

第 104 场双周赛 T3。

给你一个下标从 0 开始长度为 n 的整数数组 nums 和一个整数 k 。每一次操作中，你可以选择一个数并将它乘 2 。
你最多可以进行 k 次操作，请你返回 nums[0] | nums[1] | ... | nums[n - 1] 的最大值。
a | b 表示两个整数 a 和 b 的 按位或 运算。
提示：
1 <= nums.length <= 10^5
1 <= nums[i] <= 10^9
1 <= k <= 15

前后缀分解。
时间复杂度 O(n)
 */