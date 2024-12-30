public class Solution37 {
    private boolean done = false;

    public void solveSudoku(char[][] board) {
        dfs(board, 0);
    }

    private void dfs(char[][] board, int n) {
        if (n >= 81) {
            done = true;
            return;
        }
        int curX = n / 9;
        int curY = n % 9;
        if (board[curX][curY] != '.') {
            dfs(board, n + 1);
        } else {
            for (char ch = '1'; ch <= '9'; ch++) {
                // 判断 ch 能否填进 数独 中
                if (check(board, curX, curY, ch)) {
                    board[curX][curY] = ch;
                    dfs(board, n + 1);
                    if (done) {
                        return;
                    }
                    // 复原
                    board[curX][curY] = '.';
                }
            }
        }
    }

    private boolean check(char[][] board, int x, int y, char ch) {
        // 行 和 列
        for (int i = 0; i < 9; i++) {
            if (board[x][i] == ch || board[i][y] == ch) {
                return false;
            }
        }
        // 3*3 box
        int startX = x / 3 * 3;
        int startY = y / 3 * 3;
        for (int i = startX; i < startX + 3; i++) {
            for (int j = startY; j < startY + 3; j++) {
                if (board[i][j] == ch) {
                    return false;
                }
            }
        }
        return true;
    }
}
/*
37. 解数独
https://leetcode.cn/problems/sudoku-solver/

编写一个程序，通过填充空格来解决数独问题。
数独的解法需 遵循如下规则：
1.数字 1-9 在每一行只能出现一次。
2.数字 1-9 在每一列只能出现一次。
3.数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）
数独部分空格内已填入了数字，空白格用 '.' 表示。
提示：
board.length == 9
board[i].length == 9
board[i][j] 是一位数字或者 '.'
题目数据 保证 输入数独仅有一个解

DFS.
 */