import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution2842 {
    private static final int MOD = (int) (1e9 + 7);

    public int countKSubsequencesWithMaxBeauty(String s, int k) {
        int[] cntArr = new int[26];
        for (char ch : s.toCharArray()) {
            cntArr[ch - 'a']++;
        }

        List<Integer> cntList = new ArrayList<>();
        Map<Integer, Integer> cntcntMap = new HashMap<>();
        for (int c : cntArr) {
            if (c > 0) {
                cntList.add(c);
                cntcntMap.put(c, cntcntMap.getOrDefault(c, 0) + 1);
            }
        }
        cntList.sort(Comparator.reverseOrder());
        if (cntList.size() < k) {
            return 0;
        }

        long ans = 1;
        Map<Integer, Integer> chose = new HashMap<>();
        for (int i = 0; i < k; i++) {
            Integer v = cntList.get(i);
            chose.put(v, chose.getOrDefault(v, 0) + 1);
            ans = ans * v % MOD;
        }
        // C(n, m)
        int n = cntcntMap.get(cntList.get(k - 1));
        int m = chose.get(cntList.get(k - 1));
        Comb comb = new Comb(n);
        ans = ans * comb.binom(n, m) % MOD;
        return (int) ans;
    }

    private static class Comb {
        private final long[] fac, invfac;

        public Comb(int n) {
            fac = new long[n + 1];
            fac[0] = 1;
            for (int i = 1; i <= n; i++) {
                fac[i] = fac[i - 1] * i % MOD;
            }
            invfac = new long[n + 1];
            for (int i = 0; i <= n; i++) {
                invfac[i] = quickPow(fac[i], MOD - 2);
            }
        }

        // C(n, m) = n! / m!(n-m)!
        private long binom(int n, int m) {
            if (n < m || m < 0) return 0;
            return fac[n] * invfac[m] % MOD * invfac[n - m] % MOD;
        }

        // 模下的 a^b
        private long quickPow(long a, long b) {
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
}
/*
2842. 统计一个字符串的 k 子序列美丽值最大的数目
https://leetcode.cn/problems/count-k-subsequences-of-a-string-with-maximum-beauty/

第 112 场双周赛 T4。

给你一个字符串 s 和一个整数 k 。
k 子序列指的是 s 的一个长度为 k 的 子序列 ，且所有字符都是 唯一 的，也就是说每个字符在子序列里只出现过一次。
定义 f(c) 为字符 c 在 s 中出现的次数。
k 子序列的 美丽值 定义为这个子序列中每一个字符 c 的 f(c) 之 和 。
比方说，s = "abbbdd" 和 k = 2 ，我们有：
- f('a') = 1, f('b') = 3, f('d') = 2
- s 的部分 k 子序列为：
  - "abbbdd" -> "ab" ，美丽值为 f('a') + f('b') = 4
  - "abbbdd" -> "ad" ，美丽值为 f('a') + f('d') = 3
  - "abbbdd" -> "bd" ，美丽值为 f('b') + f('d') = 5
请你返回一个整数，表示所有 k 子序列 里面 美丽值 是 最大值 的子序列数目。由于答案可能很大，将结果对 10^9 + 7 取余后返回。
一个字符串的子序列指的是从原字符串里面删除一些字符（也可能一个字符也不删除），不改变剩下字符顺序连接得到的新字符串。
注意：
- f(c) 指的是字符 c 在字符串 s 的出现次数，不是在 k 子序列里的出现次数。
- 两个 k 子序列如果有任何一个字符在原字符串中的下标不同，则它们是两个不同的子序列。所以两个不同的 k 子序列可能产生相同的字符串。
提示：
1 <= s.length <= 2 * 10^5
1 <= k <= s.length
s 只包含小写英文字母。

贪心。组合数学。
先选频次大的，频次相等的计算不同的组合。
 */