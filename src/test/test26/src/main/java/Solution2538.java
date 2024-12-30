import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution2538 {
    private int[] price;
    private Map<Integer, List<Integer>> adj;
    private long ans;

    public long maxOutput(int n, int[][] edges, int[] price) {
        this.price = price;
        adj = new HashMap<>();
        for (int[] edge : edges) {
            adj.computeIfAbsent(edge[0], key -> new ArrayList<>()).add(edge[1]);
            adj.computeIfAbsent(edge[1], key -> new ArrayList<>()).add(edge[0]);
        }

        ans = 0;
        dfs(0, -1);
        return ans;
    }

    private long[] dfs(int x, int fa) {
        // sum1 带上端点的最大路径和，sum2 不带上端点的最大路径和
        long sum1 = price[x], sum2 = 0;
        for (int y : adj.getOrDefault(x, new ArrayList<>())) {
            if (y == fa) {
                continue;
            }
            long[] tuple = dfs(y, x);
            ans = Math.max(ans, Math.max(tuple[0] + sum2, tuple[1] + sum1));
            sum1 = Math.max(sum1, tuple[0] + price[x]);
            sum2 = Math.max(sum2, tuple[1] + price[x]);
        }
        return new long[]{sum1, sum2};
    }
}
/*
2538. 最大价值和与最小价值和的差值
https://leetcode.cn/problems/difference-between-maximum-and-minimum-price-sum/

第 328 场周赛 T4。

给你一个 n 个节点的无向无根图，节点编号为 0 到 n - 1 。给你一个整数 n 和一个长度为 n - 1 的二维整数数组 edges ，
其中 edges[i] = [ai, bi] 表示树中节点 ai 和 bi 之间有一条边。
每个节点都有一个价值。给你一个整数数组 price ，其中 price[i] 是第 i 个节点的价值。
一条路径的 价值和 是这条路径上所有节点的价值之和。
你可以选择树中任意一个节点作为根节点 root 。选择 root 为根的 开销 是以 root 为起点的所有路径中，价值和 最大的一条路径与最小的一条路径的差值。
请你返回所有节点作为根节点的选择中，最大 的 开销 为多少。
提示：
1 <= n <= 10^5
edges.length == n - 1
0 <= ai, bi <= n - 1
edges 表示一棵符合题面要求的树。
price.length == n
1 <= price[i] <= 10^5

树形 DP
时间复杂度 O(n)
相似题目: $1245. 树的直径
https://leetcode.cn/problems/tree-diameter/
2246. 相邻字符不同的最长路径
https://leetcode.cn/problems/longest-path-with-different-adjacent-characters/
 */