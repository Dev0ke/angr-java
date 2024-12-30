import java.util.Arrays;

public class Solution3352 {
    private static final int MOD = (int) (1e9 + 7);
    private char[] s;
    private int[][] memo;

    public int countKReducibleNumbers(String s, int k) {
        this.s = s.toCharArray();
        int n = s.length();
        memo = new int[n][n + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(memo[i], -1);
        }

        long ans = 0;
        int[] f = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            f[i] = f[Integer.bitCount(i)] + 1;
            if (f[i] <= k) {
                ans += f(0, i, true);
            }
        }
        return (int) (ans % MOD);
    }

    private int f(int i, int left1, boolean isLimit) {
        if (i == s.length) {
            return !isLimit && left1 == 0 ? 1 : 0; // 小于 n, 加上 !isLimit
        }
        if (!isLimit && memo[i][left1] != -1) return memo[i][left1];
        int res = 0;
        int up = isLimit ? s[i] - '0' : 1;
        for (int d = 0; d <= Math.min(up, left1); d++) {
            res += f(i + 1, left1 - d, isLimit && d == up);
            res %= MOD;
        }
        if (!isLimit) {
            memo[i][left1] = res;
        }
        return res;
    }
}
/*
3352. 统计小于 N 的 K 可约简整数
https://leetcode.cn/problems/count-k-reducible-numbers-less-than-n/description/

第 423 场周赛 T4。

给你一个 二进制 字符串 s，它表示数字 n 的二进制形式。
同时，另给你一个整数 k。
如果整数 x 可以通过最多 k 次下述操作约简到 1 ，则将整数 x 称为 k-可约简 整数：
- 将 x 替换为其二进制表示中的置位数（即值为 1 的位）。
例如，数字 6 的二进制表示是 "110"。一次操作后，它变为 2（因为 "110" 中有两个置位）。再对 2（二进制为 "10"）进行操作后，它变为 1（因为 "10" 中有一个置位）。
返回小于 n 的正整数中有多少个是 k-可约简 整数。
由于答案可能很大，返回结果需要对 10^9 + 7 取余。
二进制中的置位是指二进制表示中值为 1 的位。
提示：
1 <= s.length <= 800
s 中没有前导零。
s 仅由字符 '0' 和 '1' 组成。
1 <= k <= 5

线性 DP + 数位 DP。
时间复杂度 O(n^2)。
相似题目: C. Travelling Salesman and Special Numbers
https://codeforces.com/contest/914/problem/C
rating 2482 (clist.by)
 */