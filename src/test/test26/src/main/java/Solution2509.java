public class Solution2509 {
    public int[] cycleLengthQueries(int n, int[][] queries) {
        int m = queries.length;
        int[] res = new int[m];
        for (int i = 0; i < m; i++) {
            int u = queries[i][0];
            int v = queries[i][1];
            int ans = 0;
            while (u != v) {
                if (u > v) {
                    u /= 2;
                } else {
                    v /= 2;
                }
                ans++;
            }
            res[i] = ans + 1;
        }
        return res;
    }
}
/*
2509. 查询树中环的长度
https://leetcode.cn/problems/cycle-length-queries-in-a-tree/

第 324 场周赛 T4。

给你一个整数 n ，表示你有一棵含有 2n - 1 个节点的 完全二叉树 。根节点的编号是 1 ，树中编号在[1, 2n - 1 - 1] 之间，编号为 val 的节点都有两个子节点，满足：
- 左子节点的编号为 2 * val
- 右子节点的编号为 2 * val + 1
给你一个长度为 m 的查询数组 queries ，它是一个二维整数数组，其中 queries[i] = [ai, bi] 。对于每个查询，求出以下问题的解：
1. 在节点编号为 ai 和 bi 之间添加一条边。
2. 求出图中环的长度。
3. 删除节点编号为 ai 和 bi 之间新添加的边。
注意：
- 环 是开始和结束于同一节点的一条路径，路径中每条边都只会被访问一次。
- 环的长度是环中边的数目。
- 在树中添加额外的边后，两个点之间可能会有多条边。
请你返回一个长度为 m 的数组 answer ，其中 answer[i] 是第 i 个查询的结果。
提示：
2 <= n <= 30
m == queries.length
1 <= m <= 10^5
queries[i].length == 2
1 <= ai, bi <= 2n - 1
ai != bi

最近公共祖先 LCA
对于每组查询，两个点到 LCA 的距离 + 1 即为答案。
 */