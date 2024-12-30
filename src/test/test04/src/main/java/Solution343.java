public class Solution343 {
    // 数学
    // 时间复杂度 O(1)
    // 空间复杂度 O(1)
    public int integerBreak(int n) {
        // 说明: 你可以假设 n 不小于 2 且不大于 58。
        if (n <= 3) {
            return n - 1;
        }
        // n = 3 * quotient + remainder
        int quotient = n / 3;
        int remainder = n % 3;
        if (remainder == 0) {
            // 余数为 0 拆分 m 个 3
            return (int) Math.pow(3, quotient);
        } else if (remainder == 1) {
            // 余数为 1 拆分 m-1 个 3 和 2 个 2
            return (int) Math.pow(3, quotient - 1) * 4;
        } else {
            // 余数为 2 拆分 m 个 3 和 1 个 2
            return (int) Math.pow(3, quotient) * 2;
        }
    }

    // 动态规划
    // 时间复杂度 O(n^2)
    public int integerBreak2(int n) {
        // f[i] 表示将正整数 i 拆分成至少两个正整数的和之后，这些正整数的最大乘积
        int[] f = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            int max = 0;
            for (int j = 1; j < i; j++) {
                max = Math.max(max, Math.max(j * (i - j), j * f[i - j]));
            }
            f[i] = max;
        }
        return f[n];
    }

    // 优化的动态规划
    // 时间复杂度 O(n)
    public int integerBreak3(int n) {
        if (n <= 3) {
            return n - 1;
        }
        // f[i] 表示将正整数 i 拆分成至少两个正整数的和之后，这些正整数的最大乘积
        int[] f = new int[n + 1];
        f[2] = 1;
        for (int i = 3; i <= n; i++) {
            f[i] = Math.max(Math.max(2 * (i - 2), 2 * f[i - 2]), Math.max(3 * (i - 3), 3 * f[i - 3]));
        }
        return f[n];
    }
}
/*
343. 整数拆分
https://leetcode.cn/problems/integer-break/

给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
提示:
2 <= n <= 58

数学 / 动态规划
相似题目: 1808. 好因子的最大数目
https://leetcode.cn/problems/maximize-number-of-nice-divisors/description/
 */
