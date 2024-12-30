import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Queue;

public class Solution802 {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int[] inDeg = new int[n];
        List<Integer>[] rg = new ArrayList[n];
        Arrays.setAll(rg, e -> new ArrayList<>());
        for (int i = 0; i < n; i++) {
            for (int j : graph[i]) {
                rg[j].add(i);
                inDeg[i]++;
            }
        }

        Queue<Integer> q = new ArrayDeque<>();
        for (int x = 0; x < n; x++) {
            if (inDeg[x] == 0) {
                q.add(x);
            }
        }
        List<Integer> ans = new ArrayList<>();
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int x = q.remove();
                ans.add(x);
                for (int y : rg[x]) {
                    if (--inDeg[y] == 0) {
                        q.add(y);
                    }
                }
            }
        }
        Collections.sort(ans);
        return ans;
    }
}
/*
802. 找到最终的安全状态
https://leetcode.cn/problems/find-eventual-safe-states/

在有向图中，以某个节点为起始节点，从该点出发，每一步沿着图中的一条有向边行走。如果到达的节点是终点（即它没有连出的有向边），则停止。
对于一个起始节点，如果从该节点出发，无论每一步选择沿哪条有向边行走，最后必然在有限步内到达终点，则将该起始节点称作是 安全 的。
返回一个由图中所有安全的起始节点组成的数组作为答案。答案数组中的元素应当按 升序 排列。
该有向图有 n 个节点，按 0 到 n - 1 编号，其中 n 是 graph 的节点数。图以下述形式给出：graph[i] 是编号 j 节点的一个列表，满足 (i, j) 是图的一条有向边。
提示：
n == graph.length
1 <= n <= 10^4
0 <= graph[i].length <= n
graph[i] 按严格递增顺序排列。
图中可能包含自环。
图中边的数目在范围 [1, 4 * 10^4] 内。

拓扑排序。
显然出度为 0 的点是安全的，每次入队出度为 0 的点。
 */