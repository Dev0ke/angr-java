public class Solution1221 {
    public int balancedStringSplit(String s) {
        int sum = 0;
        int cnt = 0;
        for (char ch : s.toCharArray()) {
            if (ch == 'L') {
                sum--;
            } else {
                sum++;
            }
            if (sum == 0) {
                cnt++;
            }
        }
        return cnt;
    }
}
/*
1221. 分割平衡字符串
https://leetcode.cn/problems/split-a-string-in-balanced-strings/

在一个 平衡字符串 中，'L' 和 'R' 字符的数量是相同的。
给你一个平衡字符串 s，请你将它分割成尽可能多的平衡字符串。
注意：分割得到的每个字符串都必须是平衡字符串，且分割得到的平衡字符串是原平衡字符串的连续子串。
返回可以通过分割得到的平衡字符串的 最大数量 。
提示：
1 <= s.length <= 1000
s[i] = 'L' 或 'R'
s 是一个 平衡 字符串

贪心
 */