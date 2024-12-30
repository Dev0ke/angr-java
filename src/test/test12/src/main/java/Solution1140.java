public class Solution1140 {
    public int stoneGameII(int[] piles) {
        int len = piles.length;
        int sum = 0;

        // dp[i][j] 表示剩余[i,n-1]堆时，M=j 的情况下，先取的人能获得的最多石子数
        int[][] dp = new int[len][len + 1];
        for (int i = len - 1; i >= 0; i--) {
            sum += piles[i];
            for (int M = 1; M <= len; M++) {
                if (i + 2 * M >= len) {
                    dp[i][M] = sum;
                } else {
                    for (int x = 1; x <= 2 * M; x++) {
                        dp[i][M] = Math.max(dp[i][M], sum - dp[i + x][Math.max(M, x)]);
                    }
                }
            }
        }
        return dp[0][1];
    }
}
/*
1140. 石子游戏 II
https://leetcode.cn/problems/stone-game-ii/

爱丽丝和鲍勃继续他们的石子游戏。许多堆石子 排成一行，每堆都有正整数颗石子 piles[i]。游戏以谁手中的石子最多来决出胜负。
爱丽丝和鲍勃轮流进行，爱丽丝先开始。最初，M = 1。
在每个玩家的回合中，该玩家可以拿走剩下的 前 X 堆的所有石子，其中 1 <= X <= 2M。然后，令 M = max(M, X)。
游戏一直持续到所有石子都被拿走。
假设爱丽丝和鲍勃都发挥出最佳水平，返回爱丽丝可以得到的最大数量的石头。
提示：
1 <= piles.length <= 100
1 <= piles[i] <= 10^4

博弈论 DP
相似题目: 1406. 石子游戏 III
https://leetcode.cn/problems/stone-game-iii/
1510. 石子游戏 IV
https://leetcode.cn/problems/stone-game-iv/
 */