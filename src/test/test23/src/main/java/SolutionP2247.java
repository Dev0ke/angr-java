import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

public class SolutionP2247 {
    public int maximumCost(int n, int[][] highways, int k) {
        if (k >= n) return -1; // 这个减枝 直接从1188ms 变成32ms。。就离谱。
        Queue<int[]> q = new ArrayDeque<>(); // 不能用优先队列。他会打乱层序遍历的顺序。
        int[][] vis = new int[n][1 << n];
        List<int[]>[] mp = new ArrayList[n];
        Arrays.setAll(mp, e -> new ArrayList<>());
        for (int[] a : highways) {
            int l = a[0], r = a[1], c = a[2];
            mp[l].add(new int[]{r, c});
            mp[r].add(new int[]{l, c});
        }
        for (int i = 0; i < n; ++i) {
            q.add(new int[]{0, i, 1 << i});
            vis[i][1 << i] = 1;
        }
        int mx = -1;
        while (k-- > 0) {
            int size = q.size();
            while (size-- > 0) {
                int[] top = q.remove();
                int sum = top[0], x = top[1], y = top[2];
                for (int[] nxt : mp[x]) {
                    int v = nxt[0], c = nxt[1];
                    int t = y | 1 << v;
                    if ((vis[v][t] == 0 || vis[v][t] < sum + c) && (y >> v & 1) == 0) {
                        vis[v][t] = sum + c;
                        q.add(new int[]{c + sum, v, t});
                        if (k == 0) {
                            mx = Math.max(mx, sum + c);
                        }
                    }
                }
            }
        }
        return mx;
    }
}
/*
$2247. K 条高速公路的最大旅行费用
https://leetcode.cn/problems/maximum-cost-of-trip-with-k-highways/description/

一系列高速公路连接从 0 到 n - 1 的 n 个城市。给定一个二维整数数组 highways，其中 highways[i] = [city1i, city2i, tolli] 表示有一条高速公路连接 city1i 和city2i，允许一辆汽车从 city1i 前往 city2i，反之亦然，费用为 tolli。
给你一个整数 k，你要正好经过 k 条公路。你可以从任何一个城市出发，但在旅途中每个城市最多只能访问一次。
返回您旅行的最大费用。如果没有符合要求的行程，则返回 -1。
提示:
2 <= n <= 15
1 <= highways.length <= 50
highways[i].length == 3
0 <= city1i, city2i <= n - 1
city1i != city2i
0 <= tolli <= 100
1 <= k <= 50
没有重复的高速公路。

bfs + 状压。
https://leetcode.cn/problems/maximum-cost-of-trip-with-k-highways/solutions/1810218/by-euyia-lhc1/
这种题型 核心是一个状态 需要加一个最后一个访问的元素。这样的二维数组 来描述
这样的方式来防止重复访问。
因为这题不单单vis过就不管了。
还要取maxinnum 所以 临时开发了vis的另外一个功能 就是顺便记录当前状态的cost_sum值。
就像最短路算法里的dist数组的作用。
相似题目: 943. 最短超级串
https://leetcode.cn/problems/find-the-shortest-superstring/description/
847. 访问所有节点的最短路径
https://leetcode.cn/problems/shortest-path-visiting-all-nodes/
 */