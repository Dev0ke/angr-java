import java.util.Arrays;

public class Solution1397 {
    private static final long MOD = (long) (1e9 + 7);
    private char[] s1c, s2c, evilc;
    private long[][] dp;
    private int[] pi;

    public int findGoodStrings(int n, String s1, String s2, String evil) {
        this.s1c = s1.toCharArray();
        this.s2c = s2.toCharArray();
        this.evilc = evil.toCharArray();

        int m = evil.length();
        dp = new long[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        this.pi = prefix_function(evilc);

        return (int) f(0, 0, true, true);
    }

    private long f(int i, int stats, boolean downLimit, boolean upLimit) {
        if (i == s1c.length) {
            return 1;
        }
        // 记忆化搜索
        if (!downLimit && !upLimit && dp[i][stats] != -1) {
            return dp[i][stats];
        }
        long res = 0;
        char down = downLimit ? s1c[i] : 'a';
        char up = upLimit ? s2c[i] : 'z';
        for (char ch = down; ch <= up; ch++) {
            int nextStats = getNextStats(stats, ch);
            if (nextStats == evilc.length) {
                continue;
            }
            res += f(i + 1, nextStats, downLimit && ch == s1c[i], upLimit && ch == s2c[i]);
            res %= MOD;
        }

        if (!downLimit && !upLimit) {
            dp[i][stats] = res;
        }
        return res;
    }

    private int getNextStats(int stats, char ch) {
        while (stats != 0 && evilc[stats] != ch) {
            stats = pi[stats - 1];
        }
        return (evilc[stats] == ch) ? stats + 1 : 0;
    }

    private int[] prefix_function(char[] s) {
        int n = s.length;
        int[] pi = new int[n];
        for (int i = 1; i < n; i++) {
            int j = pi[i - 1];
            while (j > 0 && s[i] != s[j]) j = pi[j - 1];
            if (s[i] == s[j]) j++;
            pi[i] = j;
        }
        return pi;
    }
}
/*
1397. 找到所有好字符串
https://leetcode.cn/problems/find-all-good-strings/

给你两个长度为 n 的字符串 s1 和 s2 ，以及一个字符串 evil 。请你返回 好字符串 的数目。
好字符串 的定义为：它的长度为 n ，字典序大于等于 s1 ，字典序小于等于 s2 ，且不包含 evil 为子字符串。
由于答案可能很大，请你返回答案对 10^9 + 7 取余的结果。
提示：
s1.length == n
s2.length == n
s1 <= s2
1 <= n <= 500
1 <= evil.length <= 50
所有字符串都只包含小写英文字母。

数位 DP + KMP
 */