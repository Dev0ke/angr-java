public class Solution1147 {
    private static final int BASE = 26;
    private static final long MOD1 = 1000000007;
    private static final long MOD2 = 1000000009;

    public int longestDecomposition(String text) {
        int len = text.length();
        int[] nums = new int[len];
        for (int i = 0; i < len; i++) {
            nums[i] = text.charAt(i) - 'a';
        }

        long hashL1 = 0;
        long hashL2 = 0;
        long hashR1 = 0;
        long hashR2 = 0;
        long aL1 = 1;
        long aL2 = 1;

        int res = 0;
        int lastI = -1;
        for (int i = 0; i < len / 2; i++) {
            hashL1 = (hashL1 * BASE + nums[i]) % MOD1;
            hashL2 = (hashL2 * BASE + nums[i]) % MOD2;

            hashR1 = (hashR1 + nums[len - 1 - i] * aL1) % MOD1;
            hashR2 = (hashR2 + nums[len - 1 - i] * aL2) % MOD2;

            aL1 = (aL1 * BASE) % MOD1;
            aL2 = (aL2 * BASE) % MOD2;

            if (hashL1 == hashR1 && hashL2 == hashR2) {
                res += 2;
                lastI = i;

                // reset
                hashL1 = 0;
                hashL2 = 0;
                hashR1 = 0;
                hashR2 = 0;
                aL1 = 1;
                aL2 = 1;
            }
        }
        if ((lastI + 1) * 2 == len) {
            return res;
        }
        return res + 1;
    }
}
/*
1147. 段式回文
https://leetcode.cn/problems/longest-chunked-palindrome-decomposition/

你会得到一个字符串 text 。你应该把它分成 k 个子字符串 (subtext1, subtext2，…， subtextk) ，要求满足:
- subtexti 是 非空 字符串
- 所有子字符串的连接等于 text ( 即subtext1 + subtext2 + ... + subtextk == text )
- subtexti == subtextk - i + 1 表示所有 i 的有效值( 即 1 <= i <= k )
返回k可能最大值。
提示：
1 <= text.length <= 1000
text 仅由小写英文字符组成

贪心 + 字符串哈希
 */