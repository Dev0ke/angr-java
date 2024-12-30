import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution1519 {
    private String labels;
    private Map<Integer, List<Integer>> adj;
    private int[] ans;

    public int[] countSubTrees(int n, int[][] edges, String labels) {
        this.labels = labels;
        adj = new HashMap<>();
        for (int[] edge : edges) {
            adj.computeIfAbsent(edge[0], key -> new ArrayList<>()).add(edge[1]);
            adj.computeIfAbsent(edge[1], key -> new ArrayList<>()).add(edge[0]);
        }
        ans = new int[n];
        dfs(0, -1);
        return ans;
    }

    private int[] dfs(int x, int fa) {
        int[] cntX = new int[26];
        cntX[labels.charAt(x) - 'a']++;
        for (int y : adj.getOrDefault(x, new ArrayList<>())) {
            if (y == fa) continue;
            int[] cntY = dfs(y, x);
            for (int i = 0; i < 26; i++) {
                cntX[i] += cntY[i];
            }
        }
        ans[x] = cntX[labels.charAt(x) - 'a'];
        return cntX;
    }
}
/*
1519. 子树中标签相同的节点数
https://leetcode.cn/problems/number-of-nodes-in-the-sub-tree-with-the-same-label/

给你一棵树（即，一个连通的无环无向图），这棵树由编号从 0  到 n - 1 的 n 个节点组成，且恰好有 n - 1 条 edges 。
树的根节点为节点 0 ，树上的每一个节点都有一个标签，也就是字符串 labels 中的一个小写字符（编号为 i 的 节点的标签就是 labels[i] ）
边数组 edges 以 edges[i] = [ai, bi] 的形式给出，该格式表示节点 ai 和 bi 之间存在一条边。
返回一个大小为 n 的数组，其中 ans[i] 表示第 i 个节点的子树中与节点 i 标签相同的节点数。
树 T 中的子树是由 T 中的某个节点及其所有后代节点组成的树。
提示：
1 <= n <= 10^5
edges.length == n - 1
edges[i].length == 2
0 <= ai, bi < n
ai != bi
labels.length == n
labels 仅由小写英文字母组成

树形 DP
时间复杂度 O(n)
 */