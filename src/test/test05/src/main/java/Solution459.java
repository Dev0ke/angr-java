public class Solution459 {
    public boolean repeatedSubstringPattern(String s) {
        int len = s.length();
        for (int k = 1; k <= len / 2; k++) {
            if (check(s, k)) {
                return true;
            }
        }
        return false;
    }

    // 长度为 k 是否为重复的子字符串
    private boolean check(String s, int k) {
        if (s.length() % k != 0) {
            return false;
        }
        String pattern = s.substring(0, k);
        for (int i = 0; i < s.length(); i += k) {
            String subString = s.substring(i, i + k);
            if (!pattern.equals(subString)) {
                return false;
            }
        }
        return true;
    }

    // KMP
    public boolean repeatedSubstringPattern2(String s) {
        int n = s.length();
        char[] txt = (s.substring(1) + s.substring(0, n - 1)).toCharArray();
        char[] pat = s.toCharArray();

        int[] pi = prefix_function(pat);
        for (int i = 0, j = 0; i < txt.length; i++) {
            while (j > 0 && txt[i] != pat[j]) j = pi[j - 1];
            if (txt[i] == pat[j]) j++;
            if (j == n) {
                return true;
            }
        }
        return false;
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
459. 重复的子字符串
https://leetcode.cn/problems/repeated-substring-pattern/

给定一个非空的字符串 s ，检查是否可以通过由它的一个子串重复多次构成。
提示：
1 <= s.length <= 10^4
s 由小写英文字母组成

枚举，重复的子字符串长度要能整除字符串长度，然后截取判等即可。
or KMP
 */