public class Solution1275 {
    public String tictactoe(int[][] moves) {
        int[][] a = new int[3][3];
        // A 看作 1, B 看作 -1
        int j = 1;
        for (int[] p : moves) {
            a[p[0]][p[1]] = j;
            j = -j;
        }
        // 对角线
        if (Math.abs(a[0][0] + a[1][1] + a[2][2]) == 3
                || Math.abs(a[0][2] + a[1][1] + a[2][0]) == 3) {
            return a[1][1] > 0 ? "A" : "B";
        }
        // 行和列
        for (int i = 0; i < 3; i++) {
            if (Math.abs(a[i][0] + a[i][1] + a[i][2]) == 3
                    || Math.abs(a[0][i] + a[1][i] + a[2][i]) == 3) {
                return a[i][i] > 0 ? "A" : "B";
            }
        }
        return moves.length == 9 ? "Draw" : "Pending";
    }
}
/*
1275. 找出井字棋的获胜者
https://leetcode.cn/problems/find-winner-on-a-tic-tac-toe-game/description/

A 和 B 在一个 3 x 3 的网格上玩井字棋。
井字棋游戏的规则如下：
- 玩家轮流将棋子放在空方格 (" ") 上。
- 第一个玩家 A 总是用 "X" 作为棋子，而第二个玩家 B 总是用 "O" 作为棋子。
- "X" 和 "O" 只能放在空方格中，而不能放在已经被占用的方格上。
- 只要有 3 个相同的（非空）棋子排成一条直线（行、列、对角线）时，游戏结束。
- 如果所有方块都放满棋子（不为空），游戏也会结束。
- 游戏结束后，棋子无法再进行任何移动。
给你一个数组 moves，其中每个元素是大小为 2 的另一个数组（元素分别对应网格的行和列），它按照 A 和 B 的行动顺序（先 A 后 B）记录了两人各自的棋子位置。
如果游戏存在获胜者（A 或 B），就返回该游戏的获胜者；如果游戏以平局结束，则返回 "Draw"；如果仍会有行动（游戏未结束），则返回 "Pending"。
你可以假设 moves 都 有效（遵循井字棋规则），网格最初是空的，A 将先行动。
提示：
1 <= moves.length <= 9
moves[i].length == 2
0 <= moves[i][j] <= 2
moves 里没有重复的元素。
moves 遵循井字棋的规则。

分类讨论。
时间复杂度 O(n)。
 */