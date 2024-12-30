import java.util.Arrays;

public class Solution1770 {
    private int[] nums, multipliers;
    private int n, m;
    private int[][] memo;

    public int maximumScore(int[] nums, int[] multipliers) {
        this.nums = nums;
        this.multipliers = multipliers;
        this.n = nums.length;
        this.m = multipliers.length;
        memo = new int[m + 1][m + 1];
        for (int i = 0; i < m + 1; i++) {
            Arrays.fill(memo[i], -1);
        }
        return dfs(0, 0);
    }

    // i 和 j，分别移动了 l 和 r
    private int dfs(int i, int r) {
        int j = n - 1 - r;
        int k = i + r; // k 可以由 l, r 求出，不需要单独记录
        if (i > j || k >= m) return 0;
        if (memo[i][r] != -1) return memo[i][r];
        int res1 = dfs(i + 1, r) + nums[i] * multipliers[k];
        int res2 = dfs(i, r + 1) + nums[j] * multipliers[k];
        int res = Math.max(res1, res2);
        return memo[i][r] = res;
    }
}
/*
1770. 执行乘法运算的最大分数
https://leetcode.cn/problems/maximum-score-from-performing-multiplication-operations/description/

给你两个长度分别 n 和 m 的整数数组 nums 和 multipliers ，其中 n >= m ，数组下标 从 1 开始 计数。
初始时，你的分数为 0 。你需要执行恰好 m 步操作。在第 i 步操作（从 1 开始 计数）中，需要：
- 选择数组 nums 开头处或者末尾处 的整数 x 。
- 你获得 multipliers[i] * x 分，并累加到你的分数中。
- 将 x 从数组 nums 中移除。
在执行 m 步操作后，返回 最大 分数。
提示：
n == nums.length
m == multipliers.length
1 <= m <= 10^3
m <= n <= 10^5
-1000 <= nums[i], multipliers[i] <= 1000

记忆化搜索。注意 memo 不能开到 n*n，要是 m*m。
时间复杂度 O(m^2)。
 */