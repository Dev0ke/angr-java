public class Solution1155 {
    private static final int MOD = (int) (1e9 + 7);

    public int numRollsToTarget(int n, int k, int target) {
        // 分组背包
        // f[i][j] 表示考虑前 i 个物品组，凑成价值为 j 的方案数。
        int[][] f = new int[n + 1][target + 1];
        f[0][0] = 1;
        // 枚举物品组（每个骰子）
        for (int i = 1; i <= n; i++) {
            // 枚举背包容量（所掷得的总点数）
            for (int j = 0; j <= target; j++) {
                // 枚举决策（当前骰子所掷得的点数）
                for (int _k = 1; _k <= k; _k++) {
                    if (j >= _k) {
                        f[i][j] = (f[i][j] + f[i - 1][j - _k]) % MOD;
                    }
                }
            }
        }
        return f[n][target];
    }
}
/*
1155. 掷骰子的N种方法
https://leetcode.cn/problems/number-of-dice-rolls-with-target-sum/

这里有n个一样的骰子，每个骰子上都有k个面，分别标号为1到 k 。
给定三个整数 n , k 和target，返回可能的方式(从总共kn种方式中)滚动骰子的数量，使正面朝上的数字之和等于target。
答案可能很大，你需要对10^9+ 7 取模。
提示：
1 <= n, k <= 30
1 <= target <= 1000

动态规划
分组背包求方案数
 */