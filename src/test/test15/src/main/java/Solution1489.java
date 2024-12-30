import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution1489 {
    static class V1 {
        public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
            int m = edges.length;

            // 按 weight 升序排序
            Integer[] ids = new Integer[m];
            for (int i = 0; i < m; i++) ids[i] = i;
            Arrays.sort(ids, Comparator.comparingInt(o -> edges[o][2]));

            // Kruskal 算法
            int value = 0;
            DSU dsu = new DSU(n);
            for (int id : ids) {
                int from = edges[id][0], to = edges[id][1], weight = edges[id][2];
                if (dsu.find(from) != dsu.find(to)) {
                    dsu.union(from, to);
                    value += weight;
                }
            }

            List<Integer> criticalEdges = new ArrayList<>(); // 关键边
            List<Integer> pseudoCriticalEdges = new ArrayList<>(); // 伪关键边
            for (int id1 : ids) {
                dsu = new DSU(n);
                int val = 0;
                for (int id2 : ids) {
                    if (id1 == id2) continue;
                    int from2 = edges[id2][0], to2 = edges[id2][1], weight2 = edges[id2][2];
                    if (dsu.find(from2) != dsu.find(to2)) {
                        dsu.union(from2, to2);
                        val += weight2;
                    }
                }
                if (dsu.sz != 1 || val > value) {
                    criticalEdges.add(id1);
                    continue;
                }

                int from1 = edges[id1][0], to1 = edges[id1][1], weight1 = edges[id1][2];
                dsu = new DSU(n);
                dsu.union(from1, to1);
                val = weight1;
                for (int id2 : ids) {
                    if (id1 == id2) continue;
                    int from2 = edges[id2][0], to2 = edges[id2][1], weight2 = edges[id2][2];
                    if (dsu.find(from2) != dsu.find(to2)) {
                        dsu.union(from2, to2);
                        val += weight2;
                    }
                }
                if (val == value) {
                    pseudoCriticalEdges.add(id1);
                }
            }
            return List.of(criticalEdges, pseudoCriticalEdges);
        }

        static class DSU {
            int[] fa;
            int sz;

            public DSU(int n) {
                fa = new int[n];
                for (int i = 0; i < n; i++) {
                    fa[i] = i;
                }
                sz = n;
            }

            int find(int x) {
                if (x != fa[x]) {
                    fa[x] = find(fa[x]);
                }
                return fa[x];
            }

            void union(int p, int q) {
                int rootP = find(p);
                int rootQ = find(q);
                if (rootP == rootQ) {
                    return;
                }
                fa[rootQ] = rootP;
                sz--;
            }
        }
    }

    static class V2 {
        public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
            int m = edges.length;

            // 按 weight 升序排序
            Integer[] ids = new Integer[m];
            for (int i = 0; i < m; i++) ids[i] = i;
            Arrays.sort(ids, Comparator.comparingInt(o -> edges[o][2]));

            List<Integer> criticalEdges = new ArrayList<>(); // 关键边
            List<Integer> pseudoCriticalEdges = new ArrayList<>(); // 伪关键边
            DSU dsu = new DSU(n);
            int[] label = new int[m];
            int i = 0;
            while (i < m) {
                // 分组循环
                int st = i;
                for (i++; i < m && edges[ids[i]][2] == edges[ids[st]][2]; i++) {
                }

                // 存储每个连通分量在图 G 中的编号
                Map<Integer, Integer> compToId = new HashMap<>();
                // 图 G 的节点数
                int gn = 0;
                for (int k = st; k < i; ++k) {
                    int x = dsu.find(edges[ids[k]][0]);
                    int y = dsu.find(edges[ids[k]][1]);
                    if (x != y) {
                        if (!compToId.containsKey(x)) {
                            compToId.put(x, gn++);
                        }
                        if (!compToId.containsKey(y)) {
                            compToId.put(y, gn++);
                        }
                    } else {
                        // 将自环边标记为 -1
                        label[ids[k]] = -1;
                    }
                }

                // 图 G 的边
                List<Integer>[] gm = new ArrayList[gn];
                List<Integer>[] gmid = new ArrayList[gn];
                for (int k = 0; k < gn; ++k) {
                    gm[k] = new ArrayList<>();
                    gmid[k] = new ArrayList<>();
                }
                for (int k = st; k < i; ++k) {
                    int x = dsu.find(edges[ids[k]][0]);
                    int y = dsu.find(edges[ids[k]][1]);
                    if (x != y) {
                        int idx = compToId.get(x), idy = compToId.get(y);
                        gm[idx].add(idy);
                        gmid[idx].add(ids[k]);
                        gm[idy].add(idx);
                        gmid[idy].add(ids[k]);
                    }
                }

                List<Integer> bridges = new TarjanSCC(gn, gm, gmid).getCuttingEdge();
                // 将桥边（关键边）标记为 1
                for (int id : bridges) {
                    criticalEdges.add(id);
                    label[id] = 1;
                }
                for (int k = st; k < i; ++k) {
                    dsu.union(edges[ids[k]][0], edges[ids[k]][1]);
                }
            }

            // 未标记的边即为非桥边（伪关键边）
            for (int j = 0; j < m; ++j) {
                if (label[j] == 0) {
                    pseudoCriticalEdges.add(j);
                }
            }
            return List.of(criticalEdges, pseudoCriticalEdges);
        }

        static class DSU {
            int[] fa;
            int sz;

            public DSU(int n) {
                fa = new int[n];
                for (int i = 0; i < n; i++) {
                    fa[i] = i;
                }
                sz = n;
            }

            int find(int x) {
                if (x != fa[x]) {
                    fa[x] = find(fa[x]);
                }
                return fa[x];
            }

            void union(int p, int q) {
                int rootP = find(p);
                int rootQ = find(q);
                if (rootP == rootQ) {
                    return;
                }
                fa[rootQ] = rootP;
                sz--;
            }
        }

        static class TarjanSCC {
            List<Integer>[] edges;
            List<Integer>[] edgesId;
            int[] low;
            int[] dfn;
            List<Integer> ans;
            int n;
            int ts;

            public TarjanSCC(int n, List<Integer>[] edges, List<Integer>[] edgesId) {
                this.edges = edges;
                this.edgesId = edgesId;
                this.low = new int[n];
                Arrays.fill(low, -1);
                this.dfn = new int[n];
                Arrays.fill(dfn, -1);
                this.n = n;
                this.ts = -1;
                this.ans = new ArrayList<>();
            }

            List<Integer> getCuttingEdge() {
                for (int i = 0; i < n; ++i) {
                    if (dfn[i] == -1) {
                        getCuttingEdge(i, -1);
                    }
                }
                return ans;
            }

            void getCuttingEdge(int u, int parentEdgeId) {
                low[u] = dfn[u] = ++ts;
                for (int i = 0; i < edges[u].size(); ++i) {
                    int v = edges[u].get(i);
                    int id = edgesId[u].get(i);
                    if (dfn[v] == -1) {
                        getCuttingEdge(v, id);
                        low[u] = Math.min(low[u], low[v]);
                        if (low[v] > dfn[u]) {
                            ans.add(id);
                        }
                    } else if (id != parentEdgeId) {
                        low[u] = Math.min(low[u], dfn[v]);
                    }
                }
            }
        }
    }
}
/*
1489. 找到最小生成树里的关键边和伪关键边
https://leetcode.cn/problems/find-critical-and-pseudo-critical-edges-in-minimum-spanning-tree/

给你一个 n 个点的带权无向连通图，节点编号为 0 到 n-1 ，同时还有一个数组 edges ，
其中 edges[i] = [fromi, toi, weighti] 表示在 fromi 和 toi 节点之间有一条带权无向边。最小生成树 (MST) 是给定图中边的一个子集，
它连接了所有节点且没有环，而且这些边的权值和最小。
请你找到给定图中最小生成树的所有关键边和伪关键边。如果从图中删去某条边，会导致最小生成树的权值和增加，那么我们就说它是一条关键边。
伪关键边则是可能会出现在某些最小生成树中但不会出现在所有最小生成树中的边。
请注意，你可以分别以任意顺序返回关键边的下标和伪关键边的下标。
提示：
2 <= n <= 100
1 <= edges.length <= min(200, n * (n - 1) / 2)
edges[i].length == 3
0 <= fromi < toi < n
1 <= weighti <= 1000
所有 (fromi, toi) 数对都是互不相同的。

最小生成树(MST)
Kruskal 算法 变种
时间复杂度 O(m^2 a(n))
另有 tarjan 解法。时间复杂度 O(mlogm)
相似题目: 1568. 使陆地分离的最少天数
https://leetcode.cn/problems/minimum-number-of-days-to-disconnect-island/description/
 */