import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

public class Solution2876 {
    private List<Integer>[] rg;
    private int[] deg, ans;

    public int[] countVisitedNodes(List<Integer> edges) {
        int n = edges.size();
        rg = new ArrayList[n];
        Arrays.setAll(rg, e -> new ArrayList<>());
        deg = new int[n];
        for (int x = 0; x < n; x++) {
            int y = edges.get(x);
            rg[y].add(x);
            deg[y]++;
        }
        Queue<Integer> queue = new ArrayDeque<>();
        for (int x = 0; x < n; x++) {
            if (deg[x] == 0) {
                queue.add(x);
            }
        }
        while (!queue.isEmpty()) {
            int x = queue.remove();
            int y = edges.get(x);
            if (--deg[y] == 0) {
                queue.add(y);
            }
        }
        ans = new int[n];
        for (int i = 0; i < n; i++) {
            if (deg[i] <= 0) continue;
            List<Integer> ring = new ArrayList<>();
            for (int x = i; ; x = edges.get(x)) {
                deg[x] = -1;
                ring.add(x);
                if (edges.get(x) == i) {
                    break;
                }
            }
            for (Integer r : ring) {
                rdfs(r, ring.size());
            }
        }
        return ans;
    }

    private void rdfs(int x, int depth) {
        ans[x] = depth;
        for (Integer y : rg[x]) {
            if (deg[y] == 0) {
                rdfs(y, depth + 1);
            }
        }
    }
}
/*
2876. 有向图访问计数
https://leetcode.cn/problems/count-visited-nodes-in-a-directed-graph/description/

第 365 场周赛 T4。

现有一个有向图，其中包含 n 个节点，节点编号从 0 到 n - 1 。此外，该图还包含了 n 条有向边。
给你一个下标从 0 开始的数组 edges ，其中 edges[i] 表示存在一条从节点 i 到节点 edges[i] 的边。
想象在图上发生以下过程：
- 你从节点 x 开始，通过边访问其他节点，直到你在 此过程 中再次访问到之前已经访问过的节点。
返回数组 answer 作为答案，其中 answer[i] 表示如果从节点 i 开始执行该过程，你可以访问到的不同节点数。
提示：
n == edges.length
2 <= n <= 10^5
0 <= edges[i] <= n - 1
edges[i] != i

内向基环树
时间复杂度 O(n)
空间复杂度 O(n)
相似题目: 2127. 参加会议的最多员工数
https://leetcode.cn/problems/maximum-employees-to-be-invited-to-a-meeting/
2359. 找到离给定两个节点最近的节点
https://leetcode.cn/problems/find-closest-node-to-given-two-nodes/
2360. 图中的最长环
https://leetcode.cn/problems/longest-cycle-in-a-graph/
2836. 在传球游戏中最大化函数值
https://leetcode.cn/problems/maximize-value-of-function-in-a-ball-passing-game/
 */