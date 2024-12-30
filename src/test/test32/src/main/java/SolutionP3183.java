public class SolutionP3183 {
    static final int MOD = (int) (1e9 + 7);

    public int numberOfWays(int n) {
        int[] coins = {1, 2, 6};
        int[] f = new int[n + 1];
        f[0] = 1;
        for (int x : coins) {
            for (int j = x; j <= n; ++j) {
                f[j] = (f[j] + f[j - x]) % MOD;
            }
        }

        int ans = f[n];
        if (n >= 4) ans = (ans + f[n - 4]) % MOD;
        if (n >= 8) ans = (ans + f[n - 8]) % MOD;
        return ans;
    }
}
/*
$3183. 达到总和的方法数量
https://leetcode.cn/problems/the-number-of-ways-to-make-the-sum/description/

给定 无限 数量的面值为 1，2，6 的硬币，并且 只有 2 枚硬币面值为 4。
给定一个整数 n ，返回用你持有的硬币达到总和 n 的方法数量。
因为答案可能会很大，将其 取模 10^9 + 7。
注意 硬币的顺序并不重要，[2, 2, 3] 与 [2, 3, 2] 相同。
提示：
1 <= n <= 10^5

动态规划（完全背包）
我们可以先忽略硬币 4，定义硬币数组 coins=[1,2,6]，然后使用完全背包的思想，定义 f[j] 表示使用前 i 种硬币凑成金额 j 的方案数，初始时 f[0]=1，然后我们遍历硬币数组 coins，对于每一种硬币 x，我们遍历 x 到 n 的金额，更新 f[j]=f[j]+f[j−x]。
最后 f[n] 就是使用硬币 1,2,6 凑成金额 n 的方案数，然后如果 n≥4，我们考虑选择一个硬币 4，那么方案数就是 f[n]+f[n−4]，如果 n≥8，我们再考虑选择两个硬币 4，那么方案数就是 f[n]+f[n−4]+f[n−8]。
注意答案的取模操作。
https://leetcode.cn/problems/the-number-of-ways-to-make-the-sum/solutions/2809408/python3javacgotypescript-yi-ti-shuang-ji-dwed/
 */