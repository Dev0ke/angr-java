public class Solution1541 {
    public int minInsertions(String S) {
        int n = S.length();
        char[] s = S.toCharArray();

        int insertions = 0, leftCount = 0;
        for (int i = 0; i < n; i++) {
            if (s[i] == '(') {
                leftCount++;
                continue;
            }
            // ')'
            if (leftCount > 0) {
                leftCount--;
            } else {
                insertions++; // 前面没有左括号可以匹配，需要插入一个左括号才能匹配
            }
            if (i + 1 < n && s[i + 1] == ')') {
                i++;
            } else {
                insertions++; // 没有两个连续的右括号，就需要在当前位置的后面插入一个右括号
            }
        }
        // 还有剩下的左括号没有匹配，对于每个剩下的左括号，需要插入两个右括号才能匹配
        return insertions + leftCount * 2;
    }
}
/*
1541. 平衡括号字符串的最少插入次数
https://leetcode.cn/problems/minimum-insertions-to-balance-a-parentheses-string/description/

给你一个括号字符串 s ，它只包含字符 '(' 和 ')' 。一个括号字符串被称为平衡的当它满足：
- 任何左括号 '(' 必须对应两个连续的右括号 '))' 。
- 左括号 '(' 必须在对应的连续两个右括号 '))' 之前。
比方说 "())"， "())(())))" 和 "(())())))" 都是平衡的， ")()"， "()))" 和 "(()))" 都是不平衡的。
你可以在任意位置插入字符 '(' 和 ')' 使字符串平衡。
请你返回让 s 平衡的最少插入次数。
提示：
1 <= s.length <= 10^5
s 只包含 '(' 和 ')' 。

贪心。
时间复杂度 O(n)。
 */