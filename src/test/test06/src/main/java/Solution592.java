public class Solution592 {
    public String fractionAddition(String expression) {
        int n = expression.length();
        char[] s = expression.toCharArray();
        long x = 0, y = 1;
        int i = 0;
        while (i < n) {
            // 读取分子
            long x1 = 0, sign = 1;
            if (s[i] == '-' || s[i] == '+') {
                sign = (s[i] == '-' ? -1 : 1);
                i++;
            }
            while (i < n && Character.isDigit(s[i])) {
                x1 = x1 * 10 + (s[i] - '0');
                i++;
            }
            x1 *= sign;
            i++;

            // 读取分母
            long y1 = 0;
            while (i < n && Character.isDigit(s[i])) {
                y1 = y1 * 10 + (s[i] - '0');
                i++;
            }

            x = x * y1 + x1 * y;
            y *= y1;
        }
        if (x == 0) return "0/1";
        long gcd = getGCD(Math.abs(x), y);
        return (x / gcd) + "/" + (y / gcd);
    }

    private long getGCD(long num1, long num2) {
        return num1 == 0 ? num2 : getGCD(num2 % num1, num1);
    }
}
/*
592. 分数加减运算
https://leetcode.cn/problems/fraction-addition-and-subtraction/

给定一个表示分数加减运算的字符串 expression ，你需要返回一个字符串形式的计算结果。
这个结果应该是不可约分的分数，即最简分数。 如果最终结果是一个整数，例如 2，你需要将它转换成分数形式，其分母为 1。所以在上述例子中, 2 应该被转换为 2/1。
提示:
输入和输出字符串只包含 '0' 到 '9' 的数字，以及 '/', '+' 和 '-'。
输入和输出分数格式均为 ±分子/分母。如果输入的第一个分数或者输出的分数是正数，则 '+' 会被省略掉。
输入只包含合法的最简分数，每个分数的分子与分母的范围是  [1,10]。 如果分母是1，意味着这个分数实际上是一个整数。
输入的分数个数范围是 [1,10]。
最终结果的分子与分母保证是 32 位整数范围内的有效整数。

模拟。
时间复杂度 O(n + logC)。其中 C 为化简前结果分子分母的最大值。
 */