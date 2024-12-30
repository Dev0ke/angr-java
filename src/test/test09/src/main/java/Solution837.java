public class Solution837 {
    public double new21Game(int n, int k, int maxPts) {
        // dp[x] 为她手上牌面为x时，能获胜的概率
        double[] dp = new double[k + maxPts];
        double s = 0;
        for (int i = k; i < k + maxPts; i++) {
            dp[i] = (i <= n) ? 1 : 0;
            s += dp[i];
        }

        for (int i = k - 1; i >= 0; i--) {
            dp[i] = s / maxPts;
            s = s - dp[i + maxPts] + dp[i];
        }
        return dp[0];
    }
}
/*
837. 新 21 点
https://leetcode.cn/problems/new-21-game/

爱丽丝参与一个大致基于纸牌游戏 “21点” 规则的游戏，描述如下：
爱丽丝以 0 分开始，并在她的得分少于 k 分时抽取数字。
抽取时，她从 [1, maxPts] 的范围中随机获得一个整数作为分数进行累计，其中 maxPts 是一个整数。每次抽取都是独立的，其结果具有相同的概率。
当爱丽丝获得 k 分 或更多分 时，她就停止抽取数字。
爱丽丝的分数不超过 n 的概率是多少？
与实际答案误差不超过10^-5 的答案将被视为正确答案。
提示：
0 <= k <= n <= 10^4
1 <= maxPts <= 10^4

动态规划
https://leetcode.cn/problems/new-21-game/solutions/273085/huan-you-bi-zhe-geng-jian-dan-de-ti-jie-ma-tian-ge/
时间复杂度 O(min(n, k+maxPts))
 */