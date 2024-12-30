import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class SolutionP2473 {
    public long[] minCost(int n, int[][] roads, int[] appleCost, int k) {
        List<int[]>[] g = new ArrayList[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (int[] road : roads) {
            int a = road[0] - 1, b = road[1] - 1, c = road[2];
            g[a].add(new int[]{b, c * (k + 1)});
            g[b].add(new int[]{a, c * (k + 1)});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingLong(o -> o[0]));
        boolean[] vis = new boolean[n];
        int[] dist = appleCost.clone();
        for (int i = 0; i < n; ++i) pq.add(new int[]{dist[i], i});
        while (!pq.isEmpty()) {
            int[] top = pq.remove();
            int c = top[0], x = top[1];
            if (vis[x]) continue;
            vis[x] = true;
            for (int[] nxt : g[x]) {
                int y = nxt[0], wt = nxt[1];
                if (dist[y] > c + wt) {
                    dist[y] = c + wt;
                    pq.add(new int[]{dist[y], y});
                }
            }
        }
        return Arrays.stream(dist).mapToLong(i -> i).toArray();
    }
}
/*
$2473. 购买苹果的最低成本
https://leetcode.cn/problems/minimum-cost-to-buy-apples/description/

给你一个正整数  n，表示从 1 到 n 的 n 个城市。还给你一个 二维 数组 roads，其中 roads[i] = [ai, bi, costi] 表示在城市 ai 和 bi 之间有一条双向道路，其旅行成本等于 costi。
你可以在 任何 城市买到苹果，但是有些城市买苹果的费用不同。给定数组 appleCost ，其中 appleCost[i] 是从城市 i 购买一个苹果的成本。
你从某个城市开始，穿越各种道路，最终从 任何一个 城市买 一个 苹果。在你买了那个苹果之后，你必须回到你 开始的 城市，但现在所有道路的成本将 乘以 一个给定的因子 k。
给定整数 k，返回一个大小为 n 的从 1 开始的数组 answer，其中 answer[i] 是从城市 i 开始购买一个苹果的 最小 总成本。
提示:
2 <= n <= 1000
1 <= roads.length <= 1000
1 <= ai, bi <= n
ai != bi
1 <= costi <= 10^5
appleCost.length == n
1 <= appleCost[i] <= 10^5
1 <= k <= 100
没有重复的边。

https://leetcode.cn/problems/minimum-cost-to-buy-apples/solutions/2000670/by-fzldq-gaw0/
首先简化一下题干：对于每座城市i,求min{dist[i,j]∗(k+1)+appleCost[j],j∈[1,n]}，其中dist[i, j]为i到j的最短距离。
将思路逆转一下：假设存在一个虚拟城市X与每座城市j之间有一条路road[X,j]=appleCost[j]。
那么城市X到城市i的最短距离满足dist[X,i]=min{road[X,j]+dist[j,i]∗(k+1),j∈[1,n]}=min{dist[i,j]∗(k+1)+appleCost[j],j∈[1,n]}。
原题就可以转换成求虚拟城市X到每座城市的最短路，时间复杂度就从O(n^2 logn)降低到了O(nlogn)。
 */