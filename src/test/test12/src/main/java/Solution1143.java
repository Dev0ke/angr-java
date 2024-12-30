public class Solution1143 {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();

        // f[i][j] 表示 text1 前 i 个元素与 text2 前 j 个元素的最长公共子序列
        int[][] f = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            char c1 = text1.charAt(i - 1);
            for (int j = 1; j <= m; j++) {
                char c2 = text2.charAt(j - 1);
                if (c1 == c2) {
                    f[i][j] = f[i - 1][j - 1] + 1;
                } else {
                    f[i][j] = Math.max(f[i - 1][j], f[i][j - 1]);
                }
            }
        }
        return f[n][m];
    }
}
/*
1143. 最长公共子序列
https://leetcode.cn/problems/longest-common-subsequence/

给定两个字符串 text1 和 text2，返回这两个字符串的最长 公共子序列 的长度。如果不存在 公共子序列 ，返回 0 。
一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
- 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。
两个字符串的 公共子序列 是这两个字符串所共同拥有的子序列。
提示：
1 <= text1.length, text2.length <= 1000
text1 和 text2 仅由小写英文字符组成。

LCS 裸题。动态规划。
dp[i][j] 表示 text1[0:i-1] 长度 i 与 text2[0:j-1] 长度 j 的最长公共子序列的长度
初始化
dp[0][j] = 0
dp[i][0] = 0
状态转移
若 text1[i-1] == text2[j-1] 则 dp[i][j] = dp[i-1][j-1] + 1
若 text1[i-1] != text2[j-1] 则 dp[i][j] = max(dp[i-1][j] + dp[i][j-1])
时间复杂度 O(mn)
空间复杂度 O(mn)
 */