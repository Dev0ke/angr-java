public class SolutionP2450 {
    private static final int MOD = (int) (1e9 + 7);

    public int countDistinctStrings(String s, int k) {
        return (int) quickPow(2, s.length() - k + 1);
    }

    // 快速幂 res = a^b % mod
    private long quickPow(long a, long b) {
        long res = 1L;
        while (b > 0) {
            if ((b & 1) != 0) res = res * a % MOD;
            a = a * a % MOD;
            b >>= 1;
        }
        return res;
    }
}
/*
$2450. 应用操作后不同二进制字符串的数量
https://leetcode.cn/problems/number-of-distinct-binary-strings-after-applying-operations/description/

给定一个 二进制 字符串 s 和一个正整数 k。
你可以对字符串应用以下操作 任意 次数:
- 从 s 中选择任何大小为 k 的子字符串，将其所有字符 翻转，即将所有 1 都变成 0，所有 0 都变成 1。
返回您可以获得的 不同 字符串的数量。因为答案可能太大，所以对 10^9 + 7 取模 后返回。
注意:
- 二进制字符串是 仅由 字符 0 和 1 组成的字符串。
- 子字符串是字符串的连续部分。

考虑s中长度为k的子串有 len(s)-k+1 个，每个子串有翻转与不翻转两个状态
 */