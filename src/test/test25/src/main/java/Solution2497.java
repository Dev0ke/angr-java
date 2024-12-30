import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution2497 {
    public int maxStarSum(int[] vals, int[][] edges, int k) {
        int n = vals.length;

        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int[] edge : edges) {
            adj.computeIfAbsent(edge[0], key -> new ArrayList<>()).add(edge[1]);
            adj.computeIfAbsent(edge[1], key -> new ArrayList<>()).add(edge[0]);
        }
        for (List<Integer> list : adj.values()) {
            list.sort((o1, o2) -> Integer.compare(vals[o2], vals[o1]));
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int mx = vals[i];
            int s = vals[i];
            if (adj.containsKey(i)) {
                List<Integer> list = adj.get(i);
                for (int j = 0; j < k && j < list.size(); j++) {
                    s += vals[list.get(j)];
                    mx = Math.max(mx, s);
                }
            }
            max = Math.max(max, mx);
        }
        return max;
    }
}
/*
2497. 图中最大星和
https://leetcode.cn/problems/maximum-star-sum-of-a-graph/

第 93 场双周赛 T2。

给你一个 n 个点的无向图，节点从 0 到 n - 1 编号。给你一个长度为 n 下标从 0 开始的整数数组 vals ，其中 vals[i] 表示第 i 个节点的值。
同时给你一个二维整数数组 edges ，其中 edges[i] = [ai, bi] 表示节点 ai 和 bi 之间有一条双向边。
星图 是给定图中的一个子图，它包含一个中心节点和 0 个或更多个邻居。换言之，星图是给定图中一个边的子集，且这些边都有一个公共节点。
下图分别展示了有 3 个和 4 个邻居的星图，蓝色节点为中心节点。
星和 定义为星图中所有节点值的和。
给你一个整数 k ，请你返回 至多 包含 k 条边的星图中的 最大星和 。
提示：
n == vals.length
1 <= n <= 10^5
-10^4 <= vals[i] <= 10^4
0 <= edges.length <= min(n * (n - 1) / 2, 10^5)
edges[i].length == 2
0 <= ai, bi <= n - 1
ai != bi
0 <= k <= n - 1

枚举每个中心点
 */