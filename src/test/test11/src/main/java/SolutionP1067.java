import java.util.Arrays;

public class SolutionP1067 {
    private int x;

    public int digitsCount(int d, int low, int high) {
        x = d;
        return countDigitOne(high) - countDigitOne(low - 1);
    }

    private char[] s;
    private int[][] dp;

    private int countDigitOne(int n) {
        s = String.valueOf(n).toCharArray();
        int len = s.length;
        dp = new int[len][10];
        for (int i = 0; i < len; i++) {
            Arrays.fill(dp[i], -1);
        }
        return f(0, 0, true, false);
    }

    private int f(int i, int sum, boolean isLimit, boolean isNum) {
        if (i == s.length) {
            return isNum ? sum : 0;
        }
        // 记忆化搜索
        if (!isLimit && isNum && dp[i][sum] >= 0) {
            return dp[i][sum];
        }
        int res = 0;
        if (!isNum) {
            // 可以跳过当前数位
            res = f(i + 1, sum, false, false);
        }
        int up = isLimit ? s[i] - '0' : 9;
        for (int d = isNum ? 0 : 1; d <= up; d++) {
            res += f(i + 1, sum + (d == x ? 1 : 0), isLimit && d == up, true);
        }
        if (!isLimit && isNum) {
            dp[i][sum] = res;
        }
        return res;
    }
}
/*
$1067. 范围内的数字计数
https://leetcode.cn/problems/digit-count-in-range/

给定一个在 0 到 9 之间的整数 d，和两个正整数 low 和 high 分别作为上下界。返回 d 在 low 和 high 之间的整数中出现的次数，包括边界 low 和 high。
提示：
0 <= d <= 9
1 <= low <= high <= 2×10^8

数位 DP
相似题目: 233. 数字 1 的个数
https://leetcode.cn/problems/number-of-digit-one/
 */