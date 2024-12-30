import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Solution815 {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        int M = routes.length;

        if (source == target) {
            return 0;
        }

        // 建图
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int i = 0; i < M; i++) {
            int[] route = routes[i];
            for (int ro : route) {
                adj.computeIfAbsent(ro, key -> new ArrayList<>()).add(i);
            }
        }

        // BFS
        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);
        boolean[] visited = new boolean[M];
        int cnt = 0;
        while (!queue.isEmpty()) {
            cnt++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int curStop = queue.remove();

                // 当前车站的线路集合
                for (int route : adj.get(curStop)) {
                    if (!visited[route]) {
                        visited[route] = true;
                        // 当前线路的车站 1,2,7
                        int[] stops = routes[route];
                        for (int stop : stops) {
                            // 结束条件
                            if (stop == target) {
                                return cnt;
                            }
                            // 添加当前线路的 "换乘站"
                            if (adj.get(stop).size() > 1) {
                                queue.add(stop);
                            }
                        }
                    }
                }
            }
        }
        return -1;
    }
}
/*
815. 公交路线
https://leetcode.cn/problems/bus-routes/

给你一个数组 routes ，表示一系列公交线路，其中每个 routes[i] 表示一条公交线路，第 i 辆公交车将会在上面循环行驶。
- 例如，路线 routes[0] = [1, 5, 7] 表示第 0 辆公交车会一直按序列 1 -> 5 -> 7 -> 1 -> 5 -> 7 -> 1 -> ... 这样的车站路线行驶。
现在从 source 车站出发（初始时不在公交车上），要前往 target 车站。 期间仅可乘坐公交车。
求出 最少乘坐的公交车数量 。如果不可能到达终点车站，返回 -1 。
提示：
1 <= routes.length <= 500.
1 <= routes[i].length <= 10^5
routes[i] 中的所有值 互不相同
sum(routes[i].length) <= 10^5
0 <= routes[i][j] < 10^6
0 <= source, target < 10^6

routes[i] 中的所有值 互不相同
对于用例 routes = [[1,2,7],[3,6,7]]
构造 map 如下:
1-[0]
2-[0]
7-[0,1]
3-[1]
6-[1]
因 map.get(7).size > 1，因此 7 为换乘站。
对于每个 换乘站，添加进 queue 进行 BFS 即可。
 */