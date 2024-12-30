public class SolutionP2083 {
    public long numberOfSubstrings(String s) {
        int[] cnt = new int[26];
        for (char c : s.toCharArray()) {
            cnt[c - 'a']++;
        }
        long ans = 0;
        for (int c : cnt) {
            ans += c * (c + 1L) / 2;
        }
        return ans;
    }
}
/*
$2083. 求以相同字母开头和结尾的子串总数
https://leetcode.cn/problems/substrings-that-begin-and-end-with-the-same-letter/description/

给你一个仅由小写英文字母组成的，  下标从 0 开始的字符串 s 。返回 s 中以相同字符开头和结尾的子字符串总数。
子字符串是字符串中连续的非空字符序列。
提示：
1 <= s.length <= 10^5
s 仅包含小写英文字母。

数学。统计各字符频次。
时间复杂度 O(n)。
 */