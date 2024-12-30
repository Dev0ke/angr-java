public class SolutionP634 {
    private static final int MOD = (int) (1e9 + 7);

    public int findDerangement(int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 0;
        }
        // f(n) 表示 n 个数进行错位排列的方案数
        long[] f = new long[n + 1];
        f[0] = 1L;
        f[1] = 0L;
        for (int i = 2; i <= n; i++) {
            f[i] = ((i - 1) * (f[i - 1] + f[i - 2])) % MOD;
        }
        return (int) f[n];
    }
}
/*
$634. 寻找数组的错位排列
https://leetcode.cn/problems/find-the-derangement-of-an-array/

在组合数学中，如果一个排列中所有元素都不在原先的位置上，那么这个排列就被称为 错位排列 。
给定一个从 1 到 n 升序排列的数组，返回 不同的错位排列 的数量 。由于答案可能非常大，你只需要将答案对 10^9+7 取余 输出即可。
提示：
1 <= n <= 10^6

动态规划
时间复杂度 O(n)
空间复杂度 O(1)
 */