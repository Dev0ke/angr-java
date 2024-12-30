public class Solution3305 {
    public int countOfSubstrings(String word, int k) {
        int n = word.length();
        char[] s = word.toCharArray();
        int l1 = 0, l2 = 0, r = 0;
        int[] cnt1 = new int[26];
        int[] cnt2 = new int[26];
        boolean hasA1 = false;
        boolean hasE1 = false;
        boolean hasI1 = false;
        boolean hasO1 = false;
        boolean hasU1 = false;
        boolean hasA2 = false;
        boolean hasE2 = false;
        boolean hasI2 = false;
        boolean hasO2 = false;
        boolean hasU2 = false;
        int consonants1 = 0;
        int consonants2 = 0;
        int ans = 0;
        while (r < n) {
            if (++cnt1[s[r] - 'a'] == 1) {
                if (s[r] == 'a') hasA1 = true;
                if (s[r] == 'e') hasE1 = true;
                if (s[r] == 'i') hasI1 = true;
                if (s[r] == 'o') hasO1 = true;
                if (s[r] == 'u') hasU1 = true;
            }
            if (!isVowel(s[r])) consonants1++;

            if (++cnt2[s[r] - 'a'] == 1) {
                if (s[r] == 'a') hasA2 = true;
                if (s[r] == 'e') hasE2 = true;
                if (s[r] == 'i') hasI2 = true;
                if (s[r] == 'o') hasO2 = true;
                if (s[r] == 'u') hasU2 = true;
            }
            if (!isVowel(s[r])) consonants2++;


            while (consonants1 > k
                    && hasA1
                    && hasE1
                    && hasI1
                    && hasO1
                    && hasU1) {
                if (--cnt1[s[l1] - 'a'] == 0) {
                    if (s[l1] == 'a') hasA1 = false;
                    if (s[l1] == 'e') hasE1 = false;
                    if (s[l1] == 'i') hasI1 = false;
                    if (s[l1] == 'o') hasO1 = false;
                    if (s[l1] == 'u') hasU1 = false;
                }
                if (!isVowel(s[l1])) consonants1--;
                l1++;
            }
            while (consonants2 > k - 1
                    && hasA2
                    && hasE2
                    && hasI2
                    && hasO2
                    && hasU2) {
                if (--cnt2[s[l2] - 'a'] == 0) {
                    if (s[l2] == 'a') hasA2 = false;
                    if (s[l2] == 'e') hasE2 = false;
                    if (s[l2] == 'i') hasI2 = false;
                    if (s[l2] == 'o') hasO2 = false;
                    if (s[l2] == 'u') hasU2 = false;
                }
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
3305. 元音辅音字符串计数 I
https://leetcode.cn/problems/count-of-substrings-containing-every-vowel-and-k-consonants-i/description/

第 417 场周赛 T2。

给你一个字符串 word 和一个 非负 整数 k。
返回 word 的 子字符串 中，每个元音字母（'a'、'e'、'i'、'o'、'u'）至少 出现一次，并且 恰好 包含 k 个辅音字母的子字符串的总数。
提示：
5 <= word.length <= 250
word 仅由小写英文字母组成。
0 <= k <= word.length - 5

三指针 滑动窗口。
赛时代码 十分壮观。
同: 3306. 元音辅音字符串计数 II
https://leetcode.cn/problems/count-of-substrings-containing-every-vowel-and-k-consonants-ii/description/
 */