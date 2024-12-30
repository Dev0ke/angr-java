import java.util.LinkedList;
import java.util.Queue;

public class Solution542 {
    private static final int[][] DIRECTIONS = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public int[][] updateMatrix(int[][] mat) {
        int M = mat.length;
        int N = mat[0].length;

        // BFS
        Queue<int[]> queue = new LinkedList<>();
        int[][] distances = new int[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (mat[i][j] == 0) {
                    queue.add(new int[]{i, j});
                    distances[i][j] = 0;
                } else {
                    distances[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] cur = queue.remove();
            int curM = cur[0];
            int curN = cur[1];
            int curDist = distances[curM][curN];

            for (int[] dir : DIRECTIONS) {
                int nextM = curM + dir[0];
                int nextN = curN + dir[1];
                if (nextM >= 0 && nextM < M && nextN >= 0 && nextN < N
                        && distances[nextM][nextN] > curDist + 1) {
                    distances[nextM][nextN] = curDist + 1;
                    queue.add(new int[]{nextM, nextN});
                }
            }
        }
        return distances;
    }
}
/*
542. 01 矩阵
https://leetcode.cn/problems/01-matrix/

给定一个由 0 和 1 组成的矩阵 mat，请输出一个大小相同的矩阵，其中每一个格子是 mat 中对应位置元素到最近的 0 的距离。
两个相邻元素间的距离为 1 。
提示：
m == mat.length
n == mat[i].length
1 <= m, n <= 10^4
1 <= m * n <= 10^4
mat[i][j] is either 0 or 1.
mat 中至少有一个 0

BFS。
 */