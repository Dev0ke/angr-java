import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class SolutionP1197 {
    private static final int[][] DIRECTIONS = {{-2, -1}, {-2, 1}, {2, -1}, {2, 1}, {-1, -2}, {-1, 2}, {1, -2}, {1, 2}};

    public int minKnightMoves(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        Set<Integer> visited = new HashSet<>();
        visited.add(0);
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.remove();
                if (cur[0] == x && cur[1] == y) {
                    return step;
                }

                for (int[] dir : DIRECTIONS) {
                    int nextM = cur[0] + dir[0];
                    int nextN = cur[1] + dir[1];
                    int key = nextM * 1000 + nextN;
                    if (!visited.contains(key)) {
                        visited.add(key);
                        queue.add(new int[]{nextM, nextN});
                    }
                }
            }
            step++;
        }
        return step;
    }
}
/*
$1197. 进击的骑士
https://leetcode.cn/problems/minimum-knight-moves/

一个坐标可以从 -infinity 延伸到 +infinity 的 无限大的 棋盘上，你的 骑士 驻扎在坐标为 [0, 0] 的方格里。
骑士的走法和中国象棋中的马相似，走 “日” 字：即先向左（或右）走 1 格，再向上（或下）走 2 格；或先向左（或右）走 2 格，再向上（或下）走 1 格。
每次移动，他都可以按图示八个方向之一前进。
返回 骑士前去征服坐标为 [x, y] 的部落所需的最小移动次数 。本题确保答案是一定存在的。
提示：
-300 <= x, y <= 300
0 <= |x| + |y| <= 300

BFS / 数学
相似题目: 688. 骑士在棋盘上的概率
https://leetcode.cn/problems/knight-probability-in-chessboard/
 */