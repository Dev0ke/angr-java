public class Solution130 {
    private int M;
    private int N;

    public void solve(char[][] board) {
        this.M = board.length;
        this.N = board[0].length;

        boolean[][] isO = new boolean[M][N];
        boolean[][] visited = new boolean[M][N];
        // 找出边缘的 'O'
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && board[i][j] == 'O' && (i == 0 || i == M - 1 || j == 0 || j == N - 1)) {
                    dfs(board, isO, visited, i, j);
                }
            }
        }

        // res
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (!isO[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void dfs(char[][] board, boolean[][] isO, boolean[][] visited, int i, int j) {
        if (i >= 0 && i < M && j >= 0 && j < N && !visited[i][j] && board[i][j] == 'O') {
            isO[i][j] = true;
            visited[i][j] = true;
            dfs(board, isO, visited, i + 1, j);
            dfs(board, isO, visited, i, j + 1);
            dfs(board, isO, visited, i - 1, j);
            dfs(board, isO, visited, i, j - 1);
        }
    }
}
/*
130. 被围绕的区域
https://leetcode.cn/problems/surrounded-regions/

给你一个 m x n 的矩阵 board ，由若干字符 'X' 和 'O' ，找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
提示：
m == board.length
n == board[i].length
1 <= m, n <= 200
board[i][j] 为 'X' 或 'O'

dfs 标记与边缘连接的 'O'，再将没被标记的置为 'X'
 */