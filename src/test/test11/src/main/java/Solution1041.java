public class Solution1041 {
    private static final int[][] DIRECTIONS = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public boolean isRobotBounded(String instructions) {
        int dirIdx = 1;
        int cx = 0, cy = 0;
        for (char ch : instructions.toCharArray()) {
            if (ch == 'G') {
                cx += DIRECTIONS[dirIdx][0];
                cy += DIRECTIONS[dirIdx][1];
            } else if (ch == 'L') {
                dirIdx = (dirIdx + 1) % 4;
            } else if (ch == 'R') {
                dirIdx = (dirIdx - 1 + 4) % 4;
            }
        }
        // 机器人想要摆脱循环，在一串指令之后的状态，必须是不位于原点且方向朝北。
        return dirIdx != 1 || cx == 0 && cy == 0;
    }
}
/*
1041. 困于环中的机器人
https://leetcode.cn/problems/robot-bounded-in-circle/

在无限的平面上，机器人最初位于 (0, 0) 处，面朝北方。注意:
- 北方向 是y轴的正方向。
- 南方向 是y轴的负方向。
- 东方向 是x轴的正方向。
- 西方向 是x轴的负方向。
机器人可以接受下列三条指令之一：
- "G"：直走 1 个单位
- "L"：左转 90 度
- "R"：右转 90 度
机器人按顺序执行指令 instructions，并一直重复它们。
只有在平面中存在环使得机器人永远无法离开时，返回 true。否则，返回 false。
提示：
1 <= instructions.length <= 100
instructions[i] 仅包含 'G', 'L', 'R'

模拟。
机器人想要摆脱循环，在一串指令之后的状态，必须是不位于原点且方向朝北。
时间复杂度 O(n)
空间复杂度 O(1)
 */