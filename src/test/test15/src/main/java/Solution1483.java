public class Solution1483 {
    static class TreeAncestor {
        // pa[x][i] 表示节点 x 的 2^i 个祖先节点，若不存在，用 -1 表示
        private final int[][] pa;

        public TreeAncestor(int n, int[] parent) {
            // n 的二进制长度
            int m = 32 - Integer.numberOfLeadingZeros(n);
            pa = new int[n][m];
            for (int i = 0; i < n; i++) {
                pa[i][0] = parent[i];
            }

            for (int x = 0; x < n; x++) {
                for (int i = 0; i + 1 < m; i++) {
                    int fa = pa[x][i];
                    pa[x][i + 1] = fa < 0 ? -1 : pa[fa][i];
                }
            }
        }

        public int getKthAncestor(int node, int k) {
            // k 的二进制长度
            int m = 32 - Integer.numberOfLeadingZeros(k);
            for (int i = 0; i < m; i++) {
                if ((k >> i & 1) == 1) {
                    node = pa[node][i];
                    if (node < 0) {
                        break;
                    }
                }
            }
            return node;
        }
    }
}
/*
1483. 树节点的第 K 个祖先
https://leetcode.cn/problems/kth-ancestor-of-a-tree-node/

给你一棵树，树上有 n 个节点，按从 0 到 n-1 编号。树以父节点数组的形式给出，其中 parent[i] 是节点 i 的父节点。树的根节点是编号为 0 的节点。
树节点的第 k 个祖先节点是从该节点到根节点路径上的第 k 个节点。
实现 TreeAncestor 类：
- TreeAncestor（int n， int[] parent） 对树和父数组中的节点数初始化对象。
- getKthAncestor(int node, int k) 返回节点 node 的第 k 个祖先节点。如果不存在这样的祖先节点，返回 -1 。
提示：
1 <= k <= n <= 5 * 10^4
parent[0] == -1 表示编号为 0 的节点是根节点。
对于所有的 0 < i < n ，0 <= parent[i] < n 总成立
0 <= node < n
至多查询 5 * 10^4 次

倍增法求 LCA
相似题目: C. Duff in the Army
https://codeforces.com/contest/587/problem/C
E. Minimum spanning tree for each edge
https://codeforces.com/contest/609/problem/E
F. Drivers Dissatisfaction
https://codeforces.com/contest/733/problem/F
E. The Number Games
https://codeforces.com/contest/980/problem/E
 */