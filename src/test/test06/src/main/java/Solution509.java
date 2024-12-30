public class Solution509 {
    /**
     * 动态规划
     * 时间复杂度 O(n)
     * 空间复杂度 O(n) 可用滚动数组优化至 o(1)
     */
    public int fib(int n) {
        int[] dp = new int[n + 2];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    /**
     * 矩阵快速幂
     * 时间复杂度 O(logn)
     * 空间复杂度 O(1)
     */
    public int fib2(int n) {
        int[][] mat = {{1, 1}, {1, 0}};
        int[][] mPowN = matQuickPow(mat, n);
        int[] f = {0, 1};
        return getFn(f, mPowN);
    }

    /**
     * 矩阵快速幂 res = f(n)
     */
    private int getFn(int[] f, int[][] mPowN) {
        int len = f.length;
        int res = 0;
        for (int i = 0; i < len; i++) {
            res += mPowN[len - 1][i] * f[len - 1 - i];
        }
        return res;
    }

    /**
     * 矩阵快速幂 res = a^n
     */
    private int[][] matQuickPow(int[][] a, int n) {
        int len = a.length;
        // 对角矩阵
        int[][] res = new int[len][len];
        for (int i = 0; i < len; i++) {
            res[i][i] = 1;
        }
        while (n > 0) {
            if ((n & 1) == 1) {
                res = matMulti(res, a);
            }
            n >>= 1;
            a = matMulti(a, a);
        }
        return res;
    }

    /**
     * 矩阵快速幂 res = a * b
     */
    private int[][] matMulti(int[][] a, int[][] b) {
        int len = a.length;
        int[][] res = new int[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                for (int k = 0; k < len; k++) {
                    res[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        return res;
    }
}
/*
509. 斐波那契数
https://leetcode.cn/problems/fibonacci-number/

斐波那契数，通常用 F(n) 表示，形成的序列称为 斐波那契数列 。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
F(0) = 0，F(1) = 1
F(n) = F(n - 1) + F(n - 2)，其中 n > 1
给你 n ，请计算 F(n) 。
提示：
0 <= n <= 30

相似题目: 70. 爬楼梯
https://leetcode.cn/problems/climbing-stairs/
1137. 第 N 个泰波那契数
https://leetcode.cn/problems/n-th-tribonacci-number/
 */