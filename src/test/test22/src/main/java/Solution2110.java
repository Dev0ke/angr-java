public class Solution2110 {
    public long getDescentPeriods(int[] prices) {
        // 差分数组
        int len = prices.length;
        // 长度+1 避免处理边界
        int[] diff = new int[len + 1];
        diff[0] = prices[0];
        for (int i = 1; i < len; i++) {
            diff[i] = prices[i] - prices[i - 1];
        }

        // 平滑下降阶段 的数目
        long res = len;
        long cnt = 0;
        for (int i = 1; i <= len; i++) {
            if (diff[i] == -1) {
                cnt++;
            } else {
                res += (cnt + 1) * cnt / 2;
                cnt = 0;
            }
        }
        return res;
    }
}
/*
2110. 股票平滑下跌阶段的数目
https://leetcode.cn/problems/number-of-smooth-descent-periods-of-a-stock/

第 272 场周赛 T3。

给你一个整数数组 prices ，表示一支股票的历史每日股价，其中 prices[i] 是这支股票第 i 天的价格。
一个 平滑下降的阶段 定义为：对于 连续一天或者多天 ，每日股价都比 前一日股价恰好少 1 ，这个阶段第一天的股价没有限制。
请你返回 平滑下降阶段 的数目。

预处理出差分数组，变成求连续 1 的个数。再用等差数列求和公式 求出各块的 平滑下跌阶段的数目。
 */