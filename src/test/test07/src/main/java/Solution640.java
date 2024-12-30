public class Solution640 {
    public String solveEquation(String equation) {
        int n = equation.length();
        char[] s = equation.toCharArray();
        int x = 0;
        int num = 0;

        int i = 0;
        int op = 1;
        while (i < n) {
            if (s[i] == '+') {
                op = 1;
                i++;
            } else if (s[i] == '-') {
                op = -1;
                i++;
            } else if (s[i] == '=') {
                op = 1;
                x *= -1;
                num *= -1;
                i++;
            } else {
                int j = i;
                while (j < n && s[j] != '+' && s[j] != '-' && s[j] != '=') {
                    j++;
                }
                if (s[j - 1] == 'x') {
                    x += op * (i < j - 1 ? Integer.parseInt(equation.substring(i, j - 1)) : 1);
                } else {
                    num += op * Integer.parseInt(equation.substring(i, j));
                }
                i = j;
            }
        }
        if (x == 0) {
            return num == 0 ? "Infinite solutions" : "No solution";
        }
        return "x=" + -num / x;
    }
}
/*
640. 求解方程
https://leetcode.cn/problems/solve-the-equation/

求解一个给定的方程，将x以字符串 "x=#value" 的形式返回。该方程仅包含 '+' ， '-' 操作，变量 x 和其对应系数。
如果方程没有解或存在的解不为整数，请返回 "No solution" 。如果方程有无限解，则返回 “Infinite solutions” 。
题目保证，如果方程中只有一个解，则 'x' 的值是一个整数。
提示:
3 <= equation.length <= 1000
equation 只有一个 '='. 
方程由绝对值在 [0, 100]  范围内且无任何前导零的整数和变量 'x' 组成。

模拟。表达式求值
 */