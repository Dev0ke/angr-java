public class Solution172 {
    public int trailingZeroes(int n) {
        // 2 的数量远多于 5 的数量，因此统计 5 的数量即可
        int cnt5 = 0;
        while (n > 0) {
            n /= 5;
            cnt5 += n;
        }
        return cnt5;
    }
}
/*
172. 阶乘后的零
https://leetcode.cn/problems/factorial-trailing-zeroes/

给定一个整数 n ，返回 n! 结果中尾随零的数量。
提示 n! = n * (n - 1) * (n - 2) * ... * 3 * 2 * 1
提示：
0 <= n <= 10^4
进阶：你可以设计并实现对数时间复杂度的算法来解决此问题吗？

统计因子 5 的数量即可
 */