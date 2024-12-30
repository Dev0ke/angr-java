import java.util.PriorityQueue;

public class Solution2462 {
    private int p;
    private int q;

    public long totalCost(int[] costs, int k, int candidates) {
        int len = costs.length;

        // 双指针
        this.p = 0;
        this.q = len - 1;

        PriorityQueue<Node> minHeap = new PriorityQueue<>((o1, o2) -> {
            // 如果有多位代价相同且最小的工人，选择下标更小的一位工人。
            if (o1.cost == o2.cost) {
                return Integer.compare(o1.id, o2.id);
            }
            // 雇佣他们中代价最小的一人
            return Integer.compare(o1.cost, o2.cost);
        });

        for (int i = 0; i < candidates; i++) {
            addLeft(costs, minHeap);
            addRight(costs, minHeap);
        }

        long sum = 0L;
        for (int i = 0; i < k; i++) {
            Node top = minHeap.remove();
            sum += top.cost;
            if (top.left) {
                addLeft(costs, minHeap);
            } else {
                addRight(costs, minHeap);
            }
        }
        return sum;
    }

    private void addRight(int[] costs, PriorityQueue<Node> priorityQueue) {
        if (p <= q) {
            priorityQueue.add(new Node(q, costs[q], false));
            q--;
        }
    }

    private void addLeft(int[] costs, PriorityQueue<Node> priorityQueue) {
        if (p <= q) {
            priorityQueue.add(new Node(p, costs[p], true));
            p++;
        }
    }

    private static class Node {
        int id;
        int cost;
        // true:来自左边
        boolean left;

        public Node(int id, int cost, boolean left) {
            this.id = id;
            this.cost = cost;
            this.left = left;
        }
    }
}
/*
2462. 雇佣 K 位工人的总代价
https://leetcode.cn/problems/total-cost-to-hire-k-workers/

第 318 场周赛 T3。

给你一个下标从 0 开始的整数数组 costs ，其中 costs[i] 是雇佣第 i 位工人的代价。
同时给你两个整数 k 和 candidates 。我们想根据以下规则恰好雇佣 k 位工人：
- 总共进行 k 轮雇佣，且每一轮恰好雇佣一位工人。
- 在每一轮雇佣中，从最前面 candidates 和最后面 candidates 人中选出代价最小的一位工人，如果有多位代价相同且最小的工人，选择下标更小的一位工人。
  - 比方说，costs = [3,2,7,7,1,2] 且 candidates = 2 ，第一轮雇佣中，我们选择第 4 位工人，因为他的代价最小 [3,2,7,7,1,2] 。
  - 第二轮雇佣，我们选择第 1 位工人，因为他们的代价与第 4 位工人一样都是最小代价，而且下标更小，[3,2,7,7,2] 。注意每一轮雇佣后，剩余工人的下标可能会发生变化。
- 如果剩余员工数目不足 candidates 人，那么下一轮雇佣他们中代价最小的一人，如果有多位代价相同且最小的工人，选择下标更小的一位工人。
- 一位工人只能被选择一次。
返回雇佣恰好 k 位工人的总代价。
提示：
1 <= costs.length <= 10^5
1 <= costs[i] <= 10^5
1 <= k, candidates <= costs.length

优先队列，比赛时写了一版双堆模拟的，实际上一个堆就够了。
时间复杂度 O(klogn)
 */