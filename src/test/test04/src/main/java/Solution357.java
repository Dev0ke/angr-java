import java.util.Arrays;

public class Solution357 {
    public int countNumbersWithUniqueDigits(int n) {
        return count((int) (Math.pow(10, n) - 1));
    }

    private int count(int num) {
        s = String.valueOf(num).toCharArray();
        dp = new int[10][1 << 10];
        for (int i = 0; i < 10; i++) {
            Arrays.fill(dp[i], -1);
        }
        return f(0, 0, true, false);
    }

    private char[] s;
    private int[][] dp;

    private int f(int i, int stats, boolean isLimit, boolean isNum) {
        if (i == s.length) return 1;
        if (!isLimit && isNum && dp[i][stats] != -1) return dp[i][stats];
        int res = 0;
        if (!isNum) {
            res = f(i + 1, stats, false, false);
        }
        int down = isNum ? 0 : 1;
        int up = isLimit ? s[i] - '0' : 9;
        for (int d = down; d <= up; d++) {
            if ((stats >> d & 1) == 0) {
                res += f(i + 1, stats | (1 << d), isLimit && d == up, true);
            }
        }
        if (!isLimit && isNum) dp[i][stats] = res;
        return res;
    }
}
/*
357. 统计各位数字都不同的数字个数
https://leetcode.cn/problems/count-numbers-with-unique-digits/

给你一个整数 n ，统计并返回各位数字都不同的数字 x 的个数，其中 0 <= x < 10^n 。
提示：
0 <= n <= 8

打表/数位 DP
相似题目: 1012. 至少有 1 位重复的数字
https://leetcode.cn/problems/numbers-with-repeated-digits/
 */