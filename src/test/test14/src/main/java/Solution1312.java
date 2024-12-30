public class Solution1312 {
    public int minInsertions(String s) {
        int n = s.length();
        char[] cs = s.toCharArray();
        // f[i][j] 表示 [i,j] 区间最少添加字符的数量，使 [i,j] 变为回文串
        int[][] f = new int[n][n];
        for (int span = 2; span <= n; span++) {
            for (int i = 0; i + span - 1 < n; i++) {
                int j = i + span - 1;
                f[i][j] = Math.min(f[i + 1][j], f[i][j - 1]) + 1;
                if (cs[i] == cs[j]) {
                    f[i][j] = Math.min(f[i][j], f[i + 1][j - 1]);
                }
            }
        }
        return f[0][n - 1];
    }
}
/*
1312. 让字符串成为回文串的最少插入次数
https://leetcode.cn/problems/minimum-insertion-steps-to-make-a-string-palindrome/

给你一个字符串 s ，每一次操作你都可以在字符串的任意位置插入任意字符。
请你返回让 s 成为回文串的 最少操作次数 。
「回文串」是正读和反读都相同的字符串。
提示：
1 <= s.length <= 500
s 中所有字符都是小写字母。

区间 DP
时间复杂度 O(n^2)
空间复杂度 O(n^2)
相似题目: 516. 最长回文子序列
https://leetcode.cn/problems/longest-palindromic-subsequence/
$1216. 验证回文字符串 III
https://leetcode.cn/problems/valid-palindrome-iii/
$1682. 最长回文子序列 II
https://leetcode.cn/problems/longest-palindromic-subsequence-ii/
 */