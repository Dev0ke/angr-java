public class Solution2730 {
    public int longestSemiRepetitiveSubstring(String s) {
        int n = s.length(), l = 0, r = 0, ans = 0; // r 从 1 开始
        char[] cs = s.toCharArray();
        int same = 0;
        while (r < n) {
            if (r - 1 >= 0 && cs[r] == cs[r - 1]) same++;
            // 注意这里不使用 while
            if (same > 1) {
                // 将一对相同的字符移到窗口之外。然后将 same 置为 1
                for (l++; cs[l] != cs[l - 1]; l++) {
                }
                same = 1;
            }
            ans = Math.max(ans, r - l + 1);
            r++;
        }
        return ans;
    }
}
/*
2730. 找到最长的半重复子字符串
https://leetcode.cn/problems/find-the-longest-semi-repetitive-substring/

第 106 场双周赛 T2。

给你一个下标从 0 开始的字符串 s ，这个字符串只包含 0 到 9 的数字字符。
如果一个字符串 t 中至多有一对相邻字符是相等的，那么称这个字符串是 半重复的 。
请你返回 s 中最长 半重复 子字符串的长度。
一个 子字符串 是一个字符串中一段连续 非空 的字符。
提示：
1 <= s.length <= 50
'0' <= s[i] <= '9'

不定长滑动窗口（求最长/最大）
时间复杂度 O(n)
 */