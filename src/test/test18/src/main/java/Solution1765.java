import java.util.LinkedList;
import java.util.Queue;

public class Solution1765 {
    private static final int[][] DIRECTIONS = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public int[][] highestPeak(int[][] isWater) {
        int M = isWater.length;
        int N = isWater[0].length;

        // BFS
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (isWater[i][j] == 1) {
                    queue.add(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }

        int height = 0;
        int[][] res = new int[M][N];
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.remove();
                int curM = cur[0];
                int curN = cur[1];
                res[curM][curN] = height;

                for (int[] dir : DIRECTIONS) {
                    int nextM = curM + dir[0];
                    int nextN = curN + dir[1];
                    if (nextM >= 0 && nextM < M && nextN >= 0 && nextN < N && !visited[nextM][nextN]) {
                        visited[nextM][nextN] = true;
                        queue.add(new int[]{nextM, nextN});
                    }
                }
            }
            height++;
        }
        return res;
    }
}
/*
1765. 地图中的最高点
https://leetcode.cn/problems/map-of-highest-peak/

给你一个大小为 m x n 的整数矩阵 isWater ，它代表了一个由 陆地 和 水域 单元格组成的地图。
- 如果 isWater[i][j] == 0 ，格子 (i, j) 是一个 陆地 格子。
- 如果 isWater[i][j] == 1 ，格子 (i, j) 是一个 水域 格子。
你需要按照如下规则给每个单元格安排高度：
- 每个格子的高度都必须是非负的。
- 如果一个格子是是 水域 ，那么它的高度必须为 0 。
- 任意相邻的格子高度差 至多 为 1 。当两个格子在正东、南、西、北方向上相互紧挨着，就称它们为相邻的格子。（也就是说它们有一条公共边）
找到一种安排高度的方案，使得矩阵中的最高高度值 最大 。
请你返回一个大小为 m x n 的整数矩阵 height ，其中 height[i][j] 是格子 (i, j) 的高度。如果有多种解法，请返回 任意一个 。
提示：
m == isWater.length
n == isWater[i].length
1 <= m, n <= 1000
isWater[i][j] 要么是 0 ，要么是 1 。
至少有 1 个水域格子。

多源 BFS
 */