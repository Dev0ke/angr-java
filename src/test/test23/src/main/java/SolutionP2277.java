import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SolutionP2277 {
    private List<Integer>[] g;
    private static final int K = 11;
    private int[][] pa;
    private int[] depth;

    public int[] closestNode(int n, int[][] edges, int[][] query) {
        g = new ArrayList[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (int[] p : edges) {
            g[p[0]].add(p[1]);
            g[p[1]].add(p[0]);
        }

        pa = new int[n][K];
        depth = new int[n];
        Arrays.fill(depth, 1);
        dfs(0, 0);

        int q = query.length;
        int[] ans = new int[q];
        for (int i = 0; i < q; ++i) {
            int u = query[i][0], v = query[i][1], t = query[i][2];
            int uv = lca(u, v), ut = lca(u, t), vt = lca(v, t);
            if (ut == uv) {
                ans[i] = vt;
            } else if (vt == uv) {
                ans[i] = ut;
            } else {
                ans[i] = uv;
            }
        }
        return ans;
    }

    private void dfs(int x, int fa) {
        depth[x] = depth[fa] + 1;
        pa[x][0] = fa;
        for (int i = 1; i < K; ++i) {
            pa[x][i] = pa[pa[x][i - 1]][i - 1];
        }
        for (int y : g[x]) {
            if (y == fa) continue;
            dfs(y, x);
        }
    }

    private int lca(int x, int y) {
        if (depth[x] > depth[y]) {
            int tmp = x;
            x = y;
            y = tmp;
        }
        for (int i = K - 1; i >= 0; i--) {
            if (depth[y] - depth[x] >= 1 << i) {
                y = pa[y][i];
            }
        }
        for (int i = K - 1; i >= 0; i--) {
            if (pa[x][i] != pa[y][i]) {
                x = pa[x][i];
                y = pa[y][i];
            }
        }
        return x == y ? x : pa[x][0];
    }
}
/*
2277. 树中最接近路径的节点
https://leetcode.cn/problems/closest-node-to-path-in-tree/description/

给定一个正整数 n，表示树中的节点数，编号从 0 到 n - 1 (含边界)。还给定一个长度为 n - 1 的二维整数数组 edges，其中 edges[i] = [node1i, node2i] 表示有一条 双向 边连接树中的 node1i 和 node2i。
给定一个长度为 m ，下标从 0 开始 的整数数组 query，其中 query[i] = [starti, endi, nodei] 意味着对于第 i 个查询，您的任务是从 starti 到 endi 的路径上找到 最接近 nodei 的节点。
返回长度为 m 的整数数组 answer，其中 answer[i] 是第 i 个查询的答案。
提示:
1 <= n <= 1000
edges.length == n - 1
edges[i].length == 2
0 <= node1i, node2i <= n - 1
node1i != node2i
1 <= query.length <= 1000
query[i].length == 3
0 <= starti, endi, nodei <= n - 1
这个图是一个树。

LCA（最近公共祖先）+ 分类讨论
https://leetcode.cn/problems/closest-node-to-path-in-tree/solutions/1818673/by-megurine-2377/
 */