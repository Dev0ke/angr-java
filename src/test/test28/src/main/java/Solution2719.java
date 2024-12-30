import java.math.BigInteger;
import java.util.Arrays;

public class Solution2719 {
    private static final int MOD = (int) (1e9 + 7);
    private int min_sum, max_sum;

    public int count(String num1, String num2, int min_sum, int max_sum) {
        this.min_sum = min_sum;
        this.max_sum = max_sum;
        long ans1 = count(new BigInteger(num1).subtract(BigInteger.ONE).toString());
        long ans2 = count(num2);
        return (int) (((ans2 - ans1) % MOD + MOD) % MOD);
    }

    private char[] s;
    private long[][] dp;

    private long count(String num) {
        s = num.toCharArray();
        int n = num.length();
        dp = new long[n][max_sum + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return f(0, 0, true, false);
    }

    private long f(int i, int sum, boolean isLimit, boolean isNum) {
        if (i == s.length) {
            if (!isNum) return 0;
            if (sum > max_sum || sum < min_sum) return 0;
            return 1;
        }
        if (sum > max_sum) return 0;
        if (!isLimit && isNum && dp[i][sum] != -1) {
            return dp[i][sum];
        }
        long ans = 0L;
        if (!isNum) {
            ans += f(i + 1, sum, false, false);
            ans %= MOD;
        }
        int down = isNum ? 0 : 1;
        int up = isLimit ? s[i] - '0' : 9;
        for (int d = down; d <= up; d++) {
            ans += f(i + 1, sum + d, isLimit && d == up, true);
            ans %= MOD;
        }
        if (!isLimit && isNum) {
            dp[i][sum] = ans;
        }
        return ans;
    }
}
/*
2719. 统计整数数目
https://leetcode.cn/problems/count-of-integers/

第 348 场周赛 T4。

给你两个数字字符串 num1 和 num2 ，以及两个整数 max_sum 和 min_sum 。如果一个整数 x 满足以下条件，我们称它是一个好整数：
- num1 <= x <= num2
- min_sum <= digit_sum(x) <= max_sum.
请你返回好整数的数目。答案可能很大，请返回答案对 10^9 + 7 取余后的结果。
注意，digit_sum(x) 表示 x 各位数字之和。
提示：
1 <= num1 <= num2 <= 10^22
1 <= min_sum <= max_sum <= 400

数位 DP
时间复杂度 O(n * max_sum) 其中 n = num2.length。
相似题目: 2376. 统计特殊整数
https://leetcode.cn/problems/count-special-integers/
 */