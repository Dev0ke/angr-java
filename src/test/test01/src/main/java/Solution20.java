import java.util.ArrayDeque;
import java.util.Deque;

public class Solution20 {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else if (!stack.isEmpty()
                    && ((ch == ')' && stack.peek() == '(')
                    || (ch == ']' && stack.peek() == '[')
                    || (ch == '}' && stack.peek() == '{'))
            ) {
                stack.push(ch);
                stack.pop();
                stack.pop();
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
/*
20. 有效的括号
https://leetcode.cn/problems/valid-parentheses/

给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
有效字符串需满足：
- 左括号必须用相同类型的右括号闭合。
- 左括号必须以正确的顺序闭合。
提示：
1 <= s.length <= 10^4
s 仅由括号 '()[]{}' 组成

经典题。使用栈进行模拟即可。
Stack#push() 入栈
Stack#peek() 取栈顶元素
Stack#pop() 出栈
Stack#empty() 判断是否空栈
 */
