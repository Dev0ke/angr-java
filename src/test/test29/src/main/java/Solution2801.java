import java.math.BigInteger;
import java.util.Arrays;

public class Solution2801 {
    private static final int MOD = (int) (1e9 + 7);

    public int countSteppingNumbers(String low, String high) {
        long ans1 = count(new BigInteger(low).subtract(BigInteger.ONE).toString());
        long ans2 = count(high);
        return (int) (((ans2 - ans1) % MOD + MOD) % MOD);
    }

    private char[] s;
    private long[][] dp;

    private long count(String num) {
        s = num.toCharArray();
        int n = num.length();
        dp = new long[n][10];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return f(0, 0, true, false);
    }

    // pre:上一个数字
    private long f(int i, int pre, boolean isLimit, boolean isNum) {
        if (i == s.length) {
            return isNum ? 1 : 0;
        }
        if (!isLimit && isNum && dp[i][pre] != -1) {
            return dp[i][pre];
        }
        long ans = 0L;
        if (!isNum) {
            ans += f(i + 1, pre, false, false);
            ans %= MOD;
        }
        int down = isNum ? 0 : 1;
        int up = isLimit ? s[i] - '0' : 9;
        for (int d = down; d <= up; d++) {
            if (Math.abs(d - pre) == 1 || !isNum) {
                ans += f(i + 1, d, isLimit && d == up, true);
                ans %= MOD;
            }
        }
        if (!isLimit && isNum) {
            dp[i][pre] = ans;
        }
        return ans;
    }
}
/*
2801. 统计范围内的步进数字数目
https://leetcode.cn/problems/count-stepping-numbers-in-range/

第 356 场周赛 T4。

给你两个正整数 low 和 high ，都用字符串表示，请你统计闭区间 [low, high] 内的 步进数字 数目。
如果一个整数相邻数位之间差的绝对值都 恰好 是 1 ，那么这个数字被称为 步进数字 。
请你返回一个整数，表示闭区间 [low, high] 之间步进数字的数目。
由于答案可能很大，请你将它对 10^9 + 7 取余 后返回。
注意：步进数字不能有前导 0 。
提示：
1 <= int(low) <= int(high) < 10100
1 <= low.length, high.length <= 100
low 和 high 只包含数字。
low 和 high 都不含前导 0 。

数位 dp
时间复杂度 O(10·n)
相似题目: 2719. 统计整数数目
https://leetcode.cn/problems/count-of-integers/
 */