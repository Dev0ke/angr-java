import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution2867 {
    private static final int MAX_N = (int) 1e5;
    private boolean[] np;
    private List<Integer>[] g;
    private List<Integer> nodes;

    public long countPaths(int n, int[][] edges) {
        if (np == null) {
            np = new boolean[MAX_N + 1];
            np[1] = true;
            for (int i = 2; i * i <= MAX_N; i++) {
                if (!np[i]) {
                    for (int j = i * i; j <= MAX_N; j += i) {
                        np[j] = true;
                    }
                }
            }
        }

        g = new ArrayList[n + 1];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (int[] e : edges) {
            g[e[0]].add(e[1]);
            g[e[1]].add(e[0]);
        }

        int[] size = new int[n + 1];
        long ans = 0;
        for (int x = 1; x <= n; x++) {
            // 跳过非质数
            if (np[x]) continue;
            int sum = 0;
            for (Integer y : g[x]) {
                // 非质数
                if (!np[y]) continue;
                if (size[y] == 0) {
                    nodes = new ArrayList<>();
                    dfs(y, -1);
                    for (Integer z : nodes) {
                        size[z] = nodes.size();
                    }
                }
                ans += (long) size[y] * sum;
                sum += size[y];
            }
            ans += sum;
        }
        return ans;
    }

    private void dfs(int x, int fa) {
        nodes.add(x);
        for (Integer y : g[x]) {
            if (y != fa && np[y]) {
                dfs(y, x);
            }
        }
    }
}
/*
2867. 统计树中的合法路径数目
https://leetcode.cn/problems/count-valid-paths-in-a-tree/

第 364 场周赛 T4。

给你一棵 n 个节点的无向树，节点编号为 1 到 n 。给你一个整数 n 和一个长度为 n - 1 的二维整数数组 edges ，其中 edges[i] = [ui, vi] 表示节点 ui 和 vi 在树中有一条边。
请你返回树中的 合法路径数目 。
如果在节点 a 到节点 b 之间 恰好有一个 节点的编号是质数，那么我们称路径 (a, b) 是 合法的 。
注意：
- 路径 (a, b) 指的是一条从节点 a 开始到节点 b 结束的一个节点序列，序列中的节点 互不相同 ，且相邻节点之间在树上有一条边。
- 路径 (a, b) 和路径 (b, a) 视为 同一条 路径，且只计入答案 一次 。
提示：
1 <= n <= 10^5
edges.length == n - 1
edges[i].length == 2
1 <= ui, vi <= n
输入保证 edges 形成一棵合法的树。

树形 DP
先预处理 非质数，从每个质数开始，乘法原理求方案数。
 */