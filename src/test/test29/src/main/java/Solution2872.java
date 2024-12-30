import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution2872 {
    private int[] values;
    private int k;
    private List<Integer>[] g;
    private int ans;

    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        this.values = values;
        this.k = k;
        g = new ArrayList[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (int[] e : edges) {
            g[e[0]].add(e[1]);
            g[e[1]].add(e[0]);
        }
        ans = 0;
        dfs(0, -1);
        return ans;
    }

    private long dfs(int x, int fa) {
        long sum = values[x];
        for (Integer y : g[x]) {
            if (y != fa) {
                sum += dfs(y, x);
            }
        }
        if (sum % k == 0) {
            ans++;
        }
        return sum;
    }
}
/*
2872. 可以被 K 整除连通块的最大数目
https://leetcode.cn/problems/maximum-number-of-k-divisible-components/description/

第 114 场双周赛 T4。

给你一棵 n 个节点的无向树，节点编号为 0 到 n - 1 。给你整数 n 和一个长度为 n - 1 的二维整数数组 edges ，其中 edges[i] = [ai, bi] 表示树中节点 ai 和 bi 有一条边。
同时给你一个下标从 0 开始长度为 n 的整数数组 values ，其中 values[i] 是第 i 个节点的 值 。再给你一个整数 k 。
你可以从树中删除一些边，也可以一条边也不删，得到若干连通块。一个 连通块的值 定义为连通块中所有节点值之和。如果所有连通块的值都可以被 k 整除，那么我们说这是一个 合法分割 。
请你返回所有合法分割中，连通块数目的最大值 。
提示：
1 <= n <= 3 * 10^4
edges.length == n - 1
edges[i].length == 2
0 <= ai, bi < n
values.length == n
0 <= values[i] <= 10^9
1 <= k <= 10^9
values 之和可以被 k 整除。
输入保证 edges 是一棵无向树。

树形 DP
时间复杂度 O(n)
 */