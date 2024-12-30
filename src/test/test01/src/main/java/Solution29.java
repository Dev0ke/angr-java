public class Solution29 {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        int negative = 2;
        if (dividend > 0) {
            negative--;
            dividend = -dividend;
        }
        if (divisor > 0) {
            negative--;
            divisor = -divisor;
        }
        int res = divideCode(dividend, divisor);
        return negative == 1 ? -res : res;
    }

    private int divideCode(int dividend, int divisor) {
        int res = 0;
        while (dividend <= divisor) {
            int value = divisor;
            int quotient = 1;
            // Integer.MIN_VALUE / 2
            while (value >= (Integer.MIN_VALUE / 2) && dividend <= value + value) {
                quotient += quotient;
                value += value;
            }
            res += quotient;
            dividend -= value;
        }
        return res;
    }
}
/*
29. 两数相除
https://leetcode.cn/problems/divide-two-integers/

给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
返回被除数 dividend 除以除数 divisor 得到的商。
整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2
提示：
被除数和除数均为 32 位有符号整数。
除数不为 0。
假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−2^31,  2^31 − 1]。本题中，如果除法结果溢出，则返回 231 − 1。

为什么 value >= 0xc0000000？
1. divisor 是负数 => value 是负数
2.0xc0000000 == Integer.MIN_VALUE / 2
3.>= 0xc0000000 是为了避免两个负数相加溢出
思维题（实际工程中意义不大）
 */
