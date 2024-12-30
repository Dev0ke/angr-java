import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution3241 {
    private List<Integer>[] g;
    private int[][] nodes;
    private int[] ans;

    public int[] timeTaken(int[][] edges) {
        int n = edges.length + 1;
        g = new ArrayList[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (int[] p : edges) {
            int x = p[0], y = p[1];
            g[x].add(y);
            g[y].add(x);
        }

        nodes = new int[n][3];
        dfs(0, -1);

        ans = new int[n];
        reroot(0, -1, 0);
        return ans;
    }

    private int dfs(int x, int fa) {
        int maxD = 0, maxD2 = 0, my = 0;
        for (int y : g[x]) {
            if (y == fa) continue;
            int add = y % 2 == 1 ? 1 : 2;
            int sub = dfs(y, x) + add;
            if (sub > maxD) {
                maxD2 = maxD;
                maxD = sub;
                my = y;
            } else if (sub > maxD2) {
                maxD2 = sub;
            }
        }
        nodes[x] = new int[]{maxD, maxD2, my};
        return maxD;
    }

    private void reroot(int x, int fa, int fromUp) {
        int maxD = nodes[x][0], maxD2 = nodes[x][1], my = nodes[x][2];
        ans[x] = Math.max(fromUp, maxD);
        for (int y : g[x]) {
            if (y == fa) continue;
            int add = x % 2 == 1 ? 1 : 2; // 反向边
            reroot(y, x, Math.max(fromUp, (y == my ? maxD2 : maxD)) + add);
        }
    }
}
/*
3241. 标记所有节点需要的时间
https://leetcode.cn/problems/time-taken-to-mark-all-nodes/description/

第 136 场双周赛 T4。

给你一棵 无向 树，树中节点从 0 到 n - 1 编号。同时给你一个长度为 n - 1 的二维整数数组 edges ，其中 edges[i] = [ui, vi] 表示节点 ui 和 vi 在树中有一条边。
一开始，所有 节点都 未标记 。对于节点 i ：
- 当 i 是奇数时，如果时刻 x - 1 该节点有 至少 一个相邻节点已经被标记了，那么节点 i 会在时刻 x 被标记。
- 当 i 是偶数时，如果时刻 x - 2 该节点有 至少 一个相邻节点已经被标记了，那么节点 i 会在时刻 x 被标记。
请你返回一个数组 times ，表示如果你在时刻 t = 0 标记节点 i ，那么时刻 times[i] 时，树中所有节点都会被标记。
请注意，每个 times[i] 的答案都是独立的，即当你标记节点 i 时，所有其他节点都未标记。
提示：
2 <= n <= 10^5
edges.length == n - 1
edges[i].length == 2
0 <= edges[i][0], edges[i][1] <= n - 1
输入保证 edges 表示一棵合法的树。

换根 DP。
时间复杂度 O(n)。
rating 2523 (clist.by)
相似题目: 310. 最小高度树
https://leetcode.cn/problems/minimum-height-trees/
 */