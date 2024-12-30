public class Solution879 {
    private static final int MOD = (int) (1e9 + 7);

    // https://leetcode.cn/problems/profitable-schemes/solution/leetcode-01bei-bao-zong-jie-by-pedantic-einstein/
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        int len = group.length;

        // 0-1 背包
        // f[j][k] 表示第 i 种工作，在 j 名成员参与下，获取 k 的利润的方案数
        int[][] f = new int[n + 1][minProfit + 1];
        // 如果不需要获取利润，成员人数符合条件都可以满足
        for (int j = 0; j < n + 1; j++) {
            f[j][0] = 1;
        }
        for (int i = 1; i <= len; i++) {
            int g = group[i - 1];
            int p = profit[i - 1];
            for (int j = n; j >= g; j--) {
                // 注意是 k >= 0 而不是 k >= p
                for (int k = minProfit; k >= 0; k--) {
                    // 在 k < p （剩余的所需利润 < 当前工作获取的利润）时，情况依然满足条件
                    f[j][k] = (f[j][k] + f[j - g][Math.max(0, k - p)]) % MOD;
                }
            }
        }
        return f[n][minProfit];
    }
}
/*
879. 盈利计划
https://leetcode.cn/problems/profitable-schemes/

集团里有 n 名员工，他们可以完成各种各样的工作创造利润。
第 i 种工作会产生 profit[i] 的利润，它要求 group[i] 名成员共同参与。如果成员参与了其中一项工作，就不能参与另一项工作。
工作的任何至少产生 minProfit 利润的子集称为 盈利计划 。并且工作的成员总数最多为 n 。
有多少种计划可以选择？因为答案很大，所以 返回结果模 10^9 + 7 的值。
提示：
1 <= n <= 100
0 <= minProfit <= 100
1 <= group.length <= 100
1 <= group[i] <= 100
profit.length == group.length
0 <= profit[i] <= 100

0-1 背包 求方案数
时间复杂度 O(len*n*minProfit)
空间复杂度 O(n*minProfit)
 */