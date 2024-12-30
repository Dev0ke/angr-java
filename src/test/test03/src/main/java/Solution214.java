public class Solution214 {
    public String shortestPalindrome(String s) {
        int n = s.length();
        // s 的反序
        String rev = new StringBuilder(s).reverse().toString();
        char[] txt = rev.toCharArray();
        char[] pat = s.toCharArray();

        int[] pi = prefix_function(pat);
        int j = 0;
        for (int i = 0; i < n; i++) {
            while (j > 0 && txt[i] != pat[j]) j = pi[j - 1];
            if (txt[i] == pat[j]) j++;
        }
        return rev + s.substring(j);
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
}
/*
214. 最短回文串
https://leetcode.cn/problems/shortest-palindrome/

给定一个字符串 s，你可以通过在字符串前面添加字符将其转换为回文串。找到并返回可以用这种方式转换的最短回文串。
提示：
0 <= s.length <= 5 * 10^4
s 仅由小写英文字母组成

KMP
将字符串 s 翻转拼接在开头的做法时间复杂度 O(n^2)，TLE
官方题解: https://leetcode.cn/problems/shortest-palindrome/solution/zui-duan-hui-wen-chuan-by-leetcode-solution/
 */