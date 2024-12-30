public class Solution926 {
    public int minFlipsMonoIncr(String s) {
        int len = s.length();
        if (len == 0) {
            return 0;
        }
        // 状态压缩
        int[][] dp = new int[2][2];
        char ch = s.charAt(0);
        dp[0][0] = (ch == '0') ? 0 : 1;
        dp[1][0] = (ch == '1') ? 0 : 1;

        for (int i = 1; i < len; i++) {
            ch = s.charAt(i);
            int prev1 = dp[0][(i - 1) % 2];
            int prev2 = dp[1][(i - 1) % 2];
            dp[0][i % 2] = prev1 + ((ch == '0') ? 0 : 1);
            dp[1][i % 2] = Math.min(prev1, prev2) + ((ch == '1') ? 0 : 1);
        }
        return Math.min(dp[0][(len - 1) % 2], dp[1][(len - 1) % 2]);
    }
}
/*
926. 将字符串翻转到单调递增
https://leetcode.cn/problems/flip-string-to-monotone-increasing/

第 107 场周赛 T2。

如果一个由'0' 和 '1'组成的字符串，是以一些 '0'（可能没有 '0'）后面跟着一些 '1'（也可能没有 '1'）的形式组成的，那么该字符串是单调递增的。
我们给出一个由字符 '0' 和 '1'组成的字符串 S，我们可以将任何'0' 翻转为'1'或者将'1'翻转为'0'。
返回使 S 单调递增的最小翻转次数。
提示：
1 <= s.length <= 10^5
s[i] 为 '0' 或 '1'

动态规划。
f(i) 表示把字符串中从下标 0 到 i 的字符变成符合要求的字符串并且 ‘0’ 结尾
g(i) 表示把字符串中从下标 0 到 i 的字符变成符合要求的字符串并且 ‘1’ 结尾
String s = "00110"
ch   0 0 1 1 0
i    0 1 2 3 4
f(i) 0 0 1 2 2
g(i) 1 1 0 0 1
时间复杂度 O(n)
空间复杂度 O(1)
 */
