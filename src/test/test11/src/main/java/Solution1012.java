import java.util.Arrays;

public class Solution1012 {
    private char[] s;
    private int[][] dp;

    public int numDupDigitsAtMostN(int n) {
        s = String.valueOf(n).toCharArray();
        int len = s.length;
        dp = new int[len][1 << 10];
        for (int i = 0; i < len; i++) {
            Arrays.fill(dp[i], -1);
        }
        return n - f(0, 0, true, false);
    }

    private int f(int i, int state, boolean isLimit, boolean isNum) {
        if (i == s.length) {
            return isNum ? 1 : 0;
        }
        // 记忆化搜索
        if (!isLimit && isNum && dp[i][state] >= 0) {
            return dp[i][state];
        }
        int res = 0;
        if (!isNum) {
            // 可以跳过当前数位
            res = f(i + 1, state, false, false);
        }
        int up = isLimit ? s[i] - '0' : 9;
        for (int d = isNum ? 0 : 1; d <= up; d++) {
            // 枚举要填入的数字 d
            if ((state >> d & 1) == 0) {
                // d 不在 mask 中
                res += f(i + 1, state | (1 << d), isLimit && d == up, true);
            }
        }
        if (!isLimit && isNum) {
            dp[i][state] = res;
        }
        return res;
    }
}
/*
1012. 至少有 1 位重复的数字
https://leetcode.cn/problems/numbers-with-repeated-digits/

给定正整数 n，返回在 [1, n] 范围内具有 至少 1 位 重复数字的正整数的个数。
提示：
1 <= n <= 10^9

数位 DP
相似题目: 357. 统计各位数字都不同的数字个数
https://leetcode.cn/problems/count-numbers-with-unique-digits/
 */