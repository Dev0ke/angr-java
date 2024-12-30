import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution2322 {
    private int[] nums;
    private int[] in;
    private int[] out;
    private int clock;
    private int[] xor;
    private Map<Integer, List<Integer>> adj;

    public int minimumScore(int[] nums, int[][] edges) {
        int n = nums.length;
        this.nums = nums;

        // 建图
        adj = new HashMap<>();
        for (int[] edge : edges) {
            adj.computeIfAbsent(edge[0], key -> new ArrayList<>()).add(edge[1]);
            adj.computeIfAbsent(edge[1], key -> new ArrayList<>()).add(edge[0]);
        }

        in = new int[n];
        out = new int[n];
        xor = new int[n];

        dfs(0, -1);

        // swap
        for (int[] edge : edges) {
            if (!isParent(edge[0], edge[1])) {
                int tmp = edge[0];
                edge[0] = edge[1];
                edge[1] = tmp;
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < edges.length; i++) {
            int x1 = edges[i][0];
            int y1 = edges[i][1];
            for (int j = 0; j < i; j++) {
                int x2 = edges[j][0];
                int y2 = edges[j][1];

                int x, y, z;
                // y1 是 x2 的祖先节点（或重合）
                if (isParent(y1, x2)) {
                    x = xor[y2];
                    y = xor[y1] ^ x;
                    z = xor[0] ^ xor[y1];
                }
                // y2 是 x1 的祖先节点（或重合）
                else if (isParent(y2, x1)) {
                    x = xor[y1];
                    y = xor[y2] ^ x;
                    z = xor[0] ^ xor[y2];
                }
                // 不同的子树
                else {
                    x = xor[y1];
                    y = xor[y2];
                    z = xor[0] ^ x ^ y;
                }
                min = Math.min(min, Math.max(x, Math.max(y, z)) - Math.min(x, Math.min(y, z)));
                if (min == 0) {
                    return min;
                }
            }
        }
        return min;
    }

    private void dfs(int x, int fa) {
        in[x] = ++clock;
        xor[x] = nums[x];
        for (int next : adj.get(x)) {
            if (next != fa) {
                dfs(next, x);
                xor[x] ^= xor[next];
            }
        }
        out[x] = clock;
    }

    // x 是 y 的祖先节点（或重合）
    private boolean isParent(int x, int y) {
        return in[x] <= in[y] && in[y] <= out[x];
    }
}
/*
2322. 从树中删除边的最小分数
https://leetcode.cn/problems/minimum-score-after-removals-on-a-tree/

第 299 场周赛 T4。

存在一棵无向连通树，树中有编号从 0 到 n - 1 的 n 个节点， 以及 n - 1 条边。
给你一个下标从 0 开始的整数数组 nums ，长度为 n ，其中 nums[i] 表示第 i 个节点的值。另给你一个二维整数数组 edges ，长度为 n - 1 ，其中 edges[i] = [ai, bi] 表示树中存在一条位于节点 ai 和 bi 之间的边。
删除树中两条 不同 的边以形成三个连通组件。对于一种删除边方案，定义如下步骤以计算其分数：
1.分别获取三个组件 每个 组件中所有节点值的异或值。
2.最大 异或值和 最小 异或值的 差值 就是这一种删除边方案的分数。
- 例如，三个组件的节点值分别是：[4,5,7]、[1,9] 和 [3,3,3] 。三个异或值分别是 4 ^ 5 ^ 7 = 6、1 ^ 9 = 8 和 3 ^ 3 ^ 3 = 3 。最大异或值是 8 ，最小异或值是 3 ，分数是 8 - 3 = 5 。
返回在给定树上执行任意删除边方案可能的 最小 分数。
提示：
n == nums.length
3 <= n <= 1000
1 <= nums[i] <= 10^8
edges.length == n - 1
edges[i].length == 2
0 <= ai, bi < n
ai != bi
edges 表示一棵有效的树

前置知识 a^b^b = a
分类讨论 + DFS 时间戳
子问题：
时间复杂度 O(n^2)
 */