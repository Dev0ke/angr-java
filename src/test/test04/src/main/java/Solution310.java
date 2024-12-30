import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Solution310 {
    static class V1 {
        public List<Integer> findMinHeightTrees(int n, int[][] edges) {
            List<Integer> ans = new ArrayList<>();
            if (n == 1) {
                ans.add(0);
                return ans;
            }

            // 无向图
            List<Integer>[] g = new ArrayList[n];
            Arrays.setAll(g, e -> new ArrayList<>());
            int[] inDeg = new int[n];
            for (int[] p : edges) {
                g[p[0]].add(p[1]);
                g[p[1]].add(p[0]);
                inDeg[p[1]]++;
                inDeg[p[0]]++;
            }

            // 度为 1 进队列
            Queue<Integer> q = new LinkedList<>();
            // n 个节点的树，标记为 0 到 n - 1
            for (int i = 0; i < n; i++) {
                if (inDeg[i] == 1) {
                    q.add(i);
                }
            }
            while (!q.isEmpty()) {
                ans.clear();
                int size = q.size();
                for (int i = 0; i < size; i++) {
                    int x = q.remove();
                    ans.add(x);

                    for (Integer y : g[x]) {
                        if (--inDeg[y] == 1) {
                            q.add(y);
                        }
                    }
                }
            }
            return ans;
        }
    }

    static class V2 {
        List<Integer>[] adj;
        private int[] f1, f2, g, p;

        // 树形 DP
        // https://leetcode.cn/problems/minimum-height-trees/solution/by-ac_oier-7xio/
        public List<Integer> findMinHeightTrees(int n, int[][] edges) {
            adj = new ArrayList[n];
            Arrays.setAll(adj, e -> new ArrayList<>());
            for (int[] p : edges) {
                adj[p[0]].add(p[1]);
                adj[p[1]].add(p[0]);
            }
            // f[u] 代表在以 0 号点为根节点的树中，以 u 节点为子树根节点时，往下的最大高度
            // g[u] 代表在以 0 号点为根节点的树中，以 u 节点为子节点时，往上的最大高度
            // f1 最大值，f2 次大值
            f1 = new int[n];
            f2 = new int[n];
            g = new int[n];
            // p 数组记录下取得 f1[u] 时 u 的子节点 j 为何值。
            p = new int[n];

            dfs(0, -1);
            reroot(0, -1);
            List<Integer> ans = new ArrayList<>();
            int min = n;
            for (int i = 0; i < n; i++) {
                int cur = Math.max(f1[i], g[i]);
                if (cur < min) {
                    min = cur;
                    ans.clear();
                    ans.add(i);
                } else if (cur == min) {
                    ans.add(i);
                }
            }
            return ans;
        }

        private int dfs(int x, int fa) {
            for (int y : adj[x]) {
                if (y == fa) continue;
                int sub = dfs(y, x) + 1;
                if (sub > f1[x]) {
                    f2[x] = f1[x];
                    f1[x] = sub;
                    p[x] = y;
                } else if (sub > f2[x]) {
                    f2[x] = sub;
                }
            }
            return f1[x];
        }

        private void reroot(int x, int fa) {
            for (int y : adj[x]) {
                if (y == fa) continue;
                if (p[x] != y) {
                    g[y] = Math.max(g[y], f1[x] + 1);
                } else {
                    g[y] = Math.max(g[y], f2[x] + 1);
                }
                g[y] = Math.max(g[y], g[x] + 1);
                reroot(y, x);
            }
        }
    }
}
/*
310. 最小高度树
https://leetcode.cn/problems/minimum-height-trees/

树是一个无向图，其中任何两个顶点只通过一条路径连接。 换句话说，一个任何没有简单环路的连通图都是一棵树。
给你一棵包含 n 个节点的树，标记为 0 到 n - 1 。给定数字 n 和一个有 n - 1 条无向边的 edges 列表（每一个边都是一对标签），
其中 edges[i] = [ai, bi] 表示树中节点 ai 和 bi 之间存在一条无向边。
可选择树中任何一个节点作为根。当选择节点 x 作为根节点时，设结果树的高度为 h 。在所有可能的树中，具有最小高度的树（即，min(h)）被称为 最小高度树 。
请你找到所有的 最小高度树 并按 任意顺序 返回它们的根节点标签列表。
树的 高度 是指根节点和叶子节点之间最长向下路径上边的数量。
提示：
1 <= n <= 2 * 10^4
edges.length == n - 1
0 <= ai, bi < n
ai != bi
所有 (ai, bi) 互不相同
给定的输入 保证 是一棵树，并且 不会有重复的边

拓扑排序 / 换根 DP。
每次去掉度为 1 的顶点。保留最内层。
相似题目: 834. 树中距离之和
https://leetcode.cn/problems/sum-of-distances-in-tree/
3241. 标记所有节点需要的时间
https://leetcode.cn/problems/time-taken-to-mark-all-nodes/description/
 */