import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Solution2477 {
    public long minimumFuelCost(int[][] roads, int seats) {
        int n = roads.length + 1;

        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int[] road : roads) {
            adj.computeIfAbsent(road[0], key -> new ArrayList<>()).add(road[1]);
            adj.computeIfAbsent(road[1], key -> new ArrayList<>()).add(road[0]);
        }
        // 拓扑排序
        // id
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (adj.getOrDefault(i, new ArrayList<>()).size() == 1) {
                queue.add(i);
            }
        }
        long[] sz = new long[n];
        Arrays.fill(sz, 1L);

        long res = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer u = queue.remove();
                if (u == 0) {
                    continue;
                }

                for (int v : adj.getOrDefault(u, new ArrayList<>())) {
                    if (adj.get(u).size() == 1) {
                        adj.get(v).remove(u);
                        // 数论向上取整
                        res += (sz[u] + seats - 1) / seats;
                        sz[v] += sz[u];
                        sz[u] = 0;
                        queue.add(v);
                    }
                }
            }
        }
        return res;
    }
}
/*
2477. 到达首都的最少油耗
https://leetcode.cn/problems/minimum-fuel-cost-to-report-to-the-capital/

第 320 场周赛 T3。

给你一棵 n 个节点的树（一个无向、连通、无环图），每个节点表示一个城市，编号从 0 到 n - 1 ，且恰好有 n - 1 条路。0 是首都。
给你一个二维整数数组 roads ，其中 roads[i] = [ai, bi] ，表示城市 ai 和 bi 之间有一条 双向路 。
每个城市里有一个代表，他们都要去首都参加一个会议。
每座城市里有一辆车。给你一个整数 seats 表示每辆车里面座位的数目。
城市里的代表可以选择乘坐所在城市的车，或者乘坐其他城市的车。相邻城市之间一辆车的油耗是一升汽油。
请你返回到达首都最少需要多少升汽油。
提示：
1 <= n <= 10^5
roads.length == n - 1
roads[i].length == 2
0 <= ai, bi < n
ai != bi
roads 表示一棵合法的树。
1 <= seats <= 10^5

拓扑序贪心
时间复杂度 O(n)
 */