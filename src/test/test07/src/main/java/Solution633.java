public class Solution633 {
    public boolean judgeSquareSum(int c) {
        for (long a = 0; a * a <= c; a++) {
            double b = Math.sqrt(c - a * a);
            if (b == (int) b) {
                return true;
            }
        }
        return false;
    }
}
/*
633. 平方数之和
https://leetcode.cn/problems/sum-of-square-numbers/

给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a^2 + b^2 = c 。
提示：
0 <= c <= 2^31 - 1

枚举。
时间复杂度 O(√n)
 */