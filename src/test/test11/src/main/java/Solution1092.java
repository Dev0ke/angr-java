public class Solution1092 {
    public String shortestCommonSupersequence(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        str1 = " " + str1;
        str2 = " " + str2;
        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();

        // LCS
        int[][] f = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1[i] == s2[j]) {
                    f[i][j] = f[i - 1][j - 1] + 1;
                } else {
                    f[i][j] = Math.max(f[i - 1][j], f[i][j - 1]);
                }
            }
        }

        StringBuilder ans = new StringBuilder();
        int i = n;
        int j = m;
        while (i > 0 || j > 0) {
            if (i == 0) {
                ans.append(s2[j--]);
            } else if (j == 0) {
                ans.append(s1[i--]);
            } else {
                if (s1[i] == s2[j]) {
                    ans.append(s1[i]);
                    i--;
                    j--;
                } else if (f[i][j] == f[i - 1][j]) {
                    ans.append(s1[i--]);
                } else {
                    ans.append(s2[j--]);
                }
            }
        }
        return ans.reverse().toString();
    }
}
/*
1092. 最短公共超序列
https://leetcode.cn/problems/shortest-common-supersequence/

给出两个字符串 str1 和 str2，返回同时以 str1 和 str2 作为子序列的最短字符串。如果答案不止一个，则可以返回满足条件的任意一个答案。
（如果从字符串 T 中删除一些字符（也可能不删除，并且选出的这些字符可以位于 T 中的 任意位置），可以得到字符串 S，那么 S 就是 T 的子序列）
提示：
1 <= str1.length, str2.length <= 1000
str1 和 str2 都由小写英文字母组成。

LCS
最终的方案必然是由三部分组成：两字符串的公共子序列（且必然是最长公共子序列）+ 两者特有的字符部分。
时间复杂度 O(nm)
相似题目: 1143. 最长公共子序列
https://leetcode.cn/problems/longest-common-subsequence/
 */