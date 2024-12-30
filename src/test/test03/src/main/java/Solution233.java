import java.util.Arrays;

public class Solution233 {
    private char[] s;
    private int[][] dp;

    // 数位 DP
    public int countDigitOne(int n) {
        s = String.valueOf(n).toCharArray();
        int len = s.length;
        dp = new int[len][10];
        for (int i = 0; i < len; i++) {
            Arrays.fill(dp[i], -1);
        }
        return f(0, 0, true);
    }

    private int f(int i, int sum, boolean isLimit) {
        if (i == s.length) {
            return sum;
        }
        // 记忆化搜索
        if (!isLimit && dp[i][sum] >= 0) {
            return dp[i][sum];
        }
        int res = 0;
        int up = isLimit ? s[i] - '0' : 9;
        for (int d = 0; d <= up; d++) {
            res += f(i + 1, sum + (d == 1 ? 1 : 0), isLimit && d == up);
        }
        if (!isLimit) {
            dp[i][sum] = res;
        }
        return res;
    }

    public int countDigitOne2(int n) {
        // mulk 表示 10^k
        // 在下面的代码中，可以发现 k 并没有被直接使用到（都是使用 10^k）
        // 但为了让代码看起来更加直观，这里保留了 k
        long mulk = 1;
        int ans = 0;
        for (int k = 0; n >= mulk; k++) {
            ans += (n / (mulk * 10)) * mulk + Math.min(Math.max(n % (mulk * 10) - mulk + 1, 0), mulk);
            mulk *= 10;
        }
        return ans;
    }
}
/*
233. 数字 1 的个数
https://leetcode.cn/problems/number-of-digit-one/

给定一个整数 n，计算所有小于等于 n 的非负整数中数字 1 出现的个数。
提示：
0 <= n <= 10^9

数位 DP
相似题目: 面试题 17.06. 2出现的次数
https://leetcode.cn/problems/number-of-2s-in-range-lcci/
 */