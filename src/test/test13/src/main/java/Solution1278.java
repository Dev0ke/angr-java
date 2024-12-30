import java.util.Arrays;

public class Solution1278 {
    public int palindromePartition(String s, int k) {
        int n = s.length();

        // 预处理
        int[][] cost = new int[n][n];
        for (int span = 2; span <= n; ++span) {
            for (int i = 0; i <= n - span; ++i) {
                int j = i + span - 1;
                cost[i][j] = cost[i + 1][j - 1] + (s.charAt(i) == s.charAt(j) ? 0 : 1);
            }
        }

        // f[i][j] 表示对于字符串 s 的前 i 个字符，将它分割成 j 个非空且不相交的回文串，最少需要修改的字符数
        int[][] f = new int[n + 1][k + 1];
        for (int i = 0; i < n + 1; i++) {
            Arrays.fill(f[i], Integer.MAX_VALUE);
        }
        f[0][0] = 0;
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= Math.min(k, i); ++j) {
                if (j == 1) {
                    f[i][j] = cost[0][i - 1];
                } else {
                    for (int i0 = j - 1; i0 < i; ++i0) {
                        f[i][j] = Math.min(f[i][j], f[i0][j - 1] + cost[i0][i - 1]);
                    }
                }
            }
        }
        return f[n][k];
    }
}
/*
1278. 分割回文串 III
https://leetcode.cn/problems/palindrome-partitioning-iii/

给你一个由小写字母组成的字符串 s，和一个整数 k。
请你按下面的要求分割字符串：
- 首先，你可以将 s 中的部分字符修改为其他的小写英文字母。
- 接着，你需要把 s 分割成 k 个非空且不相交的子串，并且每个子串都是回文串。
请返回以这种方式分割字符串所需修改的最少字符数。
提示：
1 <= k <= s.length <= 100
s 中只含有小写英文字母。

区间 DP
相似题目: 131. 分割回文串
https://leetcode.cn/problems/palindrome-partitioning/
132. 分割回文串 II
https://leetcode.cn/problems/palindrome-partitioning-ii/
 */