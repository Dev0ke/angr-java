import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution1377 {
    private int target;
    private Map<Integer, List<Integer>> adj;

    public double frogPosition(int n, int[][] edges, int t, int target) {
        // 特判
        if (n == 1) {
            return 1;
        }
        this.target = target;
        // 建图
        adj = new HashMap<>();
        for (int[] edge : edges) {
            adj.computeIfAbsent(edge[0], key -> new ArrayList<>()).add(edge[1]);
            adj.computeIfAbsent(edge[1], key -> new ArrayList<>()).add(edge[0]);
        }

        return dfs(1, -1, t);
    }

    private double dfs(int x, int fa, int t) {
        List<Integer> yList = adj.getOrDefault(x, new ArrayList<>());
        int sz = yList.size();
        if (t == 0 || (fa != -1 && sz == 1)) {
            if (x == target) {
                return 1;
            }
            return 0;
        }

        double p = 1.0 / (fa != -1 ? sz - 1 : sz);
        double max = 0.0;
        for (Integer y : yList) {
            if (y == fa) continue;
            max = Math.max(max, dfs(y, x, t - 1));
        }
        return p * max;
    }
}
/*
1377. T 秒后青蛙的位置
https://leetcode.cn/problems/frog-position-after-t-seconds/

给你一棵由 n 个顶点组成的无向树，顶点编号从 1 到 n。青蛙从 顶点 1 开始起跳。规则如下：
- 在一秒内，青蛙从它所在的当前顶点跳到另一个 未访问 过的顶点（如果它们直接相连）。
- 青蛙无法跳回已经访问过的顶点。
- 如果青蛙可以跳到多个不同顶点，那么它跳到其中任意一个顶点上的机率都相同。
- 如果青蛙不能跳到任何未访问过的顶点上，那么它每次跳跃都会停留在原地。
无向树的边用数组 edges 描述，其中 edges[i] = [fromi, toi] 意味着存在一条直接连通 fromi 和 toi 两个顶点的边。
返回青蛙在 t 秒后位于目标顶点 target 上的概率。
提示：
1 <= n <= 100
edges.length == n - 1
edges[i].length == 2
1 <= ai, bi <= n
1 <= t <= 50
1 <= target <= n

https://leetcode.cn/problems/frog-position-after-t-seconds/solution/leetcode-di-179-chang-zhou-sai-ti-jie-by-godweiyan/
DFS。建图，从 1 号节点开始，每往下走一次，时间 t 减 1。如果 t = 0 或者到了叶子节点了，
就判断节点是否为 target，是就返回 1，不是就返回 0。每次概率除以当前节点的子节点个数，
然后再乘上所有子节点 dfs 结果的最大值（因为结果不是 0 就是正确概率）。
时间复杂度 O(n)
 */