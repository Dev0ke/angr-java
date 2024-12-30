import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution2925 {
    private List<Integer>[] g;
    private int[] values;

    public long maximumScoreAfterOperations(int[][] edges, int[] values) {
        int n = edges.length + 1;
        g = new ArrayList[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (int[] p : edges) {
            g[p[0]].add(p[1]);
            g[p[1]].add(p[0]);
        }
        this.values = values;

        long tot = 0;
        for (int v : values) {
            tot += v;
        }
        return tot - dfs(0, -1);
    }

    // dfs(x) 表示以 x 为根的子树是健康时，失去的最小分数
    private long dfs(int x, int fa) {
        // 父节点没选，x 是叶子，必选
        if (x != 0 && g[x].size() == 1) return values[x];
        // 父节点不选，递归子树
        long loss = 0;
        for (Integer y : g[x]) {
            if (y != fa) {
                loss += dfs(y, x);
            }
        }
        // 父节点选
        return Math.min(loss, values[x]);
    }
}
/*
2925. 在树上执行操作以后得到的最大分数
https://leetcode.cn/problems/maximum-score-after-applying-operations-on-a-tree/description/

第 370 场周赛 T3。

有一棵 n 个节点的无向树，节点编号为 0 到 n - 1 ，根节点编号为 0 。给你一个长度为 n - 1 的二维整数数组 edges 表示这棵树，其中 edges[i] = [ai, bi] 表示树中节点 ai 和 bi 有一条边。
同时给你一个长度为 n 下标从 0 开始的整数数组 values ，其中 values[i] 表示第 i 个节点的值。
一开始你的分数为 0 ，每次操作中，你将执行：
- 选择节点 i 。
- 将 values[i] 加入你的分数。
- 将 values[i] 变为 0 。
如果从根节点出发，到任意叶子节点经过的路径上的节点值之和都不等于 0 ，那么我们称这棵树是 健康的 。
你可以对这棵树执行任意次操作，但要求执行完所有操作以后树是 健康的 ，请你返回你可以获得的 最大分数 。
提示：
2 <= n <= 2 * 10^4
edges.length == n - 1
edges[i].length == 2
0 <= ai, bi < n
values.length == n
1 <= values[i] <= 10^9
输入保证 edges 构成一棵合法的树。

树形 DP。选 或 不选
正难则反。总和减去最小 "不选" 的
时间复杂度 O(n)
 */