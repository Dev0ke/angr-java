public class Solution1319 {
    public int makeConnected(int n, int[][] connections) {
        int len = connections.length;

        // 连接 n 台计算机 至少需要 n-1 根线
        if (len < n - 1) {
            return -1;
        }
        DSU unionFind = new DSU(n);
        for (int[] connection : connections) {
            unionFind.union(connection[0], connection[1]);
        }
        return unionFind.sz - 1;
    }

    static class DSU {
        int[] fa;
        int sz;

        public DSU(int n) {
            fa = new int[n];
            for (int i = 0; i < n; i++) {
                fa[i] = i;
            }
            sz = n;
        }

        int find(int x) { // 查找
            return x == fa[x] ? fa[x] : (fa[x] = find(fa[x]));
        }

        void union(int p, int q) { // 合并
            p = find(p);
            q = find(q);
            if (p == q) return;
            fa[q] = p;
            sz--;
        }
    }
}
/*
1319. 连通网络的操作次数
https://leetcode.cn/problems/number-of-operations-to-make-network-connected/

第 171 场周赛 T3。

用以太网线缆将 n 台计算机连接成一个网络，计算机的编号从 0 到 n-1。线缆用 connections 表示，其中 connections[i] = [a, b] 连接了计算机 a 和 b。
网络中的任何一台计算机都可以通过网络直接或者间接访问同一个网络中其他任意一台计算机。
给你这个计算机网络的初始布线 connections，你可以拔开任意两台直连计算机之间的线缆，并用它连接一对未直连的计算机。
请你计算并返回使所有计算机都连通所需的最少操作次数。如果不可能，则返回 -1 。
提示：
1 <= n <= 10^5
1 <= connections.length <= min(n*(n-1)/2, 10^5)
connections[i].length == 2
0 <= connections[i][0], connections[i][1] < n
connections[i][0] != connections[i][1]
没有重复的连接。
两台计算机不会通过多条线缆连接。

并查集。
连接 n 台计算机 至少需要 n-1 根线
如果线数量不够，返回 -1
最少操作次数 等于 当前连通分量 - 1
 */