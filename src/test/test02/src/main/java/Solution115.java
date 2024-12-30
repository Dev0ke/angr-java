public class Solution115 {
    private static final int MOD = (int) (1e9 + 7);

    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        long[][] f = new long[n + 1][m + 1];
        f[0][0] = 1;
        for (int i = 0; i < n; i++) {
            f[i + 1][0] = 1;
            for (int j = 0; j <= i && j < m; j++) {
                if (s.charAt(i) == t.charAt(j)) {
                    f[i + 1][j + 1] = (f[i][j] + f[i][j + 1]) % MOD;
                } else {
                    f[i + 1][j + 1] = f[i][j + 1];
                }
            }
        }
        return (int) f[n][m];
    }
}
/*
115. 不同的子序列
https://leetcode.cn/problems/distinct-subsequences/

给定一个字符串 s 和一个字符串 t ，计算在 s 的子序列中 t 出现的个数。
字符串的一个 子序列 是指，通过删除一些（也可以不删除）字符且不干扰剩余字符相对位置所组成的新字符串。
（例如，"ACE"是"ABCDE"的一个子序列，而"AEC"不是）
题目数据保证答案符合 32 位带符号整数范围。
提示：
0 <= s.length, t.length <= 1000
s 和 t 由英文字母组成

动态规划。
用 f(i,j) 表示字符串 s 下标 0 到 i 等于字符串 t 下标 0 到 j 的子序列的数目。
当 s[i] == s[j] 则 f(i,j) = f(i-1,j-1) + f(i-1,j)
当 s[i] != s[j] 则 f(i,j) =  f(i-1,j)
 */