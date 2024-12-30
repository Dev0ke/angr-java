import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SolutionP1245 {
    private List<Integer>[] g;
    private int ans;

    public int treeDiameter(int[][] edges) {
        int n = edges.length + 1;
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
        int maxLen = 0;
        for (int y : g[x]) {
            if (y == fa) continue;
            int len = dfs(y, x);
            ans = Math.max(ans, maxLen + len);
            maxLen = Math.max(maxLen, len);
        }
        return maxLen + 1;
    }
}
/*
$1245. 树的直径
https://leetcode.cn/problems/tree-diameter/

给你这棵「无向树」，请你测算并返回它的「直径」：这棵树上最长简单路径的 边数。
我们用一个由所有「边」组成的数组 edges 来表示一棵无向树，其中 edges[i] = [u, v] 表示节点 u 和 v 之间的双向边。
树上的节点都已经用 {0, 1, ..., edges.length} 中的数做了标记，每个节点上的标记都是独一无二的。
提示：
0 <= edges.length < 10^4
edges[i][0] != edges[i][1]
0 <= edges[i][j] <= edges.length
edges 会形成一棵无向树

树形 DP
相似题目: 543. 二叉树的直径
https://leetcode.cn/problems/diameter-of-binary-tree/
2246. 相邻字符不同的最长路径
https://leetcode.cn/problems/longest-path-with-different-adjacent-characters/
 */