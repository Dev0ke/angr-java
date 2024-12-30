import java.util.Arrays;

public class Solution467 {
    public int findSubstringInWraproundString(String s) {
        int n = s.length();
        int[] f = new int[26];
        int k = 0;
        for (int i = 0; i < n; i++) {
            // 字符之差为 1 或 -25
            if (i > 0 && (s.charAt(i) - s.charAt(i - 1) + 26) % 26 == 1) {
                k++;
            } else {
                k = 1;
            }
            int j = s.charAt(i) - 'a';
            f[j] = Math.max(f[j], k);
        }
        return Arrays.stream(f).sum();
    }
}
/*
467. 环绕字符串中唯一的子字符串
https://leetcode.cn/problems/unique-substrings-in-wraparound-string/description/

定义字符串 base 为一个 "abcdefghijklmnopqrstuvwxyz" 无限环绕的字符串，所以 base 看起来是这样的：
- "...zabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcd....".
给你一个字符串 s ，请你统计并返回 s 中有多少 不同非空子串 也在 base 中出现。
提示：
1 <= s.length <= 10^5
s 由小写英文字母组成

动态规划
状态转移：f[c] 表示以字符 c 结尾且在 s 中的子串的最长长度
状态转移：维护连续递增的子串长度 k
答案为 sum(f)
时间复杂度 O(n)
 */