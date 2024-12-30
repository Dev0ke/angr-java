public class SolutionP1682 {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        char[] cs = s.toCharArray();
        // 区间 DP
        // f[i][j] 表示 [i,j] 区间最长"好的回文子序列"的长度；g[i][j] 表示 [i,j] 两边最近的回文字符
        int[][] f = new int[n][n];
        char[][] g = new char[n][n];
        for (int span = 2; span <= n; span++) {
            for (int i = 0; i + span - 1 < n; i++) {
                int j = i + span - 1;
                if (cs[i] == cs[j] && (f[i + 1][j - 1] == 0 || g[i + 1][j - 1] != cs[i])) {
                    f[i][j] = f[i + 1][j - 1] + 2;
                    g[i][j] = cs[i];
                } else {
                    if (f[i + 1][j] > f[i][j - 1]) {
                        f[i][j] = f[i + 1][j];
                        g[i][j] = g[i + 1][j];
                    } else {
                        f[i][j] = f[i][j - 1];
                        g[i][j] = g[i][j - 1];
                    }
                }
            }
        }
        return f[0][n - 1];
    }
}
/*
$1682. 最长回文子序列 II
https://leetcode.cn/problems/longest-palindromic-subsequence-ii/

字符串 s 的某个子序列符合下列条件时，称为“好的回文子序列”：
- 它是 s 的子序列。
- 它是回文序列（反转后与原序列相等）。
- 长度为偶数。
- 除中间的两个字符外，其余任意两个连续字符不相等。
例如，若 s = "abcabcabb"，则 "abba" 可称为“好的回文子序列”，而 "bcb" （长度不是偶数）和 "bbbb" （含有相等的连续字符）不能称为“好的回文子序列”。
给定一个字符串 s， 返回 s 的最长“好的回文子序列”的长度。
提示:
1 <= s.length <= 250
s 包含小写英文字母。

区间 DP
时间复杂度 O(n^2)
相似题目: 516. 最长回文子序列
https://leetcode.cn/problems/longest-palindromic-subsequence/
$1216. 验证回文字符串 III
https://leetcode.cn/problems/valid-palindrome-iii/
1312. 让字符串成为回文串的最少插入次数
https://leetcode.cn/problems/minimum-insertion-steps-to-make-a-string-palindrome/
 */