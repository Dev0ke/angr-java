import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SolutionP2378 {
    private List<int[]>[] g;
    private long[][] subRes;

    public long maxScore(int[][] edges) {
        int n = edges.length; // 节点个数
        if (n == 2) {
            return Math.max(0, edges[0][1]);
        }
        // 生成树
        g = new ArrayList[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (int i = 1; i < n; i++) {
            int par = edges[i][0], wt = edges[i][1];
            g[par].add(new int[]{i, wt});
        }
        subRes = new long[n][2];
        long[] res = dfs(0);
        return Math.max(res[0], res[1]);
    }

    // [0] 返回不选所有子树边的最大和
    // [1] 返回选择其中一条子树边的最大和 注意有负数权重边
    private long[] dfs(int x) {
        long noSubSum = 0, subSum = 0;
        // 先计算不选所有的
        for (int[] p : g[x]) {
            int y = p[0];
            subRes[y] = dfs(y);
            noSubSum += Math.max(0, Math.max(subRes[y][0], subRes[y][1]));
        }
        // 再计算只选一条的
        for (int[] p : g[x]) {
            int y = p[0];
            int curSubValue = p[1];
            if (curSubValue < 0) continue;
            long noCurSub = noSubSum - Math.max(subRes[y][0], subRes[y][1]) + subRes[y][0] + curSubValue;
            subSum = Math.max(subSum, noCurSub);
        }
        return new long[]{noSubSum, subSum};
    }
}
/*
$2378. 选择边来最大化树的得分
https://leetcode.cn/problems/choose-edges-to-maximize-score-in-a-tree/description/

给定一个 加权 树，由 n 个节点组成，从 0 到 n - 1。
该树以节点 0 为 根，用大小为 n 的二维数组 edges 表示，其中 edges[i] = [pari, weighti] 表示节点 pari 是节点 i 的 父 节点，它们之间的边的权重等于 weighti。因为根结点 没有 父结点，所以有 edges[0] = [-1, -1]。
从树中选择一些边，使所选的两条边都不 相邻，所选边的权值之 和 最大。
返回所选边的 最大 和。
注意:
- 你可以 不选择 树中的任何边，在这种情况下权值和将为 0。
- 如果树中的两条边 Edge1 和 Edge2 有一个 公共 节点，它们就是 相邻 的。
  - 换句话说，如果 Edge1连接节点 a 和 b, Edge2 连接节点 b 和 c，它们是相邻的。
提示:
n == edges.length
1 <= n <= 10^5
edges[i].length == 2
par0 == weight0 == -1
i >= 1 时 0 <= pari <= n - 1 。
pari != i
i >= 1 时 -10^6 <= weighti <= 10^6 。
edges 表示有效的树。

相似题目: 337. 打家劫舍 III
https://leetcode.cn/problems/house-robber-iii/
 */