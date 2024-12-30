public class Solution2851 {
    private static final int MOD = (int) (1e9 + 7);

    public int numberOfWays(String s, String t, long k) {
        int n = s.length();
        int c = kmpSearch(s + s.substring(0, n - 1), t);
        long[][] mat = {{c - 1, c}, {n - c, n - 1 - c}};
        long[][] mPowN = matQuickPow(mat, k);
        return (int) (s.equals(t) ? mPowN[0][0] : mPowN[0][1]);
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

    private int kmpSearch(String text, String pattern) {
        char[] txt = text.toCharArray();
        char[] pat = pattern.toCharArray();

        int[] pi = prefix_function(pat);
        int matchCnt = 0;
        for (int i = 0, j = 0; i < txt.length; i++) {
            while (j > 0 && txt[i] != pat[j]) j = pi[j - 1];
            if (txt[i] == pat[j]) j++;
            if (j == pat.length) {
                matchCnt++;
                j = pi[j - 1];
            }
        }
        return matchCnt;
    }

    // 矩阵快速幂 res = a^n
    private long[][] matQuickPow(long[][] a, long n) {
        int len = a.length;
        // 对角矩阵
        long[][] res = new long[len][len];
        for (int i = 0; i < len; i++) {
            res[i][i] = 1;
        }
        while (n > 0) {
            if ((n & 1) == 1) {
                res = matMulti(res, a);
            }
            n >>= 1;
            a = matMulti(a, a);
        }
        return res;
    }

    // 矩阵快速幂 res = a * b
    private long[][] matMulti(long[][] a, long[][] b) {
        int n = a.length;
        long[][] res = new long[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    res[i][j] += a[i][k] * b[k][j] % MOD;
                    res[i][j] %= MOD;
                }
            }
        }
        return res;
    }
}
/*
2851. 字符串转换
https://leetcode.cn/problems/string-transformation/

第 362 场周赛 T4。

给你两个长度都为 n 的字符串 s 和 t 。你可以对字符串 s 执行以下操作：
- 将 s 长度为 l （0 < l < n）的 后缀字符串 删除，并将它添加在 s 的开头。
比方说，s = 'abcd' ，那么一次操作中，你可以删除后缀 'cd' ，并将它添加到 s 的开头，得到 s = 'cdab' 。
给你一个整数 k ，请你返回 恰好 k 次操作将 s 变为 t 的方案数。
由于答案可能很大，返回答案对 10^9 + 7 取余 后的结果。
提示：
2 <= s.length <= 5 * 10^5
1 <= k <= 10^15
s.length == t.length
s 和 t 都只包含小写英文字母。

KMP + 组合数学 + 矩阵快速幂。严重超纲
相似题目: B. Word Cut
https://codeforces.com/contest/176/problem/B
3036. 匹配模式数组的子数组数目 II
https://leetcode.cn/problems/number-of-subarrays-that-match-a-pattern-ii/description/
$2912. 在网格上移动到目的地的方法数
https://leetcode.cn/problems/number-of-ways-to-reach-destination-in-the-grid/description/
 */