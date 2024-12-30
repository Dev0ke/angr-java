public class Solution2069 {
    static class Robot {
        private final int width;
        private final int height;
        // 周长 Robot(6, 3) 周长 14
        private final int round;
        // 总步数
        private int total;
        // 记录状态
        private int curX;
        private int curY;
        private String curDir;

        public Robot(int width, int height) {
            this.width = width;
            this.height = height;
            this.round = width + height + width + height - 4;
            this.curDir = "East";
        }

        public void move(int num) {
            this.total += num;
            // 第 n 圈 round + cnt
            int cnt = total % round;
            if (cnt <= width - 1) {
                curX = cnt;
                curY = 0;
                curDir = "East";
                // (0, 0) 只有第一圈朝向 "East" 其余都朝向 "South"
                if (cnt == 0 && total > 0) {
                    curDir = "South";
                }
            } else if (cnt <= (width - 1) + (height - 1)) {
                curX = width - 1;
                curY = cnt - (width - 1);
                curDir = "North";
            } else if (cnt <= (width - 1) + (height - 1) + (width - 1)) {
                curX = (width - 1) - (cnt - (width - 1) - (height - 1));
                curY = height - 1;
                curDir = "West";
            } else {
                curX = 0;
                curY = (height - 1) - (cnt - (width - 1) - (height - 1) - (width - 1));
                curDir = "South";
            }
        }

        public int[] getPos() {
            return new int[]{curX, curY};
        }

        public String getDir() {
            return curDir;
        }
    }
}
/*
2069. 模拟行走机器人 II
https://leetcode.cn/problems/walking-robot-simulation-ii/

第 65 场双周赛 T2。

请你实现 Robot 类：
Robot(int width, int height) 初始化一个 width x height 的网格图，机器人初始在 (0, 0) ，方向朝 "East" 。
void move(int num) 给机器人下达前进 num 步的指令。
int[] getPos() 返回机器人当前所处的格子位置，用一个长度为 2 的数组 [x, y] 表示。
String getDir() 返回当前机器人的朝向，为 "North" ，"East" ，"South" 或者 "West" 。

模拟。需注意边界条件。
 */
