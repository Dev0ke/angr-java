public class Solution371 {
    public int getSum(int a, int b) {
        while (b != 0) {
            int carry = (a & b) << 1;
            a = a ^ b;
            b = carry;
        }
        return a;
    }
}
/*
371. 两整数之和
https://leetcode.cn/problems/sum-of-two-integers/description/

给你两个整数 a 和 b ，不使用 运算符 + 和 -，计算并返回两整数之和。
提示：
-1000 <= a, b <= 1000

二进制高精度 + 位运算。
时间复杂度 O(logn)。其中 n 最大值 1000.
 */