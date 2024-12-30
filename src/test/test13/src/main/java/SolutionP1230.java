public class SolutionP1230 {
    public double probabilityOfHeads(double[] prob, int target) {
        int n = prob.length;
        // 概率 DP
        // f[i][j] 表示 [0,i] 枚硬币，正面朝上等于 j 的概率
        double[][] f = new double[n + 1][target + 1];
        f[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            f[i][0] = f[i - 1][0] * (1 - prob[i - 1]);
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= target; j++) {
                f[i][j] = f[i - 1][j - 1] * prob[i - 1] + f[i - 1][j] * (1 - prob[i - 1]);
            }
        }
        return f[n][target];
    }
}
/*
$1230. 抛掷硬币
https://leetcode.cn/problems/toss-strange-coins/

有一些不规则的硬币。在这些硬币中，prob[i] 表示第 i 枚硬币正面朝上的概率。
请对每一枚硬币抛掷 一次，然后返回正面朝上的硬币数等于 target 的概率。
提示：
1 <= prob.length <= 1000
0 <= prob[i] <= 1
0 <= target <= prob.length
如果答案与标准答案的误差在 10^-5 内，则被视为正确答案。

概率 DP
时间复杂度 O(n * target)
 */