import java.util.Arrays;

public class Solution3259 {
    static class V1 {
        private int[] energyDrinkA, energyDrinkB;
        private long[][] memo;

        public long maxEnergyBoost(int[] energyDrinkA, int[] energyDrinkB) {
            this.energyDrinkA = energyDrinkA;
            this.energyDrinkB = energyDrinkB;
            int n = energyDrinkA.length;

            memo = new long[n][3];
            for (int i = 0; i < n; i++) {
                Arrays.fill(memo[i], -1);
            }
            return dfs(0, 2);
        }

        // j: 0/1/2 = 选A, 选B, 都不选
        private long dfs(int i, int j) {
            if (i == energyDrinkA.length) return 0;
            if (memo[i][j] != -1) return memo[i][j];
            long res = dfs(i + 1, 2);
            if (j == 0) res = Math.max(res, dfs(i + 1, j) + energyDrinkA[i]);
            if (j == 1) res = Math.max(res, dfs(i + 1, j) + energyDrinkB[i]);
            if (j == 2) {
                res = Math.max(res, dfs(i + 1, 0) + energyDrinkA[i]);
                res = Math.max(res, dfs(i + 1, 1) + energyDrinkB[i]);
            }
            return memo[i][j] = res;
        }
    }

    static class V2 {
        public long maxEnergyBoost(int[] energyDrinkA, int[] energyDrinkB) {
            int n = energyDrinkA.length;
            long[][] f = new long[n + 2][2];
            for (int i = 0; i < n; i++) {
                f[i + 2][0] = Math.max(f[i + 1][0], f[i][1]) + energyDrinkA[i];
                f[i + 2][1] = Math.max(f[i + 1][1], f[i][0]) + energyDrinkB[i];
            }
            return Math.max(f[n + 1][0], f[n + 1][1]);
        }
    }
}
/*
3259. 超级饮料的最大强化能量
https://leetcode.cn/problems/maximum-energy-boost-from-two-drinks/description/

第 411 场周赛 T2。

来自未来的体育科学家给你两个整数数组 energyDrinkA 和 energyDrinkB，数组长度都等于 n。这两个数组分别代表 A、B 两种不同能量饮料每小时所能提供的强化能量。
你需要每小时饮用一种能量饮料来 最大化 你的总强化能量。然而，如果从一种能量饮料切换到另一种，你需要等待一小时来梳理身体的能量体系（在那个小时里你将不会获得任何强化能量）。
返回在接下来的 n 小时内你能获得的 最大 总强化能量。
注意 你可以选择从饮用任意一种能量饮料开始。
提示：
n == energyDrinkA.length == energyDrinkB.length
3 <= n <= 10^5
1 <= energyDrinkA[i], energyDrinkB[i] <= 10^5

记忆化搜索。
时间复杂度 O(n)。
 */