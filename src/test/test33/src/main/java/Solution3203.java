import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution3203 {
    public int minimumDiameterAfterMerge(int[][] edges1, int[][] edges2) {
        int d1 = treeDiameter(edges1);
        int d2 = treeDiameter(edges2);
        return Math.max(d1, Math.max(d2, (d1 + 1) / 2 + (d2 + 1) / 2 + 1));
    }

    private List<Integer>[] g;
    private int ans;

    public int treeDiameter(int[][] edges) {
        int n = edges.length + 1;
        g = new ArrayList[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (int[] p : edges) {
            g[p[0]].add(p[1]);
            g[p[1]].add(p[0]);
        }
        ans = 0;
        dfs(0, -1);
        return ans;
    }

    private int dfs(int x, int fa) {
        int maxLen = 0;
        for (int y : g[x]) {
            if (y == fa) continue;
            int len = dfs(y, x);
            ans = Math.max(ans, maxLen + len);
            maxLen = Math.max(maxLen, len);
        }
        return maxLen + 1;
    }
}
/*
3203. 合并两棵树后的最小直径
https://leetcode.cn/problems/find-minimum-diameter-after-merging-two-trees/description/

第 404 场周赛 T4。

给你两棵 无向 树，分别有 n 和 m 个节点，节点编号分别为 0 到 n - 1 和 0 到 m - 1 。给你两个二维整数数组 edges1 和 edges2 ，长度分别为 n - 1 和 m - 1 ，其中 edges1[i] = [ai, bi] 表示在第一棵树中节点 ai 和 bi 之间有一条边，edges2[i] = [ui, vi] 表示在第二棵树中节点 ui 和 vi 之间有一条边。
你必须在第一棵树和第二棵树中分别选一个节点，并用一条边连接它们。
请你返回添加边后得到的树中，最小直径 为多少。
一棵树的 直径 指的是树中任意两个节点之间的最长路径长度。
提示：
1 <= n, m <= 10^5
edges1.length == n - 1
edges2.length == m - 1
edges1[i].length == edges2[i].length == 2
edges1[i] = [ai, bi]
0 <= ai, bi < n
edges2[i] = [ui, vi]
0 <= ui, vi < m
输入保证 edges1 和 edges2 分别表示一棵合法的树。

树的直径 + 分类讨论。
第一棵树的直径特别长。那么连边后，新树的直径仍然为第一棵树的直径，答案为 d1
第二棵树的直径特别长。那么连边后，新树的直径仍然为第二棵树的直径，答案为 d2
第一棵树的直径中点 连 第二棵树的直径中点 ceil(d1/2) + ceil(d2/2) + 1
三种情况取最大值。
时间复杂度 O(n + m)。
 */