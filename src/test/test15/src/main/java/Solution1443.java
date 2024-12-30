import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Solution1443 {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        // 建图
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int[] edge : edges) {
            adj.computeIfAbsent(edge[0], key -> new ArrayList<>()).add(edge[1]);
            adj.computeIfAbsent(edge[1], key -> new ArrayList<>()).add(edge[0]);
        }

        // 多源 BFS，记录路径
        Queue<Node> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (hasApple.get(i)) {
                queue.add(new Node(i, List.of(i), Set.of(i)));
            }
        }

        int res = 0;
        // used[i] = true 该点为途径点
        boolean[] used = new boolean[n];
        used[0] = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node cur = queue.remove();
                int u = cur.id;
                List<Integer> memoList = cur.memoList;
                Set<Integer> memoSet = cur.memoSet;
                if (used[u]) {
                    for (Integer x : memoList) {
                        if (!used[x]) {
                            used[x] = true;
                            res += 2;
                        }
                    }
                    continue;
                }

                for (Integer v : adj.getOrDefault(u, new ArrayList<>())) {
                    if (!memoSet.contains(v)) {
                        List<Integer> nextList = new ArrayList<>(memoList);
                        Set<Integer> nextSet = new HashSet<>(memoSet);
                        nextList.add(v);
                        nextSet.add(v);
                        queue.add(new Node(v, nextList, nextSet));
                    }
                }
            }
        }
        return res;
    }

    private static class Node {
        int id;
        // 走过的路径
        List<Integer> memoList;
        // 走过哪些点
        Set<Integer> memoSet;

        public Node(int id, List<Integer> memoList, Set<Integer> memoSet) {
            this.id = id;
            this.memoList = memoList;
            this.memoSet = memoSet;
        }
    }
}
/*
1443. 收集树上所有苹果的最少时间
https://leetcode.cn/problems/minimum-time-to-collect-all-apples-in-a-tree/

给你一棵有 n 个节点的无向树，节点编号为 0 到 n-1 ，它们中有一些节点有苹果。通过树上的一条边，需要花费 1 秒钟。
你从 节点 0 出发，请你返回最少需要多少秒，可以收集到所有苹果，并回到节点 0 。
无向树的边由 edges 给出，其中 edges[i] = [fromi, toi] ，表示有一条边连接 from 和 toi 。
除此以外，还有一个布尔数组 hasApple ，其中 hasApple[i] = true 代表节点 i 有一个苹果，否则，节点 i 没有苹果。
提示：
1 <= n <= 10^5
edges.length == n-1
edges[i].length == 2
0 <= fromi, toi <= n-1
fromi < toi
hasApple.length == n

多源 BFS，记录路径。注意每条路径只能计算一次。
 */