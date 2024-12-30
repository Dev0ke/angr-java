import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Solution2368 {
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            adj.computeIfAbsent(from, key -> new ArrayList<>()).add(to);
            adj.computeIfAbsent(to, key -> new ArrayList<>()).add(from);
        }
        Set<Integer> restrictedSet = new HashSet<>();
        for (int i : restricted) {
            restrictedSet.add(i);
        }
        int cnt = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        restrictedSet.add(0);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int cur = queue.remove();
                cnt++;

                for (int next : adj.get(cur)) {
                    if (!restrictedSet.contains(next)) {
                        restrictedSet.add(next);
                        queue.add(next);
                    }
                }
            }
        }
        return cnt;
    }
}
/*
2368. 受限条件下可到达节点的数目
https://leetcode.cn/problems/reachable-nodes-with-restrictions/

第 305 场周赛 T2。

现有一棵由 n 个节点组成的无向树，节点编号从 0 到 n - 1 ，共有 n - 1 条边。
给你一个二维整数数组 edges ，长度为 n - 1 ，其中 edges[i] = [ai, bi] 表示树中节点 ai 和 bi 之间存在一条边。另给你一个整数数组 restricted 表示 受限 节点。
在不访问受限节点的前提下，返回你可以从节点 0 到达的 最多 节点数目。
注意，节点 0 不 会标记为受限节点。
提示：
2 <= n <= 10^5
edges.length == n - 1
edges[i].length == 2
0 <= ai, bi < n
ai != bi
edges 表示一棵有效的树
1 <= restricted.length < n
1 <= restricted[i] < n
restricted 中的所有值 互不相同

BFS
时间复杂度：O(n)
 */