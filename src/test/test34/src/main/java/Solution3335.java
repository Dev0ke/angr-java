import java.util.List;

public class Solution3335 {
    public int lengthAfterTransformations(String s, int t) {
        return lengthAfterTransformations(s, t, List.of(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2));
    }

    private static final int MOD = (int) (1e9 + 7);
    private static final int SIZE = 26;

    // T4 3337
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
3335. 字符串转换后的长度 I
https://leetcode.cn/problems/total-characters-in-string-after-transformations-i/description/

第 421 场周赛 T2。

给你一个字符串 s 和一个整数 t，表示要执行的 转换 次数。每次 转换 需要根据以下规则替换字符串 s 中的每个字符：
- 如果字符是 'z'，则将其替换为字符串 "ab"。
- 否则，将其替换为字母表中的下一个字符。例如，'a' 替换为 'b'，'b' 替换为 'c'，依此类推。
返回 恰好 执行 t 次转换后得到的字符串的 长度。
由于答案可能非常大，返回其对 10^9 + 7 取余的结果。
提示：
1 <= s.length <= 10^5
s 仅由小写英文字母组成。
1 <= t <= 10^5

T4 的一种特殊情况。
相似题目: 3337. 字符串转换后的长度 II
https://leetcode.cn/problems/total-characters-in-string-after-transformations-ii/description/
 */