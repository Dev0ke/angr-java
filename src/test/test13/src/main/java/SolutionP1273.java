import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SolutionP1273 {
    private Map<Integer, List<Integer>> adj;
    private int[] value;

    public int deleteTreeNodes(int nodes, int[] parent, int[] value) {
        // 建图
        adj = new HashMap<>();
        for (int i = 0; i < nodes; i++) {
            if (parent[i] != -1) {
                int u = parent[i];
                int v = i;
                adj.computeIfAbsent(u, key -> new ArrayList<>()).add(v);
            }
        }
        this.value = value;

        int[] cnt = new int[nodes];
        Arrays.fill(cnt, 1);
        dfs(0, cnt);
        return cnt[0];
    }

    private void dfs(int u, int[] cnt) {
        // u->v
        for (int v : adj.getOrDefault(u, new ArrayList<>())) {
            dfs(v, cnt);
            value[u] += value[v];
            cnt[u] += cnt[v];
        }
        // 请你删除节点值之和为 0 的每一棵子树。
        if (value[u] == 0) {
            cnt[u] = 0;
        }
    }
}
/*
$1273. 删除树节点
https://leetcode.cn/problems/delete-tree-nodes/

给你一棵以节点 0 为根节点的树，定义如下：
- 节点的总数为 nodes 个；
- 第 i 个节点的值为 value[i] ；
- 第 i 个节点的父节点是 parent[i] 。
请你删除节点值之和为 0 的每一棵子树。
在完成所有删除之后，返回树中剩余节点的数目。
提示：
1 <= nodes <= 10^4
parent.length == nodes
0 <= parent[i] <= nodes - 1
parent[0] == -1 表示节点 0 是树的根。
value.length == nodes
-10^5 <= value[i] <= 10^5
题目输入数据 保证 是一棵 有效的树 。

dfs
 */