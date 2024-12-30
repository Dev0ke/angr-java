public class SolutionP723 {
    public int[][] candyCrush(int[][] board) {
        int M = board.length;
        int N = board[0].length;

        boolean flag = false;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j + 2 < N; j++) {
                int val = Math.abs(board[i][j]);
                if (val > 0 && val == Math.abs(board[i][j + 1]) && val == Math.abs(board[i][j + 2])) {
                    board[i][j] = board[i][j + 1] = board[i][j + 2] = -val;
                    flag = true;
                }
            }
        }
        for (int i = 0; i + 2 < M; i++) {
            for (int j = 0; j < N; j++) {
                int val = Math.abs(board[i][j]);
                if (val > 0 && val == Math.abs(board[i + 1][j]) && val == Math.abs(board[i + 2][j])) {
                    board[i][j] = board[i + 1][j] = board[i + 2][j] = -val;
                    flag = true;
                }
            }
        }

        for (int j = 0; j < N; j++) {
            // write
            int wr = M - 1;
            for (int i = M - 1; i >= 0; i--) {
                if (board[i][j] > 0) {
                    board[wr][j] = board[i][j];
                    wr--;
                }
            }
            while (wr >= 0) {
                board[wr][j] = 0;
                wr--;
            }
        }
        return flag ? candyCrush(board) : board;
    }
}
/*
$723. 粉碎糖果
https://leetcode.cn/problems/candy-crush/

这个问题是实现一个简单的消除算法。
给定一个 m x n 的二维整数数组 board 代表糖果所在的方格，不同的正整数 board[i][j] 代表不同种类的糖果，如果 board[i][j] == 0 代表 (i, j) 这个位置是空的。
给定的方格是玩家移动后的游戏状态，现在需要你根据以下规则粉碎糖果，使得整个方格处于稳定状态并最终输出：
- 如果有三个及以上水平或者垂直相连的同种糖果，同一时间将它们粉碎，即将这些位置变成空的。
- 在同时粉碎掉这些糖果之后，如果有一个空的位置上方还有糖果，那么上方的糖果就会下落直到碰到下方的糖果或者底部，这些糖果都是同时下落，也不会有新的糖果从顶部出现并落下来。
- 通过前两步的操作，可能又会出现可以粉碎的糖果，请继续重复前面的操作。
- 当不存在可以粉碎的糖果，也就是状态稳定之后，请输出最终的状态。
你需要模拟上述规则并使整个方格达到稳定状态，并输出。
提示:
m == board.length
n == board[i].length
3 <= m, n <= 50
1 <= board[i][j] <= 2000

特殊用途的网络 Ad-Hoc
https://leetcode.cn/problems/candy-crush/solution/fen-sui-tang-guo-by-leetcode/
时间复杂度 O(mn * mn)
 */