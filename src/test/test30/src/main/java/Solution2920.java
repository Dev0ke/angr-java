import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution2920 {
    private int[] coins;
    private int k;
    private List<Integer>[] g;
    private int[][] memo;

    public int maximumPoints(int[][] edges, int[] coins, int k) {
        this.coins = coins;
        this.k = k;

        int n = edges.length + 1;
        g = new ArrayList[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (int[] e : edges) {
            g[e[0]].add(e[1]);
            g[e[1]].add(e[0]);
        }
        // 2^14 = 16384 > 1e4
        memo = new int[15][n];
        for (int i = 0; i < 15; i++) {
            Arrays.fill(memo[i], -1);
        }
        return dfs(0, -1, 0);
    }

    // 右移 >> b
    private int dfs(int x, int fa, int b) {
        if (b > 14) return 0;
        if (memo[b][x] != -1) return memo[b][x];

        int s1 = (coins[x] >> b) - k;
        int s2 = (coins[x] >> (b + 1));
        for (Integer y : g[x]) {
            if (y != fa) {
                s1 += dfs(y, x, b);
                s2 += dfs(y, x, b + 1);
            }
        }
        int res = Math.max(s1, s2);
        memo[b][x] = res;
        return res;
    }

    // java.lang.OutOfMemoryError: Java heap space
    private Map<String, Integer> memoMap;

    public int maximumPoints2(int[][] edges, int[] coins, int k) {
        this.coins = coins;
        this.k = k;

        int n = edges.length + 1;
        g = new ArrayList[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (int[] e : edges) {
            g[e[0]].add(e[1]);
            g[e[1]].add(e[0]);
        }
        memoMap = new HashMap<>();
        return dfs2(0, -1, 0);
    }

    // 右移 >> b
    private int dfs2(int x, int fa, int b) {
        if (b > 14) return 0;
        String key = x + ":" + b;
        if (memoMap.containsKey(key)) {
            return memoMap.get(key);
        }

        int s1 = (coins[x] >> b) - k;
        int s2 = (coins[x] >> (b + 1));
        for (Integer y : g[x]) {
            if (y != fa) {
                s1 += dfs2(y, x, b);
                s2 += dfs2(y, x, b + 1);
            }
        }
        int res = Math.max(s1, s2);
        memoMap.put(key, res);
        return res;
    }
}
/*
2920. 收集所有金币可获得的最大积分
https://leetcode.cn/problems/maximum-points-after-collecting-coins-from-all-nodes/

第 369 场周赛 T4。

节点 0 处现有一棵由 n 个节点组成的无向树，节点编号从 0 到 n - 1 。给你一个长度为 n - 1 的二维 整数 数组 edges ，其中 edges[i] = [ai, bi] 表示在树上的节点 ai 和 bi 之间存在一条边。另给你一个下标从 0 开始、长度为 n 的数组 coins 和一个整数 k ，其中 coins[i] 表示节点 i 处的金币数量。
从根节点开始，你必须收集所有金币。要想收集节点上的金币，必须先收集该节点的祖先节点上的金币。
节点 i 上的金币可以用下述方法之一进行收集：
- 收集所有金币，得到共计 coins[i] - k 点积分。如果 coins[i] - k 是负数，你将会失去 abs(coins[i] - k) 点积分。
- 收集所有金币，得到共计 floor(coins[i] / 2) 点积分。如果采用这种方法，节点 i 子树中所有节点 j 的金币数 coins[j] 将会减少至 floor(coins[j] / 2) 。
返回收集 所有 树节点的金币之后可以获得的最大积分。
提示：
n == coins.length
2 <= n <= 10^5
0 <= coins[i] <= 10^4
edges.length == n - 1
0 <= edges[i][0], edges[i][1] < n
0 <= k <= 10^4

树形 DP + 记忆化搜索 + 剪枝
注意到有一个剪枝上界
时间复杂度 O(n)
一开始写法是 b*2（不连续、稀疏），用哈希表做记忆化，TLE
后来优化为 记录b右移的位数（连续），用数组做记忆化，AC
 */