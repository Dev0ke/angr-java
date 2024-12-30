import java.util.Arrays;

public class Solution2359 {
    private static final int INF = 100000;

    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;

        int[] dist1 = getDist(edges, node1);
        int[] dist2 = getDist(edges, node2);

        int min = INF;
        // 返回 最小 的节点编号。如果答案不存在，返回 -1 。
        int res = -1;
        for (int i = 0; i < n; i++) {
            int max = Math.max(dist1[i], dist2[i]);
            if (min > max) {
                min = max;
                res = i;
            }
        }
        return res;
    }

    private int[] getDist(int[] edges, int node) {
        int n = edges.length;
        int[] dist = new int[n];
        Arrays.fill(dist, INF);

        int step = 0;
        for (int x = node; x != -1 && dist[x] == INF; x = edges[x]) {
            dist[x] = step;
            step++;
        }
        return dist;
    }
}
/*
2359. 找到离给定两个节点最近的节点
https://leetcode.cn/problems/find-closest-node-to-given-two-nodes/

第 304 场周赛 T3。

给你一个 n 个节点的 有向图 ，节点编号为 0 到 n - 1 ，每个节点 至多 有一条出边。
有向图用大小为 n 下标从 0 开始的数组 edges 表示，表示节点 i 有一条有向边指向 edges[i] 。如果节点 i 没有出边，那么 edges[i] == -1 。
同时给你两个节点 node1 和 node2 。
请你返回一个从 node1 和 node2 都能到达节点的编号，使节点 node1 和节点 node2 到这个节点的距离 较大值最小化。如果有多个答案，请返回 最小 的节点编号。如果答案不存在，返回 -1 。
注意 edges 可能包含环。
提示：
n == edges.length
2 <= n <= 10^5
-1 <= edges[i] < n
edges[i] != i
0 <= node1, node2 < n

内向基环树
分别计算从 node1、node2 出发到各点的距离。再遍历得出结果。
时间复杂度 O(n)
比赛时候当成普通图跑 dijkstra 计算出距离，也能 AC。
 */