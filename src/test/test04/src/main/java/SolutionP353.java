import java.util.ArrayDeque;
import java.util.Deque;

public class SolutionP353 {
    static class SnakeGame {
        private final int width;
        private final int height;
        private final int[][] food;

        private final Deque<int[]> deque;
        private int idx;
        private int score;

        public SnakeGame(int width, int height, int[][] food) {
            this.width = width;
            this.height = height;
            this.food = food;

            deque = new ArrayDeque<>();
            // [x,y]
            deque.addLast(new int[]{0, 0});
            idx = 0;
            score = 0;
        }

        public int move(String direction) {
            int[] head = deque.getFirst();
            int nextM = head[0];
            int nextN = head[1];

            // JEP 361: Switch Expressions
            switch (direction) {
                case "U" -> nextM--;
                case "D" -> nextM++;
                case "L" -> nextN--;
                case "R" -> nextN++;
            }
            if (nextM >= 0 && nextM < height && nextN >= 0 && nextN < width) {
                // 食物，不需删除蛇尾
                if (idx < food.length && nextM == food[idx][0] && nextN == food[idx][1]) {
                    idx++;
                    score++;
                }
                // 普通移动，需删除蛇尾
                else {
                    deque.removeLast();
                }

                // 是否会与身体碰撞
                for (int[] body : deque) {
                    if (nextM == body[0] && nextN == body[1]) {
                        return -1;
                    }
                }

                // 增加蛇头
                deque.addFirst(new int[]{nextM, nextN});
                return score;
            }
            return -1;
        }
    }
}
/*
$353. 贪吃蛇
https://leetcode.cn/problems/design-snake-game/

请你设计一个 贪吃蛇游戏，该游戏将会在一个 屏幕尺寸 = 宽度 x 高度 的屏幕上运行。如果你不熟悉这个游戏，可以 点击这里 在线试玩。
起初时，蛇在左上角的 (0, 0) 位置，身体长度为 1 个单位。
你将会被给出一个数组形式的食物位置序列 food ，其中 food[i] = (ri, ci) 。当蛇吃到食物时，身子的长度会增加 1 个单位，得分也会 +1 。
食物不会同时出现，会按列表的顺序逐一显示在屏幕上。比方讲，第一个食物被蛇吃掉后，第二个食物才会出现。
当一个食物在屏幕上出现时，保证 不会 出现在被蛇身体占据的格子里。
如果蛇越界（与边界相撞）或者头与 移动后 的身体相撞（即，身长为 4 的蛇无法与自己相撞），游戏结束。
实现 SnakeGame 类：
- SnakeGame(int width, int height, int[][] food) 初始化对象，屏幕大小为 height x width ，食物位置序列为 food
- int move(String direction) 返回蛇在方向 direction 上移动后的得分。如果游戏结束，返回 -1 。
提示：
1 <= width, height <= 10^4
1 <= food.length <= 50
food[i].length == 2
0 <= ri < height
0 <= ci < width
direction.length == 1
direction is 'U', 'D', 'L', or 'R'.
最多调用 10^4 次 move 方法

模拟。
若碰到食物，则仅在队列前加入新头
若普通移动，还要再删除蛇尾
 */