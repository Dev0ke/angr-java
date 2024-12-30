public class SolutionP2291 {
    public int maximumProfit(int[] present, int[] future, int budget) {
        int n = present.length;
        int[] f = new int[budget + 1];
        for (int i = 0; i < n; i++) {
            int wi = present[i];
            int vi = future[i] - present[i];
            if (vi <= 0) continue; // 剪枝，跳过负值
            for (int j = budget; j >= wi; j--) {
                f[j] = Math.max(f[j], f[j - wi] + vi);
            }
        }
        return f[budget];
    }
}
/*
$2291. 最大股票收益
https://leetcode.cn/problems/maximum-profit-from-trading-stocks/description/

给你两个下标从 0 开始的数组 present 和 future ，present[i] 和 future[i] 分别代表第 i 支股票现在和将来的价格。每支股票你最多购买 一次 ，你的预算为 budget 。
求最大的收益。
提示：
n == present.length == future.length
1 <= n <= 1000
0 <= present[i], future[i] <= 100
0 <= budget <= 1000

0-1 背包。
时间复杂度 O(n * budget)。
 */