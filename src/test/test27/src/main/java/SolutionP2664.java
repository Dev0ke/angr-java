import java.util.Arrays;

public class SolutionP2664 {
    private static final int[][] DIRECTIONS = {{-2, -1}, {-1, -2}, {1, -2}, {2, -1}, {2, 1}, {1, 2}, {-1, 2}, {-2, 1}};
    private int[][] board;
    private int m, n;
    private boolean flag = false;

    public int[][] tourOfKnight(int m, int n, int r, int c) {
        this.m = m;
        this.n = n;
        this.board = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(board[i], -1);
        }
        board[r][c] = 0;
        dfs(r, c, 1);
        return board;
    }

    private void dfs(int r, int c, int i) {
        if (i == m * n) {
            flag = true;
            return;
        }
        for (int[] d : DIRECTIONS) {
            int nx = r + d[0];
            int ny = c + d[1];
            if (nx >= 0 && nx < m && ny >= 0 && ny < n && board[nx][ny] == -1) {
                board[nx][ny] = i;
                dfs(nx, ny, i + 1);
                if (!flag) board[nx][ny] = -1;
            }
        }
    }
}
/*
$2664. 巡逻的骑士
https://leetcode.cn/problems/the-knights-tour/description/

给定两个正整数 m 和 n ，它们是一个 下标从 0 开始 的二维数组 board 的高度和宽度。还有一对正整数 (r, c) ，它们是骑士在棋盘上的起始位置。
你的任务是找到一个骑士的移动顺序，使得 board 中每个单元格都 恰好 被访问一次（起始单元格已被访问，不应 再次访问）。
返回数组 board ，其中单元格的值显示从 0 开始访问该单元格的顺序（骑士的初始位置为 0）。
注意，如果 0 <= r2 <= m-1 且 0 <= c2 <= n-1 ，并且 min(abs(r1-r2), abs(c1-c2)) = 1 且 max(abs(r1-r2), abs(c1-c2)) = 2 ，则骑士可以从单元格 (r1, c1) 移动到单元格 (r2, c2) 。
提示：
1 <= m, n <= 5
0 <= r <= m - 1
0 <= c <= n - 1
输入的数据保证在给定条件下至少存在一种访问所有单元格的移动顺序。

https://leetcode.cn/problems/the-knights-tour/solutions/2259167/2664-xun-luo-de-qi-shi-by-stormsunshine-6jqr/
时间复杂度 O(8^mn)。一个宽松的上界。
 */