import java.util.Arrays;

public class Solution730 {
    private static final int MOD = (int) (1e9 + 7);

    public int countPalindromicSubsequences(String S) {
        char[] s = S.toCharArray();
        int n = s.length;
        int[][] pre = new int[n][4];
        int[][] next = new int[n][4];

        // 子序列自动机
        // 为了快速求得 low 和 high
        int[] pos = new int[4];
        Arrays.fill(pos, -1);
        for (int i = 0; i < n; i++) {
            System.arraycopy(pos, 0, pre[i], 0, 4);
            pos[s[i] - 'a'] = i;
        }
        Arrays.fill(pos, n);
        for (int i = n - 1; i >= 0; i--) {
            System.arraycopy(pos, 0, next[i], 0, 4);
            pos[s[i] - 'a'] = i;
        }

        // 区间 DP
        long[][] f = new long[n][n];
        for (int i = 0; i < n; i++) {
            f[i][i] = 1;
        }
        for (int span = 2; span <= n; span++) {
            for (int i = 0; i + span - 1 < n; i++) {
                int j = i + span - 1;
                if (s[i] == s[j]) {
                    int low = next[i][s[i] - 'a'];
                    int high = pre[j][s[i] - 'a'];
                    if (low > high) {
                        f[i][j] = 2 + f[i + 1][j - 1] * 2;
                    } else if (low == high) {
                        f[i][j] = 1 + f[i + 1][j - 1] * 2;
                    } else {
                        f[i][j] = f[i + 1][j - 1] * 2 - f[low + 1][high - 1];
                    }
                } else {
                    f[i][j] = f[i + 1][j] + f[i][j - 1] - f[i + 1][j - 1];
                }
                f[i][j] = (f[i][j] % MOD + MOD) % MOD;
            }
        }
        return (int) f[0][n - 1];
    }
}
/*
730. 统计不同回文子序列
https://leetcode.cn/problems/count-different-palindromic-subsequences/description/

给你一个字符串 s ，返回 s 中不同的非空回文子序列个数 。由于答案可能很大，请返回对 10^9 + 7 取余 的结果。
字符串的子序列可以经由字符串删除 0 个或多个字符获得。
如果一个序列与它反转后的序列一致，那么它是回文序列。
如果存在某个 i , 满足 ai != bi ，则两个序列 a1, a2, ... 和 b1, b2, ... 不同。
提示：
1 <= s.length <= 1000
s[i] 仅包含 'a', 'b', 'c' 或 'd'

区间 DP。
时间复杂度 O(n^2)。
 */