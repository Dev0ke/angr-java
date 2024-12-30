public class Solution1812 {
    public boolean squareIsWhite(String coordinates) {
        int col = coordinates.charAt(0) - 'a'; // 0~7
        int row = coordinates.charAt(1) - '1'; // 0~7
        return (row + col) % 2 == 1;
    }
}
/*
1812. 判断国际象棋棋盘中一个格子的颜色
https://leetcode.cn/problems/determine-color-of-a-chessboard-square/description/

给你一个坐标 coordinates ，它是一个字符串，表示国际象棋棋盘中一个格子的坐标。下图是国际象棋棋盘示意图。
如果所给格子的颜色是白色，请你返回 true，如果是黑色，请返回 false 。
给定坐标一定代表国际象棋棋盘上一个存在的格子。坐标第一个字符是字母，第二个字符是数字。
提示：
coordinates.length == 2
'a' <= coordinates[0] <= 'h'
'1' <= coordinates[1] <= '8'

数学。奇偶性。
时间复杂度 O(1)。
 */