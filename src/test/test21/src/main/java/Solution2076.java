import java.util.Arrays;

public class Solution2076 {
    public boolean[] friendRequests(int n, int[][] restrictions, int[][] requests) {
        UnionFind unionFind = new UnionFind(n);
        int len = requests.length;
        boolean[] res = new boolean[len];
        Arrays.fill(res, true);

        for (int i = 0; i < len; i++) {
            // 先并
            unionFind.union(requests[i][0], requests[i][1]);
            for (int[] restriction : restrictions) {
                if (unionFind.connected(restriction[0], restriction[1])) {
                    res[i] = false;
                    // 不行就复原
                    unionFind.reset();
                    break;
                }
            }
        }
        return res;
    }

    private static class UnionFind {
        // 记录每个节点的父节点
        int[] parent;
        // 记录每棵树的重量
        int[] rank;
        // (可选) 连通分量
        int count;
        // 记录上一个状态
        int[] preParent;

        public UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = i;
            }
            count = n;
        }

        // 返回节点 x 的根节点
        private int find(int x) {
            int ret = x;
            while (ret != parent[ret]) {
                // 路径压缩
                parent[ret] = parent[parent[ret]];
                ret = parent[ret];
            }
            return ret;
        }

        // 将 p 和 q 连通
        public void union(int p, int q) {
            preParent = parent.clone();
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP != rootQ) {
                if (rank[rootP] > rank[rootQ]) {
                    parent[rootQ] = rootP;
                } else if (rank[rootP] < rank[rootQ]) {
                    parent[rootP] = rootQ;
                } else {
                    parent[rootQ] = rootP;
                    // 重量平衡
                    rank[rootP] += 1;
                }
                count--;
            }
        }

        // p 和 q 是否连通
        public boolean connected(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            return rootP == rootQ;
        }

        public void reset() {
            parent = preParent.clone();
        }
    }
}
/*
2076. 处理含限制条件的好友请求
https://leetcode.cn/problems/process-restricted-friend-requests/

第 267 场周赛 T4。

给你一个整数 n ，表示网络上的用户数目。每个用户按从 0 到 n - 1 进行编号。
给你一个下标从 0 开始的二维整数数组 restrictions ，其中 restrictions[i] = [xi, yi] 意味着用户 xi 和用户 yi 不能 成为 朋友 ，
不管是 直接 还是通过其他用户 间接 。
最初，用户里没有人是其他用户的朋友。给你一个下标从 0 开始的二维整数数组 requests 表示好友请求的列表，
其中 requests[j] = [uj, vj] 是用户 uj 和用户 vj 之间的一条好友请求。
如果 uj 和 vj 可以成为 朋友 ，那么好友请求将会 成功 。每个好友请求都会按列表中给出的顺序进行处理（即，requests[j] 会在 requests[j + 1] 前）。
一旦请求成功，那么对所有未来的好友请求而言， uj 和 vj 将会 成为直接朋友 。
返回一个 布尔数组 result ，其中元素遵循此规则：如果第 j 个好友请求 成功 ，那么 result[j] 就是 true ；否则，为 false 。
注意：如果 uj 和 vj 已经是直接朋友，那么他们之间的请求将仍然 成功 。
提示：
2 <= n <= 1000
0 <= restrictions.length <= 1000
restrictions[i].length == 2
0 <= xi, yi <= n - 1
xi != yi
1 <= requests.length <= 1000
requests[j].length == 2
0 <= uj, vj <= n - 1
uj != vj

回退并查集。
 */