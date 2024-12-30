public class Solution1240 {
    public int tilingRectangle(int n, int m) {
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                // 如果是正方形
                if (i == j) {
                    dp[i][j] = 1;
                    continue;
                }
                dp[i][j] = Integer.MAX_VALUE / 2;
                // 1.横切
                for (int k = 1; k < i; k++) {
                    dp[i][j] = Math.min(dp[i][j], dp[k][j] + dp[i - k][j]);
                }
                // 2.竖切
                for (int k = 1; k < j; k++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[i][j - k]);
                }

                // 3.横竖切
                for (int p = 1; p <= Math.min(i, j); p++) {
                    for (int k = 1; k <= p; k++) {
                        if (p - k <= 0 || j - p <= 0 || i - p + k <= 0 || j - p - k <= 0) {
                            continue;
                        }
                        dp[i][j] = Math.min(dp[i][j],
                                dp[p - k][j - p] + dp[i - p + k][j - p - k] + dp[i - p][p + k] + 2);
                    }
                }
            }
        }
        return dp[n][m];
    }
}
/*
1240. 铺瓷砖
https://leetcode.cn/problems/tiling-a-rectangle-with-the-fewest-squares/

你是一位施工队的工长，根据设计师的要求准备为一套设计风格独特的房子进行室内装修。
房子的客厅大小为 n x m，为保持极简的风格，需要使用尽可能少的 正方形 瓷砖来铺盖地面。
假设正方形瓷砖的规格不限，边长都是整数。
请你帮设计师计算一下，最少需要用到多少块方形瓷砖？
提示：
1 <= n <= 13
1 <= m <= 13

NP-Complete 问题。建议直接看论文。。
https://leetcode.cn/problems/tiling-a-rectangle-with-the-fewest-squares/solution/pu-ci-zhuan-by-leetcode-solution-r1bk/
16*17 应该是 8，题解算出来 9
本题暂不分析时空复杂度。
 */