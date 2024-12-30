import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class SolutionP499 {
    public String findShortestWay(int[][] maze, int[] ball, int[] hole) {
        int M = maze.length;
        int N = maze[0].length;

        int[][] direction = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        String[] dirStrings = {"d", "r", "u", "l"};
        // BFS
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(ball[0], ball[1], 0, ""));

        // 从 ball 到点 [x:y]，最短距离
        Map<String, Integer> visitedMap = new HashMap<>();
        visitedMap.put(ball[0] + ":" + ball[1], 0);
        // 从 ball 到点 [x:y]，最短距离的路径
        Map<String, Set<String>> pathMap = new HashMap<>();

        List<String> resList = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node cur = queue.remove();

                for (int j = 0; j < 4; j++) {
                    int[] dir = direction[j];
                    int nextM = cur.m;
                    int nextN = cur.n;
                    int nextSteps = cur.steps;
                    String path = cur.path;

                    boolean step = false;
                    while (nextM + dir[0] >= 0 && nextM + dir[0] < M && nextN + dir[1] >= 0
                            && nextN + dir[1] < N && maze[nextM + dir[0]][nextN + dir[1]] == 0) {
                        nextM += dir[0];
                        nextN += dir[1];
                        nextSteps++;
                        step = true;

                        // 掉进洞里
                        if (nextM == hole[0] && nextN == hole[1]) {
                            if (nextSteps < min) {
                                min = nextSteps;
                                resList.clear();
                                resList.add(path + dirStrings[j]);
                            } else if (nextSteps == min) {
                                resList.add(path + dirStrings[j]);
                            }
                            break;
                        }
                    }
                    if (step) {
                        path = path + dirStrings[j];
                    }

                    // 剪枝/去重
                    String key = nextM + ":" + nextN;
                    if (visitedMap.getOrDefault(key, Integer.MAX_VALUE) >= nextSteps) {
                        visitedMap.put(key, nextSteps);
                        Set<String> pathSet = pathMap.getOrDefault(key, new HashSet<>());
                        if (!pathSet.contains(path)) {
                            pathSet.add(path);
                            pathMap.put(key, pathSet);
                            queue.add(new Node(nextM, nextN, nextSteps, path));
                        }
                    }
                }
            }
        }

        // 字典序最小
        resList.sort((o1, o2) -> {
            int size = Math.min(o1.length(), o2.length());
            for (int i = 0; i < size; i++) {
                if (o1.charAt(i) != o2.charAt(i)) {
                    return o1.charAt(i) - (o2.charAt(i));
                }
            }
            return o1.length() - o2.length();
        });
        return resList.size() > 0 ? resList.get(0) : "impossible";
    }

    private static class Node {
        int m;
        int n;
        int steps;
        String path;

        public Node(int m, int n, int steps, String path) {
            this.m = m;
            this.n = n;
            this.steps = steps;
            this.path = path;
        }
    }
}
/*
$499. 迷宫 III
https://leetcode.cn/problems/the-maze-iii/

由空地和墙组成的迷宫中有一个球。球可以向上（u）下（d）左（l）右（r）四个方向滚动，但在遇到墙壁前不会停止滚动。
当球停下时，可以选择下一个方向。迷宫中还有一个洞，当球运动经过洞时，就会掉进洞里。
给定球的起始位置，目的地和迷宫，找出让球以最短距离掉进洞里的路径。 距离的定义是球从起始位置（不包括）到目的地（包括）经过的空地个数。
通过'u', 'd', 'l' 和 'r'输出球的移动方向。 由于可能有多条最短路径， 请输出字典序最小的路径。如果球无法进入洞，输出"impossible"。
迷宫由一个0和1的二维数组表示。 1表示墙壁，0表示空地。你可以假定迷宫的边缘都是墙壁。起始位置和目的地的坐标通过行号和列号给出。
注意:
迷宫中只有一个球和一个目的地。
球和洞都在空地上，且初始时它们不在同一位置。
给定的迷宫不包括边界 (如图中的红色矩形), 但你可以假设迷宫的边缘都是墙壁。
迷宫至少包括2块空地，行数和列数均不超过30。

难度升级，其中字典序最小可参考 建信03. 地铁路线规划
https://leetcode.cn/contest/ccbft-2021fall/problems/zQTFs4/
相似题目: $490. 迷宫
https://leetcode.cn/problems/the-maze/
$505. 迷宫 II
https://leetcode.cn/problems/the-maze-ii/
 */