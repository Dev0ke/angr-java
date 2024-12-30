import java.util.ArrayDeque;
import java.util.Deque;

public class Solution1614 {
    public int maxDepth(String s) {
        int max = 0;
        Deque<Character> stack = new ArrayDeque<>();
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                stack.push(ch);
                max = Math.max(max, stack.size());
            }
            if (ch == ')') {
                stack.pop();
            }
        }
        return max;
    }
}
/*
1614. 括号的最大嵌套深度
https://leetcode.cn/problems/maximum-nesting-depth-of-the-parentheses/

第 210 场周赛 T1。

如果字符串满足以下条件之一，则可以称之为 有效括号字符串（valid parentheses string，可以简写为 VPS）：
- 字符串是一个空字符串 ""，或者是一个不为 "(" 或 ")" 的单字符。
- 字符串可以写为 AB（A 与 B 字符串连接），其中 A 和 B 都是 有效括号字符串 。
- 字符串可以写为 (A)，其中 A 是一个 有效括号字符串 。
类似地，可以定义任何有效括号字符串 S 的 嵌套深度 depth(S)：
- depth("") = 0
- depth(C) = 0，其中 C 是单个字符的字符串，且该字符不是 "(" 或者 ")"
- depth(A + B) = max(depth(A), depth(B))，其中 A 和 B 都是 有效括号字符串
- depth("(" + A + ")") = 1 + depth(A)，其中 A 是一个 有效括号字符串
例如：""、"()()"、"()(()())" 都是 有效括号字符串（嵌套深度分别为 0、1、2），而 ")(" 、"(()" 都不是 有效括号字符串 。
给你一个 有效括号字符串 s，返回该字符串的 s 嵌套深度 。
提示：
1 <= s.length <= 100
s 由数字 0-9 和字符 '+'、'-'、'*'、'/'、'('、')' 组成
题目数据保证括号表达式 s 是 有效的括号表达式

类似括号匹配，统计栈的最大深度。
时间复杂度 O(n)
 */