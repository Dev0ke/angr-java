import java.util.Arrays;

public class Solution928 {
    private int[][] graph;
    private boolean[] isInitial, vis;
    private int n, nodeId, cntV;

    public int minMalwareSpread(int[][] graph, int[] initial) {
        this.graph = graph;
        this.n = graph.length;
        // 预处理，isInitial[i] = true 表示节点 i 在 initial 中
        isInitial = new boolean[n];
        for (int x : initial) {
            isInitial[x] = true;
        }
        vis = new boolean[n];

        // 逆向思维，从不在 initial 中的点 v 出发 dfs，在不经过 initial 中的点的情况下，看 v 只能被一个点感染，还是多个点感染
        int[] cnt = new int[n];
        for (int x = 0; x < n; x++) {
            if (vis[x] || isInitial[x]) continue;
            nodeId = -1;
            cntV = 0;
            dfs(x);
            if (nodeId < 0) continue;
            // 删除节点 nodeId 可以让 size 个点不被感染
            cnt[nodeId] += cntV;
        }

        int ans = -1;
        int maxSize = 0;
        for (int x = 0; x < n; x++) {
            if (maxSize < cnt[x]) {
                maxSize = cnt[x];
                ans = x;
            }
        }
        return ans >= 0 ? ans : Arrays.stream(initial).min().orElseThrow();
    }

    private void dfs(int x) {
        vis[x] = true;
        cntV++;
        for (int y = 0; y < n; y++) {
            if (graph[x][y] == 1) {
                if (isInitial[y]) {
                    // 注意避免重复统计，例如上图中的 0 有两条不同路径可以遇到 1
                    if (nodeId == y) continue;
                    // 同 924 的状态机
                    if (nodeId == -1) nodeId = y;
                    else if (nodeId >= 0) nodeId = -2;
                } else {
                    if (!vis[y]) {
                        dfs(y);
                    }
                }
            }
        }
    }
}
/*
928. 尽量减少恶意软件的传播 II
https://leetcode.cn/problems/minimize-malware-spread-ii/

给定一个由 n 个节点组成的网络，用 n x n 个邻接矩阵 graph 表示。在节点网络中，只有当 graph[i][j] = 1 时，节点 i 能够直接连接到另一个节点 j。
一些节点 initial 最初被恶意软件感染。只要两个节点直接连接，且其中至少一个节点受到恶意软件的感染，那么两个节点都将被恶意软件感染。
这种恶意软件的传播将继续，直到没有更多的节点可以被这种方式感染。
假设 M(initial) 是在恶意软件停止传播之后，整个网络中感染恶意软件的最终节点数。
我们可以从 initial 中删除一个节点，并完全移除该节点以及从该节点到任何其他节点的任何连接。
请返回移除后能够使 M(initial) 最小化的节点。如果有多个节点满足条件，返回索引 最小的节点 。
提示：
n == graph.length
n == graph[i].length
2 <= n <= 300
graph[i][j] 是 0 或 1.
graph[i][j] == graph[j][i]
graph[i][i] == 1
1 <= initial.length < n
0 <= initial[i] <= n - 1
 initial 中每个整数都不同

并查集。本题与 924 差异是 924 只是从 initial 中移除，本题则是从图中删除。
记 initial 的节点为 u，非 initial 的节点为 v
首先用 v 构建 graph，再检查这些 v 中哪些会被 u 感染
case1: 如果 v 只会被一个 u 感染，记录这个 u 对应的 v 数量。
case2: 如果 v 不只被一个 u 感染，那么即使移除了对应的 u 也是不会减少 M(initial) 的，返回索引最小的节点即可。
注意 UnionFind 中 int[] size; 的处理
时间复杂度 O(n^2)
空间复杂度 O(n)
相似题目: 924. 尽量减少恶意软件的传播
https://leetcode.cn/problems/minimize-malware-spread/
 */