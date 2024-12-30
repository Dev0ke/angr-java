import java.util.ArrayList;
import java.util.List;

public class SolutionP305 {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        int[][] grid = new int[m][n];

        List<Integer> resList = new ArrayList<>();
        DSU dsu = new DSU(m * n);
        for (int[] position : positions) {
            int i = position[0];
            int j = position[1];

            if (grid[i][j] == 0) {
                grid[i][j] = 1;
                // 增加一个岛屿
                dsu.sz++;
                int p = position[0] * n + position[1];

                // up
                if (i - 1 >= 0 && grid[i - 1][j] == 1) {
                    dsu.union(p, p - n);
                }
                // down
                if (i + 1 < m && grid[i + 1][j] == 1) {
                    dsu.union(p, p + n);
                }
                // left
                if (j - 1 >= 0 && grid[i][j - 1] == 1) {
                    dsu.union(p, p - 1);
                }
                // right
                if (j + 1 < n && grid[i][j + 1] == 1) {
                    dsu.union(p, p + 1);
                }
            }
            resList.add(dsu.sz);
        }
        return resList;
    }

    private static class DSU {
        int[] fa;
        int sz;

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
            sz--;
        }
    }
}
/*
$305. 岛屿数量 II
https://leetcode.cn/problems/number-of-islands-ii/

给你一个大小为 m x n 的二进制网格 grid 。网格表示一个地图，其中，0 表示水，1 表示陆地。最初，grid 中的所有单元格都是水单元格（即，所有单元格都是 0）。
可以通过执行 addLand 操作，将某个位置的水转换成陆地。给你一个数组 positions ，其中 positions[i] = [ri, ci] 是要执行第 i 次操作的位置 (ri, ci) 。
返回一个整数数组 answer ，其中 answer[i] 是将单元格 (ri, ci) 转换为陆地后，地图中岛屿的数量。
岛屿 的定义是被「水」包围的「陆地」，通过水平方向或者垂直方向上相邻的陆地连接而成。你可以假设地图网格的四边均被无边无际的「水」所包围。
提示：
1 <= m, n, positions.length <= 10^4
1 <= m * n <= 10^4
positions[i].length == 2
0 <= ri < m
0 <= ci < n
进阶：你可以设计一个时间复杂度 O(k log(mn)) 的算法解决此问题吗？（其中 k == positions.length）

并查集。注意本题的 连通分量 要从 0 开始增加。
 */