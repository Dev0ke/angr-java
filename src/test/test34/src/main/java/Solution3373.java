import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution3373 {
    public int[] maxTargetNodes(int[][] edges1, int[][] edges2) {
        int n = edges1.length + 1;
        int m = edges2.length + 1;
        List<Integer>[] g1 = buildTree(n, edges1);
        List<Integer>[] g2 = buildTree(m, edges2);

        int[] cnt1 = new int[2];
        dfs(0, -1, 1, g1, cnt1);
        int[] cnt2 = new int[2];
        dfs(0, -1, 0, g2, cnt2);

        int max2 = Math.max(cnt2[0], cnt2[1]);
        int[] ans = new int[n];
        Arrays.fill(ans, max2);
        dfs2(0, -1, 0, g1, cnt1, ans);
        return ans;
    }

    private List<Integer>[] buildTree(int n, int[][] edges) {
        List<Integer>[] g = new ArrayList[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (int[] p : edges) {
            g[p[0]].add(p[1]);
            g[p[1]].add(p[0]);
        }
        return g;
    }

    private void dfs(int x, int fa, int d, List<Integer>[] g, int[] cnt) {
        int odd = d % 2;
        cnt[odd] += 1;
        for (Integer y : g[x]) {
            if (y == fa) continue;
            dfs(y, x, d + 1, g, cnt);
        }
    }

    private void dfs2(int x, int fa, int d, List<Integer>[] g, int[] cnt, int[] ans) {
        int odd = d % 2;
        ans[x] += cnt[odd ^ 1];
        for (Integer y : g[x]) {
            if (y == fa) continue;
            dfs2(y, x, d + 1, g, cnt, ans);
        }
    }
}
/*
3373. 连接两棵树后最大目标节点数目 II
https://leetcode.cn/problems/maximize-the-number-of-target-nodes-after-connecting-trees-ii/description/

第 426 场周赛 T4。

有两棵 无向 树，分别有 n 和 m 个树节点。两棵树中的节点编号分别为[0, n - 1] 和 [0, m - 1] 中的整数。
给你两个二维整数 edges1 和 edges2 ，长度分别为 n - 1 和 m - 1 ，其中 edges1[i] = [ai, bi] 表示第一棵树中节点 ai 和 bi 之间有一条边，edges2[i] = [ui, vi] 表示第二棵树中节点 ui 和 vi 之间有一条边。
如果节点 u 和节点 v 之间路径的边数是偶数，那么我们称节点 u 是节点 v 的 目标节点 。注意 ，一个节点一定是它自己的 目标节点 。
请你返回一个长度为 n 的整数数组 answer ，answer[i] 表示将第一棵树中的一个节点与第二棵树中的一个节点连接一条边后，第一棵树中节点 i 的 目标节点 数目的 最大值 。
注意 ，每个查询相互独立。意味着进行下一次查询之前，你需要先把刚添加的边给删掉。
提示：
2 <= n, m <= 10^5
edges1.length == n - 1
edges2.length == m - 1
edges1[i].length == edges2[i].length == 2
edges1[i] = [ai, bi]
0 <= ai, bi < n
edges2[i] = [ui, vi]
0 <= ui, vi < m
输入保证 edges1 和 edges2 都表示合法的树。

非换根 DP。利用奇偶的特殊性。
时间复杂度 O(n+m)。
 */