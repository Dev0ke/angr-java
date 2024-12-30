public class SolutionP2912 {
    static final int MOD = (int) (1e9 + 7);

    public int numberOfWays(int n, int m, int k, int[] source, int[] dest) {
        long[] dp = new long[4];
        dp[(source[1] == dest[1] ? 1 : 0) * 2 + (source[0] == dest[0] ? 1 : 0)] = 1; // 设边界条件
        for (int p = 1; p <= k; p++) {
            long[] dp1 = new long[4];
            dp1[0] = (dp[0] * (n + m - 4) + dp[1] * (n - 1) + dp[2] * (m - 1)) % MOD;
            dp1[1] = (dp[0] + dp[1] * (m - 2) + dp[3] * (m - 1)) % MOD;
            dp1[2] = (dp[0] + dp[2] * (n - 2) + dp[3] * (n - 1)) % MOD;
            dp1[3] = (dp[1] + dp[2]) % MOD;
            dp = dp1;
        }
        return (int) dp[3]; // 最终要的当然是x和y都正确
    }
}
/*
$2912. 在网格上移动到目的地的方法数
https://leetcode.cn/problems/number-of-ways-to-reach-destination-in-the-grid/description/

给定两个整数 n 和 m，它们表示一个 下标从 1 开始 的网格的大小。还给定一个整数 k，以及两个 下标从 1 开始 的整数数组 source 和 dest。这两个数组 source 和 dest 形如 [x, y]，表示网格上的一个单元格。
你可以按照以下方式在网格上移动：
- 你可以从单元格 [x1, y1] 移动到 [x2, y2]，只要 x1 == x2 或 y1 == y2。
- 注意，你 不能 移动到当前所在的单元格，即 x1 == x2 且 y1 == y2。
请返回你在网格上从 source 到 dest 移动 k 次一共可以有 多少种 方法。
由于答案可能非常大，因此请对 10^9 + 7 取模 后返回。

相比2851题，本题不涉及字符串匹配，k也非常小，因此不需要任何超纲知识点
https://leetcode.cn/problems/number-of-ways-to-reach-destination-in-the-grid/solutions/2499977/gei-ge-bu-chao-gang-qie-yi-dong-de-chun-olhua/
每次移动必须在“换行”和“换列”中选择一项进行，因此共有(m-1)+(n-1)=m+n-2种方法。定义一个4元素的dp数组，表示移动j次(j<=k)后的x和y与dest的对应情况，4个元素分别为“x和y均不正确”，“x正确但y不正确”，“x不正确但y正确”，“x和y均正确”。下面考虑移动一步时这些状态如何实现互相转移：
dp[0]：如果上一步x和y也均不正确，那么只要从所有方法里排除掉把x和y中的任一个对准的情况即可，为dp[0] * (m+n-4)。如果上一步有1个坐标正确，那就必须改变这个坐标，即dp[1] * (n-1) + dp[2] * (m-1)。如果上一步x和y已经都正确，无法转移，因为不允许同时换行和换列。
dp[1]: 如果上一步x和y均不正确，那么想达成dp[1]的条件，唯一的做法是把x对正。如果上一步也是x正确y不正确，那可以改变y来保持状态，但注意这步不能走到正确的y，因此是dp[1] * (m-2)。如果上一步是x不正确但y正确，这是无法转移的。如果上一步x和y均正确，这步改变y就必然让y跑偏，为dp[3] * (m-1)。
dp[2]和dp[1]的分析方法完全相同，只是具体公式不同。
dp[3]不难计算，上一步至少有1个坐标正确时，才能转移过来，且移动方法必然唯一。
最终的状态转移矩阵：
n+m-4   n-1 m-1 0
1       m-2 0   m-1
1       0   n-2 n-1
0       1   1   0
dp的初值即边界条件就对应着一次都不移动，4个元素显然只能有1个为1，其余均为0，要以实际情况为准。
如果k非常大，应当对状态转移矩阵求快速幂，最终的dp值一定等于该矩阵的k次幂左乘边界条件，这对于LC平台是严重超纲内容。但本题的k只有10^5，所以按照转移的具体公式迭代k次就可以。
---
相似题目: 2851. 字符串转换
https://leetcode.cn/problems/string-transformation/
 */