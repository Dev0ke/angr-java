import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution2144 {
    public int minimumCost(int[] cost) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        for (int cos : cost) {
            maxHeap.add(cos);
        }

        int res = 0;
        int len = cost.length;
        for (int i = 0; i < len; i++) {
            if (i % 3 != 2) {
                res += maxHeap.remove();
            } else {
                maxHeap.remove();
            }
        }
        return res;
    }
}
/*
2144. 打折购买糖果的最小开销
https://leetcode.cn/problems/minimum-cost-of-buying-candies-with-discount/

第 70 场双周赛 T1。

一家商店正在打折销售糖果。每购买 两个 糖果，商店会 免费 送一个糖果。
免费送的糖果唯一的限制是：它的价格需要小于等于购买的两个糖果价格的 较小值 。
- 比方说，总共有 4 个糖果，价格分别为 1 ，2 ，3 和 4 ，一位顾客买了价格为 2 和 3 的糖果，那么他可以免费获得价格为 1 的糖果，但不能获得价格为 4 的糖果。
给你一个下标从 0 开始的整数数组 cost ，其中 cost[i] 表示第 i 个糖果的价格，请你返回获得 所有 糖果的 最小 总开销。

贪心，排序后，从最大开始买，买两个送一个。
时间复杂度 O(nlogn)
 */