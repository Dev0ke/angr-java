public class SolutionP1908 {
    public boolean nimGame(int[] piles) {
        int xor = 0;
        for (int v : piles) {
            xor ^= v;
        }
        return xor != 0;
    }
}
/*
$1908. Nim 游戏 II
https://leetcode.cn/problems/game-of-nim/description/

Alice 和 Bob 交替进行一个游戏，由 Alice 先手。
在游戏中，共有 n 堆石头。在每个玩家的回合中，玩家需要 选择 任一非空石头堆，从中移除任意 非零 数量的石头。如果不能移除任意的石头，就输掉游戏，同时另一人获胜。
给定一个整数数组 piles ，piles[i] 为 第 i 堆石头的数量，如果 Alice 能获胜返回 true ，反之返回 false 。
Alice 和 Bob 都会采取 最优策略 。
提示：
n == piles.length
1 <= n <= 7
1 <= piles[i] <= 7
进阶：你能想出一个 线性时间 的解决方案吗？虽然这一答案可能超出了面试所需的范围，但了解它可能会很有趣。

Sprague-Grundy 定理
相似题目: $294. 翻转游戏 II
https://leetcode.cn/problems/flip-game-ii/
 */