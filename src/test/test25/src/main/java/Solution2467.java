import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Solution2467 {
    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        // step1: 建图
        int n = edges.length + 1;
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int[] edge : edges) {
            adj.computeIfAbsent(edge[0], key -> new ArrayList<>()).add(edge[1]);
            adj.computeIfAbsent(edge[1], key -> new ArrayList<>()).add(edge[0]);
        }

        // step2: 求 bob 走到 0 的最短路
        List<Integer> bobPath = getBobPath(n, adj, bob);

        // step3: alice bfs 找最大值
        int max = Integer.MIN_VALUE;
        Queue<int[]> queue = new LinkedList<>();
        // id, score
        queue.add(new int[]{0, 0});
        boolean[] visited = new boolean[n];
        visited[0] = true;
        int time = 0;

        // bob 已经走过的点
        Set<Integer> bobSet = new HashSet<>();
        while (!queue.isEmpty()) {
            int size = queue.size();

            // bob 正在走的点
            int bobNode = 0;
            if (time < bobPath.size()) {
                bobNode = bobPath.get(time);
            }

            for (int i = 0; i < size; i++) {
                int[] cur = queue.remove();
                int aliceNode = cur[0];
                int score = cur[1];
                if (bobSet.contains(aliceNode)) {
                    // 如果门 已经打开 （被另一个人打开），不会有额外加分也不会扣分。
                } else if (aliceNode == bobNode) {
                    // 同时 到达一个节点，他们会共享这个节点的加分或者扣分。
                    score += amount[aliceNode] / 2;
                } else {
                    score += amount[aliceNode];
                }

                // 叶子节点
                if (adj.get(aliceNode).size() == 1 && aliceNode != 0) {
                    max = Math.max(max, score);
                }

                for (int next : adj.getOrDefault(cur[0], new ArrayList<>())) {
                    if (!visited[next]) {
                        visited[next] = true;
                        queue.add(new int[]{next, score});
                    }
                }
            }

            bobSet.add(bobNode);
            time++;
        }

        return max;
    }

    private List<Integer> getBobPath(int n, Map<Integer, List<Integer>> adj, int bob) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(bob, new ArrayList<>(List.of(bob))));
        boolean[] visited = new boolean[n];
        visited[bob] = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node cur = queue.remove();
                if (cur.id == 0) {
                    return cur.path;
                }

                for (int next : adj.getOrDefault(cur.id, new ArrayList<>())) {
                    if (!visited[next]) {
                        visited[next] = true;
                        List<Integer> nextPath = new ArrayList<>(cur.path);
                        nextPath.add(next);
                        queue.add(new Node(next, nextPath));
                    }
                }
            }
        }
        return new ArrayList<>();
    }

    private static class Node {
        int id;
        List<Integer> path;

        public Node(int id, List<Integer> path) {
            this.id = id;
            this.path = path;
        }
    }
}
/*
2467. 树上最大得分和路径
https://leetcode.cn/problems/most-profitable-path-in-a-tree/

第 91 场双周赛 T3。

一个 n 个节点的无向树，节点编号为 0 到 n - 1 ，树的根结点是 0 号节点。给你一个长度为 n - 1 的二维整数数组 edges ，其中 edges[i] = [ai, bi] ，表示节点 ai 和 bi 在树中有一条边。
在每一个节点 i 处有一扇门。同时给你一个都是偶数的数组 amount ，其中 amount[i] 表示：
- 如果 amount[i] 的值是负数，那么它表示打开节点 i 处门扣除的分数。
- 如果 amount[i] 的值是正数，那么它表示打开节点 i 处门加上的分数。
游戏按照如下规则进行：
- 一开始，Alice 在节点 0 处，Bob 在节点 bob 处。
- 每一秒钟，Alice 和 Bob 分别 移动到相邻的节点。Alice 朝着某个 叶子结点 移动，Bob 朝着节点 0 移动。
- 对于他们之间路径上的 每一个 节点，Alice 和 Bob 要么打开门并扣分，要么打开门并加分。注意：
  - 如果门 已经打开 （被另一个人打开），不会有额外加分也不会扣分。
  - 如果 Alice 和 Bob 同时 到达一个节点，他们会共享这个节点的加分或者扣分。换言之，如果打开这扇门扣 c 分，那么 Alice 和 Bob 分别扣 c / 2 分。如果这扇门的加分为 c ，那么他们分别加 c / 2 分。
- 如果 Alice 到达了一个叶子结点，她会停止移动。类似的，如果 Bob 到达了节点 0 ，他也会停止移动。注意这些事件互相 独立 ，不会影响另一方移动。
请你返回 Alice 朝最优叶子结点移动的 最大 净得分。
提示：
2 <= n <= 10^5
edges.length == n - 1
edges[i].length == 2
0 <= ai, bi < n
ai != bi
edges 表示一棵有效的树。
1 <= bob < n
amount.length == n
amount[i] 是范围 [-10^4, 10^4] 之间的一个 偶数 。

两次 bfs
bob 的路径是确定的，先 bfs 求出来
alice 的最大值同样需要 bfs 求出来
 */