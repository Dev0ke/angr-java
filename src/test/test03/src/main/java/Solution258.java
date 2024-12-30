public class Solution258 {
    public int addDigits(int num) {
        int sum = 10;
        while (sum >= 10) {
            sum = 0;
            while (num > 0) {
                int digit = num % 10;
                sum += digit;
                num /= 10;
            }
            num = sum;
        }
        return sum;
    }
}
/*
258. 各位相加
https://leetcode.cn/problems/add-digits/

给定一个非负整数 num，反复将各个位上的数字相加，直到结果为一位数。返回这个结果。
提示：
0 <= num <= 2^31 - 1
进阶：你可以不使用循环或者递归，在 O(1) 时间复杂度内解决这个问题吗？

递归。
 */