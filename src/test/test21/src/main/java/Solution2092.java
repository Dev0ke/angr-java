import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Solution2092 {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        TreeMap<Integer, List<int[]>> treeMap = new TreeMap<>();
        for (int[] meeting : meetings) {
            List<int[]> curList = treeMap.getOrDefault(meeting[2], new ArrayList<>());
            curList.add(new int[]{meeting[0], meeting[1]});
            treeMap.put(meeting[2], curList);
        }
        // 并查集
        UnionFind unionFind = new UnionFind(n);
        unionFind.union(0, firstPerson);
        for (Map.Entry<Integer, List<int[]>> entry : treeMap.entrySet()) {
            List<int[]> curList = entry.getValue();
            for (int[] meet : curList) {
                unionFind.union(meet[0], meet[1]);
            }
            for (int[] meet : curList) {
                if (!unionFind.connected(meet[0], 0)) {
                    unionFind.isolate(meet[0]);
                    unionFind.isolate(meet[1]);
                }
            }
        }
        List<Integer> resList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (unionFind.connected(i, 0)) {
                resList.add(i);
            }
        }
        return resList;
    }

    private static class UnionFind {
        // 记录每个节点的父节点
        int[] parent;
        // 记录每棵树的重量
        int[] rank;
        // (可选) 连通分量
        int count;

        // 0 ~ n-1
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

        // 孤立点 x
        public void isolate(int x) {
            if (x != parent[x]) {
                parent[x] = x;
                rank[x] = 1;
                count--;
            }
        }
    }
}
/*
2092. 找出知晓秘密的所有专家
https://leetcode.cn/problems/find-all-people-with-secret/

第 269 场周赛 T4。

给你一个整数 n ，表示有 n 个专家从 0 到 n - 1 编号。另外给你一个下标从 0 开始的二维整数数组 meetings ，
其中 meetings[i] = [xi, yi, timei] 表示专家 xi 和专家 yi 在时间 timei 要开一场会。一个专家可以同时参加 多场会议 。最后，给你一个整数 firstPerson 。
专家 0 有一个 秘密 ，最初，他在时间 0 将这个秘密分享给了专家 firstPerson 。接着，这个秘密会在每次有知晓这个秘密的专家参加会议时进行传播。
更正式的表达是，每次会议，如果专家 xi 在时间 timei 时知晓这个秘密，那么他将会与专家 yi 分享这个秘密，反之亦然。
秘密共享是 瞬时发生 的。也就是说，在同一时间，一个专家不光可以接收到秘密，还能在其他会议上与其他专家分享。
在所有会议都结束之后，返回所有知晓这个秘密的专家列表。你可以按 任何顺序 返回答案。

并查集。
 */