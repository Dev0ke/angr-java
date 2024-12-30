import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution1992 {
    private static final int[][] DIRECTIONS = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public int[][] findFarmland(int[][] land) {
        int m = land.length;
        int n = land[0].length;

        DSU dsu = new DSU(m * n);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (land[i][j] == 1) {
                    for (int[] dir : DIRECTIONS) {
                        int nx = i + dir[0];
                        int ny = j + dir[1];
                        if (nx >= 0 && nx < m && ny >= 0 && ny < n && land[nx][ny] == 1) {
                            dsu.union(i * n + j, nx * n + ny);
                        }
                    }
                }
            }
        }

        Map<Integer, List<int[]>> groupsMap = new HashMap<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (land[i][j] == 1) {
                    int pa = dsu.fa[i * n + j];
                    groupsMap.computeIfAbsent(pa, key -> new ArrayList<>()).add(new int[]{i, j});
                }
            }
        }
        List<int[]> resList = new ArrayList<>();
        for (List<int[]> list : groupsMap.values()) {
            int[] x1y1 = list.get(0);
            int[] x2y2 = list.get(list.size() - 1);
            resList.add(new int[]{x1y1[0], x1y1[1], x2y2[0], x2y2[1]});
        }
        return resList.toArray(int[][]::new);
    }

    private static class DSU {
        int[] fa;

        public DSU(int n) {
            fa = new int[n];
            for (int i = 0; i < n; i++) {
                fa[i] = i;
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
            fa[rootQ] = rootP;
        }
    }
}
/*
1992. 找到所有的农场组
https://leetcode.cn/problems/find-all-groups-of-farmland/

第 60 场双周赛 T2。

给你一个下标从 0 开始，大小为 m x n 的二进制矩阵 land ，其中 0 表示一单位的森林土地，1 表示一单位的农场土地。
为了让农场保持有序，农场土地之间以矩形的 农场组 的形式存在。每一个农场组都 仅 包含农场土地。且题目保证不会有两个农场组相邻，
也就是说一个农场组中的任何一块土地都 不会 与另一个农场组的任何一块土地在四个方向上相邻。
land 可以用坐标系统表示，其中 land 左上角坐标为 (0, 0) ，右下角坐标为 (m-1, n-1) 。请你找到所有 农场组 最左上角和最右下角的坐标。
一个左上角坐标为 (r1, c1) 且右下角坐标为 (r2, c2) 的 农场组 用长度为 4 的数组 [r1, c1, r2, c2] 表示。
请你返回一个二维数组，它包含若干个长度为 4 的子数组，每个子数组表示 land 中的一个 农场组 。如果没有任何农场组，请你返回一个空数组。
可以以 任意顺序 返回所有农场组。
提示：
m == land.length
n == land[i].length
1 <= m, n <= 300
land 只包含 0 和 1 。
农场组都是 矩形 的形状。

并查集。连片
然后找出 parent[] 值相同的 最大/最小值，分别对应左上角/右下角
相似题目: 200. 岛屿数量
https://leetcode.cn/problems/number-of-islands/
 */