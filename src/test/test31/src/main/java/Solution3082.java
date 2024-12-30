public class Solution3082 {
    // 时间复杂度 O(n^2 k)
    // 空间复杂度 O(n^2 k)
    static class V1 {
        public int sumOfPower(int[] nums, int k) {
            final int MOD = (int) (1e9 + 7);
            int n = nums.length;
            // 二维 0-1 背包 求方案数
            // 问题：有 n 个物品，每个物品的体积是 nums[i]，问恰好装满容量为 k 的背包，且选择 c 个物品的方案数
            // f[i][j][c] 表示考虑前 i 个物品，所选物品体积和是 j，选了 c 个物品的方案数
            long[][][] f = new long[n + 1][k + 1][n + 1];
            f[0][0][0] = 1;
            for (int i = 0; i < n; i++) {
                int v = nums[i];
                for (int j = k; j >= 0; j--) {
                    for (int c = i + 1; c >= 0; c--) {
                        if (j - v >= 0 && c - 1 >= 0) {
                            f[i + 1][j][c] = (f[i][j][c] + f[i][j - v][c - 1]) % MOD;
                        } else {
                            f[i + 1][j][c] = f[i][j][c];
                        }
                    }
                }
            }

            long ans = 0;
            long pow2 = 1;
            for (int i = n; i > 0; i--) {
                ans = (ans + f[n][k][i] * pow2) % MOD;
                pow2 = pow2 * 2 % MOD;
            }
            return (int) ans;
        }
    }

    // V1 空间优化
    // 时间复杂度 O(n^2 k)
    // 空间复杂度 O(nk)
    static class V2 {
        public int sumOfPower(int[] nums, int k) {
            final int MOD = (int) (1e9 + 7);
            int n = nums.length;
            long[][] f = new long[k + 1][n + 1];
            f[0][0] = 1;
            for (int i = 0; i < n; i++) {
                int v = nums[i];
                for (int j = k; j >= v; j--) {
                    for (int c = i + 1; c > 0; c--) {
                        f[j][c] = (f[j][c] + f[j - v][c - 1]) % MOD;
                    }
                }
            }

            long ans = 0;
            long pow2 = 1;
            for (int i = n; i > 0; i--) {
                ans = (ans + f[k][i] * pow2) % MOD;
                pow2 = pow2 * 2 % MOD;
            }
            return (int) ans;
        }
    }

    // 时间复杂度 O(nk)
    // 空间复杂度 O(nk)
    static class V3 {
        public int sumOfPower(int[] nums, int k) {
            final int MOD = (int) (1e9 + 7);
            int n = nums.length;
            // f[i][j] 表示考虑前 i 个数，所选元素和是 j 时的能量和
            long[][] f = new long[n + 1][k + 1];
            f[0][0] = 1;
            // 状态转移
            // 不选，且不在 T 中：f[i+1][j] = f[i][j]
            // 不选，且在 T 中：f[i+1][j] = f[i][j]
            // 选：f[i+1][j] = f[i][j-v], v=nums[i]
            for (int i = 0; i < n; i++) {
                int v = nums[i];
                for (int j = 0; j <= k; j++) {
                    if (j - v >= 0) {
                        f[i + 1][j] = (f[i][j] * 2 + f[i][j - v]) % MOD;
                    } else {
                        f[i + 1][j] = f[i][j] * 2 % MOD;
                    }
                }
            }
            return (int) f[n][k];
        }
    }

    // V3 空间优化
    // 时间复杂度 O(nk)
    // 空间复杂度 O(k)
    static class V4 {
        public int sumOfPower(int[] nums, int k) {
            final int MOD = (int) (1e9 + 7);
            long[] f = new long[k + 1];
            f[0] = 1;
            int sum = 0;
            for (int v : nums) {
                sum = Math.min(sum + v, k);
                for (int j = sum; j >= 0; j--) {
                    if (j >= v) {
                        f[j] = f[j] * 2 + f[j - v];
                    } else {
                        f[j] = f[j] * 2;
                    }
                    f[j] %= MOD;
                }
            }
            return (int) f[k];
        }
    }
}
/*
3082. 求出所有子序列的能量和
https://leetcode.cn/problems/find-the-sum-of-the-power-of-all-subsequences/description/

第 126 场双周赛 T4。

给你一个长度为 n 的整数数组 nums 和一个 正 整数 k 。
一个整数数组的 能量 定义为和 等于 k 的子序列的数目。
请你返回 nums 中所有子序列的 能量和 。
由于答案可能很大，请你将它对 10^9 + 7 取余 后返回。
提示：
1 <= n <= 100
1 <= nums[i] <= 10^4
1 <= k <= 100

0-1 背包 求方案数
 */