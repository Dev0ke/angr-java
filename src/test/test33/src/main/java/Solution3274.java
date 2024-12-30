public class Solution3274 {
    public boolean checkTwoChessboards(String coordinate1, String coordinate2) {
        int a = coordinate1.charAt(0) - 'a' + coordinate1.charAt(1) - '0';
        int b = coordinate2.charAt(0) - 'a' + coordinate2.charAt(1) - '0';
        return a % 2 == b % 2;
    }
}
/*
3274. 检查棋盘方格颜色是否相同
https://leetcode.cn/problems/check-if-two-chessboard-squares-have-the-same-color/description/

第 413 场周赛 T1。

给你两个字符串 coordinate1 和 coordinate2，代表 8 x 8 国际象棋棋盘上的两个方格的坐标。
以下是棋盘的参考图。
如果这两个方格颜色相同，返回 true，否则返回 false。
坐标总是表示有效的棋盘方格。坐标的格式总是先字母（表示列），再数字（表示行）。
提示：
coordinate1.length == coordinate2.length == 2
'a' <= coordinate1[0], coordinate2[0] <= 'h'
'1' <= coordinate1[1], coordinate2[1] <= '8'

判断奇偶性是否相等。
时间复杂度 O(1)。
 */