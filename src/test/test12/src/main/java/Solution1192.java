import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution1192 {
    private Map<Integer, List<Integer>> adj;

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        // 无向图
        adj = new HashMap<>();
        for (List<Integer> connection : connections) {
            int from = connection.get(0);
            int to = connection.get(1);

            adj.computeIfAbsent(from, key -> new ArrayList<>()).add(to);
            adj.computeIfAbsent(to, key -> new ArrayList<>()).add(from);
        }

        int[] ids = new int[n];
        Arrays.fill(ids, -1);

        List<List<Integer>> resList = new ArrayList<>();
        dfs(0, 0, -1, ids, resList);
        return resList;
    }

    private int dfs(int idx, int nodeId, int pre, int[] ids, List<List<Integer>> resList) {
        // tarjan
        ids[idx] = nodeId;

        for (int next : adj.get(idx)) {
            if (next != pre) {
                if (ids[next] == -1) {
                    ids[idx] = Math.min(ids[idx], dfs(next, nodeId + 1, idx, ids, resList));
                } else {
                    ids[idx] = Math.min(ids[idx], ids[next]);
                }
            }
        }

        if (ids[idx] == nodeId && idx != 0) {
            resList.add(Arrays.asList(pre, idx));
        }
        return ids[idx];
    }
}
/*
1192. 查找集群内的「关键连接」
https://leetcode.cn/problems/critical-connections-in-a-network/

第 154 场周赛 T4。

力扣数据中心有 n 台服务器，分别按从 0 到 n-1 的方式进行了编号。
它们之间以「服务器到服务器」点对点的形式相互连接组成了一个内部集群，其中连接 connections 是无向的。
从形式上讲，connections[i] = [a, b] 表示服务器 a 和 b 之间形成连接。任何服务器都可以直接或者间接地通过网络到达任何其他服务器。
「关键连接」是在该集群中的重要连接，也就是说，假如我们将它移除，便会导致某些服务器无法访问其他服务器。
请你以任意顺序返回该集群内的所有 「关键连接」。
提示：
1 <= n <= 10^5
n-1 <= connections.length <= 10^5
connections[i][0] != connections[i][1]
不存在重复的连接

b 站: https://www.bilibili.com/video/BV15t4y197eq/
Java DFS + Tarjan
时间复杂度 O(V+E)
 */