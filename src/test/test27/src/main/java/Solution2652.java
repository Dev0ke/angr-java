public class Solution2652 {
    // n 到 1e9
    // 时间复杂度 O(1)
    public int sumOfMultiples(int n) {
        return f(n, 3) + f(n, 5) + f(n, 7)
                - f(n, 15) - f(n, 21) - f(n, 35)
                + f(n, 105);
    }

    // [1, n] m 的倍数和
    private int f(int n, int m) {
        return (1 + n / m) * (n / m) / 2 * m;
    }
}
/*
2652. 倍数求和
https://leetcode.cn/problems/sum-multiples/

第 342 场周赛 T2。

给你一个正整数 n ，请你计算在 [1，n] 范围内能被 3、5、7 整除的所有整数之和。
返回一个整数，用于表示给定范围内所有满足约束条件的数字之和。
提示：
1 <= n <= 10^3

如果 n 扩展到 1e9 的做法。
时间复杂度 O(1)
 */