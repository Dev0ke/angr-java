public class Solution1201 {
    public int nthUglyNumber(int n, int a, int b, int c) {
        long lcmAb = a / getGCD(a, b) * b;
        long lcmAc = a / getGCD(a, c) * c;
        long lcmBc = b / getGCD(b, c) * c;
        long lcmAbc = lcmAb / getGCD(lcmAb, c) * c;

        long left = 0;
        long right = Long.MAX_VALUE;
        while (left < right) {
            long mid = left + (right - left) / 2;
            // 边界二分 F, F,..., F, [T, T,..., T]
            // ----------------------^
            // FFFTTT
            if (mid / a + mid / b + mid / c - mid / lcmAb - mid / lcmAc - mid / lcmBc + mid / lcmAbc >= n) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return (int) left;
    }

    private long getGCD(long num1, long num2) {
        if (num1 == 0) {
            return num2;
        }
        return getGCD(num2 % num1, num1);
    }
}
/*
1201. 丑数 III
https://leetcode.cn/problems/ugly-number-iii/

给你四个整数：n 、a 、b 、c ，请你设计一个算法来找出第 n 个丑数。
丑数是可以被 a 或 b 或 c 整除的 正整数 。
提示：
1 <= n, a, b, c <= 10^9
1 <= a * b * c <= 10^18
本题结果在 [1, 2 * 10^9] 的范围内

二分
相似题目: 878. 第 N 个神奇数字
https://leetcode.cn/problems/nth-magical-number/
 */