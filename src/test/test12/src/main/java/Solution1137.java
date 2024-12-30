public class Solution1137 {
    /**
     * 矩阵快速幂
     * 时间复杂度 O(logn)
     * 空间复杂度 O(1)
     */
    public int tribonacci(int n) {
        int[][] mat = {{1, 1, 1}, {1, 0, 0}, {0, 1, 0}};
        int[][] mPowN = matQuickPow(mat, n);
        int[] f = {0, 1, 1};
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
1137. 第 N 个泰波那契数
https://leetcode.cn/problems/n-th-tribonacci-number/

第 147 场周赛 T1。

泰波那契序列 Tn 定义如下： 
T0 = 0, T1 = 1, T2 = 1, 且在 n >= 0 的条件下 Tn+3 = Tn + Tn+1 + Tn+2
给你整数 n，请返回第 n 个泰波那契数 Tn 的值。
提示：
0 <= n <= 37
答案保证是一个 32 位整数，即 answer <= 2^31 - 1。

相似题目: 70. 爬楼梯
https://leetcode.cn/problems/climbing-stairs/
509. 斐波那契数
https://leetcode.cn/problems/fibonacci-number/
 */