import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Solution2973 {
    private int[] cost;
    private List<Integer>[] g;
    // 小顶堆保留最大 3 个，大顶堆保留最小 2 个
    private PriorityQueue<Integer>[] max3, min2;

    public long[] placedCoins(int[][] edges, int[] cost) {
        this.cost = cost;
        int n = edges.length + 1;
        g = new ArrayList[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (int[] edge : edges) {
            int x = edge[0], y = edge[1];
            g[x].add(y);
            g[y].add(x);
        }
        max3 = new PriorityQueue[n];
        Arrays.setAll(max3, e -> new PriorityQueue<>());
        min2 = new PriorityQueue[n];
        Arrays.setAll(min2, e -> new PriorityQueue<>(Comparator.reverseOrder()));
        dfs(0, -1);

        long[] ans = new long[n];
        for (int x = 0; x < n; x++) {
            if (max3[x].size() < 3) {
                ans[x] = 1;
                continue;
            }
            // [次次大,次大,最大] or [最小,次小,最大]
            long prod1 = 1, prod2 = 1;
            for (int i = 0; i < 2; i++) {
                prod1 *= max3[x].remove();
                prod2 *= min2[x].remove();
            }
            Integer max = max3[x].remove();
            prod1 *= max;
            prod2 *= max;
            ans[x] = Math.max(0, Math.max(prod1, prod2));
        }
        return ans;
    }

    private void dfs(int x, int fa) {
        max3[x].add(cost[x]);
        min2[x].add(cost[x]);
        for (Integer y : g[x]) {
            if (y != fa) {
                dfs(y, x);
                max3[x].addAll(max3[y]);
                min2[x].addAll(min2[y]);
            }
        }
        while (max3[x].size() > 3) max3[x].remove();
        while (min2[x].size() > 2) min2[x].remove();
    }
}
/*
2973. 树中每个节点放置的金币数目
https://leetcode.cn/problems/find-number-of-coins-to-place-in-tree-nodes/description/

第 120 场双周赛 T4。

给你一棵 n 个节点的 无向 树，节点编号为 0 到 n - 1 ，树的根节点在节点 0 处。同时给你一个长度为 n - 1 的二维整数数组 edges ，其中 edges[i] = [ai, bi] 表示树中节点 ai 和 bi 之间有一条边。
给你一个长度为 n 下标从 0 开始的整数数组 cost ，其中 cost[i] 是第 i 个节点的 开销 。
你需要在树中每个节点都放置金币，在节点 i 处的金币数目计算方法如下：
- 如果节点 i 对应的子树中的节点数目小于 3 ，那么放 1 个金币。
- 否则，计算节点 i 对应的子树内 3 个不同节点的开销乘积的 最大值 ，并在节点 i 处放置对应数目的金币。如果最大乘积是 负数 ，那么放置 0 个金币。
请你返回一个长度为 n 的数组 coin ，coin[i]是节点 i 处的金币数目。
提示：
2 <= n <= 2 * 10^4
edges.length == n - 1
edges[i].length == 2
0 <= ai, bi < n
cost.length == n
1 <= |cost[i]| <= 10^4
edges 一定是一棵合法的树。

DFS + 贪心。
用堆维护最小2个数（负数）和最大3个数（正数）
时间复杂度 O(nlogn)
 */