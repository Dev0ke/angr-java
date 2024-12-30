public class Solution576 {
    private static final int MOD = (int) (1e9 + 7);
    private static final int[][] DIRECTIONS = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        int[][][] dp = new int[maxMove + 1][m][n];
        dp[0][startRow][startColumn] = 1;

        int cnt = 0;
        for (int step = 0; step < maxMove; step++) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    int count = dp[step][i][j];
                    if (count > 0) {
                        for (int[] dir : DIRECTIONS) {
                            int nextM = i + dir[0];
                            int nextN = j + dir[1];
                            if (nextM >= 0 && nextM < m && nextN >= 0 && nextN < n) {
                                dp[step + 1][nextM][nextN] = (dp[step + 1][nextM][nextN] + count) % MOD;
                            } else {
                                cnt = (cnt + count) % MOD;
                            }
                        }
                    }
                }
            }
        }
        return cnt;
    }
}
/*
576. 出界的路径数
https://leetcode.cn/problems/out-of-boundary-paths/

给你一个大小为 m x n 的网格和一个球。球的起始坐标为 [startRow, startColumn] 。
你可以将球移到在四个方向上相邻的单元格内（可以穿过网格边界到达网格之外）。你 最多 可以移动 maxMove 次球。
给你五个整数 m、n、maxMove、startRow 以及 startColumn ，找出并返回可以将球移出边界的路径数量。因为答案可能非常大，返回对 10^9 + 7 取余 后的结果。
提示：
1 <= m, n <= 50
0 <= maxMove <= 50
0 <= startRow < m
0 <= startColumn < n

动态规划
时间复杂度 (maxMove*m*n)
空间复杂度 (m*n)
相似题目: 688. 骑士在棋盘上的概率
https://leetcode.cn/problems/knight-probability-in-chessboard/
 */