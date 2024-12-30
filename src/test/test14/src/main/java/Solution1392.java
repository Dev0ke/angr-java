public class Solution1392 {
    // KMP 前缀函数
    public String longestPrefix(String s) {
        int n = s.length();
        int[] pi = prefix_function(s.toCharArray());
        return s.substring(0, pi[n - 1]);
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

    private static final int BASE = 26;
    private static final long MOD = (long) (1e9 + 7);

    // Rabin-Karp 字符串哈希
    // 时间复杂度 O(n)
    // 空间复杂度 O(1)
    public String longestPrefix2(String s) {
        int len = s.length();

        // 预处理
        int[] nums = new int[len];
        for (int i = 0; i < len; i++) {
            nums[i] = s.charAt(i) - 'a';
        }

        long prefixHash = 0;
        long suffixHash = 0;
        long base = 1;
        int max = -1;
        for (int i = 0; i < len - 1; i++) {
            // 前缀
            prefixHash = (prefixHash * BASE + nums[i]) % MOD;

            // 后缀
            suffixHash = (suffixHash + nums[len - 1 - i] * base) % MOD;
            base = base * BASE % MOD;

            if (prefixHash == suffixHash) {
                max = i;
            }
        }
        return max == -1 ? "" : s.substring(0, max + 1);
    }
}
/*
1392. 最长快乐前缀
https://leetcode.cn/problems/longest-happy-prefix/

「快乐前缀」 是在原字符串中既是 非空 前缀也是后缀（不包括原字符串自身）的字符串。
给你一个字符串 s，请你返回它的 最长快乐前缀。如果不存在满足题意的前缀，则返回一个空字符串 "" 。
提示：
1 <= s.length <= 10^5
s 只含有小写英文字母

等价于求 KMP 算法中的 next 数组
前缀函数与 KMP 算法 https://oi-wiki.org/string/kmp/
也可以用 Rabin-Karp 字符串哈希求解
时间复杂度 O(n)
 */