import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution502 {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;

        int[][] profitCapital = new int[n][2];
        for (int i = 0; i < n; i++) {
            profitCapital[i][0] = capital[i];
            profitCapital[i][1] = profits[i];
        }
        Arrays.sort(profitCapital, Comparator.comparingInt(o -> o[0]));

        int cur = 0;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < k; i++) {
            while (cur < n && profitCapital[cur][0] <= w) {
                maxHeap.add(profitCapital[cur][1]);
                cur++;
            }
            if (!maxHeap.isEmpty()) {
                w += maxHeap.remove();
            } else {
                break;
            }
        }
        return w;
    }
}
/*
502. IPO
https://leetcode.cn/problems/ipo/

假设 力扣（LeetCode）即将开始 IPO 。为了以更高的价格将股票卖给风险投资公司，力扣 希望在 IPO 之前开展一些项目以增加其资本。
由于资源有限，它只能在 IPO 之前完成最多 k 个不同的项目。帮助 力扣 设计完成最多 k 个不同项目后得到最大总资本的方式。
给你 n 个项目。对于每个项目 i ，它都有一个纯利润 profits[i] ，和启动该项目需要的最小资本 capital[i] 。
最初，你的资本为 w 。当你完成一个项目时，你将获得纯利润，且利润将被添加到你的总资本中。
总而言之，从给定项目中选择 最多 k 个不同项目的列表，以 最大化最终资本 ，并输出最终可获得的最多资本。
答案保证在 32 位有符号整数范围内。
提示：
1 <= k <= 10^5
0 <= w <= 10^9
n == profits.length
n == capital.length
1 <= n <= 10^5
0 <= profits[i] <= 10^4
0 <= capital[i] <= 10^9

贪心，优先队列
 */