public class Solution746 {
    public int minCostClimbingStairs(int[] cost) {
        int len = cost.length;
        int[] dp = new int[len + 1];
        for (int i = 2; i <= len; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }
        return dp[len];
    }
}
/*
746. 使用最小花费爬楼梯
https://leetcode.cn/problems/min-cost-climbing-stairs/

数组的每个下标作为一个阶梯，第 i 个阶梯对应着一个非负数的体力花费值 cost[i]（下标从 0 开始）。
每当你爬上一个阶梯你都要花费对应的体力值，一旦支付了相应的体力值，你就可以选择向上爬一个阶梯或者爬两个阶梯。
请你找出达到楼层顶部的最低花费。在开始时，你可以选择从下标为 0 或 1 的元素作为初始阶梯。
提示：
2 <= cost.length <= 1000
0 <= cost[i] <= 999

动态规划.
dp[i] 表示达到下标 i 的最小花费
dp[0] = dp[1] = 0
状态转移
dp[i] = min(dp[i−1]+cost[i−1], dp[i−2]+cost[i−2])
 */