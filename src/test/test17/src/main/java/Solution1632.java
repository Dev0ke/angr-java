import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Solution1632 {
    // 130ms
    static class V1 {
        public int[][] matrixRankTransform(int[][] matrix) {
            int m = matrix.length, n = matrix[0].length;
            DSU uf = new DSU(m * n);
            for (int i = 0; i < m; i++) {
                Map<Integer, List<Integer>> num2indexList = new HashMap<>();
                for (int j = 0; j < n; j++) {
                    num2indexList.computeIfAbsent(matrix[i][j], e -> new ArrayList<>()).add(i * n + j);
                }
                for (List<Integer> indexList : num2indexList.values()) {
                    for (int k = 1; k < indexList.size(); k++) {
                        uf.union(indexList.get(0), indexList.get(k));
                    }
                }
            }
            for (int j = 0; j < n; j++) {
                Map<Integer, List<Integer>> groupIds = new HashMap<>();
                for (int i = 0; i < m; i++) {
                    groupIds.computeIfAbsent(matrix[i][j], e -> new ArrayList<>()).add(i * n + j);
                }
                for (List<Integer> ids : groupIds.values()) {
                    for (int k = 1; k < ids.size(); k++) {
                        uf.union(ids.get(0), ids.get(k));
                    }
                }
            }

            int[] degree = new int[m * n];
            Map<Integer, List<Integer>> adj = new HashMap<>();
            for (int i = 0; i < m; i++) {
                Map<Integer, Integer> num2index = new HashMap<>();
                for (int j = 0; j < n; j++) {
                    num2index.put(matrix[i][j], i * n + j);
                }
                List<Integer> sortedArray = new ArrayList<>(num2index.keySet());
                Collections.sort(sortedArray);
                for (int k = 1; k < sortedArray.size(); k++) {
                    int root1 = uf.find(num2index.get(sortedArray.get(k - 1)));
                    int root2 = uf.find(num2index.get(sortedArray.get(k)));
                    degree[root2]++;
                    adj.computeIfAbsent(root1, e -> new ArrayList<>()).add(root2);
                }
            }
            for (int j = 0; j < n; j++) {
                Map<Integer, Integer> num2index = new HashMap<>();
                for (int i = 0; i < m; i++) {
                    num2index.put(matrix[i][j], i * n + j);
                }
                List<Integer> sortedArray = new ArrayList<>(num2index.keySet());
                Collections.sort(sortedArray);
                for (int k = 1; k < sortedArray.size(); k++) {
                    int root1 = uf.find(num2index.get(sortedArray.get(k - 1)));
                    int root2 = uf.find(num2index.get(sortedArray.get(k)));
                    degree[root2]++;
                    adj.computeIfAbsent(root1, e -> new ArrayList<>()).add(root2);
                }
            }

            Set<Integer> rootSet = new HashSet<>();
            int[] ranks = new int[m * n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    int root = uf.find(i * n + j);
                    rootSet.add(root);
                    ranks[root] = 1;
                }
            }
            Queue<Integer> queue = new ArrayDeque<>();
            for (int x : rootSet) {
                if (degree[x] == 0) {
                    queue.add(x);
                }
            }
            while (!queue.isEmpty()) {
                int x = queue.poll();
                for (int y : adj.getOrDefault(x, new ArrayList<>())) {
                    if (--degree[y] == 0) {
                        queue.add(y);
                    }
                    ranks[y] = Math.max(ranks[y], ranks[x] + 1);
                }
            }
            int[][] res = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    int root = uf.find(i * n + j);
                    res[i][j] = ranks[root];
                }
            }
            return res;
        }

        static class DSU {
            int[] fa;

            public DSU(int n) {
                fa = new int[n];
                for (int i = 0; i < n; i++) fa[i] = i;
            }

            int find(int x) {
                return x == fa[x] ? fa[x] : (fa[x] = find(fa[x]));
            }

            void union(int p, int q) {
                p = find(p);
                q = find(q);
                if (p == q) return;
                fa[q] = p;
            }
        }
    }

    // 189ms
    static class V2 {
        // CF650C
        // https://codeforces.com/contest/650/submission/16573674
        public int[][] matrixRankTransform(int[][] matrix) {
            int n = matrix.length;
            int m = matrix[0].length;
            int nm = n * m;
            int k = 0;
            Pair[] p = new Pair[nm];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    p[k++] = new Pair(i, j, matrix[i][j]);
                }
            }
            Arrays.sort(p, Comparator.comparingInt(o -> o.v));

            int[][] a = new int[n][m];
            int[] row = new int[n + 2];
            int[] col = new int[m + 2];
            for (int i = 0; i < nm; ) {
                // 分组循环
                int st = i;
                for (i++; i < nm && p[i].v == p[st].v; i++) {
                }

                DSU ds = new DSU(i - st);
                Pair[] A = new Pair[i - st];
                Pair[] B = new Pair[i - st];

                for (k = st; k < i; k++) {
                    A[k - st] = new Pair(p[k].x, p[k].y, k - st);
                    B[k - st] = new Pair(p[k].x, p[k].y, k - st);
                    ds.max[k - st] = Math.max(row[p[k].x], col[p[k].y]);
                }

                Arrays.sort(A, Comparator.comparingInt(o -> o.x));
                Arrays.sort(B, Comparator.comparingInt(o -> o.y));

                for (int x = 1; x < (i - st); x++) {
                    if (A[x].x == A[x - 1].x) {
                        ds.union(A[x].v, A[x - 1].v);
                    }
                    if (B[x].y == B[x - 1].y) {
                        ds.union(B[x].v, B[x - 1].v);
                    }
                }

                for (int x = st; x < i; x++) {
                    int v = ds.max[ds.find(x - st)] + 1;
                    a[p[x].x][p[x].y] = v;
                    row[p[x].x] = Math.max(row[p[x].x], v);
                    col[p[x].y] = Math.max(col[p[x].y], v);
                }
            }
            return a;
        }

        static class Pair {
            int x, y, v;

            public Pair(int x, int y, int v) {
                this.x = x;
                this.y = y;
                this.v = v;
            }
        }

        static class DSU {
            int[] fa;
            int[] max;

            public DSU(int n) {
                fa = new int[n];
                max = new int[n];
                for (int i = 0; i < n; i++) fa[i] = i;
            }

            int find(int x) {
                return x == fa[x] ? fa[x] : (fa[x] = find(fa[x]));
            }

            void union(int p, int q) {
                p = find(p);
                q = find(q);
                if (p == q) return;
                max[p] = max[q] = Math.max(max[p], max[q]);
                fa[q] = p;
            }
        }
    }
}
/*
1632. 矩阵转换后的秩
https://leetcode.cn/problems/rank-transform-of-a-matrix/description/

给你一个 m x n 的矩阵 matrix ，请你返回一个新的矩阵 answer ，其中 answer[row][col] 是 matrix[row][col] 的秩。
每个元素的 秩 是一个整数，表示这个元素相对于其他元素的大小关系，它按照如下规则计算：
- 秩是从 1 开始的一个整数。
- 如果两个元素 p 和 q 在 同一行 或者 同一列 ，那么：
  - 如果 p < q ，那么 rank(p) < rank(q)
  - 如果 p == q ，那么 rank(p) == rank(q)
  - 如果 p > q ，那么 rank(p) > rank(q)
- 秩 需要越 小 越好。
题目保证按照上面规则 answer 数组是唯一的。
提示：
m == matrix.length
n == matrix[i].length
1 <= m, n <= 500
-10^9 <= matrix[row][col] <= 10^9

用 V1 的方法交 CF 会 TLE，必须用 V2。
但是在 lc，V2 跑的比 V1 慢。。
相似题目: CF650C
 */