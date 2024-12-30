import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution2581 {
    private Map<Integer, List<Integer>> adj;
    private Set<Long> set;
    private int k;
    private int cnt0;
    private int res;

    public int rootCount(int[][] edges, int[][] guesses, int k) {
        // 建图
        adj = new HashMap<>();
        for (int[] edge : edges) {
            adj.computeIfAbsent(edge[0], key -> new ArrayList<>()).add(edge[1]);
            adj.computeIfAbsent(edge[1], key -> new ArrayList<>()).add(edge[0]);
        }
        // 转化为 hashset, (long) x << 32 | y
        set = new HashSet<>();
        for (int[] guess : guesses) {
            set.add((long) guess[0] << 32 | guess[1]);
        }
        this.k = k;

        cnt0 = 0;
        dfs(0, -1);

        res = 0;
        reroot(0, -1, cnt0);
        return res;
    }

    private void dfs(int x, int fa) {
        for (int y : adj.getOrDefault(x, new ArrayList<>())) {
            if (y == fa) continue;
            if (set.contains((long) x << 32 | y)) {
                cnt0++;
            }
            dfs(y, x);
        }
    }

    // 换根 DP
    private void reroot(int x, int fa, int cnt) {
        if (cnt >= k) res++;
        for (int y : adj.getOrDefault(x, new ArrayList<>())) {
            if (y == fa) continue;
            int cnty = cnt;
            // 换根后，原来的 x->y 变为 y->x
            if (set.contains((long) x << 32 | y)) cnty--;
            if (set.contains((long) y << 32 | x)) cnty++;
            reroot(y, x, cnty);
        }
    }
}
/*
2581. 统计可能的树根数目
https://leetcode.cn/problems/count-number-of-possible-root-nodes/

第 99 场双周赛 T4。

Alice 有一棵 n 个节点的树，节点编号为 0 到 n - 1 。树用一个长度为 n - 1 的二维整数数组 edges 表示，其中 edges[i] = [ai, bi] ，表示树中节点 ai 和 bi 之间有一条边。
Alice 想要 Bob 找到这棵树的根。她允许 Bob 对这棵树进行若干次 猜测 。每一次猜测，Bob 做如下事情：
- 选择两个 不相等 的整数 u 和 v ，且树中必须存在边 [u, v] 。
- Bob 猜测树中 u 是 v 的 父节点 。
Bob 的猜测用二维整数数组 guesses 表示，其中 guesses[j] = [uj, vj] 表示 Bob 猜 uj 是 vj 的父节点。
Alice 非常懒，她不想逐个回答 Bob 的猜测，只告诉 Bob 这些猜测里面 至少 有 k 个猜测的结果为 true 。
给你二维整数数组 edges ，Bob 的所有猜测和整数 k ，请你返回可能成为树根的 节点数目 。如果没有这样的树，则返回 0。
提示：
edges.length == n - 1
2 <= n <= 10^5
1 <= guesses.length <= 10^5
0 <= ai, bi, uj, vj <= n - 1
ai != bi
uj != vj
edges 表示一棵有效的树。
guesses[j] 是树中的一条边。
0 <= k <= guesses.length

树形 DP + 换根 DP
每次换根后，只需要 O(1) 改变一条边的父子关系，不需要重新 O(n) 去重新构造一棵树。
时间复杂度 O(g + n) 其中 g = guesses.length
 */