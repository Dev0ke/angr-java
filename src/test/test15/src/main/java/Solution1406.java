import java.util.Arrays;

public class Solution1406 {
    public String stoneGameIII(int[] stoneValue) {
        int len = stoneValue.length;

        int[] suffixSum = new int[len];
        suffixSum[len - 1] = stoneValue[len - 1];
        for (int i = len - 2; i >= 0; --i) {
            suffixSum[i] = suffixSum[i + 1] + stoneValue[i];
        }

        // f[i] 表示还剩下第 [i,n-1] 堆石子时，当前玩家最多能从剩下的石子中拿到的石子数目
        int[] f = new int[len + 1];
        // 边界情况，当没有石子时，分数为 0
        // 为了代码的可读性，显式声明
        f[len] = 0;
        for (int i = len - 1; i >= 0; --i) {
            int bestj = f[i + 1];
            for (int j = i + 2; j <= i + 3 && j <= len; ++j) {
                bestj = Math.min(bestj, f[j]);
            }
            f[i] = suffixSum[i] - bestj;
        }

        int sum = Arrays.stream(stoneValue).sum();
        if (f[0] * 2 == sum) {
            return "Tie";
        } else {
            return f[0] * 2 > sum ? "Alice" : "Bob";
        }
    }
}
/*
1406. 石子游戏 III
https://leetcode.cn/problems/stone-game-iii/

Alice 和 Bob 用几堆石子在做游戏。几堆石子排成一行，每堆石子都对应一个得分，由数组 stoneValue 给出。
Alice 和 Bob 轮流取石子，Alice 总是先开始。在每个玩家的回合中，该玩家可以拿走剩下石子中的的前 1、2 或 3 堆石子 。比赛一直持续到所有石头都被拿走。
每个玩家的最终得分为他所拿到的每堆石子的对应得分之和。每个玩家的初始分数都是 0 。比赛的目标是决出最高分，得分最高的选手将会赢得比赛，比赛也可能会出现平局。
假设 Alice 和 Bob 都采取 最优策略 。如果 Alice 赢了就返回 "Alice" ，Bob 赢了就返回 "Bob"，平局（分数相同）返回 "Tie" 。
提示：
1 <= values.length <= 50000
-1000 <= values[i] <= 1000

博弈论 DP
相似题目: 1140. 石子游戏 II
https://leetcode.cn/problems/stone-game-ii/
1510. 石子游戏 IV
https://leetcode.cn/problems/stone-game-iv/
 */