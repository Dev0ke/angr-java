import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

public class Solution3015 {
    private static final int INF = (int) 1e9;

    // Floyd
    public int[] countOfPairs(int n, int x, int y) {
        int[][] g = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(g[i], INF);
            g[i][i] = 0;
        }
        for (int i = 1; i < n; i++) {
            g[i - 1][i] = 1;
            g[i][i - 1] = 1;
        }
        if (x != y) {
            g[x - 1][y - 1] = 1;
            g[y - 1][x - 1] = 1;
        }
        // Floyd
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    g[i][j] = Math.min(g[i][j], g[i][k] + g[k][j]);
                }
            }
        }
        int[] ans = new int[n];
        for (int[] row : g) {
            for (int v : row) {
                if (1 <= v && v <= n) {
                    ans[v - 1]++;
                }
            }
        }
        return ans;
    }

    // BFS
    public int[] countOfPairs2(int n, int x, int y) {
        List<Integer>[] g = new ArrayList[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (int i = 1; i < n; i++) {
            g[i - 1].add(i);
            g[i].add(i - 1);
        }
        g[x - 1].add(y - 1);
        g[y - 1].add(x - 1);

        int[] ans = new int[n];
        for (int st = 0; st < n; st++) {
            // BFS
            Queue<Integer> q = new ArrayDeque<>();
            boolean[] vis = new boolean[n];
            q.add(st);
            vis[st] = true;
            int dist = 0;
            while (!q.isEmpty()) {
                int sz = q.size();
                for (int i = 0; i < sz; i++) {
                    int x0 = q.remove();
                    if (dist > 0) {
                        ans[dist - 1]++;
                    }

                    for (Integer y0 : g[x0]) {
                        if (!vis[y0]) {
                            vis[y0] = true;
                            q.add(y0);
                        }
                    }
                }
                dist++;
            }
        }
        return ans;
    }
}
/*
3015. 按距离统计房屋对数目 I
https://leetcode.cn/problems/count-the-number-of-houses-at-a-certain-distance-i/description/

第 381 场周赛 T2。

给你三个 正整数 n 、x 和 y 。
在城市中，存在编号从 1 到 n 的房屋，由 n 条街道相连。对所有 1 <= i < n ，都存在一条街道连接编号为 i 的房屋与编号为 i + 1 的房屋。另存在一条街道连接编号为 x 的房屋与编号为 y 的房屋。
对于每个 k（1 <= k <= n），你需要找出所有满足要求的 房屋对 [house1, house2] ，即从 house1 到 house2 需要经过的 最少 街道数为 k 。
返回一个下标从 1 开始且长度为 n 的数组 result ，其中 result[k] 表示所有满足要求的房屋对的数量，即从一个房屋到另一个房屋需要经过的 最少 街道数为 k 。
注意，x 与 y 可以 相等 。
提示：
2 <= n <= 100
1 <= x, y <= n

Floyd / BFS
时间复杂度 O(n^3) 或者 O(n^2)
 */