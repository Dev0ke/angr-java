import java.util.Arrays;

public class Solution2930 {
    private static final int MOD = (int) (1e9 + 7);
    private long[][][][] memo;

    public int stringCount(int n) {
        memo = new long[n + 1][2][3][2];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 3; k++) {
                    Arrays.fill(memo[i][j][k], -1);
                }
            }
        }
        return (int) dfs(n, 1, 2, 1);
    }

    // 分组背包求方案数，每组都可以从 a 到 z 中选一个物品，求至少有 1 个 l，2 个 e，1 个 t 的方案数
    private long dfs(int i, int cl, int ce, int ct) {
        if (i == 0) {
            if (cl == 0 && ce == 0 && ct == 0) return 1;
            return 0;
        }
        if (memo[i][cl][ce][ct] != -1) {
            return memo[i][cl][ce][ct];
        }
        long res = dfs(i - 1, 0, ce, ct) % MOD; // l
        res = (res + dfs(i - 1, cl, ce, 0)) % MOD; // t
        res = (res + dfs(i - 1, cl, Math.max(ce - 1, 0), ct)) % MOD; // e
        res = (res + dfs(i - 1, cl, ce, ct) * 23) % MOD; // 其他
        return memo[i][cl][ce][ct] = res;
    }

    // 时间复杂度 O(1)
    public int stringCount2(int n) {
        long ans = quickPow(26, n)
                - quickPow(25, n - 1) * (3 * 25 + n)
                + quickPow(24, n - 1) * (3 * 24 + n * 2L)
                - quickPow(23, n - 1) * (23 + n);
        return (int) ((ans % MOD + MOD) % MOD);
    }

    // 模下的 a^b
    private static long quickPow(long a, long b) {
        long res = 1L;
        while (b > 0) {
            if ((b & 1) == 1) {
                res = res * a % MOD;
            }
            a = a * a % MOD;
            b >>= 1;
        }
        return res;
    }
}
/*
2930. 重新排列后包含指定子字符串的字符串数目
https://leetcode.cn/problems/number-of-strings-which-can-be-rearranged-to-contain-substring/description/

第 117 场双周赛 T3。

给你一个整数 n 。
如果一个字符串 s 只包含小写英文字母，且 将 s 的字符重新排列后，新字符串包含 子字符串 "leet" ，那么我们称字符串 s 是一个 好 字符串。
比方说：
- 字符串 "lteer" 是好字符串，因为重新排列后可以得到 "leetr" 。
- "letl" 不是好字符串，因为无法重新排列并得到子字符串 "leet" 。
请你返回长度为 n 的好字符串 总 数目。
由于答案可能很大，将答案对 10^9 + 7 取余 后返回。
子字符串 是一个字符串中一段连续的字符序列。
提示：
1 <= n <= 10^5

记忆化搜索 O(n) / 容斥原理 O(logn)
至少满足一个条件：
[1] 不含 l：方案数 25^n
[2] 不含 t：方案数 25^n
[3] 不含 e：方案数 25^n；恰好包含一个 e：先从 n 个位置中选一个填 e，然后剩下 n-1 个位置不能包含 e，方案数 n*25^(n-1)
至少满足两个条件：
不含 l 和 t：24^n
不含 l 和 e 个数小于 2：同 [3] 额外不能填 l：24^n + n*24^(n-1)
不含 t 和 e 个数小于 2：同 [3] 额外不能填 t：24^n + n*24^(n-1)
满足三个条件：
同 [3] 额外不能填 l 和 t：23^n + n*23^(n-1)
ans = 26^n - 3*25^n - n*25^(n-1) + 3 * (24^n + n*24^(n-1)) - 23^n + n*23^(n-1)
 */