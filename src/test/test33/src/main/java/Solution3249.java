import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution3249 {
    List<Integer>[] g;
    int[] sz, fx;

    public int countGoodNodes(int[][] edges) {
        int n = edges.length + 1;
        g = new ArrayList[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (int[] p : edges) {
            g[p[0]].add(p[1]);
            g[p[1]].add(p[0]);
        }
        // sz[x] 表示以 x 为根的子树的节点数量
        sz = new int[n];
        fx = new int[n];
        dfs(0, -1);

        int ans = 0;
        for (int i = 0; i < n; i++) {
            boolean flag = false;
            int all = -1;
            for (Integer v : g[i]) {
                if (v == fx[i]) continue;
                if (all == -1 || all == sz[v]) {
                    all = sz[v];
                } else {
                    flag = true;
                }
            }
            if (!flag) {
                ans++;
            }
        }
        return ans;
    }

    private void dfs(int x, int fa) {
        sz[x] = 1;
        fx[x] = fa;
        for (int y : g[x]) {
            if (y == fa) continue;
            dfs(y, x);
            sz[x] += sz[y];
        }
    }
}
/*
3249. 统计好节点的数目
https://leetcode.cn/problems/count-the-number-of-good-nodes/description/

第 410 场周赛 T2。

现有一棵 无向 树，树中包含 n 个节点，按从 0 到 n - 1 标记。树的根节点是节点 0 。给你一个长度为 n - 1 的二维整数数组 edges，其中 edges[i] = [ai, bi] 表示树中节点 ai 与节点 bi 之间存在一条边。
如果一个节点的所有子节点为根的 子树 包含的节点数相同，则认为该节点是一个 好节点。
返回给定树中 好节点 的数量。
子树 指的是一个节点以及它所有后代节点构成的一棵树。
提示：
2 <= n <= 10^5
edges.length == n - 1
edges[i].length == 2
0 <= ai, bi < n
输入确保 edges 总表示一棵有效的树。

DFS 计算子树大小。
时间复杂度 O(n)。
相似题目: 834. 树中距离之和
https://leetcode.cn/problems/sum-of-distances-in-tree/
 */