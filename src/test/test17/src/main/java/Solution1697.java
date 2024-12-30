import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

public class Solution1697 {
    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        int m = edgeList.length;
        int q = queries.length;

        // 按 dis 升序排序
        Arrays.sort(edgeList, Comparator.comparingInt(o -> o[2]));

        // 离线
        Integer[] qIds = IntStream.range(0, q).boxed().toArray(Integer[]::new);
        Arrays.sort(qIds, Comparator.comparingInt(o -> queries[o][2]));

        DSU dsu = new DSU(n);
        int eId = 0;
        boolean[] res = new boolean[q];
        for (int qId : qIds) {
            while (eId < m && edgeList[eId][2] < queries[qId][2]) {
                dsu.union(edgeList[eId][0], edgeList[eId][1]);
                eId++;
            }
            res[qId] = (dsu.find(queries[qId][0]) == dsu.find(queries[qId][1]));
        }
        return res;
    }

    private static class DSU {
        // 父节点数组/祖先数组
        int[] fa;

        // 初始化
        public DSU(int n) {
            fa = new int[n];
            for (int i = 0; i < n; i++) {
                fa[i] = i;
            }
        }

        // 查找
        int find(int x) {
            // 路径压缩
            if (x != fa[x]) {
                fa[x] = find(fa[x]);
            }
            return fa[x];
        }

        // 合并
        void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ) {
                return;
            }
            fa[rootQ] = rootP;
        }
    }
}
/*
1697. 检查边长度限制的路径是否存在
https://leetcode.cn/problems/checking-existence-of-edge-length-limited-paths/

给你一个 n 个点组成的无向图边集 edgeList ，其中 edgeList[i] = [ui, vi, disi] 表示点 ui 和点 vi 之间有一条长度为 disi 的边。请注意，两个点之间可能有 超过一条边 。
给你一个查询数组queries ，其中 queries[j] = [pj, qj, limitj] ，
你的任务是对于每个查询 queries[j] ，判断是否存在从 pj 到 qj 的路径，且这条路径上的每一条边都 严格小于 limitj 。
请你返回一个 布尔数组 answer ，其中 answer.length == queries.length ，当 queries[j] 的查询结果为 true 时， answer 第 j 个值为 true ，否则为 false 。
提示：
2 <= n <= 10^5
1 <= edgeList.length, queries.length <= 10^5
edgeList[i].length == 3
queries[j].length == 3
0 <= ui, vi, pj, qj <= n - 1
ui != vi
pj != qj
1 <= disi, limitj <= 10^9
两个点之间可能有 多条 边。

并查集 + 离线思维
何为 "离线"？：询问是全部提前给出的，不必按照询问的顺序依次对它们进行处理
参考零神的 https://leetcode.cn/problems/checking-existence-of-edge-length-limited-paths/solution/jian-cha-bian-chang-du-xian-zhi-de-lu-ji-c756/
 */