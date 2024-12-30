public class Solution521 {
    public int findLUSlength(String a, String b) {
        if (a.equals(b)) {
            return -1;
        }
        return Math.max(a.length(), b.length());
    }
}
/*
521. 最长特殊序列 Ⅰ
https://leetcode.cn/problems/longest-uncommon-subsequence-i/

给你两个字符串 a 和 b，请返回 这两个字符串中 最长的特殊序列  。如果不存在，则返回 -1 。
「最长特殊序列」 定义如下：该序列为 某字符串独有的最长子序列（即不能是其他字符串的子序列） 。
字符串 s 的子序列是在从 s 中删除任意数量的字符后可以获得的字符串。
- 例如，“abc” 是 “aebdc” 的子序列，因为您可以删除 “aebdc” 中的下划线字符来得到 “abc” 。 “aebdc” 的子序列还包括 “aebdc” 、 “aeb” 和 “” (空字符串)。
提示：
1 <= a.length, b.length <= 100
a 和 b 由小写英文字母组成

如果两个字符串相同，则没有特殊子序列，返回 -1
否则，长的字符串一定不会是短字符串的子序列，返回 长的字符串 的长度。
 */