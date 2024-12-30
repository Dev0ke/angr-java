import java.util.ArrayDeque;
import java.util.Deque;

public class SolutionP439 {
    public String parseTernary(String expression) {
        int len = expression.length();
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = len - 1; i >= 0; i--) {
            char ch = expression.charAt(i);
            if (ch == ':') {
                continue;
            } else if (ch == '?') {
                char condition = expression.charAt(i - 1);
                i--;
                char c1 = stack.pop();
                char c2 = stack.pop();
                if (condition == 'T') {
                    stack.push(c1);
                } else {
                    stack.push(c2);
                }
            } else {
                stack.push(ch);
            }
        }
        return String.valueOf(stack.pop());
    }
}
/*
$439. 三元表达式解析器
https://leetcode.cn/problems/ternary-expression-parser/

给定一个表示任意嵌套三元表达式的字符串 expression ，求值并返回其结果。
你可以总是假设给定的表达式是有效的，并且只包含数字， '?' ，  ':' ，  'T' 和 'F' ，其中 'T' 为真， 'F' 为假。表达式中的所有数字都是 一位 数(即在 [0,9] 范围内)。
条件表达式从右到左分组(大多数语言中都是这样)，表达式的结果总是为数字 'T' 或 'F' 。
提示:
5 <= expression.length <= 10^4
expression 由数字, 'T', 'F', '?' 和 ':' 组成
保证 了表达式是一个有效的三元表达式，并且每个数字都是 一位数

栈
 */