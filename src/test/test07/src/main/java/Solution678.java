import java.util.ArrayDeque;
import java.util.Deque;

public class Solution678 {
    public boolean checkValidString(String s) {
        // 存放括号
        Deque<Integer> stack = new ArrayDeque<>();
        // 存放 '*' 号
        Deque<Integer> starStack = new ArrayDeque<>();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                stack.push(i);
            } else if (ch == '*') {
                starStack.push(i);
            } else {
                // ch = ')'
                if (!stack.isEmpty()) {
                    stack.pop();
                } else if (!starStack.isEmpty()) {
                    starStack.pop();
                } else {
                    return false;
                }
            }
        }

        while (!stack.isEmpty() && !starStack.isEmpty()) {
            int idx1 = stack.pop();
            int idx2 = starStack.pop();
            if (idx1 > idx2) {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
/*
678. 有效的括号字符串
https://leetcode.cn/problems/valid-parenthesis-string/

给定一个只包含三种字符的字符串：（ ，） 和 *，写一个函数来检验这个字符串是否为有效字符串。有效字符串具有如下规则：
1. 任何左括号 ( 必须有相应的右括号 )。
2. 任何右括号 ) 必须有相应的左括号 ( 。
3. 左括号 ( 必须在对应的右括号之前 )。
4. * 可以被视为单个右括号 ) ，或单个左括号 ( ，或一个空字符串。
5. 一个空字符串也被视为有效字符串。
注意:
字符串大小将在 [1，100] 范围内。

栈
时间复杂度 O(n)
空间复杂度 O(n)
 */