public class Solution2735 {
    public long minCost(int[] nums, int x) {
        int n = nums.length;

        // f[i][j] 表示第 i 个物品，操作 x 次的最小成本
        long[][] f = new long[n][n];
        for (int i = 0; i < n; i++) {
            f[i][0] = nums[i];
        }
        for (int i = 0; i < n; i++) {
            // 第 j 轮
            for (int j = 1; j < n; j++) {
                f[i][j] = Math.min(f[i][j - 1], nums[(i + j) % n]);
            }
        }

        long ans = Long.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            long sum = (long) x * j;
            for (int i = 0; i < n; i++) {
                sum += f[i][j];
            }
            ans = Math.min(ans, sum);
        }
        return ans;
    }
}
/*
2735. 收集巧克力
https://leetcode.cn/problems/collecting-chocolates/

第 349 场周赛 T3。

给你一个长度为 n 、下标从 0 开始的整数数组 nums ，表示收集不同巧克力的成本。每个巧克力都对应一个不同的类型，最初，位于下标 i 的巧克力就对应第 i 个类型。
在一步操作中，你可以用成本 x 执行下述行为：
- 同时对于所有下标 0 <= i < n - 1 进行以下操作， 将下标 i 处的巧克力的类型更改为下标 (i + 1) 处的巧克力对应的类型。如果 i == n - 1 ，则该巧克力的类型将会变更为下标 0 处巧克力对应的类型。
假设你可以执行任意次操作，请返回收集所有类型巧克力所需的最小成本。
提示：
1 <= nums.length <= 1000
1 <= nums[i] <= 10^9
1 <= x <= 10^9

预处理 + 枚举
预处理出 第 i 个物品，操作 x 次的最小成本，然后枚举 x 次操作，取最小值。
时间复杂度 O(n^2)
 */