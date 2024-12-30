import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution3367 {
    private List<int[]>[] g; // to, wt
    private int k;

    public long maximizeSumOfWeights(int[][] edges, int k) {
        this.k = k;
        int n = edges.length + 1;
        g = new ArrayList[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (int[] p : edges) {
            int u = p[0], v = p[1], wt = p[2];
            g[u].add(new int[]{v, wt});
            g[v].add(new int[]{u, wt});
        }
        return dfs(0, -1)[0]; // notChoose >= choose
    }

    private long[] dfs(int x, int fa) {
        long notSelect = 0;
        List<Long> inc = new ArrayList<>();
        for (int[] e : g[x]) {
            int y = e[0], wt = e[1];
            if (y == fa) continue;
            long[] subY = dfs(y, x);
            notSelect += subY[0]; // 先都不选
            long d = subY[1] + wt - subY[0];
            if (d > 0) {
                inc.add(d);
            }
        }

        // 再选增量最大的 k 个或者 k-1 个
        inc.sort(Collections.reverseOrder());
        for (int i = 0; i < Math.min(inc.size(), k - 1); i++) {
            notSelect += inc.get(i);
        }
        long select = notSelect;
        if (inc.size() >= k) {
            notSelect += inc.get(k - 1);
        }
        return new long[]{notSelect, select};
    }
}
/*
3367. 移除边之后的权重最大和
https://leetcode.cn/problems/maximize-sum-of-weights-after-edge-removals/description/

第 425 场周赛 T4。

存在一棵具有 n 个节点的无向树，节点编号为 0 到 n - 1。给你一个长度为 n - 1 的二维整数数组 edges，其中 edges[i] = [ui, vi, wi] 表示在树中节点 ui 和 vi 之间有一条权重为 wi 的边。
你的任务是移除零条或多条边，使得：
- 每个节点与至多 k 个其他节点有边直接相连，其中 k 是给定的输入。
- 剩余边的权重之和 最大化 。
返回在进行必要的移除后，剩余边的权重的 最大 可能和。
提示：
2 <= n <= 10^5
1 <= k <= n - 1
edges.length == n - 1
edges[i].length == 3
0 <= edges[i][0] <= n - 1
0 <= edges[i][1] <= n - 1
1 <= edges[i][2] <= 10^6
输入保证 edges 形成一棵有效的树。

树形 DP + 贪心。
如果这棵树是一条链，就是 198. 打家劫舍。因此贪心是错的，只能 DP。
相似题目: 2611. 老鼠和奶酪
https://leetcode.cn/problems/mice-and-cheese/
rating 2626 (clist.by)
 */