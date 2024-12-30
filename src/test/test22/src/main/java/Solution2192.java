import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Solution2192 {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        // 建图
        List<Integer>[] g = new ArrayList[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        int[] inDeg = new int[n];
        for (int[] p : edges) {
            int x = p[0], y = p[1];
            g[x].add(y);
            inDeg[y]++;
        }

        // 拓扑序
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (inDeg[i] == 0) {
                queue.add(i);
            }
        }
        Set<Integer>[] ancSet = new HashSet[n];
        Arrays.setAll(ancSet, e -> new HashSet<>());
        while (!queue.isEmpty()) {
            int x = queue.remove();
            for (Integer y : g[x]) {
                // 更新子节点的祖先
                ancSet[y].add(x);
                ancSet[y].addAll(ancSet[x]);
                if (--inDeg[y] == 0) {
                    queue.add(y);
                }
            }
        }

        List<List<Integer>> ans = new ArrayList<>();
        for (Set<Integer> anc : ancSet) {
            List<Integer> ancList = new ArrayList<>(anc);
            ancList.sort(null);
            ans.add(ancList);
        }
        return ans;
    }
}
/*
2192. 有向无环图中一个节点的所有祖先
https://leetcode.cn/problems/all-ancestors-of-a-node-in-a-directed-acyclic-graph/

第 73 场双周赛 T3。

给你一个正整数 n ，它表示一个 有向无环图 中节点的数目，节点编号为 0 到 n - 1 （包括两者）。
给你一个二维整数数组 edges ，其中 edges[i] = [fromi, toi] 表示图中一条从 fromi 到 toi 的单向边。
请你返回一个数组 answer，其中 answer[i]是第 i 个节点的所有 祖先 ，这些祖先节点 升序 排序。
如果 u 通过一系列边，能够到达 v ，那么我们称节点 u 是节点 v 的 祖先 节点。
提示：
1 <= n <= 1000
0 <= edges.length <= min(2000, n * (n - 1) / 2)
edges[i].length == 2
0 <= fromi, toi <= n - 1
fromi != toi
图中不会有重边。
图是 有向 且 无环 的。

逐个点 DFS 会 TLE（深度过大），需要进行记忆化，每次处理本层与上一层的关系即可。类似拓扑排序。
 */