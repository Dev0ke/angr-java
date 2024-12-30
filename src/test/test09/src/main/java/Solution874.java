import java.util.HashSet;
import java.util.Set;

public class Solution874 {
    public int robotSim(int[] commands, int[][] obstacles) {
        Set<String> obstacleSet = new HashSet<>();
        for (int[] obstacle : obstacles) {
            obstacleSet.add(obstacle[0] + ":" + obstacle[1]);
        }

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        // 从点 (0, 0) 处开始出发，面向北方。
        int idx = 1;
        int x = 0;
        int y = 0;
        int max = 0;
        for (int command : commands) {
            if (command == -2) {
                // 向左转 90 度
                idx = (idx + 3) % 4;
            } else if (command == -1) {
                // 向右转 90 度
                idx = (idx + 1) % 4;
            } else {
                // 向前移动 x 个单位长度
                for (int i = 0; i < command; i++) {
                    String next = (x + dx[idx]) + ":" + (y + dy[idx]);
                    if (!obstacleSet.contains(next)) {
                        x += dx[idx];
                        y += dy[idx];
                        max = Math.max(max, x * x + y * y);
                    } else {
                        break;
                    }
                }
            }
        }
        return max;
    }
}
/*
874. 模拟行走机器人
https://leetcode.cn/problems/walking-robot-simulation/

机器人在一个无限大小的 XY 网格平面上行走，从点 (0, 0) 处开始出发，面向北方。该机器人可以接收以下三种类型的命令 commands ：
- -2 ：向左转 90 度
- -1 ：向右转 90 度
- 1 <= x <= 9 ：向前移动 x 个单位长度
在网格上有一些格子被视为障碍物 obstacles 。第 i 个障碍物位于网格点  obstacles[i] = (xi, yi) 。
机器人无法走到障碍物上，它将会停留在障碍物的前一个网格方块上，但仍然可以继续尝试进行该路线的其余部分。
返回从原点到机器人所有经过的路径点（坐标为整数）的最大欧式距离的平方。（即，如果距离为 5 ，则返回 25 ）
注意：
- 北表示 +Y 方向。
- 东表示 +X 方向。
- 南表示 -Y 方向。
- 西表示 -X 方向。
提示：
1 <= commands.length <= 10^4
commands[i] is one of the values in the list [-2,-1,1,2,3,4,5,6,7,8,9].
0 <= obstacles.length <= 10^4
-3 * 10^4 <= xi, yi <= 3 * 10^4
答案保证小于 2^31

最大步数不超过 9 * 10^4 = 90000
因此可以逐步模拟。
 */