import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

public class Solution2503 {
    private static final int[][] DIRECTIONS = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public int[] maxPoints(int[][] grid, int[] queries) {
        int m = grid.length;
        int n = grid[0].length;
        int k = queries.length;

        List<Node> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                list.add(new Node(i, j, grid[i][j]));
            }
        }
        // 升序排列
        list.sort(Comparator.comparingInt(o -> o.h));

        // 离线
        Integer[] qIds = IntStream.range(0, k).boxed().toArray(Integer[]::new);
        Arrays.sort(qIds, Comparator.comparingInt(o -> queries[o]));

        int[] res = new int[k];
        DSU DSU = new DSU(m * n);

        int id = 0;
        for (int qId : qIds) {
            int h = queries[qId];
            while (id < m * n && list.get(id).h < h) {
                int curM = list.get(id).m;
                int curN = list.get(id).n;
                for (int[] dir : DIRECTIONS) {
                    int nextM = curM + dir[0];
                    int nextN = curN + dir[1];
                    if (nextM >= 0 && nextM < m && nextN >= 0 && nextN < n
                            && grid[nextM][nextN] < h) {
                        DSU.union(curM * n + curN, nextM * n + nextN);
                    }
                }
                id++;
            }
            if (grid[0][0] < h) {
                res[qId] = DSU.sz[0];
            }
        }
        return res;
    }

    private static class DSU {
        int[] fa;
        int[] sz;

        public DSU(int n) {
            int N = n + 1;
            fa = new int[N];
            sz = new int[N];
            for (int i = 0; i < N; i++) {
                fa[i] = i;
                sz[i] = 1;
            }
        }

        int find(int x) {
            if (x != fa[x]) {
                fa[x] = find(fa[x]);
            }
            return fa[x];
        }

        void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ) {
                return;
            }
            // 合并到较小的节点
            if (rootP < rootQ) {
                fa[rootQ] = rootP;
                sz[rootP] += sz[rootQ];
            } else {
                fa[rootP] = rootQ;
                sz[rootQ] += sz[rootP];
            }
        }
    }

    private static class Node {
        int m;
        int n;
        int h;

        public Node(int m, int n, int h) {
            this.m = m;
            this.n = n;
            this.h = h;
        }
    }
}
/*
2503. 矩阵查询可获得的最大分数
https://leetcode.cn/problems/maximum-number-of-points-from-grid-queries/

第 323 场周赛 T4。

给你一个大小为 m x n 的整数矩阵 grid 和一个大小为 k 的数组 queries 。
找出一个大小为 k 的数组 answer ，且满足对于每个整数 queres[i] ，你从矩阵 左上角 单元格开始，重复以下过程：
- 如果 queries[i] 严格 大于你当前所处位置单元格，如果该单元格是第一次访问，则获得 1 分，并且你可以移动到所有 4 个方向（上、下、左、右）上任一 相邻 单元格。
- 否则，你不能获得任何分，并且结束这一过程。
在过程结束后，answer[i] 是你可以获得的最大分数。注意，对于每个查询，你可以访问同一个单元格 多次 。
返回结果数组 answer 。
提示：
m == grid.length
n == grid[i].length
2 <= m, n <= 1000
4 <= m * n <= 10^5
k == queries.length
1 <= k <= 10^4
1 <= grid[i][j], queries[i] <= 10^6

离线 + 并查集
相似题目: 1697. 检查边长度限制的路径是否存在
https://leetcode.cn/problems/checking-existence-of-edge-length-limited-paths/
 */