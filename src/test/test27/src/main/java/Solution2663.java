public class Solution2663 {
    public String smallestBeautifulString(String s, int k) {
        k += 'a';
        char[] cs = s.toCharArray();
        int n = s.length();
        int i = n - 1;
        cs[i]++;
        while (i < n) {
            // 超过范围
            if (cs[i] == k) {
                // 无法进位
                if (i == 0) {
                    return "";
                }
                cs[i] = 'a';
                i--;
                cs[i]++;
            }
            // 长度为 2 或长度为 3 的回文
            else if ((i - 1 >= 0 && cs[i - 1] == cs[i]) || (i - 2 >= 0 && cs[i - 2] == cs[i])) {
                cs[i]++;
            }
            // 检查 cs[i] 是否和后面的字符形成回文串
            else {
                i++;
            }
        }
        return new String(cs);
    }
}
/*
2663. 字典序最小的美丽字符串
https://leetcode.cn/problems/lexicographically-smallest-beautiful-string/

第 343 场周赛 T4。

如果一个字符串满足以下条件，则称其为 美丽字符串 ：
- 它由英语小写字母表的前 k 个字母组成。
- 它不包含任何长度为 2 或更长的回文子字符串。
给你一个长度为 n 的美丽字符串 s 和一个正整数 k 。
请你找出并返回一个长度为 n 的美丽字符串，该字符串还满足：在字典序大于 s 的所有美丽字符串中字典序最小。如果不存在这样的字符串，则返回一个空字符串。
对于长度相同的两个字符串 a 和 b ，如果字符串 a 在与字符串 b 不同的第一个位置上的字符字典序更大，则字符串 a 的字典序大于字符串 b 。
- 例如，"abcd" 的字典序比 "abcc" 更大，因为在不同的第一个位置（第四个字符）上 d 的字典序大于 c 。
提示：
1 <= n == s.length <= 10^5
4 <= k <= 26
s 是一个美丽字符串

贪心。
时间复杂度 O(n)
 */