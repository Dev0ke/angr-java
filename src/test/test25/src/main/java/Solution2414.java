public class Solution2414 {
    public int longestContinuousSubstring(String s) {
        int len = s.length();

        int max = 0;
        // 双指针。对于每个 i，找到最右的 j，长度为 j-i+1
        int i = 0;
        for (int j = i; j < len; j++) {
            if (s.charAt(j) - s.charAt(i) == j - i) {
                max = Math.max(max, j - i + 1);
            } else {
                i = j;
            }
        }
        return max;
    }
}
/*
2414. 最长的字母序连续子字符串的长度
https://leetcode.cn/problems/length-of-the-longest-alphabetical-continuous-substring/

第 311 场周赛 T2。

字母序连续字符串 是由字母表中连续字母组成的字符串。换句话说，字符串 "abcdefghijklmnopqrstuvwxyz" 的任意子字符串都是 字母序连续字符串 。
- 例如，"abc" 是一个字母序连续字符串，而 "acb" 和 "za" 不是。
给你一个仅由小写英文字母组成的字符串 s ，返回其 最长 的 字母序连续子字符串 的长度。
提示：
1 <= s.length <= 10^5
s 由小写英文字母组成

双指针。
时间复杂度 O(n)
 */