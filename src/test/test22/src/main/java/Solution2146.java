import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution2146 {
    private static final int[][] DIRECTIONS = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public List<List<Integer>> highestRankedKItems(int[][] grid, int[] pricing, int[] start, int k) {
        int m = grid.length;
        int n = grid[0].length;

        int min = pricing[0];
        int max = pricing[1];

        // BFS
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] vis = new boolean[m][n];
        queue.add(start);
        vis[start[0]][start[1]] = true;

        // row col step
        PriorityQueue<List<Integer>> priorityQueue = new PriorityQueue<>((o1, o2) -> {
            // 距离：定义为从 start 到一件物品的最短路径需要的步数（较近 距离的排名更高）。
            if (!o1.get(2).equals(o2.get(2))) {
                return Integer.compare(o1.get(2), o2.get(2));
            }
            int row1 = o1.get(0);
            int col1 = o1.get(1);
            int row2 = o2.get(0);
            int col2 = o2.get(1);
            // 价格：较低 价格的物品有更高优先级，但只考虑在给定范围之内的价格。
            if (grid[row1][col1] != grid[row2][col2]) {
                return Integer.compare(grid[row1][col1], grid[row2][col2]);
            }
            // 行坐标：较小 行坐标的有更高优先级。
            if (row1 != row2) {
                return Integer.compare(row1, row2);
            }
            // 列坐标：较小 列坐标的有更高优先级。
            return Integer.compare(col1, col2);
        });

        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            step++;
            for (int i = 0; i < size; i++) {
                int[] tuple = queue.remove();
                int cx = tuple[0], cy = tuple[1];
                // 只考虑在给定范围之内的价格
                if (grid[cx][cy] >= min && grid[cx][cy] <= max) {
                    priorityQueue.add(List.of(cx, cy, step));
                }

                for (int[] dir : DIRECTIONS) {
                    int nx = cx + dir[0];
                    int ny = cy + dir[1];
                    if (nx >= 0 && nx < m && ny >= 0 && ny < n && grid[nx][ny] != 0
                            && !vis[nx][ny]) {
                        vis[nx][ny] = true;
                        queue.add(new int[]{nx, ny});
                    }
                }
            }
        }

        // PriorityQueue<List<Integer>> 取 top k
        List<List<Integer>> resList = new ArrayList<>();
        int resLen = Math.min(priorityQueue.size(), k);
        for (int i = 0; i < resLen; i++) {
            resList.add(priorityQueue.remove().subList(0, 2));
        }
        return resList;
    }
}
/*
2146. 价格范围内最高排名的 K 样物品
https://leetcode.cn/problems/k-highest-ranked-items-within-a-price-range/

第 70 场双周赛 T3。

给你一个下标从 0 开始的二维整数数组 grid ，它的大小为 m x n ，表示一个商店中物品的分布图。数组中的整数含义为：
- 0 表示无法穿越的一堵墙。
- 1 表示可以自由通过的一个空格子。
- 所有其他正整数表示该格子内的一样物品的价格。你可以自由经过这些格子。
从一个格子走到上下左右相邻格子花费 1 步。
同时给你一个整数数组 pricing 和 start ，其中 pricing = [low, high] 且 start = [row, col] ，表示你开始位置为 (row, col) ，
同时你只对物品价格在 闭区间 [low, high] 之内的物品感兴趣。同时给你一个整数 k 。
你想知道给定范围 内 且 排名最高 的 k 件物品的 位置 。排名按照优先级从高到低的以下规则制定：
1.距离：定义为从 start 到一件物品的最短路径需要的步数（较近 距离的排名更高）。
2.价格：较低 价格的物品有更高优先级，但只考虑在给定范围之内的价格。
3.行坐标：较小 行坐标的有更高优先级。
4.列坐标：较小 列坐标的有更高优先级。
请你返回给定价格内排名最高的 k 件物品的坐标，将它们按照排名排序后返回。如果给定价格内少于 k 件物品，那么请将它们的坐标 全部 返回。
提示：
m == grid.length
n == grid[i].length
1 <= m, n <= 10^5
1 <= m * n <= 10^5
0 <= grid[i][j] <= 10^5
pricing.length == 2
2 <= low <= high <= 10^5
start.length == 2
0 <= row <= m - 1
0 <= col <= n - 1
grid[row][col] > 0
1 <= k <= m * n

BFS 将符合条件的全扔优先队列，再从 优先队列中取 top k
 */