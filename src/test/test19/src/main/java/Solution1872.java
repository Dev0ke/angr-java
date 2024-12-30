public class Solution1872 {
    public int stoneGameVIII(int[] stones) {
        int n = stones.length;
        int[] ps = new int[n + 1];
        for (int i = 0; i < n; i++) {
            ps[i + 1] = ps[i] + stones[i];
        }

        int f = ps[n];
        for (int i = n - 1; i > 1; i--) {
            f = Math.max(f, ps[i] - f);
        }
        return f;
    }
}
/*
1872. 石子游戏 VIII
https://leetcode.cn/problems/stone-game-viii/description/

Alice 和 Bob 玩一个游戏，两人轮流操作， Alice 先手 。
总共有 n 个石子排成一行。轮到某个玩家的回合时，如果石子的数目 大于 1 ，他将执行以下操作：
1.选择一个整数 x > 1 ，并且 移除 最左边的 x 个石子。
2.将 移除 的石子价值之 和 累加到该玩家的分数中。
3.将一个 新的石子 放在最左边，且新石子的值为被移除石子值之和。
当只剩下 一个 石子时，游戏结束。
Alice 和 Bob 的 分数之差 为 (Alice 的分数 - Bob 的分数) 。 Alice 的目标是 最大化 分数差，Bob 的目标是 最小化 分数差。
给你一个长度为 n 的整数数组 stones ，其中 stones[i] 是 从左边起 第 i 个石子的价值。请你返回在双方都采用 最优 策略的情况下，Alice 和 Bob 的 分数之差 。
提示：
n == stones.length
2 <= n <= 10^5
-10^4 <= stones[i] <= 10^4

在前缀和上倒序 DP
https://leetcode.cn/problems/stone-game-viii/solutions/791117/zai-qian-zhui-he-shang-dao-xu-dp-by-endl-jxqs/
时间复杂度 O(n)。
 */