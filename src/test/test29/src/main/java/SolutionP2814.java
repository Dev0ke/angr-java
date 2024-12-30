import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

public class SolutionP2814 {
    private static final int[][] DIRECTIONS = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    private static final int INF = (int) 1e9;

    public int minimumSeconds(List<List<String>> land) {
        int n = land.size();
        int m = land.get(0).size();
        int[][] time = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(time[i], INF);
        }
        int sx = -1, sy = -1, tx = -1, ty = -1;
        Queue<int[]> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                String v = land.get(i).get(j);
                if (v.equals("*")) {
                    time[i][j] = 0;
                    q.add(new int[]{i, j});
                } else if (v.equals("S")) {
                    sx = i;
                    sy = j;
                } else if (v.equals("D")) {
                    tx = i;
                    ty = j;
                } else if (v.equals("X")) {
                    time[i][j] = 0;
                }
            }
        }
        int t = 0;
        while (!q.isEmpty()) {
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                int[] top = q.remove();
                int cx = top[0], cy = top[1];
                for (int[] d : DIRECTIONS) {
                    int nx = cx + d[0];
                    int ny = cy + d[1];
                    if (nx >= 0 && nx < n && ny >= 0 && ny < m
                            && time[nx][ny] == INF && (nx != tx || ny != ty)) {
                        time[nx][ny] = t + 1;
                        q.add(new int[]{nx, ny});
                    }
                }
            }
            t++;
        }

        // 第 2 次 BFS
        q.add(new int[]{sx, sy});
        int ans = 1;
        while (!q.isEmpty()) {
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                int[] top = q.remove();
                int cx = top[0], cy = top[1];
                for (int[] d : DIRECTIONS) {
                    int nx = cx + d[0];
                    int ny = cy + d[1];
                    if (nx >= 0 && nx < n && ny >= 0 && ny < m
                            && time[nx][ny] > ans) {
                        if (nx == tx && ny == ty) return ans;
                        time[nx][ny] = 0;
                        q.add(new int[]{nx, ny});
                    }
                }
            }
            ans++;
        }
        return -1;
    }
}
/*
$2814. 避免淹死并到达目的地的最短时间
https://leetcode.cn/problems/minimum-time-takes-to-reach-destination-without-drowning/description/

现给定一个 n * m 的索引从 0 开始的二维字符串网格 land，目前你站在为 "S" 的单元格上，你需要到达为 "D" 的单元格。在这片区域上还有另外三种类型的单元格：
- "."：这些单元格是空的。
- "X"：这些单元格是石头。
- "*"：这些单元格被淹没了。
每秒钟，你可以移动到与当前单元格共享边的单元格（如果它存在）。此外，每秒钟，与被淹没的单元格共享边的每个 空单元格 也会被淹没。
在你的旅程中，有两个需要注意的问题：
- 你不能踩在石头单元格上。
- 你不能踩在被淹没的单元格上，因为你会淹死（同时，你也不能踩在在你踩上时会被淹没的单元格上）。
返回从起始位置到达目标位置所需的 最小 时间（以秒为单位），如果不可能达到目标位置，则返回 -1。
注意，目标位置永远不会被淹没。
提示：
2 <= n, m <= 100
land 只由 "S", "D", ".", "*" 和 "X" 组成。
恰好有一个单元格等于 "S"。
恰好有一个单元格等于 "D"。

两次BFS。
 */