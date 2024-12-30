public class Solution424 {
    public int characterReplacement(String s, int k) {
        int n = s.length(), l = 0, r = 0;
        char[] cs = s.toCharArray();
        int[] cnt = new int[26];
        int max = 0;
        while (r < n) {
            cnt[cs[r] - 'A']++;
            max = Math.max(max, cnt[cs[r] - 'A']);

            if (max + k < r - l + 1) {
                cnt[cs[l] - 'A']--;
                l++;
            }

            r++;
        }
        return r - l;
    }
}
/*
424. 替换后的最长重复字符
https://leetcode.cn/problems/longest-repeating-character-replacement/

给你一个字符串 s 和一个整数 k 。你可以选择字符串中的任一字符，并将其更改为任何其他大写英文字符。该操作最多可执行 k 次。
在执行上述操作后，返回包含相同字母的最长子字符串的长度。
提示：
1 <= s.length <= 10^5
s 仅由大写英文字母组成
0 <= k <= s.length

双指针，只需统计一个窗口内最长重复字符即可！
时间复杂度 O(n)
 */