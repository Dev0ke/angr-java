public class Solution516 {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        if (n == 1) return 1;
        char[] cs = s.toCharArray();
        // f[i][j] 表示 [i,j] 区间最长回文子序列的长度
        int[][] f = new int[n][n];
        for (int span = 2; span <= n; span++) {
            for (int i = 0; i + span - 1 < n; i++) {
                f[i][i] = 1;
                int j = i + span - 1;
                if (cs[i] == cs[j]) {
                    f[i][j] = f[i + 1][j - 1] + 2;
                } else {
                    f[i][j] = Math.max(f[i + 1][j], f[i][j - 1]);
                }
            }
        }
        return f[0][n - 1];
    }
}
/*
516. 最长回文子序列
https://leetcode.cn/problems/longest-palindromic-subsequence/

给你一个字符串 s ，找出其中最长的回文子序列，并返回该序列的长度。
子序列定义为：不改变剩余字符顺序的情况下，删除某些字符或者不删除任何字符形成的一个序列。
提示：
1 <= s.length <= 1000
s 仅由小写英文字母组成

区间 DP
时间复杂度 O(n^2)
空间复杂度 O(n^2)
相似题目: $1216. 验证回文字符串 III
https://leetcode.cn/problems/valid-palindrome-iii/
1312. 让字符串成为回文串的最少插入次数
https://leetcode.cn/problems/minimum-insertion-steps-to-make-a-string-palindrome/
$1682. 最长回文子序列 II
https://leetcode.cn/problems/longest-palindromic-subsequence-ii/
1770. 执行乘法运算的最大分数
https://leetcode.cn/problems/maximum-score-from-performing-multiplication-operations/description/
 */