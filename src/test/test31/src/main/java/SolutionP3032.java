import java.util.Arrays;

public class SolutionP3032 {
    public int numberCount(int a, int b) {
        return count(b) - count(a - 1);
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
$3032. 统计各位数字都不同的数字个数 II
https://leetcode.cn/problems/count-numbers-with-unique-digits-ii/description/

给你两个 正整数 a 和 b ，返回 闭区间 [a, b] 内各位数字都不同的数字个数。
提示：
1 <= a <= b <= 1000

数位 DP。
 */