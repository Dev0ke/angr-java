public class Solution518 {
    public int change(int amount, int[] coins) {
        int[] f = new int[amount + 1];
        f[0] = 1;
        for (int wi : coins) {
            for (int j = 1; j <= amount; j++) {
                if (j - wi >= 0) f[j] += f[j - wi];
            }
        }
        return f[amount];
    }
}
/*
518. 零钱兑换 II
https://leetcode.cn/problems/coin-change-ii/description/

给你一个整数数组 coins 表示不同面额的硬币，另给一个整数 amount 表示总金额。
请你计算并返回可以凑成总金额的硬币组合数。如果任何硬币组合都无法凑出总金额，返回 0 。
假设每一种面额的硬币有无限个。
题目数据保证结果符合 32 位带符号整数。
提示：
1 <= coins.length <= 300
1 <= coins[i] <= 5000
coins 中的所有值 互不相同
0 <= amount <= 5000

完全背包 求方案数。
相似题目: 322. 零钱兑换
https://leetcode.cn/problems/coin-change/
 */