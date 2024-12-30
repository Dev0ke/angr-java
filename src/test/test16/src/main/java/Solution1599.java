public class Solution1599 {
    public int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {
        // 最大化利润所需执行的 最小轮转次数
        int res = -1;

        // 轮转数，抵达的游客数，当前收益，最大收益
        int rotations = 0;
        int customerCnt = 0;
        int curProfit = 0;
        int maxProfit = 0;

        for (int customer : customers) {
            rotations++;
            customerCnt += customer;
            // 这一轮上 k 个人
            int k = Math.min(4, customerCnt);
            customerCnt -= k;
            curProfit += boardingCost * k - runningCost;

            if (maxProfit < curProfit) {
                maxProfit = curProfit;
                res = rotations;
            }
        }
        if (customerCnt == 0) {
            return res;
        }

        // 如果还有剩余的游客在等摩天轮，只有当剩余的游客带来的利润为正时，才需要考虑第二阶段
        int once = boardingCost * 4 - runningCost;
        if (once <= 0) {
            return res;
        }
        // 剩余轮数
        int remainRotations = customerCnt / 4;
        curProfit += remainRotations * once;
        rotations += remainRotations;
        if (maxProfit < curProfit) {
            maxProfit = curProfit;
            res = rotations;
        }
        // 剩余游客
        int remainCustomers = customerCnt % 4;
        curProfit += boardingCost * remainCustomers - runningCost;
        if (maxProfit < curProfit) {
            rotations++;
            maxProfit = curProfit;
            res = rotations;
        }
        return res;
    }
}
/*
1599. 经营摩天轮的最大利润
https://leetcode.cn/problems/maximum-profit-of-operating-a-centennial-wheel/

你正在经营一座摩天轮，该摩天轮共有 4 个座舱 ，每个座舱 最多可以容纳 4 位游客 。
你可以 逆时针 轮转座舱，但每次轮转都需要支付一定的运行成本 runningCost 。摩天轮每次轮转都恰好转动 1 / 4 周。
给你一个长度为 n 的数组 customers ， customers[i] 是在第 i 次轮转（下标从 0 开始）之前到达的新游客的数量。这也意味着你必须在新游客到来前轮转 i 次。
每位游客在登上离地面最近的座舱前都会支付登舱成本 boardingCost ，一旦该座舱再次抵达地面，他们就会离开座舱结束游玩。
你可以随时停下摩天轮，即便是 在服务所有游客之前 。如果你决定停止运营摩天轮，为了保证所有游客安全着陆，将免费进行所有后续轮转 。
注意，如果有超过 4 位游客在等摩天轮，那么只有 4 位游客可以登上摩天轮，其余的需要等待 下一次轮转 。
返回最大化利润所需执行的 最小轮转次数 。 如果不存在利润为正的方案，则返回 -1 。
提示：
n == customers.length
1 <= n <= 10^5
0 <= customers[i] <= 50
1 <= boardingCost, runningCost <= 100

模拟
 */