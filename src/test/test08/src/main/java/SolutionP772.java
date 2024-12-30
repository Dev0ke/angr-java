import java.util.ArrayDeque;
import java.util.Deque;

public class SolutionP772 {
    public int calculate(String s) {
        return dfs(s, 0)[0];
    }

    private int[] dfs(String s, int begin) {
        int len = s.length();

        Deque<Integer> stack = new ArrayDeque<>();
        char sign = '+';
        int num = 0;
        int[] result = new int[2];
        for (int i = begin; i < len; i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                num = num * 10 + (s.charAt(i) - '0');
            } else if (ch == '(') {
                int[] numNext = dfs(s, i + 1);
                num = numNext[0];
                // i 会突变
                i = numNext[1];
            }
            if (!Character.isDigit(ch) && ch != '(' || i == len - 1) {
                if (sign == '+') {
                    stack.push(num);
                } else if (sign == '-') {
                    stack.push(-num);
                } else if (sign == '*') {
                    stack.push(stack.pop() * num);
                } else if (sign == '/') {
                    stack.push(stack.pop() / num);
                }
                if (ch == ')') {
                    result[1] = i;
                    break;
                }
                sign = s.charAt(i);
                num = 0;
            }
        }

        while (!stack.isEmpty()) {
            result[0] += stack.pop();
        }
        return result;
    }
}
/*
$772. 基本计算器 III
https://leetcode.cn/problems/basic-calculator-iii/

实现一个基本的计算器来计算简单的表达式字符串。
表达式字符串只包含非负整数，算符 +、-、*、/ ，左括号 ( 和右括号 ) 。整数除法需要 向下截断 。
你可以假定给定的表达式总是有效的。所有的中间结果的范围为 [-2^31, 2^31 - 1] 。
提示：
1 <= s <= 10^4
s 由整数、'+'、'-'、'*'、'/'、'(' 和 ')' 组成
s 是一个 有效的 表达式
进阶：你可以在不使用内置库函数的情况下解决此问题吗？

相似题目: 相似题目: 224. 基本计算器
https://leetcode.cn/problems/basic-calculator/
227. 基本计算器 II
https://leetcode.cn/problems/basic-calculator-ii/
 */