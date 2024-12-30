public class Solution367 {
    public boolean isPerfectSquare(int num) {
        int sqrt = (int) Math.sqrt(num);
        return sqrt * sqrt == num;
    }
}
/*
367. 有效的完全平方数
https://leetcode.cn/problems/valid-perfect-square/

给定一个 正整数 num ，编写一个函数，如果 num 是一个完全平方数，则返回 true ，否则返回 false 。
进阶：不要 使用任何内置的库函数，如 sqrt 。
提示：
1 <= num <= 2^31 - 1

内置的库函数/二分查找
 */