import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Solution2646 {
    private int[] price;
    private Map<Integer, List<Integer>> adj;
    private int[] cnt;

    public int minimumTotalPrice(int n, int[][] edges, int[] price, int[][] trips) {
        this.price = price;
        adj = new HashMap<>();
        for (int[] edge : edges) {
            adj.computeIfAbsent(edge[0], key -> new ArrayList<>()).add(edge[1]);
            adj.computeIfAbsent(edge[1], key -> new ArrayList<>()).add(edge[0]);
        }
        // cnt[i] 是第 i 个节点访问次数
        cnt = new int[n];
        for (int[] trip : trips) {
            dfs(trip[0], -1, trip[1]);
        }

        int[] tuple = dfs2(0, -1);
        return Math.min(tuple[0], tuple[1]);
    }

    // x 起点 t 终点
    private boolean dfs(int x, int fa, int t) {
        if (x == t) {
            cnt[x]++;
            return true;
        }
        for (int y : adj.getOrDefault(x, new ArrayList<>())) {
            if (y == fa) continue;
            if (!dfs(y, x, t)) continue;
            cnt[x]++;
            return true;
        }
        return false;
    }

    private int[] dfs2(int x, int fa) {
        int xNotHalf = price[x] * cnt[x];
        int xHalf = xNotHalf / 2;
        for (int y : adj.getOrDefault(x, new ArrayList<>())) {
            if (y == fa) continue;
            int[] tuple = dfs2(y, x);
            int yNotHalf = tuple[0];
            int yHalf = tuple[1];
            xNotHalf += Math.min(yNotHalf, yHalf);
            xHalf += yNotHalf;
        }
        return new int[]{xNotHalf, xHalf};
    }

    // 比赛 TLE 版本
    private int n;
    private int[][] memo;

    public int minimumTotalPrice2(int n, int[][] edges, int[] price, int[][] trips) {
        this.n = n;
        this.price = price;
        // 建图
        adj = new HashMap<>();
        for (int[] edge : edges) {
            adj.computeIfAbsent(edge[0], key -> new ArrayList<>()).add(edge[1]);
            adj.computeIfAbsent(edge[1], key -> new ArrayList<>()).add(edge[0]);
        }
        // cnt[i] 是第 i 个节点访问次数
        cnt = new int[n];
        for (int[] trip : trips) {
            List<Integer> nodes = bfs(trip[0], trip[1]);
            for (Integer node : nodes) {
                cnt[node]++;
            }
        }

        memo = new int[n][3];
        for (int i = 0; i < n; i++) {
            Arrays.fill(memo[i], -1);
        }
        return Math.min(dfs0(0, -1, 1), dfs0(0, -1, 2));
    }

    // half 2:价格减半 1:原价
    private int dfs0(int x, int fa, int half) {
        if (memo[x][half] != -1) {
            return memo[x][half];
        }
        int xAns = price[x] * cnt[x] / half;

        for (int y : adj.getOrDefault(x, new ArrayList<>())) {
            if (y == fa) continue;

            int yAns;
            if (half == 2) {
                yAns = dfs0(y, x, 1);
            } else {
                yAns = Math.min(dfs0(y, x, 1), dfs0(y, x, 2));
            }
            xAns += yAns;
        }
        memo[x][half] = xAns;
        return xAns;
    }

    private List<Integer> bfs(int s, int t) {
        Queue<Node> queue = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();
        list.add(s);
        queue.add(new Node(s, list));

        boolean[] visited = new boolean[n];
        visited[s] = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node cur = queue.remove();
                int x = cur.node;
                List<Integer> xList = cur.memoList;
                if (x == t) {
                    return xList;
                }

                for (int y : adj.getOrDefault(x, new ArrayList<>())) {
                    if (!visited[y]) {
                        visited[y] = true;

                        List<Integer> yList = new ArrayList<>(xList);
                        yList.add(y);
                        queue.add(new Node(y, yList));
                    }
                }
            }
        }
        return list;
    }

    private static class Node {
        int node;
        List<Integer> memoList;

        public Node(int node, List<Integer> memoList) {
            this.node = node;
            this.memoList = memoList;
        }
    }
}
/*
2646. 最小化旅行的价格总和
https://leetcode.cn/problems/minimize-the-total-price-of-the-trips/

第 341 场周赛 T4。

现有一棵无向、无根的树，树中有 n 个节点，按从 0 到 n - 1 编号。给你一个整数 n 和一个长度为 n - 1 的二维整数数组 edges ，其中 edges[i] = [ai, bi] 表示树中节点 ai 和 bi 之间存在一条边。
每个节点都关联一个价格。给你一个整数数组 price ，其中 price[i] 是第 i 个节点的价格。
给定路径的 价格总和 是该路径上所有节点的价格之和。
另给你一个二维整数数组 trips ，其中 trips[i] = [starti, endi] 表示您从节点 starti 开始第 i 次旅行，并通过任何你喜欢的路径前往节点 endi 。
在执行第一次旅行之前，你可以选择一些 非相邻节点 并将价格减半。
返回执行所有旅行的最小价格总和。
提示：
1 <= n <= 50
edges.length == n - 1
0 <= ai, bi <= n - 1
edges 表示一棵有效的树
price.length == n
price[i] 是一个偶数
1 <= price[i] <= 1000
1 <= trips.length <= 100
0 <= starti, endi <= n - 1

树形 DP。
先求出每个点的贡献次数 cnt，再树形 DP 考虑哪些点应该设置为价格减半。
比赛时忘加记忆化导致 TLE。比赛时只会用 bfs 找最短路的途径节点。
本题还有 树上差分 或 离线LCA 等做法。
详见 https://leetcode.cn/problems/minimize-the-total-price-of-the-trips/solution/lei-si-da-jia-jie-she-iii-pythonjavacgo-4k3wq/
相似题目: 337. 打家劫舍 III
https://leetcode.cn/problems/house-robber-iii/
 */