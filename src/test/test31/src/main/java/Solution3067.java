import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution3067 {
    private List<int[]>[] g;
    private int signalSpeed, cnt;

    public int[] countPairsOfConnectableServers(int[][] edges, int signalSpeed) {
        int n = edges.length + 1;
        g = new ArrayList[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (int[] p : edges) {
            int x = p[0], y = p[1], wt = p[2];
            g[x].add(new int[]{y, wt});
            g[y].add(new int[]{x, wt});
        }
        this.signalSpeed = signalSpeed;

        int[] ans = new int[n];
        for (int x = 0; x < n; x++) {
            int acc = 0;
            // 从一条边开始算
            for (int[] p : g[x]) {
                cnt = 0;
                int y = p[0], wt = p[1];
                dfs(y, x, wt);
                ans[x] += cnt * acc;
                acc += cnt;
            }
        }
        return ans;
    }

    // d:路径和
    private void dfs(int x, int fa, int d) {
        if (fa != -1 && d % signalSpeed == 0) {
            cnt++;
        }

        for (int[] p : g[x]) {
            int y = p[0], wt = p[1];
            if (y != fa) {
                dfs(y, x, d + wt);
            }
        }
    }
}
/*
3067. 在带权树网络中统计可连接服务器对数目
https://leetcode.cn/problems/count-pairs-of-connectable-servers-in-a-weighted-tree-network/description/

第 125 场双周赛 T3。

给你一棵无根带权树，树中总共有 n 个节点，分别表示 n 个服务器，服务器从 0 到 n - 1 编号。同时给你一个数组 edges ，其中 edges[i] = [ai, bi, weighti] 表示节点 ai 和 bi 之间有一条双向边，边的权值为 weighti 。再给你一个整数 signalSpeed 。
如果两个服务器 a ，b 和 c 满足以下条件，那么我们称服务器 a 和 b 是通过服务器 c 可连接的 ：
- a < b ，a != c 且 b != c 。
- 从 c 到 a 的距离是可以被 signalSpeed 整除的。
- 从 c 到 b 的距离是可以被 signalSpeed 整除的。
- 从 c 到 b 的路径与从 c 到 a 的路径没有任何公共边。
请你返回一个长度为 n 的整数数组 count ，其中 count[i] 表示通过服务器 i 可连接 的服务器对的 数目 。
提示：
2 <= n <= 1000
edges.length == n - 1
edges[i].length == 3
0 <= ai, bi < n
edges[i] = [ai, bi, weighti]
1 <= weighti <= 10^6
1 <= signalSpeed <= 10^6
输入保证 edges 构成一棵合法的树。

枚举边 DFS。即符合 从 c 到 b 的路径与从 c 到 a 的路径没有任何公共边 这一条件。
时间复杂度 O(n^2)
 */