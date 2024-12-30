import java.util.Arrays;

public class Solution3040 {
    private int[] nums;
    private int n;

    public int maxOperations(int[] nums) {
        this.nums = nums;
        this.n = nums.length;
        int ans1 = f(nums[0] + nums[1]);
        int ans2 = f(nums[n - 2] + nums[n - 1]);
        int ans3 = f(nums[0] + nums[n - 1]);
        return Math.max(ans1, Math.max(ans2, ans3));
    }

    private int[][] memo;

    private int f(int sum) {
        memo = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(memo[i], -1);
        }
        return dp(0, n - 1, sum);
    }

    private int dp(int i, int j, int sum) {
        if (i >= j) return 0;
        if (memo[i][j] != -1) return memo[i][j];
        int res = 0;
        if (nums[i] + nums[i + 1] == sum) res = Math.max(res, dp(i + 2, j, sum) + 1);
        if (nums[j - 1] + nums[j] == sum) res = Math.max(res, dp(i, j - 2, sum) + 1);
        if (nums[i] + nums[j] == sum) res = Math.max(res, dp(i + 1, j - 1, sum) + 1);
        return memo[i][j] = res;
    }
}
/*
3040. 相同分数的最大操作数目 II
https://leetcode.cn/problems/maximum-number-of-operations-with-the-same-score-ii/description/

第 124 场双周赛 T3。

给你一个整数数组 nums ，如果 nums 至少 包含 2 个元素，你可以执行以下操作中的 任意 一个：
- 选择 nums 中最前面两个元素并且删除它们。
- 选择 nums 中最后两个元素并且删除它们。
- 选择 nums 中第一个和最后一个元素并且删除它们。
一次操作的 分数 是被删除元素的和。
在确保 所有操作分数相同 的前提下，请你求出 最多 能进行多少次操作。
请你返回按照上述要求 最多 可以进行的操作次数。
提示：
2 <= nums.length <= 2000
1 <= nums[i] <= 1000

区间 DP or 记忆化搜索
时间复杂度 O(n^2)
 */