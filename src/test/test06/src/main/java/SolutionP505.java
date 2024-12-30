import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class SolutionP505 {
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        int M = maze.length;
        int N = maze[0].length;

        int[][] direction = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        // BFS
        Queue<int[]> queue = new LinkedList<>();
        // x, y, step
        queue.add(new int[]{start[0], start[1], 0});
        Map<String, Integer> visitedMap = new HashMap<>();
        // "x:y" => 0
        visitedMap.put(start[0] + ":" + start[1], 0);

        int min = Integer.MAX_VALUE;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.remove();
                int curM = cur[0];
                int curN = cur[1];
                int curSteps = cur[2];
                if (curM == destination[0] && curN == destination[1]) {
                    // 找出让球停在目的地的最短距离
                    min = Math.min(min, curSteps);
                }

                for (int[] dir : direction) {
                    int nextM = curM;
                    int nextN = curN;
                    int nextSteps = curSteps;
                    // 在遇到墙壁前不会停止滚动。
                    while (nextM + dir[0] >= 0 && nextM + dir[0] < M && nextN + dir[1] >= 0
                            && nextN + dir[1] < N && maze[nextM + dir[0]][nextN + dir[1]] == 0) {
                        nextM += dir[0];
                        nextN += dir[1];
                        nextSteps++;
                    }

                    // 去重/剪枝。有多种方案能到达一个点，取步数最小的
                    if (visitedMap.getOrDefault(nextM + ":" + nextN, Integer.MAX_VALUE) > nextSteps) {
                        visitedMap.put(nextM + ":" + nextN, nextSteps);
                        queue.add(new int[]{nextM, nextN, nextSteps});
                    }
                }
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}
/*
$505. 迷宫 II
https://leetcode.cn/problems/the-maze-ii/

由空地和墙组成的迷宫中有一个球。球可以向上下左右四个方向滚动，但在遇到墙壁前不会停止滚动。当球停下时，可以选择下一个方向。
给定球的起始位置，目的地和迷宫，找出让球停在目的地的最短距离。距离的定义是球从起始位置（不包括）到目的地（包括）经过的空地个数。如果球无法停在目的地，返回 -1。
迷宫由一个0和1的二维数组表示。 1表示墙壁，0表示空地。你可以假定迷宫的边缘都是墙壁。起始位置和目的地的坐标通过行号和列号给出。
注意:
迷宫中只有一个球和一个目的地。
球和目的地都在空地上，且初始时它们不在同一位置。
给定的迷宫不包括边界 (如图中的红色矩形), 但你可以假设迷宫的边缘都是墙壁。
迷宫至少包括2块空地，行数和列数均不超过100。

难度升级，求最小步数。去重/剪枝 的方式由 boolean 变成 Map<Node, Integer>
相似题目: $490. 迷宫
https://leetcode.cn/problems/the-maze/
$499. 迷宫 III
https://leetcode.cn/problems/the-maze-iii/
 */