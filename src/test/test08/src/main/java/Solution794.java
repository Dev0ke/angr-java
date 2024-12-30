public class Solution794 {
    public boolean validTicTacToe(String[] board) {
        int cntX = 0;
        int cntO = 0;
        for (String row : board) {
            for (char ch : row.toCharArray()) {
                if (ch == 'X') {
                    cntX++;
                }
                if (ch == 'O') {
                    cntO++;
                }
            }
        }
        // X 是先手
        if (cntO != cntX && cntO != cntX - 1) {
            return false;
        }
        // X 赢
        if (win(board, 'X') && cntO != cntX - 1) {
            return false;
        }
        // O 赢
        if (win(board, 'O') && cntO != cntX) {
            return false;
        }
        return true;
    }

    // 00 01 02
    // 10 11 12
    // 20 21 22
    private boolean win(String[] board, char winType) {
        char[] board0 = board[0].toCharArray();
        char[] board1 = board[1].toCharArray();
        char[] board2 = board[2].toCharArray();
        // 行相等 / 列相等 / 对角线相等
        return ((board0[0] == board0[1] && board0[0] == board0[2] && board0[0] == winType)
                || (board1[0] == board1[1] && board1[0] == board1[2] && board1[0] == winType)
                || (board2[0] == board2[1] && board2[0] == board2[2] && board2[0] == winType)
                || (board0[0] == board1[0] && board0[0] == board2[0] && board0[0] == winType)
                || (board0[1] == board1[1] && board0[1] == board2[1] && board0[1] == winType)
                || (board0[2] == board1[2] && board0[2] == board2[2] && board0[2] == winType)
                || (board0[0] == board1[1] && board0[0] == board2[2] && board0[0] == winType)
                || (board0[2] == board1[1] && board0[2] == board2[0] && board0[2] == winType));
    }
}
/*
794. 有效的井字游戏
https://leetcode.cn/problems/valid-tic-tac-toe-state/

给你一个字符串数组 board 表示井字游戏的棋盘。当且仅当在井字游戏过程中，棋盘有可能达到 board 所显示的状态时，才返回 true 。
井字游戏的棋盘是一个 3 x 3 数组，由字符 ' '，'X' 和 'O' 组成。字符 ' ' 代表一个空位。
以下是井字游戏的规则：
- 玩家轮流将字符放入空位（' '）中。
- 玩家 1 总是放字符 'X' ，而玩家 2 总是放字符 'O' 。
- 'X' 和 'O' 只允许放置在空位中，不允许对已放有字符的位置进行填充。
- 当有 3 个相同（且非空）的字符填充任何行、列或对角线时，游戏结束。
- 当所有位置非空时，也算为游戏结束。
- 如果游戏结束，玩家不允许再放置字符。
提示：
board.length == 3
board[i].length == 3
board[i][j] 为 'X'、'O' 或 ' '

分类讨论。
 */
