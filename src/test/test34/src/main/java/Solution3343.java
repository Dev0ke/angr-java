import java.util.Arrays;

public class Solution3343 {
    private static final int MOD = (int) (1e9 + 7);
    private static final int MX = 41;
    private static final long[] F = new long[MX]; // f[i] = i!
    private static final long[] INV_F = new long[MX]; // inv_f[i] = i!^-1

    static {
        F[0] = 1;
        for (int i = 1; i < MX; i++) {
            F[i] = F[i - 1] * i % MOD;
        }
        INV_F[MX - 1] = quickPow(F[MX - 1], MOD - 2);
        for (int i = MX - 1; i > 0; i--) {
            INV_F[i - 1] = INV_F[i] * i % MOD;
        }
    }

    private int[] cnt;
    private long[][][] memo;

    public int countBalancedPermutations(String num) {
        cnt = new int[10];
        int total = 0;
        for (char c : num.toCharArray()) {
            cnt[c - '0']++;
            total += c - '0';
        }
        if (total % 2 > 0) return 0;

        for (int i = 1; i < 10; i++) {
            cnt[i] += cnt[i - 1];
        }

        int n = num.length();
        int n1 = n / 2;
        memo = new long[10][n1 + 1][total / 2 + 1];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < n1 + 1; j++) {
                Arrays.fill(memo[i][j], -1);
            }
        }
        return (int) (F[n1] * F[n - n1] % MOD * dfs(9, n1, total / 2) % MOD);
    }

    private long dfs(int i, int left1, int leftS) {
        if (i < 0) {
            return leftS == 0 ? 1 : 0;
        }
        if (memo[i][left1][leftS] != -1) return memo[i][left1][leftS];
        long res = 0;
        int c = cnt[i] - (i > 0 ? cnt[i - 1] : 0);
        int left2 = cnt[i] - left1;
        for (int k = Math.max(c - left2, 0); k <= Math.min(c, left1) && k * i <= leftS; k++) {
            long r = dfs(i - 1, left1 - k, leftS - k * i);
            res = (res + r * INV_F[k] % MOD * INV_F[c - k]) % MOD;
        }
        return memo[i][left1][leftS] = res;
    }

    private static long quickPow(long a, long b) {
        long res = 1L;
        while (b > 0) {
            if ((b & 1) != 0) res = res * a % MOD;
            a = a * a % MOD;
            b >>= 1;
        }
        return res;
    }
}
/*
3343. 统计平衡排列的数目
https://leetcode.cn/problems/count-number-of-balanced-permutations/description/

第 422 场周赛 T4。

给你一个字符串 num 。如果一个数字字符串的奇数位下标的数字之和与偶数位下标的数字之和相等，那么我们称这个数字字符串是 平衡的 。
请你返回 num 不同排列 中，平衡 字符串的数目。
由于答案可能很大，请你将答案对 10^9 + 7 取余 后返回。
一个字符串的 排列 指的是将字符串中的字符打乱顺序后连接得到的字符串。
提示：
2 <= num.length <= 80
num 中的字符只包含数字 '0' 到 '9' 。

排列问题：
拆分成一个组合问题 + 任意排列问题
组合问题 = 子序列问题 = 恰好型 0-1 背包问题
从一个长为 n 的数组 a 中，恰好选出 floor(n/2) 个数字，这些数字的元素和恰好等于 sum(a)/2
可重集的排列数
n1 = floor(n/2)
n1! * (n-n1)! / (cnt[0]! * cnt[1]! * ... * cnt[9]!)
最终答案 =
0-1 背包问题的方案数 * n1! * (n-n1)! / (cnt[0]! * cnt[1]! * ... * cnt[9]!)
rating 2627 (clist.by)
 */