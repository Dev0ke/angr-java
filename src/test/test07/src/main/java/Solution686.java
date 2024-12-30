import java.util.HashSet;
import java.util.Set;

public class Solution686 {
    private static final int BASE = 26;
    private static final long MOD1 = 1000000007;
    private static final long MOD2 = 1000000009;

    public int repeatedStringMatch(String a, String b) {
        int lenA = a.length();
        int lenB = b.length();

        // b 的哈希值
        long hashB1 = 0;
        long hashB2 = 0;
        for (int i = 0; i < lenB; i++) {
            int id = b.charAt(i) - 'a';
            hashB1 = (hashB1 * BASE + id) % MOD1;
            hashB2 = (hashB2 * BASE + id) % MOD2;
        }

        // 0 下标开始 a 的哈希值
        long hashA1 = 0;
        long hashA2 = 0;
        for (int i = 0; i < lenB; i++) {
            int id = a.charAt(i % lenA) - 'a';
            hashA1 = (hashA1 * BASE + id) % MOD1;
            hashA2 = (hashA2 * BASE + id) % MOD2;
        }
        if (hashA1 == hashB1 && hashA2 == hashB2) {
            // 数论上取整 / a.startsWith(b) == true
            return Math.max(1, (lenB + lenA - 1) / lenA);
        }

        Set<Long> hashSet1 = new HashSet<>();
        Set<Long> hashSet2 = new HashSet<>();
        hashSet1.add(hashA1);
        hashSet2.add(hashA2);
        long aL1 = quickPow(BASE, lenB, MOD1);
        long aL2 = quickPow(BASE, lenB, MOD2);
        // 1 开始
        for (int i = 1; ; i++) {
            int id1 = a.charAt((i - 1) % a.length()) - 'a';
            int id2 = a.charAt((i - 1 + lenB) % a.length()) - 'a';
            hashA1 = (hashA1 * BASE - id1 * aL1 % MOD1 + MOD1) % MOD1;
            hashA1 = (hashA1 + id2) % MOD1;

            hashA2 = (hashA2 * BASE - id1 * aL2 % MOD2 + MOD2) % MOD2;
            hashA2 = (hashA2 + id2) % MOD2;

            if (hashA1 == hashB1 && hashA2 == hashB2) {
                // 数论上取整
                return (i + lenB + lenA - 1) / lenA;
            }
            // 最少循环 lenA 次
            if (!hashSet1.contains(hashA1) || !hashSet2.contains(hashA2) || i < lenA) {
                hashSet1.add(hashA1);
                hashSet2.add(hashA2);
            } else {
                return -1;
            }
        }
    }

    // res = a^b % mod
    private long quickPow(long a, long b, long mod) {
        long res = 1L;
        while (b > 0) {
            if ((b & 1) == 1) {
                res = res * a % mod;
            }
            a = a * a % mod;
            b >>= 1;
        }
        return res;
    }
}
/*
686. 重复叠加字符串匹配
https://leetcode.cn/problems/repeated-string-match/

给定两个字符串 a 和 b，寻找重复叠加字符串 a 的最小次数，使得字符串 b 成为叠加后的字符串 a 的子串，如果不存在则返回 -1。
注意：字符串 "abc" 重复叠加 0 次是 ""，重复叠加 1 次是 "abc"，重复叠加 2 次是 "abcabc"。
提示：
1 <= a.length <= 10^4
1 <= b.length <= 10^4
a 和 b 由小写英文字母组成

Rabin-Karp 字符串哈希算法
时间复杂度 O(n+m) 其中 n == a.length, m == b.length
空间复杂度 O(1)
 */