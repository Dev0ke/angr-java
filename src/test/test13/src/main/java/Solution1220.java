import java.util.Arrays;

public class Solution1220 {
    private static final int MOD = (int) (1e9 + 7);
    // aeiou -> 01234
    private static final int[][] TRANSIT = {{1}, {0, 2}, {0, 1, 3, 4}, {2, 4}, {0}};
    private int n;
    private long[][] memo;

    public int countVowelPermutation(int n) {
        this.n = n;
        memo = new long[n][5];
        for (int i = 0; i < n; i++) {
            Arrays.fill(memo[i], -1);
        }
        long ans = 0;
        for (int j = 0; j < 5; j++) {
            ans += dfs(1, j);
        }
        return (int) (ans % MOD);
    }

    // 上一个数填了 j
    private long dfs(int i, int j) {
        if (i == n) return 1;
        if (memo[i][j] != -1) return memo[i][j];
        long res = 0;
        for (int nj : TRANSIT[j]) {
            res += dfs(i + 1, nj);
            res %= MOD;
        }
        return memo[i][j] = res;
    }
}
/*
1220. 统计元音字母序列的数目
https://leetcode.cn/problems/count-vowels-permutation/description/

给你一个整数 n，请你帮忙统计一下我们可以按下述规则形成多少个长度为 n 的字符串：
- 字符串中的每个字符都应当是小写元音字母（'a', 'e', 'i', 'o', 'u'）
- 每个元音 'a' 后面都只能跟着 'e'
- 每个元音 'e' 后面只能跟着 'a' 或者是 'i'
- 每个元音 'i' 后面 不能 再跟着另一个 'i'
- 每个元音 'o' 后面只能跟着 'i' 或者是 'u'
- 每个元音 'u' 后面只能跟着 'a'
由于答案可能会很大，所以请你返回 模 10^9 + 7 之后的结果。
提示：
1 <= n <= 2 * 10^4

记忆化搜索。
时间复杂度 O(5n)。
相似题目: 1839. 所有元音按顺序排布的最长子字符串
https://leetcode.cn/problems/longest-substring-of-all-vowels-in-order/
 */