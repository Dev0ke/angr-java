public class SolutionP1692 {
    private static final int MOD = (int) (1e9 + 7);

    public int waysToDistribute(int n, int k) {
        // f[i][j] 为 i 个糖果装到 j 个袋子的总方法数
        long[][] f = new long[n][k];
        // 袋子数大于糖块数的情况不作处理，默认为0
        // 只有一个袋子
        for (int i = 0; i < n; i++) {
            f[i][0] = 1;
        }
        // 袋子数小于等于糖块数, j为袋子数-1, i为糖块数-1
        for (int j = 1; j < k; j++) {
            for (int i = j; i < n; i++) {
                f[i][j] = (f[i - 1][j] * (j + 1) + f[i - 1][j - 1]) % MOD;
            }
        }
        return (int) f[n - 1][k - 1];
    }
}
/*
$1692. 计算分配糖果的不同方式
https://leetcode.cn/problems/count-ways-to-distribute-candies/

现有 n 颗 不同 糖果（分别标记为 1 到 n ）和 k 个相同的手袋。请把糖果分配到各个手袋中并保证每个手袋里至少有一颗糖果。
不考虑手袋和糖果的摆放顺序，会有多种不同的分配方式。如果某种分配方式中其中一个手袋里的糖果与另一种分配方式中所有手袋里的糖果都不相同，则认为这两种分配方式不同。
例如，(1), (2,3) 与(2), (1,3)的分配方式是不同的，因为第一种分配方式中手袋(2,3)里的糖果2和3，在第二种分配方式中被分配到了手袋(2)和(1,3) 中。
已知整数 n 和 k, 请返回分配糖果的不同方式。返回的答案如果数值太大，请取10^9 + 7的模，并返回。
提示：
1 <= k <= n <= 1000

动态规划
https://leetcode.cn/problems/count-ways-to-distribute-candies/solution/biao-zhun-dong-tai-gui-hua-zuo-fa-by-goo-kpqn/
 */