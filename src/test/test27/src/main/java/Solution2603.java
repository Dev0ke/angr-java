import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Solution2603 {
    public int collectTheCoins(int[] coins, int[][] edges) {
        int n = coins.length;
        Map<Integer, List<Integer>> adj = new HashMap<>();
        int[] inDeg = new int[n];
        for (int[] edge : edges) {
            adj.computeIfAbsent(edge[0], key -> new ArrayList<>()).add(edge[1]);
            adj.computeIfAbsent(edge[1], key -> new ArrayList<>()).add(edge[0]);
            inDeg[edge[0]]++;
            inDeg[edge[1]]++;
        }

        // 拓扑排序剪枝去掉没有金币的子树
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (inDeg[i] == 1 && coins[i] == 0) {
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
            int x = queue.remove();
            for (Integer y : adj.getOrDefault(x, new ArrayList<>())) {
                inDeg[y]--;
                if (inDeg[y] == 1 && coins[y] == 0) {
                    queue.add(y);
                }
            }
        }

        // 再次拓扑排序
        for (int i = 0; i < n; i++) {
            if (inDeg[i] == 1 && coins[i] == 1) {
                queue.add(i);
            }
        }
        // 至多一个有金币的叶子，直接收集
        if (queue.size() <= 1) {
            return 0;
        }
        int[] time = new int[n];
        while (!queue.isEmpty()) {
            int x = queue.remove();
            for (Integer y : adj.getOrDefault(x, new ArrayList<>())) {
                inDeg[y]--;
                if (inDeg[y] == 1) {
                    // 记录入队时间
                    time[y] = time[x] + 1;
                    queue.add(y);
                }
            }
        }

        int ans = 0;
        for (int[] edge : edges) {
            if (time[edge[0]] >= 2 && time[edge[1]] >= 2) {
                ans += 2;
            }
        }
        return ans;
    }
}
/*
2603. 收集树中金币
https://leetcode.cn/problems/collect-coins-in-a-tree/

第 338 场周赛 T4。

给你一个 n 个节点的无向无根树，节点编号从 0 到 n - 1 。给你整数 n 和一个长度为 n - 1 的二维整数数组 edges ，
其中 edges[i] = [ai, bi] 表示树中节点 ai 和 bi 之间有一条边。再给你一个长度为 n 的数组 coins ，其中 coins[i] 可能为 0 也可能为 1 ，1 表示节点 i 处有一个金币。
一开始，你需要选择树中任意一个节点出发。你可以执行下述操作任意次：
- 收集距离当前节点距离为 2 以内的所有金币，或者
- 移动到树中一个相邻节点。
你需要收集树中所有的金币，并且回到出发节点，请你返回最少经过的边数。
如果你多次经过一条边，每一次经过都会给答案加一。
提示：
n == coins.length
1 <= n <= 3 * 10^4
0 <= coins[i] <= 1
edges.length == n - 1
edges[i].length == 2
0 <= ai, bi < n
ai != bi
edges 表示一棵合法的树。

拓扑排序。
灵神：换根 DP 不适合这道题。
 */