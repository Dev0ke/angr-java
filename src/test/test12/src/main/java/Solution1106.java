import java.util.ArrayDeque;
import java.util.Deque;

public class Solution1106 {
    public boolean parseBoolExpr(String expression) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char ch : expression.toCharArray()) {
            if (ch == ',') {
                continue;
            }
            if (ch != ')') {
                stack.push(ch);
                continue;
            }
            int cntT = 0;
            int cntF = 0;
            while (!stack.isEmpty() && stack.peek() != '(') {
                char pop = stack.pop();
                if (pop == 't') {
                    cntT++;
                } else {
                    cntF++;
                }
            }
            stack.pop();
            char op = stack.pop();
            if (op == '!') {
                stack.push(cntF == 1 ? 't' : 'f');
            } else if (op == '&') {
                stack.push(cntF == 0 ? 't' : 'f');
            } else if (op == '|') {
                stack.push(cntT > 0 ? 't' : 'f');
            }
        }
        return stack.pop() == 't';
    }
}
/*
1106. 解析布尔表达式
https://leetcode.cn/problems/parsing-a-boolean-expression/

给你一个以字符串形式表述的 布尔表达式（boolean） expression，返回该式的运算结果。
有效的表达式需遵循以下约定：
- "t"，运算结果为 True
- "f"，运算结果为 False
- "!(expr)"，运算过程为对内部表达式 expr 进行逻辑 非的运算（NOT）
- "&(expr1,expr2,...)"，运算过程为对 2 个或以上内部表达式 expr1, expr2, ... 进行逻辑 与的运算（AND）
- "|(expr1,expr2,...)"，运算过程为对 2 个或以上内部表达式 expr1, expr2, ... 进行逻辑 或的运算（OR）
提示：
1 <= expression.length <= 20000
expression[i] 由 {'(', ')', '&', '|', '!', 't', 'f', ','} 中的字符组成。
expression 是以上述形式给出的有效表达式，表示一个布尔值。

栈
 */