public class Solution3306 {
    public long countOfSubstrings(String word, int k) {
        int n = word.length();
        char[] s = word.toCharArray();
        int l1 = 0, l2 = 0, r = 0;
        int[] cnt1 = new int[26], cnt2 = new int[26];
//        final int VOWEL_MASK = (1 << ('a' - 'a')) | (1 << ('e' - 'a')) | (1 << ('i' - 'a')) | (1 << ('o' - 'a')) | (1 << ('u' - 'a'));
        final int VOWEL_MASK = 1065233;
        int mask1 = 0, mask2 = 0;
        int consonants1 = 0, consonants2 = 0;
        long ans = 0;
        while (r < n) {
            if (++cnt1[s[r] - 'a'] == 1) mask1 |= 1 << (s[r] - 'a');
            if (!isVowel(s[r])) consonants1++;
            if (++cnt2[s[r] - 'a'] == 1) mask2 |= 1 << (s[r] - 'a');
            if (!isVowel(s[r])) consonants2++;

            while (consonants1 > k && (mask1 & VOWEL_MASK) == VOWEL_MASK) {
                if (--cnt1[s[l1] - 'a'] == 0) mask1 ^= 1 << (s[l1] - 'a');
                if (!isVowel(s[l1])) consonants1--;
                l1++;
            }
            while (consonants2 > k - 1 && (mask2 & VOWEL_MASK) == VOWEL_MASK) {
                if (--cnt2[s[l2] - 'a'] == 0) mask2 ^= 1 << (s[l2] - 'a');
                if (!isVowel(s[l2])) consonants2--;
                l2++;
            }

            ans += l2 - l1;
            r++;
        }
        return ans;
    }

    private boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}
/*
3306. 元音辅音字符串计数 II
https://leetcode.cn/problems/count-of-substrings-containing-every-vowel-and-k-consonants-ii/description/

第 417 场周赛 T3。

给你一个字符串 word 和一个 非负 整数 k。
返回 word 的 子字符串 中，每个元音字母（'a'、'e'、'i'、'o'、'u'）至少 出现一次，并且 恰好 包含 k 个辅音字母的子字符串的总数。
提示：
5 <= word.length <= 2 * 10^5
word 仅由小写英文字母组成。
0 <= k <= word.length - 5

三指针 滑动窗口。
位运算的写法。
同: 3305. 元音辅音字符串计数 I
https://leetcode.cn/problems/count-of-substrings-containing-every-vowel-and-k-consonants-i/description/
相似题目: 992. K 个不同整数的子数组
https://leetcode.cn/problems/subarrays-with-k-different-integers/
 */