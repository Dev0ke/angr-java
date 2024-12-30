import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution2508 {
    private Map<Integer, Set<Integer>> adj;

    public boolean isPossible(int n, List<List<Integer>> edges) {
        int[] degrees = new int[n + 1];

        // 建图
        adj = new HashMap<>();
        for (List<Integer> edge : edges) {
            int u = edge.get(0);
            int v = edge.get(1);
            adj.computeIfAbsent(u, key -> new HashSet<>()).add(v);
            adj.computeIfAbsent(v, key -> new HashSet<>()).add(u);
            degrees[u]++;
            degrees[v]++;
        }
        List<Integer> oddNodes = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (degrees[i] % 2 == 1) {
                oddNodes.add(i);
            }
        }
        int sz = oddNodes.size();
        if (sz == 0) {
            return true;
        }
        if (sz != 2 && sz != 4) {
            return false;
        }

        if (sz == 2) {
            // 两点直连 或 两点连同一个偶数点
            int a = oddNodes.get(0);
            int b = oddNodes.get(1);
            if (link(a, b)) {
                return true;
            }
            for (int i = 1; i <= n; i++) {
                if (degrees[i] % 2 == 0 && (link(a, i) && link(b, i))) {
                    return true;
                }
            }
        } else {
            // 两点直连 * 2
            int a = oddNodes.get(0);
            int b = oddNodes.get(1);
            int c = oddNodes.get(2);
            int d = oddNodes.get(3);
            if ((link(a, b) && link(c, d))
                    || (link(a, c) && link(b, d))
                    || (link(a, d) && link(b, c))
            ) {
                return true;
            }
        }
        return false;
    }

    // 是否可以增加边 a-b
    private boolean link(int a, int b) {
        return !adj.getOrDefault(a, new HashSet<>()).contains(b);
    }
}
/*
2508. 添加边使所有节点度数都为偶数
https://leetcode.cn/problems/add-edges-to-make-degrees-of-all-nodes-even/

第 324 场周赛 T3。

给你一个有 n 个节点的 无向 图，节点编号为 1 到 n 。再给你整数 n 和一个二维整数数组 edges ，其中 edges[i] = [ai, bi] 表示节点 ai 和 bi 之间有一条边。图不一定连通。
你可以给图中添加 至多 两条额外的边（也可以一条边都不添加），使得图中没有重边也没有自环。
如果添加额外的边后，可以使得图中所有点的度数都是偶数，返回 true ，否则返回 false 。
点的度数是连接一个点的边的数目。
提示：
3 <= n <= 10^5
2 <= edges.length <= 10^5
edges[i].length == 2
1 <= ai, bi <= n
ai != bi
图中不会有重边

分类讨论
度数为奇数的节点个数只能是 0/2/4 个
如果是 0 个，不需要添加边；
如果是 2 个，可以两个点直连，或者连到同一个偶数点
如果是 4 个，只能是 两个点直连 * 2
 */