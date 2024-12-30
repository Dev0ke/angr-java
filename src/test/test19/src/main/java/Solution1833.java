import java.util.Arrays;

public class Solution1833 {
    public int maxIceCream(int[] costs, int coins) {
        // 贪心
        Arrays.sort(costs);
        // 前缀和剪枝
        int len = costs.length;
        int[] preSum = new int[len + 1];
        preSum[0] = 0;
        for (int i = 0; i < len; i++) {
            preSum[i + 1] = preSum[i] + costs[i];
            if (preSum[i + 1] > coins) {
                return i;
            }
        }
        return len;
    }
}
/*
1833. 雪糕的最大数量
https://leetcode.cn/problems/maximum-ice-cream-bars/

第 237 场周赛 T2。

夏日炎炎，小男孩 Tony 想买一些雪糕消消暑。
商店中新到 n 支雪糕，用长度为 n 的数组 costs 表示雪糕的定价，其中 costs[i] 表示第 i 支雪糕的现金价格。Tony 一共有 coins 现金可以用于消费，他想要买尽可能多的雪糕。
给你价格数组 costs 和现金量 coins ，请你计算并返回 Tony 用 coins 现金能够买到的雪糕的 最大数量 。
注意：Tony 可以按任意顺序购买雪糕。
提示：
costs.length == n
1 <= n <= 10^5
1 <= costs[i] <= 10^5
1 <= coins <= 10^8

贪心法+前缀和。要想买尽可能多的雪糕，当然是从最便宜的开始买。
 */