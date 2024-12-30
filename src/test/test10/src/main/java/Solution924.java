import java.util.Arrays;

public class Solution924 {
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

        // dfs 找只包含一个被感染节点的最大连通块
        int ans = -1;
        int maxSize = 0;
        for (int x : initial) {
            if (vis[x]) continue;
            nodeId = -1;
            cntV = 0;
            dfs(x);
            if (nodeId < 0) continue;
            if (cntV > maxSize || cntV == maxSize && nodeId < ans) {
                maxSize = cntV;
                ans = nodeId;
            }
        }
        return ans >= 0 ? ans : Arrays.stream(initial).min().orElseThrow();
    }

    private void dfs(int x) {
        vis[x] = true;
        cntV++;
        if (isInitial[x]) {
            // 状态机：初始状态为 -1
            // 如果状态是 -1，在找到被感染的节点 x 后，状态变为 x
            // 如果状态是非负数 x，在找到另一个被感染的节点后，状态变为 -2
            // 如果状态已经是 -2，则不变
            if (nodeId == -1) nodeId = x;
            else if (nodeId >= 0) nodeId = -2;
        }
        for (int y = 0; y < n; y++) {
            if (graph[x][y] == 1 && !vis[y]) {
                dfs(y);
            }
        }
    }
}
/*
924. 尽量减少恶意软件的传播
https://leetcode.cn/problems/minimize-malware-spread/

给出了一个由 n 个节点组成的网络，用 n × n 个邻接矩阵图 graph 表示。在节点网络中，当 graph[i][j] = 1 时，表示节点 i 能够直接连接到另一个节点 j。
一些节点 initial 最初被恶意软件感染。只要两个节点直接连接，且其中至少一个节点受到恶意软件的感染，那么两个节点都将被恶意软件感染。
这种恶意软件的传播将继续，直到没有更多的节点可以被这种方式感染。
假设 M(initial) 是在恶意软件停止传播之后，整个网络中感染恶意软件的最终节点数。
如果从 initial 中移除某一节点能够最小化 M(initial)， 返回该节点。如果有多个节点满足条件，就返回索引最小的节点。
请注意，如果某个节点已从受感染节点的列表 initial 中删除，它以后仍有可能因恶意软件传播而受到感染。
提示：
n == graph.length
n == graph[i].length
2 <= n <= 300
graph[i][j] == 0 或 1.
graph[i][j] == graph[j][i]
graph[i][i] == 1
1 <= initial.length <= n
0 <= initial[i] <= n - 1
initial 中所有整数均不重复

并查集。
case1: 对于 initial 中颜色唯一的节点，找联通分量 size 最大的。
case2: 如果 initial 中的两个节点属于相同的联通分量，那么即使移除了也是不会减少 M(initial) 的，返回索引最小的节点即可。
注意 UnionFind 中 int[] size; 的处理
时间复杂度 O(n^2)
空间复杂度 O(n)
相似题目: 928. 尽量减少恶意软件的传播 II
https://leetcode.cn/problems/minimize-malware-spread-ii/
 */