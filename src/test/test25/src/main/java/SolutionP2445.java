import java.util.HashMap;
import java.util.Map;

public class SolutionP2445 {
    private int n;
    private Map<Integer, Integer> cnt;

    public int numberOfNodes(int n, int[] queries) {
        this.n = n;
        cnt = new HashMap<>();
        for (int q : queries) {
            cnt.merge(q, 1, Integer::sum);
        }
        return dfs(1, 0);
    }

    private int dfs(int node, int c) {
        if (node > n) return 0;
        int nc = (c + cnt.getOrDefault(node, 0)) % 2;
        int ans = nc;
        ans += dfs(node * 2, nc);
        ans += dfs(node * 2 + 1, nc);
        return ans;
    }
}
/*
$2445. 值为 1 的节点数
https://leetcode.cn/problems/number-of-nodes-with-value-one/description/

有一个 无向 树，有 n 个节点，节点标记为从 1 到 n ，还有 n - 1 条边。给定整数 n。标记为 v 的节点的父节点是标记为 floor (v / 2) 的节点。树的根节点是标记为 1 的节点。
- 例如，如果 n = 7，那么标记为 3 的节点将标记 floor(3 / 2) = 1 的节点作为其父节点，标记为 7 的节点将标记 floor(7 / 2) = 3 的节点作为其父节点。
你还得到一个整数数组 queries。最初，每个节点的值都是 0。对于每个查询 queries[i]，您应该翻转节点标记为 queries[i] 的子树中的所有值。
在 处理完所有查询后，返回值为 1 的节点总数。
注意:
- 翻转节点的值意味着值为 0 的节点变为 1，反之亦然。
- floor(x) 相当于将 x 舍入到最接近的整数。
提示:
1 <= n <= 10^5
1 <= queries.length <= 10^5
1 <= queries[i] <= n

观察发现翻转奇数次时最终取值为1
使用DFS自顶向下遍历结点，维护每个结点被翻转次数的奇偶性
 */