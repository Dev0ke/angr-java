public class Solution1723 {
    public int minimumTimeRequired(int[] jobs, int k) {
        int n = jobs.length;
        int[] sum = new int[1 << n];
        for (int state = 1; state < (1 << n); state++) {
            // 尾随 0
            int x = Integer.numberOfTrailingZeros(state);
            int y = state - (1 << x);
            sum[state] = sum[y] + jobs[x];
        }

        // dp[i][j] 表示给前 i 个人分配工作，工作分配情况为 j 时，完成所有工作量的最短时间。
        int[][] dp = new int[k][1 << n];

        // 初始状态 dp[0][state] = sum[state]
        System.arraycopy(sum, 0, dp[0], 0, (1 << n));

        // 状态转移 dp[i][j] = min(max(dp[i-1][j的子集的补集],sum[j的子集]))
        for (int i = 1; i < k; i++) {
            for (int state = 0; state < (1 << n); state++) {
                int min = Integer.MAX_VALUE;
                for (int subState = state; subState > 0; subState = (subState - 1) & state) {
                    min = Math.min(min, Math.max(dp[i - 1][state ^ subState], sum[subState]));
                }
                dp[i][state] = min;
            }
        }
        return dp[k - 1][(1 << n) - 1];
    }
}
/*
1723. 完成所有工作的最短时间
https://leetcode.cn/problems/find-minimum-time-to-finish-all-jobs/

给你一个整数数组 jobs ，其中 jobs[i] 是完成第 i 项工作要花费的时间。
请你将这些工作分配给 k 位工人。所有工作都应该分配给工人，且每项工作只能分配给一位工人。工人的 工作时间 是完成分配给他们的所有工作花费时间的总和。
请你设计一套最佳的工作分配方案，使工人的 最大工作时间 得以 最小化 。
返回分配方案中尽可能 最小 的 最大工作时间 。
提示：
1 <= k <= jobs.length <= 12
1 <= jobs[i] <= 10^7

本题用贪心是错误的，如用例 jobs = [5,5,4,4,4], k = 2，expected=12, actual=13
有两种可行的解法：
方法一：二分查找 + 回溯 + 剪枝
方法二：状态压缩动态规划
时间复杂度 O(n * 3^n)
空间复杂度 O(n * 2^n)
同: 2305. 公平分发饼干
https://leetcode.cn/problems/fair-distribution-of-cookies/
 */