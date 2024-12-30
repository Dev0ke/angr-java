import java.util.Arrays;

public class Solution903 {
    // 2ms 时间复杂度 O(n^2)
    static class V1 {
        private static final int MOD = (int) (1e9 + 7);

        public int numPermsDISequence(String s) {
            int n = s.length();

            // dp[i][j] means the number of possible permutations of first i + 1 digits,
            // where the i + 1th digit is j + 1th smallest in the rest of unused digits.
            long[][] f = new long[n + 1][n + 1];
            Arrays.fill(f[0], 1);

            for (int i = 0; i < n; i++) {
                long cur = 0;
                if (s.charAt(i) == 'I') {
                    for (int j = 0; j < n - i; j++) {
                        cur = (cur + f[i][j]) % MOD;
                        f[i + 1][j] = cur;
                    }
                } else {
                    for (int j = n - i - 1; j >= 0; j--) {
                        cur = (cur + f[i][j + 1]) % MOD;
                        f[i + 1][j] = cur;
                    }
                }
            }
            return (int) f[n][0];
        }
    }

    // 2ms 滚动数组 优化
    static class V2 {
        private static final int MOD = (int) (1e9 + 7);

        public int numPermsDISequence(String s) {
            int n = s.length();
            long[] f = new long[n + 1];
            Arrays.fill(f, 1);

            for (int i = 0; i < n; i++) {
                long cur = 0;
                long[] g = new long[n + 1];
                if (s.charAt(i) == 'I') {
                    for (int j = 0; j < n - i; j++) {
                        cur = (cur + f[j]) % MOD;
                        g[j] = cur;
                    }
                } else {
                    for (int j = n - i - 1; j >= 0; j--) {
                        cur = (cur + f[j + 1]) % MOD;
                        g[j] = cur;
                    }
                }
                f = g;
            }
            return (int) f[0];
        }
    }
}
/*
903. DI 序列的有效排列
https://leetcode.cn/problems/valid-permutations-for-di-sequence/description/

给定一个长度为 n 的字符串 s ，其中 s[i] 是:
- “D” 意味着减少，或者
- “I” 意味着增加
有效排列 是对有 n + 1 个在 [0, n]  范围内的整数的一个排列 perm ，使得对所有的 i：
- 如果 s[i] == 'D'，那么 perm[i] > perm[i+1]，以及；
- 如果 s[i] == 'I'，那么 perm[i] < perm[i+1]。
返回 有效排列  perm的数量 。因为答案可能很大，所以请返回你的答案对 10^9 + 7 取余。
提示:
n == s.length
1 <= n <= 200
s[i] 不是 'I' 就是 'D'

动态规划。
时间复杂度 O(n^2)
详见官解：https://leetcode.com/problems/valid-permutations-for-di-sequence/solutions/168278/C++JavaPython-DP-Solution-O(N2)/
相似题目: $484. 寻找排列
https://leetcode.cn/problems/find-permutation/
2375. 根据模式串构造最小数字
https://leetcode.cn/problems/construct-smallest-number-from-di-string/
 */