import java.util.HashMap;
import java.util.Map;

public class SolutionP2539 {
    private static final int MOD = (int) (1e9 + 7);

    //
    public int countGoodSubsequences(String s) {
        Map<Character, Integer> cnt = new HashMap<>();
        for (char c : s.toCharArray()) {
            cnt.merge(c, 1, Integer::sum);
        }

        Integer mx = cnt.values().stream().max(Integer::compareTo).orElseThrow();
        Comb comb = new Comb(mx);
        long ans = 0;
        for (int p = 1; p <= mx; p++) {
            long cur = 1;
            for (Integer v : cnt.values()) {
                cur *= comb.binom(v, p) + 1;
                cur %= MOD;
            }
            ans += cur - 1;
            ans %= MOD;
        }
        return (int) ans;
    }

    static class Comb {
        long[] fac, inv_fac;

        public Comb(int n) {
            fac = new long[n + 1];
            fac[0] = 1;
            for (int i = 1; i <= n; i++) fac[i] = fac[i - 1] * i % MOD;
            inv_fac = new long[n + 1];
            for (int i = 0; i <= n; i++) inv_fac[i] = quickPow(fac[i], MOD - 2);
        }

        // C(n, m) = n! / m!(n-m)!
        long binom(int n, int m) {
            if (n < m || m < 0) return 0;
            return fac[n] * inv_fac[m] % MOD * inv_fac[n - m] % MOD;
        }

        // 模下的 a^b
        long quickPow(long a, long b) {
            long res = 1L;
            while (b > 0) {
                if ((b & 1) != 0) res = res * a % MOD;
                a = a * a % MOD;
                b >>= 1;
            }
            return res;
        }
    }
}
/*
$2539. 好子序列的个数
https://leetcode.cn/problems/count-the-number-of-good-subsequences/description/

如果字符串的某个 子序列 不为空，且其中每一个字符出现的频率都相同，就认为该子序列是一个好子序列。
给你一个字符串 s ，请你统计并返回它的好子序列的个数。由于答案的值可能非常大，请返回对 10^9 + 7 取余的结果作为答案。
字符串的 子序列 是指，通过删除一些（也可以不删除）字符且不改变剩余字符相对位置所组成的新字符串。
提示：
1 <= s.length <= 10^4
s 仅由小写英文字母组成

计数+枚举每种可能的频率+预处理逆元算组合数。
https://leetcode.cn/problems/count-the-number-of-good-subsequences/solutions/2068936/by-v5qyy4q65w-wvte/
相似题目: 2514. 统计同位异构字符串数目
https://leetcode.cn/problems/count-anagrams/
 */