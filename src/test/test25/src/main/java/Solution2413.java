public class Solution2413 {
    public int smallestEvenMultiple(int n) {
        if (n % 2 == 1) {
            return n * 2;
        }
        return n;
    }

    // LCM 通用解法
    public int smallestEvenMultiple2(int n) {
        int lcm = 2;
        // 最小公倍数
        lcm = lcm / getGCD(lcm, n) * n;
        return lcm;
    }

    private static int getGCD(int num1, int num2) {
        if (num1 == 0) {
            return num2;
        }
        return getGCD(num2 % num1, num1);
    }
}
/*
2413. 最小偶倍数
https://leetcode.cn/problems/smallest-even-multiple/

第 311 场周赛 T1。

给你一个正整数 n ，返回 2 和 n 的最小公倍数（正整数）。
提示：
1 <= n <= 150

数学。
当 n 为奇数时，答案为 2n；当 n 为偶数时，答案为 n。
时间复杂度 O(1)
 */