public class Solution2484 {
    private static final int MAX_N = 10;
    private static final int MOD = (int) (1e9 + 7);

    public int countPalindromes(String s) {
        int len = s.length();

        // 预处理
        int[] nums = new int[len];
        for (int i = 0; i < len; i++) {
            nums[i] = s.charAt(i) - '0';
        }

        long[][] c = new long[len + 1][MAX_N];
        long[][][] pre = new long[len + 1][MAX_N][MAX_N];
        for (int i = 1; i <= len; i++) {
            for (int j = 0; j < MAX_N; j++) {
                c[i][j] = c[i - 1][j];
            }
            c[i][nums[i - 1]]++;
            for (int j = 0; j < MAX_N; j++) {
                for (int k = 0; k < MAX_N; k++) {
                    pre[i][j][k] = pre[i - 1][j][k];
                }
            }
            for (int k = 0; k < MAX_N; k++) {
                pre[i][nums[i - 1]][k] = (pre[i][nums[i - 1]][k] + c[i - 1][k]) % MOD;
            }
        }


        long[][] d = new long[len + 2][MAX_N];
        long[][][] suf = new long[len + 2][MAX_N][MAX_N];
        for (int i = len; i >= 1; i--) {
            for (int j = 0; j < MAX_N; j++) {
                d[i][j] = d[i + 1][j];
            }
            d[i][nums[i - 1]]++;
            for (int j = 0; j < MAX_N; j++) {
                for (int k = 0; k < MAX_N; k++) {
                    suf[i][j][k] = suf[i + 1][j][k];
                }
            }
            for (int k = 0; k < MAX_N; k++) {
                suf[i][nums[i - 1]][k] = (suf[i][nums[i - 1]][k] + d[i + 1][k]) % MOD;
            }
        }

        long res = 0;
        for (int i = 1; i <= len; i++) {
            for (int j = 0; j < MAX_N; j++) {
                for (int k = 0; k < MAX_N; k++) {
                    res = (res + pre[i - 1][j][k] * suf[i + 1][j][k]) % MOD;
                }
            }
        }
        return (int) res;
    }
}
/*
2484. 统计回文子序列数目
https://leetcode.cn/problems/count-palindromic-subsequences/

第 92 场双周赛 T4。

给你数字字符串 s ，请你返回 s 中长度为 5 的 回文子序列 数目。由于答案可能很大，请你将答案对 10^9 + 7 取余 后返回。
提示：
- 如果一个字符串从前往后和从后往前读相同，那么它是 回文字符串 。
- 子序列是一个字符串中删除若干个字符后，不改变字符顺序，剩余字符构成的字符串。
提示：
1 <= s.length <= 10^4
s 只包含数字字符。

中心向两边扩展。
00 - 99 共 100 种可能的前后缀
时间复杂度 O(n * C^2)
相似题目: 1930. 长度为 3 的不同回文子序列
https://leetcode.cn/problems/unique-length-3-palindromic-subsequences/
 */