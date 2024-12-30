import java.util.LinkedList;
import java.util.Queue;

public class SolutionP286 {
    public void wallsAndGates(int[][] rooms) {
        int M = rooms.length;
        int N = rooms[0].length;
        int[][] direction = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        // BFS
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (rooms[i][j] == 0) {
                    queue.add(new int[]{i, j});
                }
            }
        }
        int distance = 0;
        while (!queue.isEmpty()) {
            distance++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.remove();
                for (int[] dir : direction) {
                    int nextM = cur[0] + dir[0];
                    int nextN = cur[1] + dir[1];
                    if (nextM >= 0 && nextM < M && nextN >= 0 && nextN < N && rooms[nextM][nextN] > distance) {
                        rooms[nextM][nextN] = distance;
                        queue.add(new int[]{nextM, nextN});
                    }
                }
            }
        }
    }
}
/*
$286. 墙与门
https://leetcode.cn/problems/walls-and-gates/

你被给定一个 m × n 的二维网格 rooms ，网格中有以下三种可能的初始化值：
1. -1 表示墙或是障碍物
2. 0 表示一扇门
3. INF 无限表示一个空的房间。然后，我们用 231 - 1 = 2147483647 代表 INF。你可以认为通往门的距离总是小于 2147483647 的。
你要给每个空房间位上填上该房间到 最近门的距离 ，如果无法到达门，则填 INF 即可。
提示：
m == rooms.length
n == rooms[i].length
1 <= m, n <= 250
rooms[i][j] 是 -1、0 或 2^31 - 1

从每个门开始 BFS。
时间复杂度 O(mn)
空间复杂度 O(mn)
 */