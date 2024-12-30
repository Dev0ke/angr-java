import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution1938 {
    private Map<Integer, List<Integer>> g;
    private Map<Integer, List<int[]>> qs;
    private int[] ans;
    private Trie trie;

    public int[] maxGeneticDifference(int[] parents, int[][] queries) {
        int n = parents.length;
        int q = queries.length;

        int root = 0;
        g = new HashMap<>();
        for (int x = 0; x < n; x++) {
            int pa = parents[x];
            if (pa == -1) {
                root = x;
            } else {
                g.computeIfAbsent(pa, key -> new ArrayList<>()).add(x);
            }
        }
        qs = new HashMap<>();
        for (int i = 0; i < q; i++) {
            int node = queries[i][0], val = queries[i][1];
            qs.computeIfAbsent(node, key -> new ArrayList<>()).add(new int[]{val, i});
        }

        ans = new int[q];
        trie = new Trie(n, 32);

        dfs(root);
        return ans;
    }

    private void dfs(int v) {
        trie.insert(v, 1);
        for (int[] tuple : qs.getOrDefault(v, new ArrayList<>())) {
            int val = tuple[0], i = tuple[1];
            ans[i] = trie.query(val);
        }
        for (Integer w : g.getOrDefault(v, new ArrayList<>())) {
            dfs(w);
        }
        trie.insert(v, -1);
    }

    // 0-1 Trie
    // 2^31
    private static class Trie {
        int[][] dict;
        int[] cnt;
        int nextIdx, m;

        // n:长度 m:2^m
        public Trie(int n, int m) {
            this.dict = new int[2][n * m + 2];
            this.cnt = new int[n * m + 2];
            this.nextIdx = 1;
            this.m = m;
        }

        // op:1 插入 op:-1 删除
        public void insert(int x, int op) {
            int idx = 0;
            for (int k = m - 1; k >= 0; k--) {
                int pos = x >> k & 1;
                if (dict[pos][idx] == 0) {
                    dict[pos][idx] = nextIdx++;
                }
                idx = dict[pos][idx];
                cnt[idx] += op;
            }
        }

        public int query(int x) {
            int res = 0;
            int idx = 0;
            for (int k = m - 1; k >= 0; k--) {
                int pos = x >> k & 1;
                if (cnt[dict[1 - pos][idx]] != 0) {
                    res |= 1 << k;
                    idx = dict[1 - pos][idx];
                } else {
                    idx = dict[pos][idx];
                }
            }
            return res;
        }
    }
}
/*
1938. 查询最大基因差
https://leetcode.cn/problems/maximum-genetic-difference-query/

第 250 场周赛 T4。

给你一棵 n 个节点的有根树，节点编号从 0 到 n - 1 。每个节点的编号表示这个节点的 独一无二的基因值 （也就是说节点 x 的基因值为 x）。两个基因值的 基因差 是两者的 异或和 。给你整数数组 parents ，其中 parents[i] 是节点 i 的父节点。如果节点 x 是树的 根 ，那么 parents[x] == -1 。
给你查询数组 queries ，其中 queries[i] = [nodei, vali] 。对于查询 i ，请你找到 vali 和 pi 的 最大基因差 ，其中 pi 是节点 nodei 到根之间的任意节点（包含 nodei 和根节点）。更正式的，你想要最大化 vali XOR pi 。
请你返回数组 ans ，其中 ans[i] 是第 i 个查询的答案。
提示：
2 <= parents.length <= 10^5
对于每个 不是 根节点的 i ，有 0 <= parents[i] <= parents.length - 1 。
parents[root] == -1
1 <= queries.length <= 3 * 10^4
0 <= nodei <= parents.length - 1
0 <= vali <= 2 * 10^5

离线询问 + 0-1 Trie
相似题目: 421. 数组中两个数的最大异或值
https://leetcode.cn/problems/maximum-xor-of-two-numbers-in-an-array/
1707. 与数组中元素的最大异或值
https://leetcode.cn/problems/maximum-xor-with-an-element-from-array/
1938. 查询最大基因差
https://leetcode.cn/problems/maximum-genetic-difference-query/
$2479. 两个不重叠子树的最大异或值
https://leetcode.cn/problems/maximum-xor-of-two-non-overlapping-subtrees/description/
 */