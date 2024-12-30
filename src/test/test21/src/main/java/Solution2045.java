import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Solution2045 {
    public int secondMinimum(int n, int[][] edges, int time, int change) {
        // 预处理 无向图
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            List<Integer> uvList = graph.getOrDefault(edge[0], new ArrayList<>());
            uvList.add(edge[1]);
            graph.put(edge[0], uvList);

            List<Integer> vuList = graph.getOrDefault(edge[1], new ArrayList<>());
            vuList.add(edge[0]);
            graph.put(edge[1], vuList);
        }
        // 距离矩阵
        int[] distances = new int[n + 1];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[1] = 0;
        // 是否已经访问过（针对第二次访问）
        boolean[] second = new boolean[n + 1];
        // BFS
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        while (!queue.isEmpty()) {
            int cur = queue.remove();
            List<Integer> neighbours = graph.get(cur);
            for (int neighbour : neighbours) {
                if (distances[neighbour] > distances[cur] + 1) {
                    distances[neighbour] = distances[cur] + 1;
                    queue.add(neighbour);
                }
                // 1-3, 1-4, 3-4 [3->4] [4->3]
                else if (distances[neighbour] == distances[cur]
                        // 存在递推关系，若 second[3] = true, second[4] = true,
                        // 4-5 [4->5] second[5] = true,
                        || (second[cur] && distances[neighbour] == distances[cur] + 1)) {
                    if (!second[neighbour]) {
                        queue.add(neighbour);
                        second[neighbour] = true;
                    }
                }
            }
        }
        // 第二短时间 路径长度
        int secondPathLen;
        if (second[n]) {
            secondPathLen = distances[n] + 1;
        } else {
            secondPathLen = distances[n] + 2;
        }
        // 距离转时间
        return pathLen2Time(secondPathLen, time, change);
    }

    private int pathLen2Time(int pathLen, int time, int change) {
        int cnt = 0;
        for (int i = 0; i < pathLen; i++) {
            cnt = nextGreen(cnt, change);
            cnt += time;
        }
        return cnt;
    }

    // 根据当前时间计算下一次绿灯时间
    private int nextGreen(int curTime, int change) {
        int change2 = change * 2;
        int tmp = curTime % change2;
        if (tmp < change) {
            return curTime;
        }
        return curTime + (change2 - tmp);
    }
}
/*
2045. 到达目的地的第二短时间
https://leetcode.cn/problems/second-minimum-time-to-reach-destination/

第 263 场周赛 T4。

城市用一个 双向连通 图表示，图中有 n 个节点，从 1 到 n 编号（包含 1 和 n）。图中的边用一个二维整数数组 edges 表示，
其中每个 edges[i] = [ui, vi] 表示一条节点 ui 和节点 vi 之间的双向连通边。每组节点对由 最多一条 边连通，顶点不存在连接到自身的边。
穿过任意一条边的时间是 time 分钟。
每个节点都有一个交通信号灯，每 change 分钟改变一次，从绿色变成红色，再由红色变成绿色，循环往复。所有信号灯都 同时 改变。
你可以在 任何时候 进入某个节点，但是 只能 在节点 信号灯是绿色时 才能离开。如果信号灯是  绿色 ，你 不能 在节点等待，必须离开。
第二小的值 是 严格大于 最小值的所有值中最小的值。
例如，[2, 3, 4] 中第二小的值是 3 ，而 [2, 2, 4] 中第二小的值是 4 。
给你 n、edges、time 和 change ，返回从节点 1 到节点 n 需要的 第二短时间 。
注意：
你可以 任意次 穿过任意顶点，包括 1 和 n 。
你可以假设在 启程时 ，所有信号灯刚刚变成 绿色 。

无向等权图 时间即路径长度。
节点 1 到节点 n 的最短时间，即节点 1 到节点 n 的最短路径（设为 p）
第二短时间 即节点 1 到节点 n 第二短路径，必定为 p+1 或 p+2
 */