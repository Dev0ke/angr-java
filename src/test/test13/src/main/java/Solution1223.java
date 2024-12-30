import java.util.Arrays;

public class Solution1223 {
    private static final int MOD = (int) (1e9 + 7);
    private int[] rollMax;
    private long[][][] memo;

    public int dieSimulator(int n, int[] rollMax) {
        this.rollMax = rollMax;
        memo = new long[n][6][15];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 6; j++) {
                Arrays.fill(memo[i][j], -1);
            }
        }

        long res = 0L;
        for (int i = 0; i < 6; i++) {
            res = (res + f(n - 1, i, rollMax[i] - 1)) % MOD;
        }
        return (int) res;
    }

    // 剩余 i 次，上一次掷出数字，还可以连续 left 次
    private long f(int i, int pre, int left) {
        if (i == 0) {
            return 1;
        }
        if (memo[i][pre][left] != -1) {
            return memo[i][pre][left];
        }
        long res = 0L;
        for (int j = 0; j < 6; j++) {
            if (j != pre) {
                res = (res + f(i - 1, j, rollMax[j] - 1)) % MOD;
            } else if (left > 0) {
                res = (res + f(i - 1, pre, left - 1)) % MOD;
            }
        }
        memo[i][pre][left] = res;
        return res;
    }
}
/*
1223. 掷骰子模拟
https://leetcode.cn/problems/dice-roll-simulation/

有一个骰子模拟器会每次投掷的时候生成一个 1 到 6 的随机数。
不过我们在使用它时有个约束，就是使得投掷骰子时，连续 掷出数字 i 的次数不能超过 rollMax[i]（i 从 1 开始编号）。
现在，给你一个整数数组 rollMax 和一个整数 n，请你来计算掷 n 次骰子可得到的不同点数序列的数量。
假如两个序列中至少存在一个元素不同，就认为这两个序列是不同的。由于答案可能很大，所以请返回 模 10^9 + 7 之后的结果。
提示：
1 <= n <= 5000
rollMax.length == 6
1 <= rollMax[i] <= 15

记忆化搜索
 */