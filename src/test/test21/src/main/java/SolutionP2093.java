import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class SolutionP2093 {
    public int minimumCost(int n, int[][] highways, int discounts) {
        List<int[]>[] g = new ArrayList[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (int[] p : highways) {
            int x = p[0], y = p[1], toll = p[2];
            g[x].add(new int[]{y, toll});
            g[y].add(new int[]{x, toll});
        }

        // 花费，id，打折次数
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
        minHeap.add(new int[]{0, 0, 0});
        int[][] dist = new int[n][discounts + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        while (!minHeap.isEmpty()) {
            int[] top = minHeap.remove();
            int cur_cost = top[0], cur_id = top[1], cur_discount = top[2];
            if (cur_discount > discounts) continue;
            if (cur_id == n - 1) return cur_cost;

            if (dist[cur_id][cur_discount] > cur_cost) {
                dist[cur_id][cur_discount] = cur_cost;
                for (int[] p : g[cur_id]) {
                    int next_id = p[0], toll = p[1];
                    minHeap.add(new int[]{cur_cost + toll, next_id, cur_discount});
                    minHeap.add(new int[]{cur_cost + toll / 2, next_id, cur_discount + 1});
                }
            }
        }
        return -1;
    }
}
/*
$2093. 前往目标城市的最小费用
https://leetcode.cn/problems/minimum-cost-to-reach-city-with-discounts/description/

一组公路连接 n 个城市，城市编号为从 0 到 n - 1 。 输入包含一个二维数组 highways ，其中 highways[i] = [city1i, city2i, tolli] 表示有一条连接城市 city1i 和 city2i 的双向公路，允许汽车缴纳值为 tolli 的费用从  city1i 前往 city2i 或 从  city2i 前往 city1i 。
另给你一个整数 discounts 表示你最多可以使用折扣的次数。你可以使用一次折扣使通过第 ith 条公路的费用降低至 tolli / 2（向下取整）。 最多只可使用 discounts 次折扣， 且 每条公路最多只可使用一次折扣 。
返回从城市0 前往城市 n - 1 的 最小费用 。如果不存在从城市0 前往城市 n - 1 的路径，返回 -1 。
提示:
2 <= n <= 1000
1 <= highways.length <= 1000
highways[i].length == 3
0 <= city1i, city2i <= n - 1
city1i != city2i
0 <= tolli <= 10^5
0 <= discounts <= 500
任意两个城市之间最多只有一条公路相连

dijkstra
时间复杂度 O(mlogm)。
 */