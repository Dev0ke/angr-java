public class Solution2318 {
    // 7*7 转移矩阵
    private static final int[][] TRANSFER = {
            {},
            {0, 0, 1, 1, 1, 1, 1},
            {0, 1, 0, 1, 0, 1, 0},
            {0, 1, 1, 0, 1, 1, 0},
            {0, 1, 0, 1, 0, 1, 0},
            {0, 1, 1, 1, 1, 0, 1},
            {0, 1, 0, 0, 0, 1, 0}
    };

    private static final int MOD = 1000000007;

    public int distinctSequences(int n) {
        if (n == 1) {
            return 6;
        } else if (n == 2) {
            return 22;
        }

        // f[i][a][b] 表示第 i 次结果 a，第 i-1 次结果 b
        long[][][] f = new long[10010][7][7];
        // n=3
        for (int i = 1; i <= 6; i++) {
            for (int j = 1; j <= 6; j++) {
                for (int k = 1; k <= 6; k++) {
                    if (i != j && i != k && j != k && TRANSFER[i][j] == 1 && TRANSFER[j][k] == 1) {
                        f[3][i][j]++;
                    }
                }
            }
        }
        // n>3
        for (int ni = 4; ni <= n; ni++) {
            for (int i = 1; i <= 6; i++) {
                for (int j = 1; j <= 6; j++) {
                    for (int k = 1; k <= 6; k++) {
                        if (i != j && i != k && j != k && TRANSFER[i][j] == 1 && TRANSFER[j][k] == 1) {
                            f[ni][i][j] += f[ni - 1][j][k];
                            f[ni][i][j] %= MOD;
                        }
                    }
                }
            }
        }

        // 求和
        long sum = 0;
        for (int i = 1; i <= 6; i++) {
            for (int j = 1; j <= 6; j++) {
                sum += f[n][i][j];
                sum %= MOD;
            }
        }
        return (int) sum;
    }
}
/*
2318. 不同骰子序列的数目
https://leetcode.cn/problems/number-of-distinct-roll-sequences/

第 81 场双周赛 T4。

给你一个整数 n 。你需要掷一个 6 面的骰子 n 次。请你在满足以下要求的前提下，求出 不同 骰子序列的数目：
1.序列中任意 相邻 数字的 最大公约数 为 1 。
2.序列中 相等 的值之间，至少有 2 个其他值的数字。正式地，如果第 i 次掷骰子的值 等于 第 j 次的值，那么 abs(i - j) > 2 。
请你返回不同序列的 总数目 。由于答案可能很大，请你将答案对 10^9 + 7 取余 后返回。
如果两个序列中至少有一个元素不同，那么它们被视为不同的序列。
提示：
1 <= n <= 10^4

转移矩阵
1 23456
2 135
3 1245
4 135
5 12346
6 15
动态规划。
时间复杂度 O(n) 常数 6^3 = 216
 */