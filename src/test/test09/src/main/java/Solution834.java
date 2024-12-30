import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution834 {
    List<Integer>[] g;
    private int[] sz, dp, ans;

    // https://leetcode.cn/problems/sum-of-distances-in-tree/solution/shu-zhong-ju-chi-zhi-he-by-leetcode-solution/
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        g = new ArrayList[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (int[] p : edges) {
            g[p[0]].add(p[1]);
            g[p[1]].add(p[0]);
        }
        // dp[x] 表示以 x 为根的子树，它的所有子节点到它的距离之和
        // sz[x] 表示以 x 为根的子树的节点数量
        sz = new int[n];
        dp = new int[n];
        ans = new int[n];

        dfs(0, -1);
        reroot(0, -1);
        return ans;
    }

    private void dfs(int x, int fa) {
        sz[x] = 1;
        dp[x] = 0;
        for (int y : g[x]) {
            if (y == fa) continue;
            dfs(y, x);
            dp[x] += dp[y] + sz[y];
            sz[x] += sz[y];
        }
    }

    private void reroot(int x, int fa) {
        ans[x] = dp[x];
        for (int y : g[x]) {
            if (y == fa) continue;
            // 让 v 换到根的位置，u 变为其孩子节点，同时维护原有的 dp 信息
            int dpx = dp[x], dpy = dp[y];
            int szx = sz[x], szy = sz[y];

            dp[x] -= dp[y] + sz[y];
            sz[x] -= sz[y];
            dp[y] += dp[x] + sz[x];
            sz[y] += sz[x];

            reroot(y, x);

            dp[x] = dpx;
            dp[y] = dpy;
            sz[x] = szx;
            sz[y] = szy;
        }
    }
}
/*
834. 树中距离之和
https://leetcode.cn/problems/sum-of-distances-in-tree/

给定一个无向、连通的树。树中有 n 个标记为 0...n-1 的节点以及 n-1 条边 。
给定整数 n 和数组 edges ， edges[i] = [ai, bi]表示树中的节点 ai 和 bi 之间有一条边。
返回长度为 n 的数组 answer ，其中 answer[i] 是树中第 i 个节点与所有其他节点之间的距离之和。
提示:
1 <= n <= 3 * 10^4
edges.length == n - 1
edges[i].length == 2
0 <= ai, bi < n
ai != bi
给定的输入保证为有效的树

换根 DP。
相似题目: 310. 最小高度树
https://leetcode.cn/problems/minimum-height-trees/
 */