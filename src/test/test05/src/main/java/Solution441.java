public class Solution441 {
    public int arrangeCoins(int n) {
        return (int) ((Math.sqrt(1 + 8.0 * n) - 1) / 2);
    }
}
/*
441. 排列硬币
https://leetcode.cn/problems/arranging-coins/

你总共有 n 枚硬币，并计划将它们按阶梯状排列。对于一个由 k 行组成的阶梯，其第 i 行必须正好有 i 枚硬币。阶梯的最后一行 可能 是不完整的。
给你一个数字 n ，计算并返回可形成 完整阶梯行 的总行数。
提示：
1 <= n <= 2^31 - 1

解一元二次方程 x * (x + 1) / 2 = n
 */