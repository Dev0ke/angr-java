import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution3331 {
    private List<Integer>[] g;
    private char[] s;
    private int[] ancestor;
    private int[] sz;

    public int[] findSubtreeSizes(int[] parent, String s) {
        int n = parent.length;
        g = new ArrayList[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (int i = 1; i < n; i++) {
            g[parent[i]].add(i);
        }
        this.s = s.toCharArray();

        ancestor = new int[26];
        Arrays.fill(ancestor, -1);
        sz = new int[n];
        dfs(0, -1);
        return sz;
    }

    private void dfs(int x, int fa) {
        sz[x] = 1;
        int x_ch = s[x] - 'a';
        int x_ancestor = ancestor[x_ch];
        ancestor[x_ch] = x;
        for (Integer y : g[x]) {
            if (y == fa) continue;
            dfs(y, x);
            int y_ancestor = ancestor[s[y] - 'a'];
            if (y_ancestor == -1) {
                sz[x] += sz[y];
            } else {
                sz[y_ancestor] += sz[y];
            }
        }
        ancestor[x_ch] = x_ancestor;
    }
}
/*
3331. 修改后子树的大小
https://leetcode.cn/problems/find-subtree-sizes-after-changes/description/

第 142 场双周赛 T2。

给你一棵 n 个节点且根节点为编号 0 的树，节点编号为 0 到 n - 1 。这棵树用一个长度为 n 的数组 parent 表示，其中 parent[i] 是第 i 个节点的父亲节点的编号。由于节点 0 是根，parent[0] == -1 。
给你一个长度为 n 的字符串 s ，其中 s[i] 是节点 i 对应的字符。
对于节点编号从 1 到 n - 1 的每个节点 x ，我们 同时 执行以下操作 一次 ：
- 找到距离节点 x 最近 的祖先节点 y ，且 s[x] == s[y] 。
- 如果节点 y 不存在，那么不做任何修改。
- 否则，将节点 x 与它父亲节点之间的边 删除 ，在 x 与 y 之间连接一条边，使 y 变为 x 新的父节点。
请你返回一个长度为 n 的数组 answer ，其中 answer[i] 是 最终 树中，节点 i 为根的 子树 的 大小 。
提示：
n == parent.length == s.length
1 <= n <= 10^5
对于所有的 i >= 1 ，都有 0 <= parent[i] <= n - 1 。
parent[0] == -1
parent 表示一棵合法的树。
s 只包含小写英文字母。

赛时一心想着换根 DP，就走远了，，
时间复杂度 O(n + 26)。
还可以两遍 DFS，第一遍模拟修改父节点，第二遍计算子树大小。
 */