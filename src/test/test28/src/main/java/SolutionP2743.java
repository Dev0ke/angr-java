public class SolutionP2743 {
    public int numberOfSpecialSubstrings(String s) {
        int[] cnt = new int[26];
        int n = s.length(), l = 0, r = 0, ans = 0, repeated = 0;
        while (r < n) {
            if (++cnt[s.charAt(r) - 'a'] == 2) repeated++;
            while (repeated > 0) {
                if (--cnt[s.charAt(l) - 'a'] == 1) repeated--;
                l++;
            }
            ans += r - l + 1;
            r++;
        }
        return ans;
    }
}
/*
$2743. 计算没有重复字符的子字符串数量
https://leetcode.cn/problems/count-substrings-without-repeating-character/description/

给定你一个只包含小写英文字母的字符串 s 。如果一个子字符串不包含任何字符至少出现两次（换句话说，它不包含重复字符），则称其为 特殊 子字符串。你的任务是计算 特殊 子字符串的数量。例如，在字符串 "pop" 中，子串 "po" 是一个特殊子字符串，然而 "pop" 不是 特殊 子字符串（因为 'p' 出现了两次）。
返回 特殊 子字符串的数量。
子字符串 是指字符串中连续的字符序列。例如，"abc" 是 "abcd" 的一个子字符串，但 "acd" 不是。
提示：
1 <= s.length <= 10^5
s 只包含小写英文字母。

双指针。
时间复杂度 O(n)。
 */