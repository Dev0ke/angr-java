public class Solution2240 {
    public long waysToBuyPensPencils(int total, int cost1, int cost2) {
        // 最多买 n 支钢笔
        int n = total / cost1;
        long cnt = 0;
        for (int i = 0; i <= n; i++) {
            int remain = total - cost1 * i;
            // 最多买 m 支铅笔
            int m = remain / cost2;
            cnt += m + 1;
        }
        return cnt;
    }
}
/*
2240. 买钢笔和铅笔的方案数
https://leetcode.cn/problems/number-of-ways-to-buy-pens-and-pencils/

第 76 场双周赛 T2。

给你一个整数 total ，表示你拥有的总钱数。同时给你两个整数 cost1 和 cost2 ，分别表示一支钢笔和一支铅笔的价格。你可以花费你部分或者全部的钱，去买任意数目的两种笔。
请你返回购买钢笔和铅笔的 不同方案数目 。
提示：
1 <= total, cost1, cost2 <= 10^6

枚举
设可以买 n 支钢笔，m 支铅笔，则有 cost1 * n + cost2 * m <= total
 */