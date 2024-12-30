public class SolutionP1216 {
    public boolean isValidPalindrome(String s, int k) {
        int n = s.length();
        char[] cs = s.toCharArray();
        // 区间 DP
        // f[i][j] = k 表示 [i,j] 是 k 回文
        int[][] f = new int[n][n];
        for (int span = 2; span <= n; span++) {
            for (int i = 0; i + span - 1 < n; i++) {
                int j = i + span - 1;
                f[i][j] = Math.min(f[i + 1][j] + 1, f[i][j - 1] + 1);
                if (cs[i] == cs[j]) {
                    f[i][j] = Math.min(f[i][j], f[i + 1][j - 1]);
                }
            }
        }
        return f[0][n - 1] <= k;
    }
}
/*
$1216. 验证回文字符串 III
https://leetcode.cn/problems/valid-palindrome-iii/

给出一个字符串 s 和一个整数 k，若这个字符串是一个「k 回文 」，则返回 true 。
如果可以通过从字符串中删去最多 k 个字符将其转换为回文，那么这个字符串就是一个「k 回文 」。
提示：
1 <= s.length <= 1000
s 中只含有小写英文字母
1 <= k <= s.length

区间 DP
时间复杂度 O(n^2)
相似题目: 516. 最长回文子序列
https://leetcode.cn/problems/longest-palindromic-subsequence/
1312. 让字符串成为回文串的最少插入次数
https://leetcode.cn/problems/minimum-insertion-steps-to-make-a-string-palindrome/
$1682. 最长回文子序列 II
https://leetcode.cn/problems/longest-palindromic-subsequence-ii/
 */