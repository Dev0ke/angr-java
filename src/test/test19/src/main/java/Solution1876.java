public class Solution1876 {
    public int countGoodSubstrings(String S) {
        int n = S.length();
        char[] s = S.toCharArray();
        int ans = 0;
        for (int i = 0; i < n - 2; i++) {
            if (s[i] != s[i + 1] && s[i] != s[i + 2] && s[i + 1] != s[i + 2]) {
                ans++;
            }
        }
        return ans;
    }
}
/*
1876. 长度为三且各字符不同的子字符串
https://leetcode.cn/problems/substrings-of-size-three-with-distinct-characters/description/

如果一个字符串不含有任何重复字符，我们称这个字符串为 好 字符串。
给你一个字符串 s ，请你返回 s 中长度为 3 的 好子字符串 的数量。
注意，如果相同的好子字符串出现多次，每一次都应该被记入答案之中。
子字符串 是一个字符串中连续的字符序列。
提示：
1 <= s.length <= 100
s 只包含小写英文字母。

枚举。
时间复杂度 O(n)。
 */