public class Solution1456 {
    public int maxVowels(String s, int k) {
        int n = s.length();
        int cnt_vowel = 0;
        for (int i = 0; i < k; i++) {
            if (isVowel(s.charAt(i))) cnt_vowel++;
        }
        int ans = cnt_vowel;
        for (int i = k; i < n; i++) {
            if (isVowel(s.charAt(i - k))) cnt_vowel--;
            if (isVowel(s.charAt(i))) cnt_vowel++;
            ans = Math.max(ans, cnt_vowel);
        }
        return ans;
    }

    private boolean isVowel(char ch) {
        return "aeiou".indexOf(ch) >= 0;
    }
}
/*
1456. 定长子串中元音的最大数目
https://leetcode.cn/problems/maximum-number-of-vowels-in-a-substring-of-given-length/description/

给你字符串 s 和整数 k 。
请返回字符串 s 中长度为 k 的单个子字符串中可能包含的最大元音字母数。
英文中的 元音字母 为（a, e, i, o, u）。
提示：
1 <= s.length <= 10^5
s 由小写英文字母组成
1 <= k <= s.length

定长滑动窗口。
时间复杂度 O(n)
 */