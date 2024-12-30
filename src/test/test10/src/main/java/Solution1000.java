public class Solution1000 {
    public int mergeStones(int[] stones, int k) {
        int n = stones.length;
        if ((n - 1) % (k - 1) != 0) {
            return -1;
        }

        // dp[i][j] 为尽可能多的合并区间 [i,j] 所需的成本，不一定能合并成一堆，但合并完成后剩下的堆数一定小于 k
        int[][] dp = new int[n + 1][n + 1];
        int[] sum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + stones[i - 1];
        }
        // 枚举区间长度
        for (int len = k; len <= n; len++) {
            // 枚举区间起点
            for (int i = 1; i + len - 1 <= n; i++) {
                int j = i + len - 1;
                dp[i][j] = Integer.MAX_VALUE;
                // 枚举分界点
                for (int p = i; p < j; p += k - 1) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][p] + dp[p + 1][j]);
                }
                if ((j - i) % (k - 1) == 0) {
                    dp[i][j] += sum[j] - sum[i - 1];
                }
            }
        }
        return dp[1][n];
    }
}
/*
1000. 合并石头的最低成本
https://leetcode.cn/problems/minimum-cost-to-merge-stones/

有 N 堆石头排成一排，第 i 堆中有 stones[i] 块石头。
每次移动（move）需要将连续的 K 堆石头合并为一堆，而这个移动的成本为这 K 堆石头的总数。
找出把所有石头合并成一堆的最低成本。如果不可能，返回 -1 。
提示：
1 <= stones.length <= 30
2 <= K <= 30
1 <= stones[i] <= 100

区间 DP
https://leetcode.cn/problems/minimum-cost-to-merge-stones/solution/yi-dong-you-yi-dao-nan-yi-bu-bu-shuo-ming-si-lu-he/
 */