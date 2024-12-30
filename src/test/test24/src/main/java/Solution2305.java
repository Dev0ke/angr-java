public class Solution2305 {
    public int distributeCookies(int[] cookies, int k) {
        int n = cookies.length;
        int[] sum = new int[1 << n];
        for (int state = 1; state < (1 << n); state++) {
            // 尾随 0
            int x = Integer.numberOfTrailingZeros(state);
            int y = state - (1 << x);
            sum[state] = sum[y] + cookies[x];
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
                    min = Math.min(min, Math.max(dp[i - 1][state - subState], sum[subState]));
                }
                dp[i][state] = min;
            }
        }
        return dp[k - 1][(1 << n) - 1];
    }
}
/*
2305. 公平分发饼干
https://leetcode.cn/problems/fair-distribution-of-cookies/

第 297 场周赛 T3。

给你一个整数数组 cookies ，其中 cookies[i] 表示在第 i 个零食包中的饼干数量。另给你一个整数 k 表示等待分发零食包的孩子数量，所有 零食包都需要分发。
在同一个零食包中的所有饼干都必须分发给同一个孩子，不能分开。
分发的 不公平程度 定义为单个孩子在分发过程中能够获得饼干的最大总数。
返回所有分发的最小不公平程度。
提示：
2 <= cookies.length <= 8
1 <= cookies[i] <= 10^5
2 <= k <= cookies.length

状态压缩动态规划。
同: 1723. 完成所有工作的最短时间
https://leetcode.cn/problems/find-minimum-time-to-finish-all-jobs/
 */