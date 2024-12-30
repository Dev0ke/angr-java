public class Solution1977 {
    private static final int MOD = (int) (1e9 + 7);
    private String num;
    private int[][] lcp;

    public int numberOfCombinations(String num) {
        if (num.startsWith("0")) {
            return 0;
        }

        this.num = num;
        int n = num.length();
        // 计算 lcp
        lcp = new int[n + 1][n + 1];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (num.charAt(i) == num.charAt(j)) {
                    lcp[i][j] = lcp[i + 1][j + 1] + 1;
                }
            }
        }

        // f[i][j] 表示 num 的前 j 个字符划分出的最后一个整数的起始位置为 i 时的方案数
        int[][] f = new int[n][n];
        for (int j = 0; j < n; j++) {
            f[0][j] = 1;
        }
        for (int i = 1; i < n; i++) {
            if (num.charAt(i) == '0') {
                continue;
            }
            int sum = 0;
            // k 和 j 同时向左向右扩展
            for (int j = i, k = i - 1; j < n; j++, k--) {
                // 对应上面所说的长度小于最后一个划分出的整数
                f[i][j] = sum;
                if (k < 0) {
                    continue;
                }
                if (num.charAt(k) > '0' && lessEq(k, i, j + 1)) {
                    // 对应上面所说的长度等于最后一个划分出的整数
                    f[i][j] = (f[i][j] + f[k][i - 1]) % MOD;
                }
                sum = (sum + f[k][i - 1]) % MOD;
            }
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            res = (res + f[i][n - 1]) % MOD;
        }
        return res;
    }

    // 返回 s[l1:l2] <= s[l2:r2]
    private boolean lessEq(int l1, int l2, int r2) {
        int l = lcp[l1][l2];
        return l >= r2 - l2 || num.charAt(l1 + l) < num.charAt(l2 + l);
    }
}
/*
1977. 划分数字的方案数
https://leetcode.cn/problems/number-of-ways-to-separate-numbers/

第 59 场双周赛 T4。

你写下了若干 正整数 ，并将它们连接成了一个字符串 num 。但是你忘记给这些数字之间加逗号了。你只记得这一列数字是 非递减 的且 没有 任何数字有前导 0 。
请你返回有多少种可能的 正整数数组 可以得到字符串 num 。由于答案可能很大，将结果对 10^9 + 7 取余 后返回。
提示：
1 <= num.length <= 3500
num 只含有数字 '0' 到 '9' 。

预处理 + 动态规划
时间复杂度 O(n^2)
 */