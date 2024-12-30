public class Solution28 {
    public int strStr(String haystack, String needle) {
        char[] txt = haystack.toCharArray();
        char[] pat = needle.toCharArray();
        int n = txt.length, m = pat.length;

        int[] pi = prefix_function(pat);
        for (int i = 0, j = 0; i < n; i++) {
            while (j > 0 && txt[i] != pat[j]) j = pi[j - 1];
            if (txt[i] == pat[j]) j++;
            if (j == m) {
                return i - m + 1;
            }
        }
        return -1;
    }

    private int[] prefix_function(char[] s) {
        int n = s.length;
        int[] pi = new int[n];
        for (int i = 1; i < n; i++) {
            int j = pi[i - 1];
            while (j > 0 && s[i] != s[j]) j = pi[j - 1];
            if (s[i] == s[j]) j++;
            pi[i] = j;
        }
        return pi;
    }

    public int strStr2(String haystack, String needle) {
        return haystack.indexOf(needle);
    }
}
/*
28. 找出字符串中第一个匹配项的下标
https://leetcode.cn/problems/implement-strstr/

给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标（下标从 0 开始）。如果 needle 不是 haystack 的一部分，则返回  -1 。
提示：
1 <= haystack.length, needle.length <= 10^4
haystack 和 needle 仅由小写英文字符组成

KMP 模板题。
时间复杂度 O(n+m)
空间复杂度 O(m)
扩展: Boyer-Moore 算法、Sunday 算法
官方题解 https://leetcode.cn/problems/implement-strstr/solution/
 */