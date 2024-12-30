import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Solution1591 {
    public boolean isPrintable(int[][] targetGrid) {
        // 题目转化为 是否存在一种染色顺序，使最终矩阵满足题目要求
        // 即 拓扑排序
        int M = targetGrid.length;
        int N = targetGrid[0].length;

        // 预处理每种颜色的边界
        int[] top = new int[61];
        int[] right = new int[61];
        int[] bottom = new int[61];
        int[] left = new int[61];
        Arrays.fill(top, Integer.MAX_VALUE);
        Arrays.fill(left, Integer.MAX_VALUE);
        Arrays.fill(bottom, Integer.MIN_VALUE);
        Arrays.fill(right, Integer.MIN_VALUE);
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                int color = targetGrid[i][j];
                top[color] = Math.min(top[color], i);
                left[color] = Math.min(left[color], j);
                bottom[color] = Math.max(bottom[color], i);
                right[color] = Math.max(right[color], j);
            }
        }

        // 建图。adj[i][j] 表示 i => j 存在有向边
        boolean[][] adj = new boolean[61][61];
        Map<Integer, List<Integer>> outGraph = new HashMap<>();
        int[] inDegrees = new int[61];

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                int to = targetGrid[i][j];
                // 1 <= targetGrid[row][col] <= 60
                for (int from = 1; from <= 60; from++) {
                    if (top[from] <= i && bottom[from] >= i && left[from] <= j && right[from] >= j) {
                        if (from != to && !adj[from][to]) {
                            adj[from][to] = true;

                            outGraph.computeIfAbsent(from, key -> new ArrayList<>()).add(to);
                            inDegrees[to]++;
                        }
                    }
                }
            }
        }

        // 入度为 0 进队列
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= 60; i++) {
            if (inDegrees[i] == 0) {
                queue.add(i);
            }
        }
        int cnt = 0;
        while (!queue.isEmpty()) {
            cnt++;
            int cur = queue.remove();

            for (int next : outGraph.getOrDefault(cur, new ArrayList<>())) {
                inDegrees[next]--;
                if (inDegrees[next] == 0) {
                    queue.add(next);
                }
            }
        }
        return cnt == 60;
    }
}
/*
1591. 奇怪的打印机 II
https://leetcode.cn/problems/strange-printer-ii/

给你一个奇怪的打印机，它有如下两个特殊的打印规则：
- 每一次操作时，打印机会用同一种颜色打印一个矩形的形状，每次打印会覆盖矩形对应格子里原本的颜色。
- 一旦矩形根据上面的规则使用了一种颜色，那么 相同的颜色不能再被使用 。
给你一个初始没有颜色的 m x n 的矩形 targetGrid ，其中 targetGrid[row][col] 是位置 (row, col) 的颜色。
如果你能按照上述规则打印出矩形 targetGrid ，请你返回 true ，否则返回 false 。
提示：
m == targetGrid.length
n == targetGrid[i].length
1 <= m, n <= 60
1 <= targetGrid[row][col] <= 60

本题难点在于将问题转化为 拓扑排序
参考: https://leetcode.cn/problems/strange-printer-ii/solution/cyi-chong-qi-guai-de-si-lu-jian-tu-tuo-bu-pai-xu-b/
 */