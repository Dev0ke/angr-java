public class Solution322 {
    public int coinChange(int[] coins, int amount) {
        // 完全背包
        // f[i] 表示凑出总额为 i 的硬币需要的最少的数目
        int[] f = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            f[i] = amount + 1;
            for (int coin : coins) {
                if (i >= coin) {
                    f[i] = Math.min(f[i], f[i - coin] + 1);
                }
            }
        }
        return (f[amount] > amount) ? -1 : f[amount];
    }
}
/*
322. 零钱兑换
https://leetcode.cn/problems/coin-change/

给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
计算并返回可以凑成总金额所需的 最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1 。
你可以认为每种硬币的数量是无限的。
提示：
1 <= coins.length <= 12
1 <= coins[i] <= 2^31 - 1
0 <= amount <= 10^4

动态规划。完全背包。
完全背包与 0-1 背包 区别为 完全背包同一物品可以选取任意多次。
定义 f(i) 凑出总额为 i 的硬币需要的最少的数目。如果目标总额为 t，那么 f(t) 就是整个问题的解。
状态转移
当 coins[j] <= i 时，f(i) = min(f(i-coins[j])+1)
相似题目: 377. 组合总和 Ⅳ
https://leetcode.cn/problems/combination-sum-iv/
518. 零钱兑换 II
https://leetcode.cn/problems/coin-change-ii/description/
 */