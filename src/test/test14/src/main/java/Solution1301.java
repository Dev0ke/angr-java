import java.util.List;

public class Solution1301 {
    private static final int MOD = (int) (1e9 + 7);
    private int n;
    private int[][] maxScore, maxScorePaths;

    public int[] pathsWithMaxScore(List<String> board) {
        n = board.size();
        maxScore = new int[n][n];
        maxScorePaths = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                maxScore[i][j] = -1;
            }
        }
        maxScore[n - 1][n - 1] = 0;
        maxScorePaths[n - 1][n - 1] = 1;
        for (int i = n - 1; i >= 0; --i) {
            for (int j = n - 1; j >= 0; --j) {
                char c = board.get(i).charAt(j);
                if (!(i == n - 1 && j == n - 1) && c != 'X') {
                    update(i, j, i + 1, j);
                    update(i, j, i, j + 1);
                    update(i, j, i + 1, j + 1);
                    if (maxScore[i][j] != -1) {
                        maxScore[i][j] += (c == 'E' ? 0 : c - '0');
                    }
                }
            }
        }
        if (maxScore[0][0] == -1) {
            return new int[2];
        }
        return new int[]{maxScore[0][0], maxScorePaths[0][0]};
    }

    // 从 (i,j) 转移到 (ni,nj)
    private void update(int ni, int nj, int i, int j) {
        if (i >= n || j >= n || maxScore[i][j] == -1) {
            return;
        }
        if (maxScore[i][j] > maxScore[ni][nj]) {
            maxScore[ni][nj] = maxScore[i][j];
            maxScorePaths[ni][nj] = maxScorePaths[i][j];
        } else if (maxScore[i][j] == maxScore[ni][nj]) {
            maxScorePaths[ni][nj] += maxScorePaths[i][j];
            if (maxScorePaths[ni][nj] >= MOD) {
                maxScorePaths[ni][nj] -= MOD;
            }
        }
    }
}
/*
1301. 最大得分的路径数目
https://leetcode.cn/problems/number-of-paths-with-max-score/description/

给你一个正方形字符数组 board ，你从数组最右下方的字符 'S' 出发。
你的目标是到达数组最左上角的字符 'E' ，数组剩余的部分为数字字符 1, 2, ..., 9 或者障碍 'X'。在每一步移动中，你可以向上、向左或者左上方移动，可以移动的前提是到达的格子没有障碍。
一条路径的 「得分」 定义为：路径上所有数字的和。
请你返回一个列表，包含两个整数：第一个整数是 「得分」 的最大值，第二个整数是得到最大得分的方案数，请把结果对 10^9 + 7 取余。
如果没有任何路径可以到达终点，请返回 [0, 0] 。
提示：
2 <= board.length == board[i].length <= 100

动态规划。
时间复杂度 O(n^2)。
 */