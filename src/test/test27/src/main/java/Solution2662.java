import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution2662 {
    private static final int INF = (int) 1e9;

    public int minimumCost(int[] start, int[] target, int[][] specialRoads) {
        // 离散化 begin
        Map<Long, Node> map = new HashMap<>();
        Node sNode = new Node(start[0], start[1]);
        Node tNode = new Node(target[0], target[1]);
        map.put(sNode.id, sNode);
        map.put(tNode.id, tNode);
        for (int[] sp : specialRoads) {
            Node node1 = new Node(sp[0], sp[1]);
            Node node2 = new Node(sp[2], sp[3]);
            map.put(node1.id, node1);
            map.put(node2.id, node2);
        }
        int sz = map.size();
        long[] yArr = new long[sz];
        int id = 0;
        for (Long x : map.keySet()) {
            yArr[id++] = x;
        }
        Arrays.sort(yArr);
        // 离散化 end

        // 建图
        int[][] adj = new int[sz][sz];
        for (int i = 0; i < sz; i++) {
            for (int j = i + 1; j < sz; j++) {
                Node nodeI = map.get(yArr[i]);
                Node nodeJ = map.get(yArr[j]);
                int abs = Math.abs(nodeI.x - nodeJ.x) + Math.abs(nodeI.y - nodeJ.y);
                adj[i][j] = adj[j][i] = abs;
            }
        }
        for (int[] sp : specialRoads) {
            Node node1 = new Node(sp[0], sp[1]);
            Node node2 = new Node(sp[2], sp[3]);
            int node1Id = getId(yArr, node1.id);
            int node2Id = getId(yArr, node2.id);
            if (adj[node1Id][node2Id] > sp[4]) {
                adj[node1Id][node2Id] = sp[4];
            }
        }

        int startId = getId(yArr, sNode.id);
        int targetId = getId(yArr, tNode.id);

        int[] dist = new int[sz];
        boolean[] visited = new boolean[sz];
        Arrays.fill(dist, INF);
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        priorityQueue.add(new int[]{startId, 0});
        dist[startId] = 0;
        while (!priorityQueue.isEmpty()) {
            int[] top = priorityQueue.remove();
            int x = top[0];
            if (visited[x]) {
                continue;
            }
            visited[x] = true;
            for (int y = 0; y < sz; y++) {
                if (x != y && adj[x][y] != INF) {
                    if (dist[y] > dist[x] + adj[x][y]) {
                        dist[y] = dist[x] + adj[x][y];
                        priorityQueue.add(new int[]{y, dist[y]});
                    }
                }
            }
        }

        return dist[targetId];
    }

    private int getId(long[] yArr, long x) {
        return Arrays.binarySearch(yArr, x);
    }

    private static class Node {
        int x;
        int y;
        long id;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
            this.id = (long) x << 32 | y;
        }
    }
}
/*
2662. 前往目标的最小代价
https://leetcode.cn/problems/minimum-cost-of-a-path-with-special-roads/

第 343 场周赛 T3。

给你一个数组 start ，其中 start = [startX, startY] 表示你的初始位置位于二维空间上的 (startX, startY) 。
另给你一个数组 target ，其中 target = [targetX, targetY] 表示你的目标位置 (targetX, targetY) 。
从位置 (x1, y1) 到空间中任一其他位置 (x2, y2) 的代价是 |x2 - x1| + |y2 - y1| 。
给你一个二维数组 specialRoads ，表示空间中存在的一些特殊路径。
其中 specialRoads[i] = [x1i, y1i, x2i, y2i, costi] 表示第 i 条特殊路径可以从 (x1i, y1i) 到 (x2i, y2i) ，但成本等于 costi 。你可以使用每条特殊路径任意次数。
返回从 (startX, startY) 到 (targetX, targetY) 所需的最小代价。
提示：
start.length == target.length == 2
1 <= startX <= targetX <= 10^5
1 <= startY <= targetY <= 10^5
1 <= specialRoads.length <= 200
specialRoads[i].length == 5
startX <= x1i, x2i <= targetX
startY <= y1i, y2i <= targetY
1 <= costi <= 10^5

离散化后套 dijkstra 模板。
时间复杂度 O(mlogn)。其中 m = n^2 稠密图
 */