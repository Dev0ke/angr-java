import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution2242 {
    public int maximumScore(int[] scores, int[][] edges) {
        Map<Integer, List<int[]>> adj = new HashMap<>();
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.computeIfAbsent(u, key -> new ArrayList<>()).add(new int[]{v, scores[v]});
            adj.computeIfAbsent(v, key -> new ArrayList<>()).add(new int[]{u, scores[u]});
        }
        // 剪枝
        for (Map.Entry<Integer, List<int[]>> entry : adj.entrySet()) {
            if (entry.getValue().size() > 3) {
                List<int[]> list = entry.getValue();
                list.sort((o1, o2) -> Integer.compare(o2[1], o1[1]));
                adj.put(entry.getKey(), list.subList(0, 3));
            }
        }

        // 枚举中间边
        int maxSum = -1;
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            for (int[] uNext : adj.get(u)) {
                if (uNext[0] != v) {
                    for (int[] vNext : adj.get(v)) {
                        if (vNext[0] != u && vNext[0] != uNext[0]) {
                            maxSum = Math.max(maxSum, scores[u] + scores[v] + uNext[1] + vNext[1]);
                        }
                    }
                }
            }
        }
        return maxSum;
    }
}
/*
2242. 节点序列的最大得分
https://leetcode.cn/problems/maximum-score-of-a-node-sequence/

第 76 场双周赛 T4。

给你一个 n 个节点的 无向图 ，节点编号为 0 到 n - 1 。
给你一个下标从 0 开始的整数数组 scores ，其中 scores[i] 是第 i 个节点的分数。同时给你一个二维整数数组 edges ，
其中 edges[i] = [ai, bi] ，表示节点 ai 和 bi 之间有一条 无向 边。
一个合法的节点序列如果满足以下条件，我们称它是 合法的 ：
- 序列中每 相邻 节点之间有边相连。
- 序列中没有节点出现超过一次。
节点序列的分数定义为序列中节点分数之 和 。
请你返回一个长度为 4 的合法节点序列的最大分数。如果不存在这样的序列，请你返回 -1 。
提示：
n == scores.length
4 <= n <= 5 * 10^4
1 <= scores[i] <= 10^8
0 <= edges.length <= 5 * 10^4
edges[i].length == 2
0 <= ai, bi <= n - 1
ai != bi
不会有重边。

枚举中间边依然会超时，要在此基础上进行剪枝，只需保留前三大的边。
 */