import java.util.List;

public class Solution3337 {
    private static final int MOD = (int) (1e9 + 7);
    private static final int SIZE = 26;

    public int lengthAfterTransformations(String s, int t, List<Integer> nums) {
        long[][] f0 = new long[SIZE][1];
        for (int i = 0; i < SIZE; i++) {
            f0[i][0] = 1;
        }
        long[][] M = new long[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            int c = nums.get(i);
            for (int j = i + 1; j <= i + c; j++) {
                M[i][j % SIZE] = 1;
            }
        }
        M = mat_pow(M, t);
        M = mat_mul(M, f0);

        long ans = 0;
        for (char c : s.toCharArray()) {
            int b = (c - 'a');
            ans = (ans + M[b][0]) % MOD;
        }
        return (int) ans;
    }

    // 矩阵快速幂 res[][] = a[][]^b
    static long[][] mat_pow(long[][] a, long b) {
        int n = a.length;
        // 对角矩阵
        long[][] res = new long[n][n];
        for (int i = 0; i < n; i++) res[i][i] = 1;
        while (b > 0) {
            if ((b & 1) == 1) {
                res = mat_mul(res, a);
            }
            a = mat_mul(a, a);
            b >>= 1;
        }
        return res;
    }

    // 矩阵乘法 res[][] = a[][] * b[][]
    static long[][] mat_mul(long[][] a, long[][] b) {
        int n = a.length;
        int m = b[0].length;
        long[][] res = new long[n][m];
        for (int i = 0; i < n; i++) {
            for (int k = 0; k < n; k++) {
                if (a[i][k] == 0) continue;
                for (int j = 0; j < m; j++) {
                    res[i][j] += a[i][k] * b[k][j] % MOD;
                    res[i][j] %= MOD;
                }
            }
        }
        return res;
    }
}
/*
3337. 字符串转换后的长度 II
https://leetcode.cn/problems/total-characters-in-string-after-transformations-ii/description/

第 421 场周赛 T4。

给你一个由小写英文字母组成的字符串 s，一个整数 t 表示要执行的 转换 次数，以及一个长度为 26 的数组 nums。每次 转换 需要根据以下规则替换字符串 s 中的每个字符：
- 将 s[i] 替换为字母表中后续的 nums[s[i] - 'a'] 个连续字符。例如，如果 s[i] = 'a' 且 nums[0] = 3，则字符 'a' 转换为它后面的 3 个连续字符，结果为 "bcd"。
- 如果转换超过了 'z'，则 回绕 到字母表的开头。例如，如果 s[i] = 'y' 且 nums[24] = 3，则字符 'y' 转换为它后面的 3 个连续字符，结果为 "zab"。
返回 恰好 执行 t 次转换后得到的字符串的 长度。
由于答案可能非常大，返回其对 10^9 + 7 取余的结果。
提示：
1 <= s.length <= 105
s 仅由小写英文字母组成。
1 <= t <= 10^9
nums.length == 26
1 <= nums[i] <= 25

矩阵快速幂优化 DP
https://leetcode.cn/problems/total-characters-in-string-after-transformations-ii/solutions/2967037/ju-zhen-kuai-su-mi-you-hua-dppythonjavac-cd2j/
rating 2400 (clist.by)
 */