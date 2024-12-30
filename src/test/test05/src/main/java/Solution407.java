import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution407 {
    private static final int[][] DIRECTIONS = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public int trapRainWater(int[][] heightMap) {
        int M = heightMap.length;
        int N = heightMap[0].length;
        if (M <= 2 || N <= 2) {
            return 0;
        }

        // x, y, h
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(o -> o[2]));
        boolean[][] visited = new boolean[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (i == 0 || i == M - 1 || j == 0 || j == N - 1) {
                    minHeap.add(new int[]{i, j, heightMap[i][j]});
                    visited[i][j] = true;
                }
            }
        }

        int res = 0;
        while (!minHeap.isEmpty()) {
            int[] cur = minHeap.remove();
            int curH = cur[2];

            for (int[] dir : DIRECTIONS) {
                int nextM = cur[0] + dir[0];
                int nextN = cur[1] + dir[1];
                if (nextM >= 0 && nextM < M && nextN >= 0 && nextN < N && !visited[nextM][nextN]) {
                    if (curH > heightMap[nextM][nextN]) {
                        res += curH - heightMap[nextM][nextN];
                    }
                    int nextH = Math.max(curH, heightMap[nextM][nextN]);
                    minHeap.add(new int[]{nextM, nextN, nextH});
                    visited[nextM][nextN] = true;
                }
            }
        }
        return res;
    }
}
/*
407. 接雨水 II
https://leetcode.cn/problems/trapping-rain-water-ii/

给你一个 m x n 的矩阵，其中的值均为非负整数，代表二维高度图每个单元的高度，请计算图中形状最多能接多少体积的雨水。
提示:
m == heightMap.length
n == heightMap[i].length
1 <= m, n <= 200
0 <= heightMap[i][j] <= 2 * 10^4

最小堆
时间复杂度 O(mnlog(m+n))
空间复杂度 O(mn)
相似题目: 42. 接雨水
https://leetcode.cn/problems/trapping-rain-water/
 */