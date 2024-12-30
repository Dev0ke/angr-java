import java.util.LinkedList;
import java.util.Queue;

public class Solution1210 {
    private static final int[][] DIRS = {{1, 0, 0}, {0, 1, 0}, {0, 0, 1}};

    public int minimumMoves(int[][] grid) {
        int n = grid.length;
        boolean[][][] visited = new boolean[n][n][2];
        Queue<int[]> queue = new LinkedList<>();
        visited[0][0][0] = true;
        queue.add(new int[]{0, 0, 0});
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.remove();
                if (cur[0] == n - 1 && cur[1] == n - 2) {
                    return step;
                }
                for (int[] dir : DIRS) {
                    int x = cur[0] + dir[0];
                    int y = cur[1] + dir[1];
                    int s = cur[2] ^ dir[2];
                    int x2 = x + s;
                    int y2 = y + (s ^ 1);
                    if (x2 < n && y2 < n && !visited[x][y][s]
                            && grid[x][y] == 0 && grid[x2][y2] == 0
                            && (dir[2] == 0 || grid[x + 1][y + 1] == 0)) {
                        visited[x][y][s] = true;
                        queue.add(new int[]{x, y, s});
                    }
                }
            }
            step++;
        }
        return -1;
    }
}
/*
1210. 穿过迷宫的最少移动次数
https://leetcode.cn/problems/minimum-moves-to-reach-target-with-rotations/

你还记得那条风靡全球的贪吃蛇吗？
我们在一个 n*n 的网格上构建了新的迷宫地图，蛇的长度为 2，也就是说它会占去两个单元格。蛇会从左上角（(0, 0) 和 (0, 1)）开始移动。我们用 0 表示空单元格，用 1 表示障碍物。蛇需要移动到迷宫的右下角（(n-1, n-2) 和 (n-1, n-1)）。
每次移动，蛇可以这样走：
- 如果没有障碍，则向右移动一个单元格。并仍然保持身体的水平／竖直状态。
- 如果没有障碍，则向下移动一个单元格。并仍然保持身体的水平／竖直状态。
- 如果它处于水平状态并且其下面的两个单元都是空的，就顺时针旋转 90 度。蛇从（(r, c)、(r, c+1)）移动到 （(r, c)、(r+1, c)）。
- 如果它处于竖直状态并且其右面的两个单元都是空的，就逆时针旋转 90 度。蛇从（(r, c)、(r+1, c)）移动到（(r, c)、(r, c+1)）。
返回蛇抵达目的地所需的最少移动次数。
如果无法到达目的地，请返回 -1。
提示：
2 <= n <= 100
0 <= grid[i][j] <= 1
蛇保证从空单元格开始出发。

https://leetcode.cn/problems/minimum-moves-to-reach-target-with-rotations/solution/huan-zai-if-elseyi-ge-xun-huan-chu-li-li-tw8b/
时间复杂度 O(n^2)
空间复杂度 O(n^2)
 */