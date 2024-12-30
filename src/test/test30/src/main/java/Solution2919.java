import java.util.Arrays;

public class Solution2919 {
    private int[] nums;
    private int n, k;
    private long[] memo;

    public long minIncrementOperations(int[] nums, int k) {
        this.nums = nums;
        this.n = nums.length;
        this.k = k;

        memo = new long[n];
        Arrays.fill(memo, -1);
        return dfs(2);
    }

    private long dfs(int i) {
        if (i >= n) return 0;
        if (memo[i] != -1) return memo[i];

        long res = (long) 1e18;
        for (int j = i; j >= i - 2; j--) {
            res = Math.min(res, dfs(j + 3) + Math.max(0, k - nums[j]));
        }
        return memo[i] = res;
    }
}
/*
2919. 使数组变美的最小增量运算数
https://leetcode.cn/problems/minimum-increment-operations-to-make-array-beautiful/

第 369 场周赛 T3。

给你一个下标从 0 开始、长度为 n 的整数数组 nums ，和一个整数 k 。
你可以执行下述 递增 运算 任意 次（可以是 0 次）：
- 从范围 [0, n - 1] 中选则一个下标 i ，并将 nums[i] 的值加 1 。
如果数组中任何长度 大于或等于 3 的子数组，其 最大 元素都大于或等于 k ，则认为数组是一个 美丽数组 。
以整数形式返回使数组变为 美丽数组 需要执行的 最小 递增运算数。
子数组是数组中的一个连续 非空 元素序列。
提示：
3 <= n == nums.length <= 10^5
0 <= nums[i] <= 10^9
0 <= k <= 10^9

记忆化搜索，从下标 2 开始。
时间复杂度 O(n)
 */