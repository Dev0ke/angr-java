import java.util.ArrayDeque;
import java.util.Deque;

public class Solution921 {
    public int minAddToMakeValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                stack.push(ch);
            } else {
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                } else {
                    stack.push(ch);
                }
            }
        }
        return stack.size();
    }
}
/*
921. 使括号有效的最少添加
https://leetcode.cn/problems/minimum-add-to-make-parentheses-valid/

第 106 场周赛 T2。

给定一个由 '(' 和 ')' 括号组成的字符串 S，我们需要添加最少的括号（ '(' 或是 ')'，可以在任何位置），以使得到的括号字符串有效。
从形式上讲，只有满足下面几点之一，括号字符串才是有效的：
它是一个空字符串，或者
它可以被写成 AB （A 与 B 连接）, 其中 A 和 B 都是有效字符串，或者
它可以被写作 (A)，其中 A 是有效字符串。
给定一个括号字符串，返回为使结果字符串有效而必须添加的最少括号数。
提示：
1 <= s.length <= 1000
s 只包含 '(' 和 ')' 字符。

贪心。
括号匹配一般用栈，遇到左括号直接入栈，遇到右括号，如果栈顶是左括号，配对出栈。最后统计栈中括号数即可。
 */