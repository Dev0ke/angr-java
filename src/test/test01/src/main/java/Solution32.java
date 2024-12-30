public class Solution32 {
    public int longestValidParentheses(String s) {
        int len = s.length();
        int cntLeft = 0;
        int cntRight = 0;
        int maxLen = 0;

        // 左到右
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == '(') {
                cntLeft++;
            } else {
                cntRight++;
            }
            if (cntLeft == cntRight) {
                maxLen = Math.max(maxLen, cntLeft + cntRight);
            } else if (cntRight > cntLeft) {
                cntLeft = 0;
                cntRight = 0;
            }
        }

        // 右到左
        cntLeft = 0;
        cntRight = 0;
        for (int i = len - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                cntLeft++;
            } else {
                cntRight++;
            }
            if (cntLeft == cntRight) {
                maxLen = Math.max(maxLen, cntLeft + cntRight);
            } else if (cntLeft > cntRight) {
                cntLeft = 0;
                cntRight = 0;
            }
        }
        return maxLen;
    }
}
/*
32. 最长有效括号
https://leetcode.cn/problems/longest-valid-parentheses/

给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
提示：
0 <= s.length <= 3 * 10^4
s[i] 为 '(' 或 ')'

贪心。计数。
时间复杂度 O(n)
空间复杂度 O(1)
 */