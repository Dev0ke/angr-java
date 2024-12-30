import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SolutionP3004 {
    private List<Integer>[] g;
    private int[] colors;
    private int ans;

    public int maximumSubtreeSize(int[][] edges, int[] colors) {
        int n = colors.length;
        this.colors = colors;
        g = new ArrayList[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (int[] p : edges) {
            g[p[0]].add(p[1]);
            g[p[1]].add(p[0]);
        }

        ans = 0;
        dfs(0, -1);
        return ans;
    }

    private int dfs(int x, int fa) {
        int xSize = 1;
        boolean same = true;
        for (Integer y : g[x]) {
            if (y == fa) continue;
            int ySize = dfs(y, x);
            if (ySize == -1 || colors[x] != colors[y]) {
                same = false;
            } else {
                xSize += ySize;
            }
        }
        if (!same) return -1;
        ans = Math.max(ans, xSize);
        return xSize;
    }
}
/*
$3004. 相同颜色的最大子树
https://leetcode.cn/problems/maximum-subtree-of-the-same-color/description/

给定一个二维整数数组 edges，表示一个有 n 个节点的树，节点编号从 0 到 n - 1，以节点 0 为根，其中 edges[i] = [ui, vi] 表示节点 vi 和 ui 之间存在一条边。
还给定一个 下标从 0 开始，大小为 n 的整数数组 colors，其中 colors[i] 表示节点 i 分配的颜色。
我们希望找到一个节点 v，使得 v 的子树中的每个节点具有 相同 的颜色。
返回 具有 尽可能多 节点 且 符合上述要求的 子树 大小。
提示：
n == edges.length + 1
1 <= n <= 5 * 10^4
edges[i] == [ui, vi]
0 <= ui, vi < n
colors.length == n
1 <= colors[i] <= 10^5
输入被生成，使得由 edges 表示的图是一棵树。

树形 DP。
时间复杂度 O(n)。
 */