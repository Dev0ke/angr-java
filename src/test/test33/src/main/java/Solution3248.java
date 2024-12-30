import java.util.List;

public class Solution3248 {
    public int finalPositionOfSnake(int n, List<String> commands) {
        int x = 0, y = 0;
        for (String cmd : commands) {
            char c = cmd.charAt(0);
            if (c == 'U') x--;
            else if (c == 'R') y++;
            else if (c == 'D') x++;
            else if (c == 'L') y--;
        }
        return x * n + y;
    }
}
/*
3248. 矩阵中的蛇
https://leetcode.cn/problems/snake-in-matrix/description/

第 410 场周赛 T1。

大小为 n x n 的矩阵 grid 中有一条蛇。蛇可以朝 四个可能的方向 移动。矩阵中的每个单元格都使用位置进行标识： grid[i][j] = (i * n) + j。
蛇从单元格 0 开始，并遵循一系列命令移动。
给你一个整数 n 表示 grid 的大小，另给你一个字符串数组 commands，其中包括 "UP"、"RIGHT"、"DOWN" 和 "LEFT"。题目测评数据保证蛇在整个移动过程中将始终位于 grid 边界内。
返回执行 commands 后蛇所停留的最终单元格的位置。
提示：
2 <= n <= 10
1 <= commands.length <= 100
commands 仅由 "UP"、"RIGHT"、"DOWN" 和 "LEFT" 组成。
生成的测评数据确保蛇不会移动到矩阵的边界外。

三题选手。。
模拟。答案为 x*n+y。
时间复杂度 O(m)。其中 m = commands.size()
 */