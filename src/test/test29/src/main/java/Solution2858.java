import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution2858 {
    private List<int[]>[] g;
    private int tot;
    private int[] ans;

    public int[] minEdgeReversals(int n, int[][] edges) {
        g = new List[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (int[] e : edges) {
            // 正向权重为 0，反向为 1
            g[e[0]].add(new int[]{e[1], 0});
            g[e[1]].add(new int[]{e[0], 1});
        }

        tot = 0;
        dfs(0, -1);

        ans = new int[n];
        reroot(0, -1, tot);
        return ans;
    }

    private void dfs(int x, int fa) {
        for (int[] p : g[x]) {
            int y = p[0], wt = p[1];
            if (y == fa) continue;
            tot += wt;
            dfs(y, x);
        }
    }

    private void reroot(int x, int fa, int cnt) {
        ans[x] = cnt;
        for (int[] p : g[x]) {
            int y = p[0], wt = p[1];
            if (y == fa) continue;
            reroot(y, x, cnt + (wt == 1 ? -1 : 1));
        }
    }
}
/*
2858. 可以到达每一个节点的最少边反转次数
https://leetcode.cn/problems/minimum-edge-reversals-so-every-node-is-reachable/

第 113 场双周赛 T4。

给你一个 n 个点的 简单有向图 （没有重复边的有向图），节点编号为 0 到 n - 1 。如果这些边是双向边，那么这个图形成一棵 树 。
给你一个整数 n 和一个 二维 整数数组 edges ，其中 edges[i] = [ui, vi] 表示从节点 ui 到节点 vi 有一条 有向边 。
边反转 指的是将一条边的方向反转，也就是说一条从节点 ui 到节点 vi 的边会变为一条从节点 vi 到节点 ui 的边。
对于范围 [0, n - 1] 中的每一个节点 i ，你的任务是分别 独立 计算 最少 需要多少次 边反转 ，从节点 i 出发经过 一系列有向边 ，可以到达所有的节点。
请你返回一个长度为 n 的整数数组 answer ，其中 answer[i]表示从节点 i 出发，可以到达所有节点的 最少边反转 次数。
提示：
2 <= n <= 10^5
edges.length == n - 1
edges[i].length == 2
0 <= ui == edges[i][0] < n
0 <= vi == edges[i][1] < n
ui != vi
输入保证如果边是双向边，可以得到一棵树。

换根 DP
时间复杂度 O(n)
相似题目: 2581. 统计可能的树根数目
https://leetcode.cn/problems/count-number-of-possible-root-nodes/
 */