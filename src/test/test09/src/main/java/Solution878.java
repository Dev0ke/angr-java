public class Solution878 {
    private static final int MOD = (int) (1e9 + 7);

    public int nthMagicalNumber(int n, int a, int b) {
        int lcm = a / getGCD(a, b) * b;

        long left = 0;
        long right = Long.MAX_VALUE;
        while (left < right) {
            long mid = left + (right - left) / 2;
            // 边界二分 F, F,..., F, [T, T,..., T]
            // ----------------------^
            if (mid / a + mid / b - mid / lcm >= n) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return (int) (left % MOD);
    }

    private int getGCD(int num1, int num2) {
        return num1 == 0 ? num2 : getGCD(num2 % num1, num1);
    }
}
/*
878. 第 N 个神奇数字
https://leetcode.cn/problems/nth-magical-number/

一个正整数如果能被 a 或 b 整除，那么它是神奇的。
给定三个整数 n , a , b ，返回第 n 个神奇的数字。因为答案可能很大，所以返回答案 对 10^9 + 7 取模 后的值。
提示：
1 <= n <= 10^9
2 <= a, b <= 4 * 10^4

二分
相似题目: 1201. 丑数 III
https://leetcode.cn/problems/ugly-number-iii/
 */