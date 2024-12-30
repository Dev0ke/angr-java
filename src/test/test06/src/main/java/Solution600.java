import java.util.Arrays;

public class Solution600 {
    private char[] s;
    private int[][] dp;

    public int findIntegers(int n) {
        // 二进制字符串
        s = Integer.toBinaryString(n).toCharArray();
        int len = s.length;
        dp = new int[len][2];
        for (int i = 0; i < len; i++) {
            Arrays.fill(dp[i], -1);
        }
        return 1 + f(0, 0, true, false);
    }

    private int f(int i, int pre, boolean isLimit, boolean isNum) {
        if (i == s.length) {
            return isNum ? 1 : 0;
        }
        // 记忆化搜索
        if (!isLimit && isNum && dp[i][pre] >= 0) {
            return dp[i][pre];
        }
        int res = 0;
        if (!isNum) {
            // 可以跳过当前数位
            res = f(i + 1, pre, false, false);
        }
        int up = isLimit ? s[i] - '0' : 1;
        for (int d = isNum ? 0 : 1; d <= up; d++) {
            if (pre == 1 && d == 1) {
                break;
            }
            res += f(i + 1, d, isLimit && d == up, true);
        }
        if (!isLimit && isNum) {
            dp[i][pre] = res;
        }
        return res;
    }
}
/*
600. 不含连续1的非负整数
https://leetcode.cn/problems/non-negative-integers-without-consecutive-ones/

给定一个正整数 n ，返回范围在 [0, n] 都非负整数中，其二进制表示不包含 连续的 1 的个数。
提示:
1 <= n <= 10^9

数位 DP
 */