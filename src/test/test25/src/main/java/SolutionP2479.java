import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SolutionP2479 {
    private List<Integer>[] graph;
    private int[] values;
    private long[] s;
    private long ans;
    private TrieNode tree;

    public long maxXor(int n, int[][] edges, int[] values) {
        graph = new ArrayList[n];
        Arrays.setAll(graph, e -> new ArrayList<>());
        for (int[] e : edges) {
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }
        this.values = values;

        // 预处理子树和
        s = new long[n];
        dfs1(0, -1);
        // 遍历子树和，求最大异或值
        ans = 0;
        tree = new TrieNode();
        dfs2(0, -1);
        return ans;
    }

    private long dfs1(int node, int fa) {
        long tot = values[node];
        for (int nxt : graph[node]) {
            if (nxt == fa) continue;
            tot += dfs1(nxt, node);
        }
        s[node] = tot;
        return tot;
    }

    private void dfs2(int node, int fa) {
        ans = Math.max(ans, tree.queryMaxOr(s[node]));
        for (int nxt : graph[node]) {
            if (nxt == fa) continue;
            dfs2(nxt, node);
        }
        tree.insert(s[node]);
    }

    static class TrieNode {
        static final int L = 47;
        TrieNode left;
        TrieNode right;

        public TrieNode() {
            left = null;
            right = null;
        }

        void insert(long val) {
            TrieNode node = this;
            for (int i = L; i >= 0; i--) {
                if ((val >> i & 1) == 0) {
                    if (node.left == null) {
                        node.left = new TrieNode();
                    }
                    node = node.left;
                } else {
                    if (node.right == null) {
                        node.right = new TrieNode();
                    }
                    node = node.right;
                }
            }
        }

        long queryMaxOr(long val) {
            TrieNode node = this;
            long ans = 0;
            for (int i = L; i >= 0; i--) {
                if (node == null) {
                    return ans;
                }
                if ((val >> i & 1) == 1) {
                    if (node.left != null) {
                        ans |= 1L << i;
                        node = node.left;
                    } else {
                        node = node.right;
                    }
                } else {
                    if (node.right != null) {
                        ans |= 1L << i;
                        node = node.right;
                    } else {
                        node = node.left;
                    }
                }
            }
            return ans;
        }
    }
}
/*
$2479. 两个不重叠子树的最大异或值
https://leetcode.cn/problems/maximum-xor-of-two-non-overlapping-subtrees/description/

有一个无向树，有 n 个节点，节点标记为从 0 到 n - 1。给定整数 n 和一个长度为 n - 1 的 2 维整数数组 edges，其中 edges[i] = [ai, bi] 表示在树中的节点 ai 和 bi 之间有一条边。树的根节点是标记为 0 的节点。
每个节点都有一个相关联的 值。给定一个长度为 n 的数组 values，其中 values[i] 是第 i 个节点的 值。
选择任意两个 不重叠 的子树。你的 分数 是这些子树中值的和的逐位异或。
返回你能达到的最大分数。如果不可能找到两个不重叠的子树，则返回 0。
注意：
- 节点的 子树 是由该节点及其所有子节点组成的树。
- 如果两个子树不共享 任何公共 节点，则它们是 不重叠 的。
提示：
2 <= n <= 5 * 10^4
edges.length == n - 1
0 <= ai, bi < n
values.length == n
1 <= values[i] <= 10^9
保证 edges 代表一个有效的树。


预处理所有节点为根节点时的子树和
使用0-1字典树维护遍历过的子树和，方便快速查找下一个子树和与之前的子树和的最大异或值
由于子树不能重叠，故先查询当前子树和与之前遍历过的子树和的最大异或值，递归结束后再将当前子树和插入到字典树中
https://leetcode.cn/problems/maximum-xor-of-two-non-overlapping-subtrees/solutions/1988655/by-steven2018-2xn8/
相似题目: 421. 数组中两个数的最大异或值
https://leetcode.cn/problems/maximum-xor-of-two-numbers-in-an-array/
1707. 与数组中元素的最大异或值
https://leetcode.cn/problems/maximum-xor-with-an-element-from-array/
1803. 统计异或值在范围内的数对有多少
https://leetcode.cn/problems/count-pairs-with-xor-in-a-range/description/
1938. 查询最大基因差
https://leetcode.cn/problems/maximum-genetic-difference-query/
 */