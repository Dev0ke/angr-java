public class Solution69 {
    public int mySqrt(int x) {
        return (int) Math.sqrt(x);
    }
}
/*
69. x 的平方根
https://leetcode.cn/problems/sqrtx/

给你一个非负整数 x ，计算并返回 x 的 算术平方根 。
由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。
注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。
提示：
0 <= x <= 2^31 - 1

二分查找
（实际工程中意义不大）
 */