import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution3372 {
    public int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {
        int n = edges1.length + 1;
        int m = edges2.length + 1;
        List<Integer>[] g1 = buildTree(n, edges1);
        List<Integer>[] g2 = buildTree(m, edges2);

        int d2_max = 0;
        if (k > 0) {
            int[] d2 = new int[m];
            for (int i = 0; i < m; i++) {
                d2[i] = dfs(i, -1, k - 1, g2);
            }
            d2_max = Arrays.stream(d2).max().orElseThrow();
        }

        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = dfs(i, -1, k, g1) + d2_max;
        }
        return ans;
    }

    private List<Integer>[] buildTree(int n, int[][] edges) {
        List<Integer>[] g = new ArrayList[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (int[] p : edges) {
            g[p[0]].add(p[1]);
            g[p[1]].add(p[0]);
        }
        return g;
    }

    private int dfs(int x, int fa, int d, List<Integer>[] g) {
        int sz = 1;
        if (d == 0) return sz;
        for (Integer y : g[x]) {
            if (y == fa) continue;
            sz += dfs(y, x, d - 1, g);
        }
        return sz;
    }
}
/*
100475. 连接两棵树后最大目标节点数目 I
https://leetcode.cn/problems/maximize-the-number-of-target-nodes-after-connecting-trees-i/description/

第 426 场周赛 T3。

有两棵 无向 树，分别有 n 和 m 个树节点。两棵树中的节点编号分别为[0, n - 1] 和 [0, m - 1] 中的整数。
给你两个二维整数 edges1 和 edges2 ，长度分别为 n - 1 和 m - 1 ，其中 edges1[i] = [ai, bi] 表示第一棵树中节点 ai 和 bi 之间有一条边，edges2[i] = [ui, vi] 表示第二棵树中节点 ui 和 vi 之间有一条边。同时给你一个整数 k 。
如果节点 u 和节点 v 之间路径的边数小于等于 k ，那么我们称节点 u 是节点 v 的 目标节点 。注意 ，一个节点一定是它自己的 目标节点 。
请你返回一个长度为 n 的整数数组 answer ，answer[i] 表示将第一棵树中的一个节点与第二棵树中的一个节点连接一条边后，第一棵树中节点 i 的 目标节点 数目的 最大值 。
注意 ，每个查询相互独立。意味着进行下一次查询之前，你需要先把刚添加的边给删掉。
提示：
2 <= n, m <= 1000
edges1.length == n - 1
edges2.length == m - 1
edges1[i].length == edges2[i].length == 2
edges1[i] = [ai, bi]
0 <= ai, bi < n
edges2[i] = [ui, vi]
0 <= ui, vi < m
输入保证 edges1 和 edges2 都表示合法的树。
0 <= k <= 1000

DFS。
从题解区似乎没看到 O(n) 的解法。
时间复杂度 O(n^2)。
 */