import java.util.HashSet;
import java.util.Set;

public class SolutionP2061 {
    private static final int[][] DIRS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private int[][] room;
    private int m, n;
    private Set<Long> ans;
    private boolean[][][] memo;

    public int numberOfCleanRooms(int[][] room) {
        this.room = room;
        m = room.length;
        n = room[0].length;

        ans = new HashSet<>();
        memo = new boolean[m][n][4];
        dfs(0, 0, 0);
        return ans.size();
    }

    private void dfs(int x, int y, int idx) {
        if (memo[x][y][idx]) return;
        ans.add(hash(x, y));
        memo[x][y][idx] = true;
        int nx = x + DIRS[idx][0];
        int ny = y + DIRS[idx][1];
        if (nx >= 0 && nx < m && ny >= 0 && ny < n && room[nx][ny] == 0) {
            dfs(nx, ny, idx);
        } else {
            dfs(x, y, (idx + 1) % 4);
        }
    }

    private long hash(long x, long y) {
        return (x << 32) + y;
    }
}
/*
$2061. 扫地机器人清扫过的空间个数
https://leetcode.cn/problems/number-of-spaces-cleaning-robot-cleaned/description/

一个房间用一个从 0 开始索引的二维二进制矩阵 room 表示，其中 0 表示空闲空间， 1 表示放有物体的空间。在每个测试用例中，房间左上角永远是空闲的。
一个扫地机器人面向右侧，从左上角开始清扫。机器人将一直前进，直到抵达房间边界或触碰到物体时，机器人将会顺时针旋转 90 度并重复以上步骤。初始位置和所有机器人走过的空间都会被它清扫干净。
若机器人持续运转下去，返回被清扫干净的空间数量。
提示：
m == room.length
n == room[r].length
1 <= m, n <= 300
room[r][c] 只会是 0 或 1 。
room[0][0] == 0

DFS。记忆化。
 */