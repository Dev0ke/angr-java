import java.util.PriorityQueue;

public class SolutionP1167 {
    public int connectSticks(int[] sticks) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int x : sticks) {
            minHeap.add(x);
        }
        int res = 0;
        while (minHeap.size() > 1) {
            int cost = minHeap.remove() + minHeap.remove();
            res += cost;
            minHeap.add(cost);
        }
        return res;
    }
}
/*
$1167. 连接棒材的最低费用
https://leetcode.cn/problems/minimum-cost-to-connect-sticks/

你有一些长度为正整数的棍子。这些长度以数组 sticks 的形式给出， sticks[i] 是 第i个 木棍的长度。
你可以通过支付 x + y 的成本将任意两个长度为 x 和 y 的棍子连接成一个棍子。你必须连接所有的棍子，直到剩下一个棍子。
返回以这种方式将所有给定的棍子连接成一个棍子的 最小成本 。
提示：
1 <= sticks.length <= 10^4
1 <= sticks[i] <= 10^4

贪心/堆
 */