import java.util.Arrays;

public class Solution3007 {
    private int x;

    public long findMaximumNumber(long k, int x) {
        this.x = x;

        long left = 2;
        long right = (long) 1e16;
        while (left < right) {
            long mid = left + (right - left) / 2;
            // 边界二分 F, F,..., F, [T, T,..., T]
            // ----------------------^
            if (count(mid) > k) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left - 1;
    }

    private char[] s;
    private int n;
    private long[][] dp;

    private long count(long num) {
        s = Long.toBinaryString(num).toCharArray();
        n = s.length;
        dp = new long[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return f(0, 0, true, false);
    }

    private long f(int i, int sum, boolean isLimit, boolean isNum) {
        if (i == n) {
            return isNum ? sum : 0;
        }
        // 记忆化搜索
        if (!isLimit && isNum && dp[i][sum] != -1) {
            return dp[i][sum];
        }
        long res = 0;
        if (!isNum) {
            // 可以跳过当前数位
            res = f(i + 1, sum, false, false);
        }
        int up = isLimit ? s[i] - '0' : 1;
        for (int d = isNum ? 0 : 1; d <= up; d++) {
            int is1 = ((n - i) % x == 0 && d == 1) ? 1 : 0;
            res += f(i + 1, sum + is1, isLimit && d == up, true);
        }
        if (!isLimit && isNum) {
            dp[i][sum] = res;
        }
        return res;
    }
}
/*
3007. 价值和小于等于 K 的最大数字
https://leetcode.cn/problems/maximum-number-that-sum-of-the-prices-is-less-than-or-equal-to-k/description/

第 380 场周赛 T3。

给你一个整数 k 和一个整数 x 。
令 s 为整数 num 的下标从 1 开始的二进制表示。我们说一个整数 num 的 价值 是满足 i % x == 0 且 s[i] 是 设置位 的 i 的数目。
请你返回 最大 整数 num ，满足从 1 到 num 的所有整数的 价值 和小于等于 k 。
注意：
- 一个整数二进制表示下 设置位 是值为 1 的数位。
- 一个整数的二进制表示下标从右到左编号，比方说如果 s == 11100 ，那么 s[4] == 1 且 s[2] == 0 。
提示：
1 <= k <= 10^15
1 <= x <= 8

二分 + 数位 DP。注意一般数位 DP 的 i 是左到右，本题的 i 是低位到高位，需要转换成 n - i。
时间复杂度 O((x + logk)^3)
空间复杂度 O((x + logk)^2)
 */