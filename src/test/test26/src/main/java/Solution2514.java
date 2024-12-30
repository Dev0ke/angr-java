public class Solution2514 {
    private static final int MOD = (int) (1e9 + 7);

    public int countAnagrams(String s) {
        long res = 1;
        long mul = 1;
        String[] ss = s.split(" ");
        for (int i = 0; i < ss.length; i++) {
            int[] cntArr = new int[26];
            for (int j = 0; j < ss[i].length(); j++) {
                int id = ss[i].charAt(j) - 'a';
                cntArr[id]++;
                mul = mul * cntArr[id] % MOD;
                res = res * (j + 1) % MOD;
            }
        }
        return (int) (res * inv(mul, MOD) % MOD);
    }

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

    /**
     * 求 a 在模 mod 下的乘法逆元
     */
    private long inv(long a, long mod) {
        return quickPow(a, mod - 2, mod);
    }
}
/*
2514. 统计同位异构字符串数目
https://leetcode.cn/problems/count-anagrams/

第 94 场双周赛 T4。

给你一个字符串 s ，它包含一个或者多个单词。单词之间用单个空格 ' ' 隔开。
如果字符串 t 中第 i 个单词是 s 中第 i 个单词的一个 排列 ，那么我们称字符串 t 是字符串 s 的同位异构字符串。
- 比方说，"acb dfe" 是 "abc def" 的同位异构字符串，但是 "def cab" 和 "adc bef" 不是。
请你返回 s 的同位异构字符串的数目，由于答案可能很大，请你将它对 10^9 + 7 取余 后返回。
提示：
1 <= s.length <= 10^5
s 只包含小写英文字母和空格 ' ' 。
相邻单词之间由单个空格隔开。

乘法逆元。
每个单词自己是互相独立的，因此分别计算每个单词的同位异构字符串的数目，再用乘法原理相乘。
时间复杂度 O(n + logM)。其中 M = 1e9+7。
相似题目: $2539. 好子序列的个数
https://leetcode.cn/problems/count-the-number-of-good-subsequences/description/
 */