public class SolutionP3018 {
    public int maximumProcessableQueries(int[] nums, int[] queries) {
        int n = nums.length, m = queries.length;
        int[][] dp = new int[n][n];
        for (int l = 0; l < n; ++l) {
            for (int r = n - 1; r >= l; --r) {
                int max = 0;
                if (l > 0) {
                    int index = dp[l - 1][r];
                    max = Math.max(max, nums[l - 1] >= queries[index] ? index + 1 : index);
                }
                if (r < n - 1) {
                    int index = dp[l][r + 1];
                    max = Math.max(max, nums[r + 1] >= queries[index] ? index + 1 : index);
                }
                if (max == m) {
                    return m;
                }
                dp[l][r] = max;
            }
        }

        int ans = 0;
        for (int i = 0; i < n; ++i) {
            int index = dp[i][i];
            ans = Math.max(ans, nums[i] >= queries[index] ? index + 1 : index);
        }
        return ans;
    }
}
/*
3018. 可处理的最大删除操作数 I
https://leetcode.cn/problems/maximum-number-of-removal-queries-that-can-be-processed-i/description/

给定一个下标 从 0 开始 的数组 nums 和一个下标 从 0 开始 的数组 queries。
你可以在开始时执行以下操作 最多一次：
- 用 nums 的 子序列  替换 nums。
我们以给定的queries顺序处理查询；对于queries[i]，我们执行以下操作：
- 如果 nums 的第一个 和 最后一个元素 小于 queries[i]，则查询处理 结束。
- 否则，从 nums 选择第一个 或 最后一个元素，要求其大于或等于 queries[i]，然后将其从 nums 中 删除。
返回通过以最佳方式执行该操作可以处理的 最多 次数。
提示：
1 <= nums.length <= 1000
1 <= queries.length <= 1000
1 <= nums[i], queries[i] <= 10^9

区间 DP。
dp[l][r]: 表示在数组 nums 中，当数据 [l,r] 还没有被删除时我们所能查询的最大 queries 数。
dp[l][r] 可以由 dp[l−1][r] 和 dp[l][r+1] 计算得到，我们首先取其中的最大值。
如果 nums[l−1]>=queries[dp[l−1][r]]，那么我们可以删除 nums[l−1]得到 dp[l][r] ，因此在这种情况下 dp[l][r] 比 dp[l−1][r] 能多查询一个数。
如果 nums[r+1]>=queries[dp[l][r+1]]，那么我们可以删除 nums[r+1]得到 dp[l][r]，因此在这种情况下 dp[l][r] 比 dp[l][r+1] 能多查询一个数。
在以上的几种情况下，我们取其中的最大值为 dp[l][r]。在计算 dp[l][r] 的过程中，如果 dp[l][r]=m , 那么我们可以直接返回结果。其中 m 为数组 queries 的长度。
https://leetcode.cn/problems/maximum-number-of-removal-queries-that-can-be-processed-i/solutions/2619968/jian-ji-de-dong-tai-gui-hua-by-peaceful-u3fs0/
时间复杂度 O(n^2)。
 */