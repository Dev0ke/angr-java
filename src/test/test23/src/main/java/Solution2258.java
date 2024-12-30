import java.util.LinkedList;
import java.util.Queue;

public class Solution2258 {
    private static final int[][] DIRECTIONS = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    private int M;
    private int N;

    public int maximumMinutes(int[][] grid) {
        M = grid.length;
        N = grid[0].length;

        int left = 0;
        int right = 20000;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int[][] gridCopy = new int[M][N];
            for (int i = 0; i < M; i++) {
                System.arraycopy(grid[i], 0, gridCopy[i], 0, N);
            }
            // 边界二分 F, F,..., F, [T, T,..., T]
            // ----------------------^
            if (!checkMid(gridCopy, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left == 20000 ? 1000000000 : left - 1;
    }

    private boolean checkMid(int[][] grid, int mid) {
        Queue<int[]> fires = new LinkedList<>();
        // 在初始位置停留 mid 分钟 火势蔓延
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == 1) {
                    fires.add(new int[]{i, j});
                }
            }
        }
        int minutes = 0;
        while (!fires.isEmpty()) {
            int size = fires.size();
            if (minutes == mid) {
                break;
            }
            minutes++;

            for (int i = 0; i < size; i++) {
                int[] cur = fires.remove();
                // 烧到人，直接 G
                if (cur[0] == 0 && cur[1] == 0) {
                    return false;
                }

                for (int[] dir : DIRECTIONS) {
                    int nextM = cur[0] + dir[0];
                    int nextN = cur[1] + dir[1];
                    if (nextM >= 0 && nextM < M && nextN >= 0 && nextN < N && grid[nextM][nextN] == 0) {
                        grid[nextM][nextN] = 1;
                        fires.add(new int[]{nextM, nextN});
                    }
                }
            }
        }

        // 开始逃离火灾
        Queue<int[]> player = new LinkedList<>();
        boolean[][] visited = new boolean[M][N];
        player.add(new int[]{0, 0});
        visited[0][0] = true;
        while (!player.isEmpty()) {
            int size = player.size();
            for (int i = 0; i < size; i++) {
                int[] cur = player.remove();
                if (cur[0] == M - 1 && cur[1] == N - 1) {
                    return true;
                }
                if (grid[cur[0]][cur[1]] == 1) {
                    continue;
                }

                for (int[] dir : DIRECTIONS) {
                    int nextM = cur[0] + dir[0];
                    int nextN = cur[1] + dir[1];
                    if (nextM >= 0 && nextM < M && nextN >= 0 && nextN < N && !visited[nextM][nextN] && grid[nextM][nextN] == 0) {
                        visited[nextM][nextN] = true;
                        player.add(new int[]{nextM, nextN});
                    }
                }
            }

            int fireSize = fires.size();
            for (int i = 0; i < fireSize; i++) {
                int[] cur = fires.remove();
                // 烧到 安全屋，直接 G
                if (cur[0] == M - 1 && cur[1] == N - 1) {
                    return false;
                }

                for (int[] dir : DIRECTIONS) {
                    int nextM = cur[0] + dir[0];
                    int nextN = cur[1] + dir[1];
                    if (nextM >= 0 && nextM < M && nextN >= 0 && nextN < N && grid[nextM][nextN] == 0) {
                        grid[nextM][nextN] = 1;
                        fires.add(new int[]{nextM, nextN});
                    }
                }
            }
        }
        return false;
    }
}
/*
2258. 逃离火灾
https://leetcode.cn/problems/escape-the-spreading-fire/

第 77 场双周赛 T4。

给你一个下标从 0 开始大小为 m x n 的二维整数数组 grid ，它表示一个网格图。每个格子为下面 3 个值之一：
- 0 表示草地。
- 1 表示着火的格子。
- 2 表示一座墙，你跟火都不能通过这个格子。
一开始你在最左上角的格子 (0, 0) ，你想要到达最右下角的安全屋格子 (m - 1, n - 1) 。每一分钟，你可以移动到 相邻 的草地格子。
每次你移动 之后 ，着火的格子会扩散到所有不是墙的 相邻 格子。
请你返回你在初始位置可以停留的 最多 分钟数，且停留完这段时间后你还能安全到达安全屋。如果无法实现，请你返回 -1 。
如果不管你在初始位置停留多久，你 总是 能到达安全屋，请你返回 10^9 。
注意，如果你到达安全屋后，火马上到了安全屋，这视为你能够安全到达安全屋。
如果两个格子有共同边，那么它们为 相邻 格子。
提示：
m == grid.length
n == grid[i].length
2 <= m, n <= 300
4 <= m * n <= 2 * 10^4
grid[i][j] 是 0 ，1 或者 2 。
grid[0][0] == grid[m - 1][n - 1] == 0

BFS + 二分。着火的格子扩散和人能到达的位置均满足 BFS 模型。
停留时间也显然满足单调性（如果能停留到 n 分钟，则必定也能停留 n-1 分钟），可用二分法求出在初始位置可以停留的 最多 分钟数。
因为数据范围 m * n <= 2 * 10^4，着火的格子每分钟扩散 1 格，所以二分上界可以设置为 2 * 10^4（当然设置为 10^9 也能过）。
时间复杂度: O(m*n*logT)，其中 T = 2 * 10^4。
 */