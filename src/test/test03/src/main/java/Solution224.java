import java.util.ArrayDeque;
import java.util.Deque;

public class Solution224 {
    public int calculate(String s) {
        int len = s.length();

        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(1);
        int sign = 1;
        int res = 0;
        int idx = 0;
        while (idx < len) {
            if (s.charAt(idx) == ' ') {
                idx++;
            } else if (s.charAt(idx) == '+') {
                sign = stack.element();
                idx++;
            } else if (s.charAt(idx) == '-') {
                sign = -stack.element();
                idx++;
            } else if (s.charAt(idx) == '(') {
                stack.push(sign);
                idx++;
            } else if (s.charAt(idx) == ')') {
                stack.pop();
                idx++;
            } else {
                long num = 0;
                while (idx < len && Character.isDigit(s.charAt(idx))) {
                    num = num * 10 + (s.charAt(idx) - '0');
                    idx++;

                }
                res += sign * num;
            }
        }
        return res;
    }
}
/*
224. 基本计算器
https://leetcode.cn/problems/basic-calculator/

给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
注意:不允许使用任何将字符串作为数学表达式计算的内置函数，比如 eval() 。
提示：
1 <= s.length <= 3 * 10^5
s 由数字、'+'、'-'、'('、')'、和 ' ' 组成
s 表示一个有效的表达式
'+' 不能用作一元运算(例如， "+1" 和 "+(2 + 3)" 无效)
'-' 可以用作一元运算(即 "-1" 和 "-(2 + 3)" 是有效的)
输入中不存在两个连续的操作符
每个数字和运行的计算将适合于一个有符号的 32位 整数

相似题目: 227. 基本计算器 II
https://leetcode.cn/problems/basic-calculator-ii/
$772. 基本计算器 III
https://leetcode.cn/problems/basic-calculator-iii/
 */