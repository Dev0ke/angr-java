public class Solution1958 {
    private static final int[][] DIRECTIONS8 = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}, {-1, -1}, {1, 1}, {-1, 1}, {1, -1}};

    public boolean checkMove(char[][] board, int rMove, int cMove, char color) {
        for (int[] dir : DIRECTIONS8) {
            if (check(board, rMove, cMove, color, dir)) {
                return true;
            }
        }
        return false;
    }

    private static boolean check(char[][] board, int rMove, int cMove, char color, int[] dir) {
        int nextM = rMove + dir[0];
        int nextN = cMove + dir[1];
        // 当前遍历到的节点序号
        int step = 1;
        while (nextM >= 0 && nextM < 8 && nextN >= 0 && nextN < 8) {
            if (step == 1) {
                // 第一个点必须为相反颜色
                if (board[nextM][nextN] == '.' || board[nextM][nextN] == color) {
                    return false;
                }
            } else {
                // 好线段中不应存在空格子
                if (board[nextM][nextN] == '.') {
                    return false;
                }
                // 遍历到好线段的终点，返回 true
                if (board[nextM][nextN] == color) {
                    return true;
                }
            }
            step++;
            nextM += dir[0];
            nextN += dir[1];
        }
        return false;
    }
}
/*
1958. 检查操作是否合法
https://leetcode.cn/problems/check-if-move-is-legal/

第 58 场双周赛 T2。

给你一个下标从 0 开始的 8 x 8 网格 board ，其中 board[r][c] 表示游戏棋盘上的格子 (r, c) 。棋盘上空格用 '.' 表示，白色格子用 'W' 表示，黑色格子用 'B' 表示。
游戏中每次操作步骤为：选择一个空格子，将它变成你正在执行的颜色（要么白色，要么黑色）。但是，合法 操作必须满足：涂色后这个格子是 好线段的一个端点 （好线段可以是水平的，竖直的或者是对角线）。
好线段 指的是一个包含 三个或者更多格子（包含端点格子）的线段，线段两个端点格子为 同一种颜色 ，且中间剩余格子的颜色都为 另一种颜色 （线段上不能有任何空格子）。你可以在下图找到好线段的例子：
给你两个整数 rMove 和 cMove 以及一个字符 color ，表示你正在执行操作的颜色（白或者黑），如果将格子 (rMove, cMove) 变成颜色 color 后，是一个 合法 操作，那么返回 true ，如果不是合法操作返回 false 。
提示：
board.length == board[r].length == 8
0 <= rMove, cMove < 8
board[rMove][cMove] == '.'
color 要么是 'B' 要么是 'W' 。

枚举每个方向验证
时间复杂度 O(n) 其中 n = 8，常数为 8
空间复杂度 O(1)
 */