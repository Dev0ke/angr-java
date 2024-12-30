public class Solution2207 {
    public long maximumSubsequenceCount(String text, String pattern) {
        int len = text.length();
        char ch0 = pattern.charAt(0);
        char ch1 = pattern.charAt(1);

        int cnt0 = 0;
        int cnt1 = 0;
        long sum = 0L;
        if (ch0 == ch1) {
            for (int i = 0; i < len; i++) {
                if (text.charAt(i) == ch0) {
                    cnt0++;
                    sum += cnt0;
                }
            }
            return sum;
        }

        // pattern[0] != pattern[1]
        for (int i = 0; i < len; i++) {
            if (text.charAt(i) == ch0) {
                cnt0++;
            } else if (text.charAt(i) == ch1) {
                cnt1++;
                sum += cnt0;
            }
        }
        return sum + Math.max(cnt0, cnt1);
    }
}
/*
2207. 字符串中最多数目的子字符串
https://leetcode.cn/problems/maximize-number-of-subsequences-in-a-string/

第 74 场双周赛 T2。

给你一个下标从 0 开始的字符串 text 和另一个下标从 0 开始且长度为 2 的字符串 pattern ，两者都只包含小写英文字母。
你可以在 text 中任意位置插入 一个 字符，这个插入的字符必须是 pattern[0] 或者 pattern[1] 。注意，这个字符可以插入在 text 开头或者结尾的位置。
请你返回插入一个字符后，text 中最多包含多少个等于 pattern 的 子序列 。
子序列 指的是将一个字符串删除若干个字符后（也可以不删除），剩余字符保持原本顺序得到的字符串。
提示：
1 <= text.length <= 10^5
pattern.length == 2
text 和 pattern 都只包含小写英文字母。

本质是贪心，但需要分情况讨论：
case1: pattern 是两个相等的字符：如 text = "aaaaa", pattern = "aa", 1+2+3+4(+5) = 15
case2: pattern 是两个不等的字符：如 text = "aaabb", pattern = "ab", a 比 b 多，因此补 b 会得到更多的子序列，2+2+2(+3)
 */